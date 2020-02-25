package com.hyunjin.auto.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hyunjin.auto.domain.MemberOrderVO;
import com.hyunjin.auto.domain.MemberVO;
import com.hyunjin.auto.domain.OrderListVO;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Inject
	private SqlSession session;

	private static String namespace = "com.hyunjin.mapper.orderMapper";

	@Override
	public List<OrderListVO> allOrderList() throws Exception {
		return session.selectList(namespace+".selectOrder");
	}

	@Override
	public List<MemberVO> allMember() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectMember");
	}

	@Override
	public int countMember() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".countMember");
	}

	@Override
	public void orderingNo(List<OrderListVO> newOrderList) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0; i<newOrderList.size(); i++) {
			session.insert(namespace+".insertOrder",newOrderList.get(i));
		}
	}

	@Override
	public List<OrderListVO> curOrderList(String today) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectCurOrder",today);
	}

	@Override
	public List<MemberOrderVO> allMemSum() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectSum");
	}
	
}
