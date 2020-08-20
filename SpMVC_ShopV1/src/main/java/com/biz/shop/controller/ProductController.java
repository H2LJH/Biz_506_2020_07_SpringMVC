package com.biz.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.model.ProductVO;
import com.biz.shop.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/product")
@Controller
public class ProductController 
{
	@Autowired
	@Qualifier("proServiceV1")
	private ProductService proService;
	
	
	// 상품 리스트 보이기
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String proHome(Model model)
	{
		// 전체 상품리스트를 SELECT 
		List<ProductVO> proList = proService.selectAll();
		
		// PRO_LIST에 담아서 home으로 보내기
		model.addAttribute("PRO_LIST", proList);
		model.addAttribute("BODY", "PRO_HOME");
		return "home";
	}
	
	@RequestMapping(value = "insert", method=RequestMethod.GET)
	public String insert(Model model)
	{
		model.addAttribute("BODY", "PRO_WRITE");
		return "home";
		//return "product/product_write";
	}
		
	@RequestMapping(value = "insert", method=RequestMethod.POST)
	public String insert(ProductVO proVO)
	{
		log.debug("상품정보 입력 : {}",proVO.toString());
		int ret = proService.insert(proVO);
		return "redirect:/";
	}
}
