package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.mapper.EmployeesDAO;
import com.biz.bbs.model.EmployeesVO;

@RequestMapping(value="/api")
@RestController
public class APIController {
	
	
	@Autowired
	private EmployeesDAO emplService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<EmployeesVO> list() {
		
		return emplService.selectAll();
	}
	
	@RequestMapping(value = "/find/{pk}", method = RequestMethod.GET)
	public EmployeesVO find(@PathVariable("pk") String pk ) {
	
		System.out.println(pk);
		return emplService.findById(Long.valueOf(pk));
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public int insert() {
		
		EmployeesVO vo = new EmployeesVO();
		vo.setE_first_name("1");
		vo.setE_last_name("1");
		vo.setE_tel("1");
		vo.setE_email("1");
		vo.setE_address("1");
		return emplService.insert(vo);
	}
	
	
	@RequestMapping(value = "/update/{pk}", method = RequestMethod.GET)
	public int update(@PathVariable("pk") String pk) {
		
		return emplService.update(emplService.findById(Long.valueOf(pk)));
	}
	
	
	@RequestMapping(value = "/delete/{pk}", method = RequestMethod.GET)
	public int delete(@PathVariable("pk") String pk ) {
		
		return emplService.delete(Long.valueOf(pk));
	}
	
}
