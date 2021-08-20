package com.afd.member.mypage.myreservation;

import java.util.Date;

public class MySpaceDTO {

	private int rentalseq;
	private String name;
	private int hourpay;
	private int limitperson;
	private String address;
	private int memberseq;
	private String purpose;
	private Date reservationdate;
	private Date paydate;
	private String request;
	private int startdate;
	private int enddate;
	private int personcount;
	private int totalpay;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMemberseq() {
		return memberseq;
	}
	public void setMemberseq(int memberseq) {
		this.memberseq = memberseq;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getReservationdate() {
		return reservationdate;
	}
	public void setReservationdate(Date reservationdate) {
		this.reservationdate = reservationdate;
	}
	public Date getPaydate() {
		return paydate;
	}
	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public int getStartdate() {
		return startdate;
	}
	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}
	public int getEnddate() {
		return enddate;
	}
	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}
	public int getPersoncount() {
		return personcount;
	}
	public void setPersoncount(int personcount) {
		this.personcount = personcount;
	}
	public int getTotalpay() {
		return totalpay;
	}
	public void setTotalpay(int totalpay) {
		this.totalpay = totalpay;
	}
	
	
}
