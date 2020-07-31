package com.biz.order.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.order.model.OrderVO;
import com.biz.order.model.DAO.OrderDAO;


/*
 * OrderServiceImp 클래스를 객체로 생성하는 과정에서
 * getMapper() method를 자동으로 호출하고
 * orderDAO를 초기화하라.
 * Serviceimpl 클래스를 객체로 생성할때 호출되는 생성자는 
 * 최초에 한번 Container에 등록될때 호출된다.
 * 
 * 이후에 다른 객체, 변수등을 초기화 하려면 별도의 method를 만든후 @Autowired를 설정해 주어야 한다.
 */

@Service
public class OrderServiceImplV1 implements OrderService
{
	@Autowired
	private SqlSession sqlSession;
	private OrderDAO orderDAO;
	
	@Autowired
	public void getMapper()
	{
		this.orderDAO = sqlSession.getMapper(OrderDAO.class);
	}

	@Override
	public List<OrderVO> selectAll() 
	{
		List<OrderVO> orderList = orderDAO.selectAll();
		System.out.println("Controller에서 받은 데이터");
		System.out.println(orderList);
		
		return orderList;
	}

	@Override
	public OrderVO findBySeq(long seq) 
	{
		/*
		 	seq 값을 매개변수로 받고 OrderDao.findbySeq(seq)호출하고
		 	DB로부터 전달되어온 주문서 1개 레코드를 orderVO에 받고
		 	호출한 곳으로 그대로 return 구조
		*/
		OrderVO orderVO = orderDAO.findBySeq(seq);
		return orderVO;
	}

	@Override
	public int insert(OrderVO orderVO) 
	{
		int ret = orderDAO.insert(orderVO);
		return ret;
	}

	@Override
	public int update(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long seq) 
	{
		int ret = orderDAO.delete(seq);
		return ret;
	}

}
