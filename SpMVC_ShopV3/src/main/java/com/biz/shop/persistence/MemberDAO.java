package com.biz.shop.persistence;

import org.apache.ibatis.annotations.Select;

import com.biz.shop.model.MemberVO;

public interface MemberDAO extends GenericDAO<MemberVO, String> 
{

	@Select( "SELECT COUNT(*) FROM tbl_member")
	public int memberCount();

	
	
}
