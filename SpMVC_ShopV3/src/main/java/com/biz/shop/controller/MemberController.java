package com.biz.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.model.MemberVO;
import com.biz.shop.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/member")
@Controller
public class MemberController 
{
	@Autowired
	@Qualifier("memServiceV1")
	private MemberService memService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute("MEM_VO") MemberVO memVO, Model model)
	{
		model.addAttribute("BODY", "MEM_WRITE");
		return "home";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("MEM_VO") MemberVO memVO, Model model, String temp)
	{
		log.debug(memVO.toString());
		memService.insert(memVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@ModelAttribute("LOGIN_VO")MemberVO loginVO, Model model)
	{
		model.addAttribute("BODY", "LOGIN");
		return "home";
	}
	
	/*
	 * 보안과 관련된 개념
	 * 인증 : ID, PWD등을 검사하여 정상 사용자인가를 알아보기
	 * 인가 : 인증이 성공하면 정상 사용자라는 것을 확인시킴
	 * 권한 : 인가받은 사용자의 권한이 어떠한 것인가
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("LOGIN_VO") MemberVO loginVO, Model model, HttpSession httpSession)
	{
		String retURL = "";
		// 로그인을 위한 입력값
		log.debug(loginVO.toString());
		
		MemberVO memVO = memService.login(loginVO);
		
		// 로그인 체크를 수행한 후의 사용자 정보
		// log.debug(memVO.toString());
		
		
		if(memVO == null) // id fail
		{
			retURL = "LOGIN";
			model.addAttribute("MSG", "아이디가 없습니다.");
		}
		else if(!loginVO.getM_userid().equals(memVO.getM_userid())) // pwd fail
		{
			retURL = "LOGIN";
			model.addAttribute("MSG", "비밀번호가 일치하지 않습니다.");
		}
		else
		{
			// HttpSession을 사용하여  Client와 Server간에 Session을 주고 받을 수 있도록 하는 절차
			httpSession.setAttribute("LOGIN", memVO);
		}
		
		model.addAttribute("BODY", retURL);
		return "home";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpsession)
	{
		httpsession.removeAttribute("LOGIN");
		httpsession = null;
		return "home";
	}
}
