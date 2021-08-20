package com.afd.member.mypage;

public class MyJobDTO {
   
   private String memberSeq;
   private String name;
   private String jobPostSeq;
   private String companyName;
   private String postName;
   private String attachedFile;
   
   
   public String getAttachedFile() {
      return attachedFile;
   }
   public void setAttachedFile(String attachedFile) {
      this.attachedFile = attachedFile;
   }
   public String getMemberSeq() {
      return memberSeq;
   }
   public void setMemberSeq(String memberSeq) {
      this.memberSeq = memberSeq;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getJobPostSeq() {
      return jobPostSeq;
   }
   public void setJobPostSeq(String jobPostSeq) {
      this.jobPostSeq = jobPostSeq;
   }
   public String getCompanyName() {
      return companyName;
   }
   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }
   public String getPostName() {
      return postName;
   }
   public void setPostName(String postName) {
      this.postName = postName;
   }
   
   
}