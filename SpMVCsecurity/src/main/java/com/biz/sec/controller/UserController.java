package com.biz.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/user")
@Controller
public class UserController 
{
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login()
	{
		System.out.println("sss");
		return "user/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join()
	{
		return "user/join"; // return "users/join";
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage()
	{
		// InternalView를 사용한 rendering
		// return "users/mypage" = internalView를 사용한 rendering 
		// return "mypage" = tiles의 mypage definition을 찾아 rendering
		return "users/mypage"; // >> tiles의 user/* 찾고, * 대신 mypage 문자열을 전달하여 rendering
		
		// 1. tiles-layout.xml에서 user/mypage 설정값을 찾아보기
		// 2. tiles-layout.xml에서 user/* 설정값을 찾아보기
		// 1 OR 2번 에서 해당 설정을 찾게 되면 template로 설정된 layout.jsp을 열고
		// attribute로 설정된 jsp 파일들을 loading 하여 layout.jsp에 설정된 대로 
		// layout을 만들고, HTML로 rendering 한 후 response
	}
}
