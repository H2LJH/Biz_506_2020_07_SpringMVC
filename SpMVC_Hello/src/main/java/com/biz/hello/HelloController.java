package com.biz.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.hello.model.StudentVO;
import com.biz.hello.service.StudentService;

/*
 *  @Controller : 프로젝트에서 사용자의 Request를 수신하여 요청을 분석하는 클래스를 만들기
 *  Spring MVC 프로젝트에서는 @Controller Annotation이 설정된 클래스를
 *  모두 자동 Scan하여 리스트를 준비해 놓는다.
 *  Controller 클래스를 자동으로 객체로 선언, 생성하여 리스트를 만들고 
 *  	사용자(Web Browser)의 요청(Request)를 받을 준비를 한다.
 *  	이때 객체 리스트가 보관되는 곳을 Container 이라고 한다.
 *  
 *  Spring FrameWork에서 클래스를 자동으로 객체로 선언, 생성하는 과정이 이루어지고
 *  그 리스트를 Container에 보관을 하는데, 이때 Container에 보관되는 객체들을 Bean 이라고 한다.
 */

@Controller
public class HelloController 
{
	@Autowired
	StudentService stService;
	
	@RequestMapping(value="/student")
	public String student(Model model)
	{
		StudentVO stVO = stService.findByStnum("30001"); 
		
		model.addAttribute("STUDENT", stVO);
		return "Student";
	}
}
