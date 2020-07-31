package com.biz.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.order.model.OrderVO;
import com.biz.order.service.OrderService;

@Controller
public class OrderController 
{
	/*
	 * OrderService interface를 사용하여 oService를 선언하고
	 * 이미 생성되어 Container에 보관중이 OrderServiceImplV1 객체를
	 * oService에 주입하라 (Dependency Inject)
	 * 결국 oService 객체를 통하여 method를 호출할 준비가 된다.
	 */
	@Autowired
	private OrderService oService;
	
	@RequestMapping(value = "/list")
	public String orderList(Model model)
	{
		/*
		 *  주문서 전체리스트를 DB로 부터 가져와서 보여주는 controller
		 *  1. Service에서 전체리스트를 요청
		 *  2. Service는 DAO에게 전체리스트를 요청	
		 */
		
		List<OrderVO> orderList =  oService.selectAll();
		model.addAttribute("ORDERS", orderList);
		return "order/list";
	}
	
	@RequestMapping(value = "/order")
	public String getOrder(String seq, String name, Model model)
	{
		System.out.println("SEQ 값  : " + seq);
		System.out.println("Name 값 :" + name);
		long longSeq = 0;
		
		try  { longSeq = Long.valueOf(seq); } 
		catch (Exception e) { System.out.println("SEQ값을 수신하지 못함"); }
		
		// 서비스에 seq(21)를전달하고 데이터에 레코드를 Select한 결과를 받아서 orderVO에 담는다.
		OrderVO orderVO = oService.findBySeq(longSeq);
		
		/*
		 * view(*.jsp)파일에 전달하여 Rendering을 수행할 수 있도록
		 * model 객체에 orderVO 데이터를 추가해 놓는다.
		 */
		model.addAttribute("ORDER", orderVO);
		
		/*
		   Dispatcher에 /WEB-INF/views/order/view.jsp 파일을 읽어서
		     클라이언트(요청한 곳)으로 응답을 하여라
		     이때 model에 담겨있는 데이터를 사용하여 rendering 할때 사용하라
		*/
		return "order/detail_view";
	}
	
	
	
	// a href = "input"으로 설정된 링크를 클랙했을때 응답할 method
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input()
	{
		return "order/input";
	}
	
	// input form에서 action으로 지정하여 호출할 method
	@RequestMapping(value="/input", method = RequestMethod.POST)
	public String insert(@ModelAttribute OrderVO orderVO, Model model)
	{
		// 칼럼,vo,input 이름은 같아야함
		System.out.println(orderVO);
		int ret = oService.insert(orderVO);
		return "redirect:/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(String o_num,   String o_date, 
						 String o_cnum,  String o_pcode, 
						 String o_price, String o_qty, Model model)
	{
		System.out.println("주문번호 : " + o_num);
		System.out.println("날짜 : "    + o_date);
		System.out.println("고객번호 : " + o_cnum);
		
		OrderVO orderVO = new OrderVO();
		orderVO.setO_num(o_num);
		orderVO.setO_date(o_date);
		orderVO.setO_cnum(o_cnum);
		orderVO.setO_pcode(o_pcode);
		
		try 
		{
			orderVO.setO_price(Integer.valueOf(o_price));
			orderVO.setO_qty(Integer.valueOf(o_qty));
			orderVO.setO_total(orderVO.getO_price() * orderVO.getO_qty());
		} 
		catch (Exception e) 
		{
			System.out.println("숫자 변환 오류");
		}
		
		int ret = oService.insert(orderVO);
		
		//return "redirect:/list"; // Web browser의 주소창에 .../order/list 라고 입력한후 Enter를 누른것과 같이 명령을 수행하라고 web browser에게 알리기
		return null;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(String seq)
	{
		long longseq = 0;
		try 
		{
			longseq = Long.valueOf(seq);
		} 
		catch (Exception e) 
		{
			
		}
		System.out.println("ddd : " + longseq);
		int ret = oService.delete(longseq);
		
		return "redirect:/list";
	}
	
	
}