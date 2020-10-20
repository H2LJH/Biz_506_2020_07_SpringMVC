package com.biz.bbs.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/*
 *  파일 upload 프로젝트에서 외부에 파일을 공개하기 위해 폴더를 개방해 두면
 *  폴더를 외부에서 접근하여 해킹을 수행하는 경우들이 발생할수 있다.
 *  
 *  특히, 프로젝트 구조를 알게되는 경우 같은 이름의 파일을 엉뚱한 파일로
 *  업로드하여 원래 저장되어 있던 파일을 변형하는 일들이 발생할수 있다.
 *  
 *  파일을 업로드 할때 원래 파일이름(OriginalName) 감추고 
 *  서버에서 별도의 파일이름을 생성하여 저장해 주는 것이 좋다.
 */

@Slf4j
@RequiredArgsConstructor
@Service("fileServiceV4")
public class FileServiceImplV4 extends FileServiceImplV1 
{

	@Override
	public String fileUp(MultipartFile file) 
	{
		String rootForder = "C:/bizwork/workspace/upload";
		File dir = new File(rootForder);
		
		if(!dir.exists()) // file을 upload할 폴더를 검사하여 없으면 새로 생성해달라
			dir.mkdirs(); // mkdir() 제일끝의 폴더1개만 생성 mkdirs() 모든경로의 폴더를 한꺼번에 생성 
		
		
		String originalFileName = file.getOriginalFilename(); // 원본 파일 이름
		
		/*
		 * 원본 파일이름을 임의 값을 부착한 변형된 파일 이름으로 바꾸기
		 * 1. UUID 값을 생성하고
		 * 2. 원본 파일이름에 UUID를 부착하기
		 * 3. UUID 값이 부착된 파일이름은 서버에 업로드가 될 것이고
		 * 		만약 해커가 해당 파일으름을 알게되어 동일한 이름의 파일을 만들어서
		 * 		업로드 하면 다시 새로운 UUID가 부착되어 원래 저장된 파일을 보호한다.
		 */
		 String strUUID = UUID.randomUUID().toString();
		 String saveFileName = strUUID + originalFileName;
		
		
		// 서버의 저장폴더 + 파일이름을 합성하여 파일 저장준비
		File saveFile = new File(rootForder, saveFileName);
		
		try   { file.transferTo(saveFile);  } 
		catch (IllegalStateException e)  { e.printStackTrace(); } 
		catch (IOException e)  { e.printStackTrace(); }
		
		return saveFileName;
		
	}
	
}
