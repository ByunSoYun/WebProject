package com.afd.member.space;

import java.util.ArrayList;

public class SpaceMainDTO {

	private int rentalseq;
	private String name;
	private int hourpay;
	private int limitperson;
	private String dong;

	
	
	public SpaceMainDTO() {
		super();
	}

	
	public int getRentalseq() {
		return rentalseq;
	}
	public void setRentalseq(int rentalseq) {
		this.rentalseq = rentalseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHourpay() {
		return hourpay;
	}
	public void setHourpay(int hourpay) {
		this.hourpay = hourpay;
	}
	public int getLimitperson() {
		return limitperson;
	}
	public void setLimitperson(int limitperson) {
		this.limitperson = limitperson;
	}
	
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}


	
}
