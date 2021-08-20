package com.afd.member.study;

public class CommentDTO {

	
	private String commentSeq;
	private String commentPostSeq;
	private String commentMemberSeq;
	private String regdate;
	private String content;
	
	private String isnew;
	private String nickName;
	
	
	
	public String getIsnew() {
		return isnew;
	}
	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(String commentSeq) {
		this.commentSeq = commentSeq;
	}
	public String getCommentPostSeq() {
		return commentPostSeq;
	}
	public void setCommentPostSeq(String commentPostSeq) {
		this.commentPostSeq = commentPostSeq;
	}
	public String getCommentMemberSeq() {
		return commentMemberSeq;
	}
	public void setCommentMemberSeq(String commentMemberSeq) {
		this.commentMemberSeq = commentMemberSeq;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
