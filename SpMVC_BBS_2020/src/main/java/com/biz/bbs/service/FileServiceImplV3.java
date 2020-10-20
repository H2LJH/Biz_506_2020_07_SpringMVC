package com.biz.bbs.service;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("fileServiceV3")
public class FileServiceImplV3 extends FileServiceImplV1 
{

	@Override
	public String fileUp(MultipartFile file) 
	{
		String rootForder = "C:/bizwork/workspace/upload";
		File dir = new File(rootForder);
		
		if(!dir.exists()) // file을 upload할 폴더를 검사하여 없으면 새로 생성해달라
			dir.mkdirs(); // mkdir() 제일끝의 폴더1개만 생성 mkdirs() 모든경로의 폴더를 한꺼번에 생성 
		
		
		String fileName = file.getOriginalFilename();
		
		// 서버의 저장폴더 + 파일이름을 합성하여 파일 저장준비
		File saveFile = new File(rootForder, fileName);
		
		try   { file.transferTo(saveFile);  } 
		catch (IllegalStateException e)  { e.printStackTrace(); } 
		catch (IOException e)  { e.printStackTrace(); }
		
		return null;
		
	}
	
}
