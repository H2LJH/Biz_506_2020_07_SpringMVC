package com.biz.bbs.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService
{
	public String fileUp(MultipartFile file)
	{
		
		String fileNmae = file.getOriginalFilename();
		String rootPath = System.getProperty("catalina.home");
		
		File dir = new File(rootPath, "tmpFolder");
		
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		
		File serverSaveFile = new File(dir.getAbsolutePath(), fileNmae);
		
		FileOutputStream outFile;
		try 
		{
			outFile = new FileOutputStream(serverSaveFile);
			BufferedOutputStream outStream = new BufferedOutputStream(outFile);
			byte[] fileData = file.getBytes();
			outStream.write(fileData);
			outStream.close();
			
		} 
		catch (FileNotFoundException e) 
		{ e.printStackTrace(); }
		
		catch (IOException e) 
		{ e.printStackTrace(); }
		
		
		return null;
	}
}
