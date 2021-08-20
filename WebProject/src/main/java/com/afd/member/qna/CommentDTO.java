package com.afd.member.qna;

/**
 * 댓글에 대한 정보들을 포함하고 있는 DTO 클래스
 * @author 3조
 *
 */
public class CommentDTO {
	
	/**
	 * 댓글을 작성하기 위해 필요한 댓글번호, 게시글번호, 회원번호, 작성일자, 내용, 닉네임, 아이디
	 */
	private String techQnaCommentSeq;
	private String techQnaSeq;
	private String memberSeq;
	private String regdate;
	private String content;
	private String nickName;
	private String id;
	
	/**
	 * 아이디를 얻어오게 하는 메소드(Getter)
	 * @return 아이디
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 아이디 값을 저장하는 메소드(Setter)
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 닉네임을 얻어오는 메소드(Getter)
	 * @return 닉네임
	 */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * 닉네임 값을 저장하는 메소드(Setter)
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * 댓글 번호를 얻어오는 메소드(Getter)
	 * @return 댓글 번호
	 */
	public String getTechQnaCommentSeq() {
		return techQnaCommentSeq;
	}
	
	/**
	 * 댓글 번호 값을 저장하는 메소드(Setter)
	 * @param techQnaCommentSeq
	 */
	public void setTechQnaCommentSeq(String techQnaCommentSeq) {
		this.techQnaCommentSeq = techQnaCommentSeq;
	}
	
	/**
	 * 게시글 번호를 얻어오는 메소드(Getter)
	 * @return 게시글 번호
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
	 * @return 회원 번호
	 */
	public String getMemberSeq() {
		return memberSeq;
	}
	
	/**
	 * 회원 번호를 저장하는 메소드(Setter)
	 * @param memberSeq
	 */
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	
	/**
	 * 작성일자를 얻어오는 메소드(Getter)
	 * @return 작성일자
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
	 * 게시글 내용을 얻어오는 메소드(Getter)
	 * @return 게시글 내용
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
	
	

}
