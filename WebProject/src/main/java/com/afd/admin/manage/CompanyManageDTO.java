package com.afd.admin.manage;

/**
 * 기업회원의 목록을 보여주기 위해 필요한 클래스
 * @author 3조
 *
 */
public class CompanyManageDTO {
	
	private String companySeq;
	private String name;
	private String id;
	private String registrationNumber;
	private String companyTel;
	private String managerName;
	private String managerEmail;
	private String companyURL;
	
	/**
	 * 기업의 번호를 얻어오는 메소드(Getter)
	 * @return companySeq
	 */
	public String getCompanySeq() {
		return companySeq;
	}
	
	/**
	 * 기업의 번호를 저장하는 메소드(Setter)
	 * @param companySeq
	 */
	public void setCompanySeq(String companySeq) {
		this.companySeq = companySeq;
	}
	
	/**
	 * 기업의 이름을 얻어오는 메소드(Getter)
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 기업의 이름을 저장하는 메소드(Setter)
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 기업 담당자의 아이디를 얻어오는 메소드(Getter)
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 기업 담당자의 아이디를 저장하는 메소드(Setter)
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 기업의 사업자등록번호를 얻어오는 메소드(Getter)
	 * @return registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	/**
	 * 기업의 사업자등록번호를 저장하는 메소드(Setter)
	 * @param registrationNumber
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	/**
	 * 기업의 전화번호를 얻어오는 메소드(Getter)
	 * @return companyTel
	 */
	public String getCompanyTel() {
		return companyTel;
	}
	
	/**
	 * 기업의 전화번호를 저장하는 메소드(Setter)
	 * @param companyTel
	 */
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	
	/**
	 * 기업 담당자의 이름을 얻어오는 메소드(Getter)
	 * @return managerName
	 */
	public String getManagerName() {
		return managerName;
	}
	
	/**
	 * 기업 담당자의 이름을 저장하는 메소드(Setter)
	 * @param managerName
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	/**
	 * 기업 담당자의 이메일을 얻어오는 메소드(Getter)
	 * @return managerEmail
	 */
	public String getManagerEmail() {
		return managerEmail;
	}
	
	/**
	 * 기업 담당자의 이메일을 저장하는 메소드(Setter)
	 * @param managerEmail
	 */
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	
	/**
	 * 기업의 홈페이지 URL을 얻어오는 메소드(Getter)
	 * @return companyURL
	 */
	public String getCompanyURL() {
		return companyURL;
	}
	
	/**
	 * 기업의 홈페이지 URL을 저장하는 메소드(Setter)
	 * @param companyURL
	 */
	public void setCompanyURL(String companyURL) {
		this.companyURL = companyURL;
	}
	
	/**
	 * DTO에 저장되어 있는 변수를 출력하는 메소드
	 */
	@Override
	public String toString() {
		return "CompanyManageDTO [companySeq=" + companySeq + ", name=" + name + ", id=" + id + ", registrationNumber="
				+ registrationNumber + ", companyTel=" + companyTel + ", managerName=" + managerName + ", managerEmail="
				+ managerEmail + ", companyURL=" + companyURL + "]";
	}
	
}
