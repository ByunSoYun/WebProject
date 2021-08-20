package com.afd.member;

/**
 * 회원의 기본 정보가 담겨있는 클래스
 * @author 3조
 *
 */
public class MemberDTO {

	private String memberSeq;
	private String name;
	private String id;
	private String pw;
	private String nickName;
	private String registrationNumber;
	private String tel;
	private String address;
	private String email;
	
	/**
	 * 회원의 번호를 얻을 수 있는 메소드(Getter)
	 * @return memberSeq
	 */
	public String getMemberSeq() {
		return memberSeq;
	}
	
	/**
	 * 회원의 번호를 저장하는 메소드(Setter)
	 * @param memberSeq
	 */
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	
	/**
	 * 회원의 이름을 얻어오는 메소드(Getter)
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 회원의 이름을 저장하는 메소드(Setter)
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 회원의 아이디를 얻어오는 메소드(Getter)
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 회원의 아이디를 저장하는 메소드(Setter)
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 회원의 비밀번호를 얻어오는 메소드(Getter)
	 * @return pw
	 */
	public String getPw() {
		return pw;
	}
	
	/**
	 * 회원의 비밀번호를 저장하는 메소드(Setter)
	 * @param pw
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	/**
	 * 회원의 닉네임을 얻어오는 메소드(Getter)
	 * @return nickName
	 */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * 회원의 닉네임을 저장하는 메소드(Setter)
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * 회원의 주민등록번호를 얻어오는 메소드(Getter)
	 * @return registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	/**
	 * 회원의 주민등록번호를 저장하는 메소드(Setter)
	 * @param registrationNumber
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	/**
	 * 회원의 전화번호를 얻어오는 메소드(Getter)
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * 회원의 전화번호를 저장하는 메소드(Setter)
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * 회원의 주소를 얻어오는 메소드(Getter)
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 회원의 주소를 저장하는 메소드(Setter)
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 회원의 이메일을 얻어오는 메소드(Getter)
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 회원의 이메일을 저장하는 메소드(Setter)
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
