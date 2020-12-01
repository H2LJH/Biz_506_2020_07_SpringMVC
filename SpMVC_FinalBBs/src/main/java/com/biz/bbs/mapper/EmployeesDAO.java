package com.biz.bbs.mapper;

import java.util.List;

import com.biz.bbs.model.EmployeesVO;

public interface EmployeesDAO {

	
	public List<EmployeesVO> selectAll();
	public EmployeesVO findById(long pk);
	public int insert(EmployeesVO vo);
	public int update(EmployeesVO vo);
	public int delete(long pk);
	
}
