package com.biz.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String proHome(Model model, HttpSession httpsession)
	{
		Object obj = httpsession.getAttribute("LOGIN");
		if(obj == null)
		{
			model.addAttribute("BODY", "LOGIN");
			model.addAttribute("MSG", "로그인을 해야합니다.");
			return "redirect:/member/login";
		}
		// 전체 상품리스트를 SELECT 
		List<ProductVO> proList = proService.selectAll();
		
		// PRO_LIST에 담아서 home으로 보내기
		model.addAttribute("PRO_LIST", proList);
		model.addAttribute("BODY", "PRO_HOME");
		return "home";
	}
	
	
	@RequestMapping(value = "insert", method=RequestMethod.GET)
	public String insert(@ModelAttribute("PRO_VO") ProductVO proVO, Model model)
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
		return "redirect:/product/";
	}
	
	/*
	 *  @RequestParam(query_이름)
	 *  URL에 담긴 변수이름과 실제 사용하는 파라메터 변수가 다를때는 
	 *  @RequestParam()을 사용하는 방법이 있다.
	 *  @RequestParam()은 Spring 4.x 이상에서는 선택사항이다.
	 *  "Query_이름" 과 파라메터 변수이름이 같을때는 생략해도 된다.
	 *  단, 이 Annotation은 primitive형 이거나 wrapper(Integer, Character, String)일 경우만 사용가능하다.
	 *  임의로 만든 VO를 파라메터로 사용할때는 
	 *  @ModelAttribute()를 사용해야 한다.
	 */
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("id") String p_code, Model model)
	{
		ProductVO proVO = proService.findById(p_code);
		model.addAttribute("PRO_VO", proVO);
		model.addAttribute("BODY", "PRO_DETAIL");
		return "home";
	}
	
	/*
	 * redirect
	 * request를 전환한다 라는 개념
	 * Server가 client에게 요청하기를 
	 * 방금 요청한(delete)를 잘 수행했으니
	 * 다시한번 /product/ URL로 request를 수행해달라 라는 요청
	 * 상태코드 304번
	 */
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("id") String p_code)
	{
		int ret = proService.delete(p_code);
		return "redirect:/product/";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam("id") String p_code, Model model)
	{
		ProductVO proVO = proService.findById(p_code);
		model.addAttribute("PRO_VO", proVO);
		model.addAttribute("BODY", "PRO_WRITE");
		return "home";
	}
	
//	@RequestMapping(value="/update", method=RequestMethod.GET)
//	public String update(@ModelAttribute ProductVO proVO, Model model)
//	{
//		ProductVO proVO = proService.findById(p_code);
//		model.addAttribute("PRO_VO", proVO);
//		model.addAttribute("BODY", "PRO_WRITE");
//		return "home";
//	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute ProductVO proVO, Model model)
	{
		int ret = proService.update(proVO);
		model.addAttribute("id", proVO.getP_code());
		return "redirect:/product/detail";
	}
	
}
