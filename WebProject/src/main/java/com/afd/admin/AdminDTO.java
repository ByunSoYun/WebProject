package com.afd.admin;

/**
 * 관리자의 데이터를 담고있는 클래스
 * @author 3조
 *
 */
public class AdminDTO {
	
	private String adminSeq;
	private String id;
	private String pw;
	
	/**
	 * 관리자의 번호를 얻어오는 메소드(Getter)
	 * @return adminSeq
	 */
	public String getAdminSeq() {
		return adminSeq;
	}
	
	/**
	 * 관리자의 번호를 저장하는 메소드(Setter)
	 * @param adminSeq
	 */
	public void setAdminSeq(String adminSeq) {
		this.adminSeq = adminSeq;
	}
	
	/**
	 * 관리자의 아이디를 얻어오는 메소드(Getter)
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 관리자의 아이디를 저장하는 메소드(Setter)
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 관리자의 비밀번호를 얻어오는 메소드(Getter)
	 * @return pw
	 */
	public String getPw() {
		return pw;
	}
	
	/**
	 * 관리자의 비밀번호를 저장하는 메소드(Setter)
	 * @param pw
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	

}
