package com.afd.admin.qna;

public class CommentDTO {
	
	private String techQnaCommentSeq;
	private String techQnaSeq;
	private String memberSeq;
	private String regdate;
	private String content;
	private String nickName;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTechQnaCommentSeq() {
		return techQnaCommentSeq;
	}
	public void setTechQnaCommentSeq(String techQnaCommentSeq) {
		this.techQnaCommentSeq = techQnaCommentSeq;
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
