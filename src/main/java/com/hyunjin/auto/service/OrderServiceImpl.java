package com.hyunjin.auto.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hyunjin.auto.domain.MemberOrderVO;
import com.hyunjin.auto.domain.MemberVO;
import com.hyunjin.auto.domain.OrderListVO;
import com.hyunjin.auto.persistence.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService{

	@Inject
	OrderDAO dao;
	
	@Override
	public List<OrderListVO> allOrderList() throws Exception {
		return dao.allOrderList();
		
	}
	//전체순서꺼내기

	@Override
	public List<MemberVO> allStudent() throws Exception {
		// TODO Auto-generated method stub
		return dao.allMember();
	}

	@Override
	public int countMember() throws Exception {
		// TODO Auto-generated method stub
		return dao.countMember();
	}

	@Override
	public void orderingNo(List<OrderListVO> newOrderList) throws Exception {
		// TODO Auto-generated method stub
		dao.orderingNo(newOrderList);
		
	}

	@Override
	public List<OrderListVO> curOrder(String today) throws Exception {
		// TODO Auto-generated method stub
		return dao.curOrderList(today);
	}

	@Override
	public List<MemberOrderVO> allMemSum() throws Exception {
		// TODO Auto-generated method stub
		return dao.allMemSum();
	}
}
