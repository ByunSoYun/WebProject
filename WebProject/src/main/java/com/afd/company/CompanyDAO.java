package com.afd.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.afd.DBUtil;
import com.afd.member.job.JobDTO;

public class CompanyDAO {

   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   private ResultSet rs;
   
   public CompanyDAO() {
      
      try {
         conn = DBUtil.open();
      } catch (Exception e) {
         System.out.println("CompanyDAO.CompanyDAO()");
         e.printStackTrace();
      }
      
   }
   
   public CompanyDTO login(CompanyDTO dto) {

      try {
         
         //로그인 처리
         String sql = "select * from tblCompany where id=? and pw=?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, dto.getId());
         pstat.setString(2, dto.getPw());
         
         rs = pstat.executeQuery();
         
         if(rs.next()) {
            
            //로그인 O
            CompanyDTO resultDTO = new CompanyDTO();
            
            resultDTO.setCompanySeq(rs.getString("companySeq"));
            resultDTO.setName(rs.getString("name"));
            resultDTO.setId(rs.getString("id"));
            resultDTO.setRegistrationNumber(rs.getString("registrationNumber"));
            resultDTO.setCompanyTel(rs.getString("companyTel"));
            resultDTO.setManagerName(rs.getString("managerName"));
            resultDTO.setManagerEmail(rs.getString("managerEmail"));
            resultDTO.setCompanyURL(rs.getString("companyURL"));
         
            return resultDTO;
         }

   
      } catch (Exception e) {
         System.out.println("CompanyDAO.login()");
         e.printStackTrace();
      } 
      
      return null;
   }

   public ArrayList<CompanyDTO> list(String companySeq) {

      try {
         
         String sql = "select * from vwJobPost where companySeq = ?";
         pstat=conn.prepareStatement(sql);
         pstat.setString(1, companySeq);
         
         rs = pstat.executeQuery();

         ArrayList<CompanyDTO> list = new ArrayList<CompanyDTO>(); // 옮겨 담을 큰상자
         
         while (rs.next()) {

            CompanyDTO dto = new CompanyDTO();
            
            dto.setCompanySeq(rs.getString("companySeq"));
            dto.setJobPostSeq(rs.getString("jobPostSeq"));
            dto.setName(rs.getString("name"));
            dto.setPostName(rs.getString("postName"));
            dto.setCareer(rs.getString("career"));
            dto.setStartDate(rs.getString("startDate"));
            dto.setEndDate(rs.getString("endDate"));
            dto.setCareer(rs.getString("career"));
            dto.setEducationLevel(rs.getString("educationLevel"));
            dto.setAttachedFile(rs.getString("attachedFile"));
            dto.setCity(rs.getString("city"));
            dto.setGu(rs.getString("gu"));
            
            list.add(dto);

         }
         return list;
         
      } catch (Exception e) {
         System.out.println("CompanyDAO.list()");
         e.printStackTrace();
      }
      return null;
      
   }
   
   public CompanyDTO view(String jobPostSeq) {

      try {

         String sql = "select * from vwJobView where jobPostSeq = ?";

         pstat = conn.prepareStatement(sql);
         pstat.setString(1, jobPostSeq);

         rs = pstat.executeQuery();

         if (rs.next()) {

            CompanyDTO resultDTO = new CompanyDTO();
            
            resultDTO.setCompanySeq(rs.getString("companySeq"));
            resultDTO.setJobPostSeq(rs.getString("jobPostSeq"));
            resultDTO.setPostName(rs.getString("postName"));
            resultDTO.setName(rs.getString("name"));
            resultDTO.setPostContent(rs.getString("postContent"));
            resultDTO.setAttachedFile(rs.getString("attachedFile"));
            resultDTO.setCity(rs.getString("city"));
            resultDTO.setGu(rs.getString("gu"));
            resultDTO.setDong(rs.getString("dong"));
            resultDTO.setAddress(rs.getString("address"));
            resultDTO.setStartDate(rs.getString("startDate"));
            resultDTO.setEndDate(rs.getString("endDate"));
            resultDTO.setLatitude(rs.getString("latitude"));
            resultDTO.setLongitude(rs.getString("longitude"));
            
            return resultDTO;
         }

      } catch (Exception e) {
         System.out.println("CompanyDAO.view()");
         e.printStackTrace();
      }

      return null;
   }

   public CompanyDTO profile(String companySeq) {
      
      try {
         
         //로그인 처리
         String sql = "select * from tblCompany where companySeq = ?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, companySeq);
         
         rs = pstat.executeQuery();
         
         if(rs.next()) {
            
            //로그인 O
            CompanyDTO resultDTO = new CompanyDTO();
            
            resultDTO.setCompanySeq(rs.getString("companySeq"));
            resultDTO.setName(rs.getString("name"));
            resultDTO.setId(rs.getString("id"));
            resultDTO.setRegistrationNumber(rs.getString("registrationNumber"));
            resultDTO.setCompanyTel(rs.getString("companyTel"));
            resultDTO.setManagerName(rs.getString("managerName"));
            resultDTO.setManagerEmail(rs.getString("managerEmail"));
            resultDTO.setCompanyURL(rs.getString("companyURL"));
         
            return resultDTO;
         }

   
      } catch (Exception e) {
         System.out.println("CompanyDAO.profile()");
         e.printStackTrace();
      } 
      
      return null;
   }
   
}