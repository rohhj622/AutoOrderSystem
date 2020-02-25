package com.hyunjin.auto.persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.hyunjin.auto.domain.MemberVO;
import com.hyunjin.auto.persistence.AddStudentDAO;

@Repository
public class AddStudentDAOImpl implements AddStudentDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.hyunjin.mapper.MemberContorlMapper";
	
	@Override
	public void addStudent(List<MemberVO> listMember) throws Exception {
		// TODO Auto-generated method stub
		
		for(int i=0; i<listMember.size(); i++) {
			System.out.println(i+":"+listMember.get(i).getName());

			session.insert(namespace+".addStudent",listMember.get(i));
		}

	}
}

