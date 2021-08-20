package com.afd.member.mypage.myreservation;

public class MySpaceImageDTO {
	private String imageName;
	private int memberseq;

	public MySpaceImageDTO() {
		super();
	}


	public MySpaceImageDTO(String imageName) {
		super();
		this.imageName = imageName;
	}
	
	public MySpaceImageDTO(int memberseq) {
		super();
		this.memberseq = memberseq;
	}

	public int getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(int memberseq) {
		this.memberseq = memberseq;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	
	
	
}
