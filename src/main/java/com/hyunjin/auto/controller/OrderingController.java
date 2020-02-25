package com.hyunjin.auto.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyunjin.auto.domain.MemberOrderVO;
import com.hyunjin.auto.domain.MemberVO;
import com.hyunjin.auto.domain.OrderListVO;
import com.hyunjin.auto.service.OrderService;

@Controller
public class OrderingController {
	private static final Logger logger = LoggerFactory.getLogger(OrderingController.class);
	
	@Inject
	OrderService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	
	/*
	 * 1. 순서리스트에 오늘 날짜로 된거 있는지 확인하기
	 * 2. 없다면 순서 정하고 디비에 추가 
	 * 3. 있다면 순서 안정하고 바로 있던거 보여주기
	 * */
	
	@RequestMapping(value = "/ordering")
	public String ordering(Model model) throws Exception {
		
		int countMem=service.countMember(); //등록된 학생 수
		
		List<MemberVO> memList=service.allStudent(); //학번으로 정렬된 학생정보
		
		List<MemberOrderVO> sumList=new ArrayList<MemberOrderVO>(); // 누적 카운트
		sumList=service.allMemSum();
		
		int no=0;
		int max=0;
		
		if(!sumList.isEmpty()) {
			for(int i=0; i<sumList.size();i++) {
				if(sumList.get(i).getOrderNo()>max) {
					max=sumList.get(i).getOrderNo();
					no=sumList.get(i).getNo();
				}else if (sumList.get(i).getOrderNo()==max){
					if(no>sumList.get(i).getNo()){
						no=sumList.get(i).getNo();
						max=sumList.get(i).getOrderNo();
					}
				}
			}
		}
	
		System.out.println(no+":"+max);
		
		int temp=1;
		if(max!=0) {
			temp=2;
		}
		System.out.println(temp);
		
		int[] numbers=new int[countMem];
		
		for(int insertCur = 0; insertCur < numbers.length ; insertCur++){
		    numbers[insertCur] = (int)(Math.random() * countMem) + temp;
		    for(int searchCur = 0; searchCur < insertCur; searchCur ++){
		        if(numbers[insertCur] == numbers[searchCur]){
		            insertCur--; // insertCur를 앞으로 민다
		            break; // 다음 것을 검색할 필요가 없으므로 중복검사 반복을 나갑니다.
		        }
		    }
		}
		
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Date nowD = sf.parse(sf.format(now)); /* 오늘 날 */
		List<OrderListVO> curOrder=new ArrayList<OrderListVO>();
		
		System.out.println("0");
		List<OrderListVO> list=service.allOrderList(); // 전체 순서 가져오기
		List<OrderListVO> newOrderList=new ArrayList<OrderListVO>(); //새로운 순서가 담길 곳
		
//		비었다면
		if(list.isEmpty()) {
			System.out.println("1");
			for(int i=0; i<memList.size(); i++) {
				OrderListVO orderListVO= new OrderListVO();
				
				orderListVO.setNo(memList.get(i).getNo());
				orderListVO.setOrderNo(numbers[i]);
				orderListVO.setTodayDate(sf.format(now).toString());
				System.out.println(sf.format(now).toString());
				
				newOrderList.add(orderListVO);
			}
			
			service.orderingNo(newOrderList); //DB insert
			
			list=service.allOrderList(); // 새롭게 추가된 순서
			
		}else {
			System.out.println("2");
			
			String onceD= list.get(0).getTodayDate();// 최근 순서를 정한 날짜
			Date pDate = sf.parse(onceD); // Date 형식으로 변환
			
			/* 오늘 순서를 안 정했다면,  */
			int subR = pDate.compareTo(nowD); // 오늘 날짜와 비교
			System.out.println("subR:"+subR);
			
			if(subR==1||subR==-1){ // 같지 않다면,
				System.out.println(memList.size());
				
				for(int i=0; i<memList.size(); i++){
					OrderListVO orderListVO= new OrderListVO();
					
					orderListVO.setNo(memList.get(i).getNo());
					if(no==memList.get(i).getNo()) {
						orderListVO.setOrderNo(1);
					}else {
						orderListVO.setOrderNo(numbers[i]);
					}
					orderListVO.setTodayDate(sf.format(now).toString());
					
					newOrderList.add(orderListVO);
				}
				
				service.orderingNo(newOrderList);//DB insert
				
				list=service.allOrderList(); // 새롭게 추가된 순서
			}else {
				System.out.println("4");
			}
		}

		curOrder=service.curOrder(sf.format(now).toString());
		
		model.addAttribute("allOrder",list); // 전체 순서
		model.addAttribute("allMember",memList); // 학생 정보
		model.addAttribute("eachSum",sumList);
		model.addAttribute("curOrder",curOrder);// 순서
		
//		
//		// 새롭게 순서를 정하지 않았다면
//		if(!newOrderList.isEmpty()) {
//			model.addAttribute("temp", temp);
//			model.addAttribute("newOrder",newOrderList); //이번 순서
//		}else {
//			temp=1;
//			model.addAttribute("temp", temp);
//			model.addAttribute("curOrder",curOrder);
//		}

		return "orderResult";
	}
}
