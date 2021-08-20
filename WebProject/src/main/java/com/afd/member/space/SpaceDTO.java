package com.afd.member.space;

import java.util.Date;

public class SpaceDTO {
	
	private int rentalseq;
	private String name;
	private String content;
	private Date regdate;
	private int hourpay;
	private String address;
	private int limitperson;
	private String purpose;
	private Date startdate;
	private Date enddate;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHourpay() {
		return hourpay;
	}
	public void setHourpay(int hourpay) {
		this.hourpay = hourpay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLimitperson() {
		return limitperson;
	}
	public void setLimitperson(int limitperson) {
		this.limitperson = limitperson;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	
}
