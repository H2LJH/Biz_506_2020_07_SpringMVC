package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.shop.model.ProductVO;
import com.biz.shop.persistence.ProductDAO;
import com.biz.shop.service.ProductService;

import lombok.extern.slf4j.Slf4j;


/*
 * ProductService 인터페이스는 GenericService 인터페이스를 상속(extends)하므로서
 * CRUD 기본 method를 별도로 선언하지 않아도 된다.
 * 필요한 추가 method가 있으면 별도로 선언을 해주고 
 * 이 interface를 implements한 클래스는 인터페이스의 영향을 받아 method를 구현하게 된다.
 */

@Slf4j
@Service(value="proServiceV1")
public class ProductServiceImplV1 implements ProductService 
{
	@Autowired
	private ProductDAO proDAO;
	
	
	@Override
	public List<ProductVO> selectAll() 
	{
		return proDAO.selectAll();
	}

	@Override
	public ProductVO findById(String id) 
	{
		return null;
	}

	@Override
	public int insert(ProductVO vo) 
	{
		vo.setP_image("이미지 없음");
		int ret = proDAO.insert(vo);
		
		if(ret >0)
			log.debug("INSERT 성공 {} 개 데이터 추가", ret);
		
		else
			log.debug("INSERT 실패 {}", ret);
		
		return ret;
	}

	@Override
	public int update(ProductVO vo) 
	{
		return 0;
	}

	@Override
	public int delete(String id) 
	{
		return 0;
	}

	@Override
	public List<ProductVO> findByTitle(String title) 
	{
		return null;
	}
	
}
