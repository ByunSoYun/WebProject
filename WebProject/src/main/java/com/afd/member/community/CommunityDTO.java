package com.afd.member.community;

public class CommunityDTO {
	private String rnum;

	private String seq;
	private String memberseq;
	private String category;
	private String title;
	private String content;
	private String regdate;
	private String readcount;

	private String isnew; 

	private String nickname;
	private int commentcount;
	private int scrapcount;
	private int recommendcount;
	private int decommendcount;

	
	public String getIsnew() {
		return isnew;
	}
	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getMemberseq() {
		return memberseq;
	}
	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getReadcount() {
		return readcount;
	}
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}
	public Integer getRecommendcount() {
		return recommendcount;
	}
	public void setRecommendcount(Integer recommendcount) {
		this.recommendcount = recommendcount;
	}
	public Integer getDecommendcount() {
		return decommendcount;
	}
	public void setDecommendcount(Integer decommendcount) {
		this.decommendcount = decommendcount;
	}
	public Integer getScrapcount() {
		return scrapcount;
	}
	public void setScrapcount(int scrapcount) {
		this.scrapcount = scrapcount;
	}

	
	
}

