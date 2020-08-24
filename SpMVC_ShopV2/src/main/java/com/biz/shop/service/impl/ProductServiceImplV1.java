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
		return proDAO.findById(id);
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

	@Override
	public String getPCode() 
	{
		/*
		   tbl_product table에서 상품코드를 조회하는데 가장 큰값의 코드를 가져와라
		     그중에 P0010코드를 가져오는 SQL을 만들겠다.
		*/
		String strMaxPCode = proDAO.maxPCode();
		log.debug("조회한 상품코드 : {}", strMaxPCode);
		
		
		
		String retPCode = "P00001";
		try {
				String preCode = strMaxPCode.substring(0, 1);
				String pCode = strMaxPCode.substring(1);
				log.debug("분리된 상품코드 {}, {}", preCode, pCode);
				retPCode = String.format("%s%05d", preCode, Integer.valueOf(pCode) + 1); 
			} 
		catch (Exception e) {}
		log.debug("새로 생성된 상품코드 {}", retPCode);
		
		return retPCode;
	}
	
}
