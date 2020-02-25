package com.hyunjin.auto.persistence;

import java.util.List;

import com.hyunjin.auto.domain.MemberVO;

public interface AddStudentDAO {
	public void addStudent(List<MemberVO> listMember) throws Exception;
}
