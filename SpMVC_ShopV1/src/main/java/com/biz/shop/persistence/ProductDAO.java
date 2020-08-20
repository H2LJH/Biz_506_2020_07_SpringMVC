package com.biz.shop.persistence;

import java.util.List;

import com.biz.shop.model.ProductVO;

public interface ProductDAO extends GenericDAO<ProductVO, String> 
{
	public List<ProductVO> findByTitle(String title);
}
