package com.afd.admin.qna;

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
	



	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getRecommendMemberSeq() {
		return recommendMemberSeq;
	}
	public void setRecommendMemberSeq(String recommendMemberSeq) {
		this.recommendMemberSeq = recommendMemberSeq;
	}
	public String getRecommendTechQnaSeq() {
		return recommendTechQnaSeq;
	}
	public void setRecommendTechQnaSeq(String recommendTechQnaSeq) {
		this.recommendTechQnaSeq = recommendTechQnaSeq;
	}
	public String getRecommendCount() {
		return recommendCount;
	}
	public void setRecommendCount(String recommendCount) {
		this.recommendCount = recommendCount;
	}
	public String getDecommendCount() {
		return decommendCount;
	}
	public void setDecommendCount(String decommendCount) {
		this.decommendCount = decommendCount;
	}
	public String getScrapCount() {
		return scrapCount;
	}
	public void setScrapCount(String scrapCount) {
		this.scrapCount = scrapCount;
	}
	public String getReadCount() {
		return readCount;
	}
	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getCcnt() {
		return ccnt;
	}
	public void setCcnt(String ccnt) {
		this.ccnt = ccnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "QnaDTO [techQnaSeq=" + techQnaSeq + ", memberSeq=" + memberSeq + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", image=" + image + ", readCount=" + readCount + ", nickName="
				+ nickName + ", id=" + id + ", ccnt=" + ccnt + ", isNew=" + isNew + ", recommendCount=" + recommendCount
				+ ", decommendCount=" + decommendCount + ", scrapCount=" + scrapCount + "]";
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTechQnaSeq() {
		return techQnaSeq;
	}
	public void setTechQnaSeq(String techQnaSeq) {
		this.techQnaSeq = techQnaSeq;
	}
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
