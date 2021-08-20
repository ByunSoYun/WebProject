package com.afd.member.community;

public class RecommendDTO {

	
	private String comrecseq;		//추천수고유번호
	private String memberseq;		//추천멤버번호
	private String communityseq;	//추천된 게시물번호
	private String recommend;		//추천 y or n 
	
	
	public String getComrecseq() {
		return comrecseq;
	}
	public void setComrecseq(String comrecseq) {
		this.comrecseq = comrecseq;
	}
	public String getMemberseq() {
		return memberseq;
	}
	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}
	public String getCommunityseq() {
		return communityseq;
	}
	public void setCommunityseq(String communityseq) {
		this.communityseq = communityseq;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

}
