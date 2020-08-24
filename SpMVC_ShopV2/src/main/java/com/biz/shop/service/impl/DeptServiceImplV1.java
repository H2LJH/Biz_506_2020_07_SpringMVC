package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.shop.model.DeptVO;
import com.biz.shop.persistence.DeptDAO;
import com.biz.shop.service.DeptService;

@Service
public class DeptServiceImplV1 implements DeptService 
{
	
	@Autowired
	DeptDAO deptDAO;
	
	@Override
	public List<DeptVO> selectAll() {
		
		return deptDAO.selectAll();
	}

	@Override
	public DeptVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DeptVO vo) {
		int ret = deptDAO.insert(vo);
		return ret;
	}

	@Override
	public int update(DeptVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
