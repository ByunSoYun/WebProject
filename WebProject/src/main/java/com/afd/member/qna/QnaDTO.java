package com.afd.member.qna;

/**
 * 게시글과 관련된 변수를 담고 있는 클래스
 * @author 3조
 *
 */
public class QnaDTO {
	
	private String techQnaSeq;
	private String memberSeq;
	private String title;
	private String content;
	private String regdate;
	private String image;
	private String readCount;
	private String nickName;
	private String id;
	private String ccnt;
	private String isNew;
	private String recommendCount;
	private String decommendCount;
	private String scrapCount;
	private String recommendMemberSeq;
	private String recommendTechQnaSeq;
	private String recommend;
	


	/**
	 * 게시글의 추천수를 얻어오는 메소드(Getter)
	 * @return recommend
	 */
	public String getRecommend() {
		return recommend;
	}
	
	/**
	 * 게시글의 추천수를 저장하는 메소드(Setter)
	 * @param recommend
	 */
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	
	/**
	 * 게시글에 추천한 회원의 번호를 얻어오는 메소드(Getter)
	 * @return recommendMemberSeq
	 */
	public String getRecommendMemberSeq() {
		return recommendMemberSeq;
	}
	
	/**
	 * 추천한 회원의 번호를 저장하는 메소드(Setter)
	 * @param recommendMemberSeq
	 */
	public void setRecommendMemberSeq(String recommendMemberSeq) {
		this.recommendMemberSeq = recommendMemberSeq;
	}
	
	/**
	 * 추천한 게시글의 번호를 얻어오는 메소드(Getter)
	 * @return recommendTechQnaSeq
	 */
	public String getRecommendTechQnaSeq() {
		return recommendTechQnaSeq;
	}
	
	/**
	 * 추천한 게시글의 번호를 저장하는 메소드(Setter)
	 * @param recommendTechQnaSeq
	 */
	public void setRecommendTechQnaSeq(String recommendTechQnaSeq) {
		this.recommendTechQnaSeq = recommendTechQnaSeq;
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
	 * 스크랩 수를 얻어오는 메소드(Getter)
	 * @return scrapCount
	 */
	public String getScrapCount() {
		return scrapCount;
	}
	
	/**
	 * 스크랩 수를 저장하는 메소드(Setter)
	 * @param scrapCount
	 */
	public void setScrapCount(String scrapCount) {
		this.scrapCount = scrapCount;
	}
	
	/**
	 * 조회수를 얻어오는 메소드(Getter)
	 * @return readCount
	 */
	public String getReadCount() {
		return readCount;
	}
	
	/**
	 * 조회수를 저장하는 메소드(Setter)
	 * @param readCount
	 */
	public void setReadCount(String readCount) {
		this.readCount = readCount;
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
	 * 모든 Getter들을 출력하는 메소드
	 */
	@Override
	public String toString() {
		return "QnaDTO [techQnaSeq=" + techQnaSeq + ", memberSeq=" + memberSeq + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", image=" + image + ", readCount=" + readCount + ", nickName="
				+ nickName + ", id=" + id + ", ccnt=" + ccnt + ", isNew=" + isNew + ", recommendCount=" + recommendCount
				+ ", decommendCount=" + decommendCount + ", scrapCount=" + scrapCount + "]";
	}
	
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
	 * 회원 번호를 얻어오는 메소드(Getter)
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
	 * 작성일자를 얻어오는 메소드(Getter)
	 * @return reggdate
	 */
	public String getRegdate() {
		return regdate;
	}
	
	/**
	 * 작성일자를 저장하는 메소드(Setter)
	 * @param regdate
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	/**
	 * 이미지 경로를 얻어오는 메소드(Getter)
	 * @return image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * 이미지 경로를 저장하는 메소드(Setter)
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
