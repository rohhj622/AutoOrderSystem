package com.hyunjin.auto.persistence;

import java.util.List;

import com.hyunjin.auto.domain.MemberOrderVO;
import com.hyunjin.auto.domain.MemberVO;
import com.hyunjin.auto.domain.OrderListVO;

public interface OrderDAO {
	public List<OrderListVO> allOrderList() throws Exception; //전체 순서 보기
	public List<MemberVO> allMember() throws Exception;
	public int countMember() throws Exception;
	public void orderingNo(List<OrderListVO> newOrderList) throws Exception;
	public List<OrderListVO> curOrderList(String today) throws Exception;
	public List<MemberOrderVO> allMemSum() throws Exception;
}
