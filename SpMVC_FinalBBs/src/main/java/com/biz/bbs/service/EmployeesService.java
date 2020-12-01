package com.biz.bbs.service;

import java.util.List;

import com.biz.bbs.model.EmployeesVO;

public interface EmployeesService {

	public List<EmployeesVO> selectAll();
	public EmployeesVO findById(long pk);
	public int insert(EmployeesVO vo);
	public int update(EmployeesVO vo);
	public int delete(long pk);
	
}
