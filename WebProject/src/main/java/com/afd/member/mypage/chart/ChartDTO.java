package com.afd.member.mypage.chart;

/**
 * 자신이 작성한 게시글 내역을 차트로 보여주기 위해 필요한 DTO
 * @author 3조
 *
 */
public class ChartDTO {
	
	private String name;
	private String qnaCount;
	private String communityCount;
	private String studyCount;
	private String qnaCommentCount;
	private String communityCommentCount;
	private String studyCommentCount;
	private String memberSeq;
	
	/**
	 * 회원 번호를 얻어오는 메소드(Getter)
	 * @return memberSeq
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
	 * 회원 이름을 얻어오는 메소드(Getter)
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 회원 이름을 저장하는 메소드(Setter)
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Q&A에 작성한 게시글 수를 얻어오는 메소드(Getter)
	 * @return qnaCount
	 */
	public String getQnaCount() {
		return qnaCount;
	}
	
	/**
	 * Q&A에 작성한 게시글 수를 저장하는 메소드(Setter)
	 * @param qnaCount
	 */
	public void setQnaCount(String qnaCount) {
		this.qnaCount = qnaCount;
	}
	
	/**
	 * 커뮤니티에 작성한 게시글 수를 얻어오는 메소드(Getter)
	 * @return communityCount
	 */
	public String getCommunityCount() {
		return communityCount;
	}
	/**
	 * 커뮤니티에 작성한 게시글 수를 저장하는 메소드(Setter)
	 * @param communityCount
	 */
	public void setCommunityCount(String communityCount) {
		this.communityCount = communityCount;
	}
	
	/**
	 * 스터디에 작성한 게시글 수를 얻어오는 메소드(Getter)
	 * @return studyCount
	 */
	public String getStudyCount() {
		return studyCount;
	}
	/**
	 * 스터디에 작성한 게시글 수를 저장하는 메소드(Setter)
	 * @param studyCount
	 */
	public void setStudyCount(String studyCount) {
		this.studyCount = studyCount;
	}
	
	/**
	 * Q&A에 작성한 댓글수를 얻어오는 메소드(Getter)
	 * @return qnaCommentCount
	 */
	public String getQnaCommentCount() {
		return qnaCommentCount;
	}
	
	/**
	 * Q&A에 작성한 댓글수를 저장하는 메소드(Setter)
	 * @param qnaCommentCount
	 */
	public void setQnaCommentCount(String qnaCommentCount) {
		this.qnaCommentCount = qnaCommentCount;
	}
	
	/**
	 * 커뮤니티에 작성한 댓글수를 얻어오는 메소드(Getter)
	 * @return communityCommentCount
	 */
	public String getCommunityCommentCount() {
		return communityCommentCount;
	}
	
	/**
	 * 커뮤니티에 작성한 댓글수를 저장하는 메소드(Setter)
	 * @param communityCommentCount
	 */
	public void setCommunityCommentCount(String communityCommentCount) {
		this.communityCommentCount = communityCommentCount;
	}
	
	/**
	 * 스터디에 작성한 댓글수를 얻어오는 메소드(Getter)
	 * @return studyCommentCount
	 */
	public String getStudyCommentCount() {
		return studyCommentCount;
	}
	
	/**
	 * 스터디에 작성한 댓글수를 저장하는 메소드(Setter)
	 * @param studyCommentCount
	 */
	public void setStudyCommentCount(String studyCommentCount) {
		this.studyCommentCount = studyCommentCount;
	}

}
