package com.afd.member.mypage;

/**
 * 회원의 마이페이지에서 필요로 하는 데이터를 담고 있는 DTO
 * @author 3조
 *
 */
public class MyPageDTO {
	
	private String memberSeq;
	private String name;
	private String id;
	private String pw;
	private String nickName;
	private String registrationNumber;
	private String tel;
	private String address;
	private String email;
	private String memberProfileSeq;
	private String career;
	private String academicBackground;
	private String gender;
	private String interestOccupation;
	private String availableLanguage;
	private String major;
	private String score;
	private String qnaScrapCount;
	private String studyScrapCount;
	private String comScrapCount;
	private String spaceScrapCount;
	private String jobPostScrapCount;
	
	/**
	 * String 변수에 저장한 데이터를 출력하는 메소드
	 */
	@Override
	public String toString() {
		return "MyPageDTO [memberSeq=" + memberSeq + ", name=" + name + ", id=" + id + ", pw=" + pw + ", nickName="
				+ nickName + ", registrationNumber=" + registrationNumber + ", tel=" + tel + ", address=" + address
				+ ", email=" + email + ", memberProfileSeq=" + memberProfileSeq + ", career=" + career
				+ ", academicBackground=" + academicBackground + ", gender=" + gender + ", interestOccupation="
				+ interestOccupation + ", availableLanguage=" + availableLanguage + ", major=" + major + ", score="
				+ score + ", qnaScrapCount=" + qnaScrapCount + ", studyScrapCount=" + studyScrapCount
				+ ", comScrapCount=" + comScrapCount + ", spaceScrapCount=" + spaceScrapCount + ", jobPostScrapCount="
				+ jobPostScrapCount + "]";
	}
	
	/**
	 * 공간대여에서 스크랩한 게시글의 수를 얻어오는 메소드(Getter)
	 * @return spaceScrapCount
	 */
	public String getSpaceScrapCount() {
		return spaceScrapCount;
	}
	
	/**
	 * 공간대여에서 스크랩한 게시글의 수를 저장하는 메소드(Setter)
	 * @param spaceScrapCount
	 */
	public void setSpaceScrapCount(String spaceScrapCount) {
		this.spaceScrapCount = spaceScrapCount;
	}
	
	/**
	 * 채용공고에서 스크랩한 공고의 수를 얻어오는 메소드(Getter)
	 * @return jobPostScrapCount
	 */
	public String getJobPostScrapCount() {
		return jobPostScrapCount;
	}
	
	/**
	 * 채용공고에서 스크랩한 공고의 수를 저장하는 메소드(Setter)
	 * @param jobPostScrapCount
	 */
	public void setJobPostScrapCount(String jobPostScrapCount) {
		this.jobPostScrapCount = jobPostScrapCount;
	}
	
	/**
	 * Q&A에서 스크랩한 게시글의 수를 얻어오는 메소드(Getter)
	 * @return qnaScrapCount
	 */
	public String getQnaScrapCount() {
		return qnaScrapCount;
	}
	
	/**
	 * Q&A에서 스크랩한 게시글의 수를 저장하는 메소드(Setter)
	 * @param qnaScrapCount
	 */
	public void setQnaScrapCount(String qnaScrapCount) {
		this.qnaScrapCount = qnaScrapCount;
	}
	
	/**
	 * 스터디에서 스크랩한 게시글의 수를 얻어오는 메소드(Getter)
	 * @return studyScrapCount
	 */
	public String getStudyScrapCount() {
		return studyScrapCount;
	}
	
	/**
	 * 스터디에서 스크랩한 게시글의 수를 저장하는 메소드(Setter)
	 * @param studyScrapCount
	 */
	public void setStudyScrapCount(String studyScrapCount) {
		this.studyScrapCount = studyScrapCount;
	}
	
	/**
	 * 커뮤니티에서 스크랩한 게시글의 수를 얻어오는 메소드(Getter)
	 * @return comScrapCount
	 */
	public String getComScrapCount() {
		return comScrapCount;
	}
	
	/**
	 * 커뮤니티에서 스크랩한 게시글의 수를 저장하는 메소드(Setter)
	 * @param comScrapCount
	 */
	public void setComScrapCount(String comScrapCount) {
		this.comScrapCount = comScrapCount;
	}
	
	/**
	 * 회원의 프로필 정보 번호를 얻어오는 메소드(Getter)
	 * @return memberProfileSeq
	 */
	public String getMemberProfileSeq() {
		return memberProfileSeq;
	}
	
	/**
	 * 회원의 프로필 정보 번호를 저장하는 메소드(Setter)
	 * @param memberProfileSeq
	 */
	public void setMemberProfileSeq(String memberProfileSeq) {
		this.memberProfileSeq = memberProfileSeq;
	}
	
	/**
	 * 회원의 경력을 얻어오는 메소드(Getter)
	 * @return career
	 */
	public String getCareer() {
		return career;
	}
	
	/**
	 * 회원의 경력을 저장하는 메소드(Setter)
	 * @param career
	 */
	public void setCareer(String career) {
		this.career = career;
	}
	
	/**
	 * 회원의 학력을 얻어오는 메소드(Getter)
	 * @return academicBackground
	 */
	public String getAcademicBackground() {
		return academicBackground;
	}
	
	/**
	 * 회원의 학력을 얻어오는 메소드(Setter)
	 * @param academicBackground
	 */
	public void setAcademicBackground(String academicBackground) {
		this.academicBackground = academicBackground;
	}
	
	/**
	 * 회원의 성별을 얻어오는 메소드(Getter)
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * 회원의 성별을 저장하는 메소드(Setter)
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * 회원의 관심직종을 얻어오는 메소드(Getter)
	 * @return interestOccupation
	 */
	public String getInterestOccupation() {
		return interestOccupation;
	}
	
	/**
	 * 회원의 관심직종을 저장하는 메소드(Setter)
	 * @param interestOccupation
	 */
	public void setInterestOccupation(String interestOccupation) {
		this.interestOccupation = interestOccupation;
	}
	
	/**
	 * 회원의 사용가능언어를 얻어오는 메소드(Getter)
	 * @return availableLanguage
	 */
	public String getAvailableLanguage() {
		return availableLanguage;
	}
	
	/**
	 * 회원의 사용가능언어를 저장하는 메소드(Setter)
	 * @param availableLanguage
	 */
	public void setAvailableLanguage(String availableLanguage) {
		this.availableLanguage = availableLanguage;
	}
	
	/**
	 * 회원의 전공을 얻어오는 메소드(Getter)
	 * @return major
	 */
	public String getMajor() {
		return major;
	}
	
	/**
	 * 회원의 전공을 저장하는 메소드(Setter)
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * 회원의 평점을 얻어오는 메소드(Getter)
	 * @return score
	 */
	public String getScore() {
		return score;
	}
	
	/**
	 * 회원의 평점을 저장하는 메소드(Setter)
	 * @param score
	 */
	public void setScore(String score) {
		this.score = score;
	}
	
	/**
	 * 회원번호를 얻어오는 메소드(Getter)
	 * @return memberSeq
	 */
	public String getMemberSeq() {
		return memberSeq;
	}
	
	/**
	 * 회원번호를 저장하는 메소드(Setter)
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
	 * 회원의 이름을 저장하는 메소드(Seeter)
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
