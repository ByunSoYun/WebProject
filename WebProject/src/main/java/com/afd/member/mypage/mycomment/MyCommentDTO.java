package com.afd.member.mypage.mycomment;

/**
 * 내가 작성한 게시글을 보기 위해 필요한 DTO
 * @author 3조
 *
 */
public class MyCommentDTO {
	
	private String techQnaSeq;
	private String memberSeq;
	private String title;
	private String content;
	private String regdate;
	private String readCount;
	private String image;
	private String nickName;
	private String id;
	private String isNew;
	private String ccnt;
	private String recommendCount;
	private String decommendCount;
	
	/**
	 * 닉네임을 얻어오는 메소드(Getter)
	 * @return nickName
	 */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * 닉네임을 저장하는 메소드(Setter)
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * 아이디를 얻어오는 메소드(Getter)
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 아이디를 저장하는 메소드(Setter)
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * (작성일자 - 현재날짜)를 얻어오는 메소드(Getter)
	 * @return isNew
	 */
	public String getIsNew() {
		return isNew;
	}
	
	/**
	 * (작성일자 - 현재날짜)를 저장하는 메소드(Setter)
	 * @param isNew
	 */
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	
	/**
	 * 댓글수를 얻어오는 메소드(Getter)
	 * @return ccnt
	 */
	public String getCcnt() {
		return ccnt;
	}
	
	/**
	 * 댓글수를 저장하는 메소드(Setter)
	 * @param ccnt
	 */
	public void setCcnt(String ccnt) {
		this.ccnt = ccnt;
	}
	
	/**
	 * 추천수를 얻어오는 메소드(Getter)
	 * @return recommendCount
	 */
	public String getRecommendCount() {
		return recommendCount;
	}
	
	/**
	 * 추천수를 저장하는 메소드(Setter)
	 * @param recommendCount
	 */
	public void setRecommendCount(String recommendCount) {
		this.recommendCount = recommendCount;
	}
	
	/**
	 * 비추천수를 얻어오는 메소드(Getter)
	 * @return decommendCount
	 */
	public String getDecommendCount() {
		return decommendCount;
	}
	
	/**
	 * 비추천수를 저장하는 메소드(Setter)
	 * @param decommendCount
	 */
	public void setDecommendCount(String decommendCount) {
		this.decommendCount = decommendCount;
	}
	
	/**
	 * 게시글 번호를 얻어오는 메소드(Getter)
	 * @return techQnaSeq
	 */
	public String getTechQnaSeq() {
		return techQnaSeq;
	}
	
	/**
	 * 게시글 번호를 저장하는 메소드(Setter)
	 * @param techQnaSeq
	 */
	public void setTechQnaSeq(String techQnaSeq) {
		this.techQnaSeq = techQnaSeq;
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
	 * 게시글 제목을 얻어오는 메소드(Getter)
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 게시글 제목을 저장하는 메소드(Setter)
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 게시글 내용을 얻어오는 메소드(Getter)
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 게시글 내용을 저장하는 메소드(Setter)
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 게시글 작성일자를 얻어오는 메소드(Getter)
	 * @return regdate
	 */
	public String getRegdate() {
		return regdate;
	}
	
	/**
	 * 게시글 작성일자를 저장하는 메소드(Setter)
	 * @param regdate
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	/**
	 * 게시글 조회수를 얻어오는 메소드(Getter)
	 * @return readCount
	 */
	public String getReadCount() {
		return readCount;
	}
	
	/**
	 * 게시글 조회수를 저장하는 메소드(Setter)
	 * @param readCount
	 */
	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}
	
	/**
	 * 이미지 URL을 얻어오는 메소드(Getter)
	 * @return image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * 이미지 URL을 저장하는 메소드(Seter)
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
}
