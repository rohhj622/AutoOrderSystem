package com.hyunjin.auto.domain;

public class OrderListVO {
	/* *
	 * idx=인덱스
	 * no=학번
	 * todayDate=순서정한 날짜
	 * order=그날의 순서
	 * */
	
	private int idx;
	private int no;
	private String todayDate;
	private int orderNo;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	

}
