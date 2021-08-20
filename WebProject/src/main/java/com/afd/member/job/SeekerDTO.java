package com.afd.member.job;

public class SeekerDTO {
	
	private String seekerSeq;
	private String memberSeq;
	private String jobPostSeq;
	private String attachedFile;
	private String readStatus;
	
	private String filename;
	private String orgfilename;

	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOrgfilename() {
		return orgfilename;
	}
	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}
	
	public String getSeekerSeq() {
		return seekerSeq;
	}
	public void setSeekerSeq(String seekerSeq) {
		this.seekerSeq = seekerSeq;
	}
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getJobPostSeq() {
		return jobPostSeq;
	}
	public void setJobPostSeq(String jobPostSeq) {
		this.jobPostSeq = jobPostSeq;
	}
	public String getAttachedFile() {
		return attachedFile;
	}
	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}
	public String getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}
	
	
	
}
