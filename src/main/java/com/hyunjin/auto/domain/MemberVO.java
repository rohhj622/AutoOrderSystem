package com.hyunjin.auto.domain;

public class MemberVO {
	/* *
	 * no=학번
	 * name=이름
	 * address=github주소
	 * */
	
	private int no;
	private String name;
	private String address; 
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
