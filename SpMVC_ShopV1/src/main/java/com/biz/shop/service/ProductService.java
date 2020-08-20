package com.biz.shop.service;

import java.util.List;

import com.biz.shop.model.ProductVO;

public interface ProductService extends GenericService<ProductVO, String> 
{
	// Generic에는 없지만 Product를 구현하는데 필요한 메서드가 있으면 그 메세드를 별도로 구현해 준다.
	public List<ProductVO> findByTitle(String title);
}
