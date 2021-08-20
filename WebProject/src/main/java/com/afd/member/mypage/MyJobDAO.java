package com.afd.member.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.afd.DBUtil;

public class MyJobDAO {
   
   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   private ResultSet rs;

   public MyJobDAO() {

      try {

         conn = DBUtil.open();

      } catch (Exception e) {
         System.out.println("MyJobDAO.MyJobDAO()");
         e.printStackTrace();
      }

   }

   public ArrayList<MyJobDTO> list(String memberSeq) {

      try {
         
         String sql = "select j.* , rownum from vwMyJob j where memberSeq = ? and rownum between 1 and 3 ";
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, memberSeq);
         
         rs = pstat.executeQuery();
         
         ArrayList<MyJobDTO> list = new ArrayList<MyJobDTO>();
         
         while (rs.next()) {
            
            MyJobDTO dto = new MyJobDTO();
            
            dto.setMemberSeq(rs.getString("memberSeq"));
            dto.setName(rs.getString("name"));
            dto.setJobPostSeq(rs.getString("jobPostSeq"));
            dto.setPostName(rs.getString("postname"));
            dto.setCompanyName(rs.getString("companyName"));
            dto.setAttachedFile(rs.getString("attachedFile"));
   
            list.add(dto);
            
         }
         return list;
         
      } catch (Exception e) {
         System.out.println("MyJobDAO.list()");
         e.printStackTrace();
      }
      
      return null;
   }

}