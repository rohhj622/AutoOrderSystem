package com.hyunjin.auto.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hyunjin.auto.domain.MemberVO;
import com.hyunjin.auto.service.AddStudentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AddStudentController {
	
	@Inject
	AddStudentService service;
	
	private static final Logger logger = LoggerFactory.getLogger(AddStudentController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/addStudentPage")
	public String addStudentPage() {
		return "addStudentView";
	}
	
	@RequestMapping(value = "/addStudentProc")
	public String addStudentProc(HttpServletRequest req) throws Exception {

		String realCount=req.getParameter("count");
		int count=Integer.parseInt(realCount);
		logger.info("count:"+realCount);
		
		
		List<MemberVO> listMember=new ArrayList<MemberVO>();
		
		for (int i=1; i<=count-1; i++ ) {
			String name="stu_name_"+i;
			String no="stu_no_"+i;
			String gitAdd="stu_github_"+i;
			
			MemberVO memberVO = new MemberVO();
			
			logger.info(req.getParameter(no));
						
			int reqNo= Integer.parseInt(req.getParameter(no));
			String reqName=req.getParameter(name);
			String reqGit=req.getParameter(gitAdd);
			
			memberVO.setName(reqName);
			memberVO.setNo(reqNo);
			memberVO.setAddress(reqGit);
			
			
			listMember.add(i-1,memberVO);

			
			logger.info(memberVO.getName()+"+"+memberVO.getNo()+"+"+memberVO.getAddress());
		}
		
		if(listMember.isEmpty()) {
			logger.info("왜 빈거야?");
		}

		service.addStudent(listMember);
		
		
		return "home";
	}
	
}
