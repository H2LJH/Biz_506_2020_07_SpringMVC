package com.biz.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.BBsDAO;
import com.biz.bbs.model.BBsVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("bbsServiceV1")
public class BBsServiceIMPLV1 implements BBsService 
{
	private final BBsDAO bbsDAO;

	@Override
	public List<BBsVO> selectAll() 
	{
		return bbsDAO.selectAll();
	}

	@Override
	public BBsVO findById(long long_seq) 
	{
		return bbsDAO.findBySeq(long_seq);
	}
	
	@Override
	public void insert(BBsVO bbsVO) 
	{
		bbsDAO.insert(bbsVO);
	}

}
