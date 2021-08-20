package com.afd.member.community;

public class CommentDTO {
	
	private String commentseq;
	private String memberseq;
	private String communityseq;
	private String content;
	private String regdate;
	private String nickname;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCommentseq() {
		return commentseq;
	}
	public void setCommentseq(String commentseq) {
		this.commentseq = commentseq;
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
	
	

}
//CREATE TABLE tblCommunityComment (
//		 commentSeq number NOT NULL,
//		 memberSeq number NOT NULL,
//		 communitySeq number NOT NULL,
//		 content varchar2(2000) NOT NULL,
//		 regdate date DEFAULT sysdate NOT NULL
//		);