package com.biz.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.EmployeesDAO;
import com.biz.bbs.model.EmployeesVO;
import com.biz.bbs.service.EmployeesService;

@Service
public class EmployeesV1 implements EmployeesService{

	@Autowired
	private EmployeesDAO emplDAO;
	
	@Override
	public List<EmployeesVO> selectAll() {
		return emplDAO.selectAll();
	}

	@Override
	public EmployeesVO findById(long pk) {
		
		return emplDAO.findById(pk);
	}

	@Override
	public int insert(EmployeesVO vo) {
		
		
		return emplDAO.insert(vo);
	}

	@Override
	public int update(EmployeesVO vo) {
		
		return emplDAO.update(vo);
	}

	@Override
	public int delete(long pk) {

		return emplDAO.delete(pk);
	}

	
}
