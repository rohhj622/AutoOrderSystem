package com.hyunjin.auto.service;

import java.util.List;

import com.hyunjin.auto.domain.MemberOrderVO;
import com.hyunjin.auto.domain.MemberVO;
import com.hyunjin.auto.domain.OrderListVO;

public interface OrderService {
	public List<OrderListVO> allOrderList() throws Exception; //전체순서꺼내기
	public List<MemberVO> allStudent() throws Exception; //전체 학생 꺼내기
	public int countMember() throws Exception; //전체 학생 수
	public void orderingNo(List<OrderListVO> newOrderList) throws Exception;
	public List<OrderListVO> curOrder(String today) throws Exception;
	public List<MemberOrderVO> allMemSum() throws Exception;
}
