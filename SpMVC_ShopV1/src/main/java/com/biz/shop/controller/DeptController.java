package com.biz.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.model.DeptVO;
import com.biz.shop.model.ProductVO;
import com.biz.shop.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value ="/dept")
@Controller
public class DeptController 
{
	
	@Autowired
	DeptService deptService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model)
	{
		List<DeptVO> deptList = deptService.selectAll();
		model.addAttribute("DEPT_LIST", deptList);
		model.addAttribute("BODY", "DEPT_HOME");
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String insert(DeptVO vo)
	{
		deptService.insert(vo);
		return "redirect:/dept/";
	}	
}
