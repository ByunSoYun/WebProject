package com.afd.member.space;

import java.util.Date;

public class SpaceReservationDTO {
	
	private int rentalseq;
	private int memberseq;
	private int hourpay;
	private int limitpserson;
	private String purpose;
	private Date paydate;
	private Date reservationdate;
	private String request;
	private int startdate;
	private int enddate;
	private int personcount;
	private int totalpay;
	
	
	public int getMemberseq() {
		return memberseq;
	}
	public void setMemberseq(int memberseq) {
		this.memberseq = memberseq;
	}
	public Date getPaydate() {
		return paydate;
	}
	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}
	public int getRentalseq() {
		return rentalseq;
	}
	public void setRentalseq(int rentalseq) {
		this.rentalseq = rentalseq;
	}
	public int getHourpay() {
		return hourpay;
	}
	public void setHourpay(int hourpay) {
		this.hourpay = hourpay;
	}
	public int getLimitpserson() {
		return limitpserson;
	}
	public void setLimitpserson(int limitpserson) {
		this.limitpserson = limitpserson;
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
