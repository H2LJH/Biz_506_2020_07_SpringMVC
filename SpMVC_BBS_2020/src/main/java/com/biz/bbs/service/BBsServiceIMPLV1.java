package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.mapper.BBsDAO;
import com.biz.bbs.model.BBsVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("bbsServiceV1")
public class BBsServiceIMPLV1 implements BBsService 
{
	@Autowired
	protected BBsDAO bbsDAO;
	
	@Autowired
	@Qualifier("fileServiceV4")
	protected FileService fileService;

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
		
	}
	
	@Override
	public void insert(BBsVO bbsVO, MultipartFile file) 
	{
		String fileName = fileService.fileUp(file);
		bbsVO.setB_file(fileName);
		bbsDAO.insert(bbsVO);
	}

	@Override
	public int delete(long long_seq) 
	{
		BBsVO bbsVO = bbsDAO.findBySeq(long_seq);
		
		if(bbsVO.getB_file() != null)
			fileService.fileDelete(bbsVO.getB_file());
		
		return bbsDAO.delete(long_seq);
	}


}
