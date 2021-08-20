package com.afd.admin.manage;

/**
 * 일반 회원 목록을 보기 위해 필요한 데이터를 담고있는 클래스
 * @author 3조
 *
 */
public class MemberManageDTO {
	
	private String memberSeq;
	private String name;
	private String id;
	private String nickName;
	private String registrationNumber;
	private String tel;
	private String address;
	private String email;
	private String score;
	
	/**
	 * 일반 회원의 평점을 얻어오는 메소드(Getter)
	 * @return score
	 */
	public String getScore() {
		return score;
	}
	
	/**
	 * 일반 회원의 평점을 저장하는 메소드(Setter)
	 * @param score
	 */
	public void setScore(String score) {
		this.score = score;
	}
	
	/**
	 * 일반 회원의 번호를 얻어오는 메소드(Getter)
	 * @return memberSeq
	 */
	public String getMemberSeq() {
		return memberSeq;
	}
	
	/**
	 * 일반 회원의 번호를 저장하는 메소드(Setter)
	 * @param memberSeq
	 */
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	
	/**
	 * 일반 회원의 이름을 얻어오는 메소드(Getter)
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 일반 회원의 이름을 저장하는 메소드(Setter)
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 일반 회원의 아이디를 얻어오는 메소드(Getter)
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 일반 회원의 아이디를 저장하는 메소드(Setter)
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 일반 회원의 닉네임을 얻어오는 메소드(Getter)
	 * @return nickName
	 */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * 일반 회원의 닉네임을 저장하는 메소드(Setter)
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * 일반 회원의 주민등록번호를 얻어오는 메소드(Getter)
	 * @return registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	/**
	 * 일반 회원의 주민등록번호를 저장하는 메소드(Setter)
	 * @param registrationNumber
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	/**
	 * 일반 회원의 전화번호를 얻어오는 메소드(Getter)
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * 일반 회원의 전화번호를 저장하는 메소드(Setter)
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * 일반 회원의 주소를 얻어오는 메소드(Getter)
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 일반 회원의 주소를 저장하는 메소드(Setter)
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 일반 회원의 이메일을 얻어오는 메소드(Getter)
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 일반 회원의 이메일을 저장하는 메소드(Setter)
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * DTO의 결과값을 출력하기 위한 메소드
	 */
	@Override
	public String toString() {
		return "MemberManageDTO [memberSeq=" + memberSeq + ", name=" + name + ", id=" + id + ", nickName=" + nickName
				+ ", registrationNumber=" + registrationNumber + ", tel=" + tel + ", address=" + address + ", email="
				+ email + ", score=" + score + "]";
	}
	
}
