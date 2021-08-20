package com.afd.member.mypage.myscrap;

public class MyScrapDTO {
	
	private String techQnaSeq;
	private String memberSeq;
	private String title;
	private String content;
	private String regdate;
	private String readCount;
	private String nickName;
	private String ccnt;
	private String recommendCount;
	private String decommendCount;
	private String name;
	private String id;
	private String registrationNumber;
	private String tel;
	private String address;
	private String email;
	private String communityScrapCount;
	private String qnaScrapCount;
	private String studyScrapCount;
	private String jobPostScrapCount;
	private String spaceScrapCount;
	
	/**
	 * 커뮤니티에서 스크랩한 게시글의 수를 얻어오는 메소드(Getter)
	 * @return communityScrapCount
	 */
	public String getCommunityScrapCount() {
		return communityScrapCount;
	}
	
	/**
	 * 커뮤니티에서 스크랩한 게시글의 수를 저장하는 메소드(Setter)
	 * @param communityScrapCount
	 */
	public void setCommunityScrapCount(String communityScrapCount) {
		this.communityScrapCount = communityScrapCount;
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
	
	/**
	 * 게시글의 번호를 얻어오는 메소드(Getter)
	 * @return techQnaSeq
	 */
	public String getTechQnaSeq() {
		return techQnaSeq;
	}
	
	/**
	 * 게시글의 번호를 저장하는 메소드(Setter)
	 * @param techQnaSeq
	 */
	public void setTechQnaSeq(String techQnaSeq) {
		this.techQnaSeq = techQnaSeq;
	}
	
	/**
	 * 회원 번호를 저장하는 메소드(Getter)
	 * @return
	 */
	public String getMemberSeq() {
		return memberSeq;
	}
	
	/**
	 * 회원 번호를 얻어오는 메소드(Setter)
	 * @param memberSeq
	 */
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	
	/**
	 * 게시글의 제목을 얻어오는 메소드(Getter)
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 게시글의 제목을 저장하는 메소드(Setter)
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 게시글의 내용을 얻어오는 메소드(Getter)
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 게시글의 내용을 저장하는 메소드(Setter)
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 게시글의 작성일자를 얻어오는 메소드(Getter)
	 * @return regdate
	 */
	public String getRegdate() {
		return regdate;
	}
	
	/**
	 * 게시글의 작성일자를 저장하는 메소드(Setter)
	 * @param regdate
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	/**
	 * 게시글의 조회수를 얻어오는 메소드(Getter)
	 * @return readCount
	 */
	public String getReadCount() {
		return readCount;
	}
	
	/**
	 * 게시글의 조회수를 저장하는 메소드(Setter)
	 * @param readCount
	 */
	public void setReadCount(String readCount) {
		this.readCount = readCount;
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
	 * 게시글의 댓글수를 얻어오는 메소드(Getter)
	 * @return ccnt
	 */
	public String getCcnt() {
		return ccnt;
	}
	
	/**
	 * 게시글의 댓글수를 저장하는 메소드(Setter)
	 * @param ccnt
	 */
	public void setCcnt(String ccnt) {
		this.ccnt = ccnt;
	}
	
	/**
	 * 게시글의 추천수를 얻어오는 메소드(Getter)
	 * @return recommendCount
	 */
	public String getRecommendCount() {
		return recommendCount;
	}
	
	/**
	 * 게시글의 추천수를 저장하는 메소드(Setter)
	 * @param recommendCount
	 */
	public void setRecommendCount(String recommendCount) {
		this.recommendCount = recommendCount;
	}
	
	/**
	 * 게시글의 비추천수를 얻어오는 메소드(Getter)
	 * @return decommendCount
	 */
	public String getDecommendCount() {
		return decommendCount;
	}
	
	/**
	 * 게시글의 비추천수를 저장하는 메소드(Setter)
	 * @param decommendCount
	 */
	public void setDecommendCount(String decommendCount) {
		this.decommendCount = decommendCount;
	}
	
	/**
	 * 회원의 스크랩 내역 DTO를 출력하기 위한 메소드
	 */
	@Override
	public String toString() {
		return "MyScrapDTO [techQnaSeq=" + techQnaSeq + ", memberSeq=" + memberSeq + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", readCount=" + readCount + ", nickName=" + nickName + ", ccnt="
				+ ccnt + ", recommendCount=" + recommendCount + ", decommendCount=" + decommendCount + ", name=" + name
				+ ", id=" + id + ", registrationNumber=" + registrationNumber + ", tel=" + tel + ", address=" + address
				+ ", email=" + email + "]";
	}
	
}
