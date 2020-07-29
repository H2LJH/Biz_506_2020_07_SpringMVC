package com.biz.hello.service;

import java.util.List;

import com.biz.hello.model.StudentVO;

public interface StudentService 
{
	public List<StudentVO> selectAll();
	
	public StudentVO findByStnum(String st_num);
	
	public int insert(StudentVO vo);
	
	public int update(StudentVO vo);
	
	public int delete(String st_num);
}
