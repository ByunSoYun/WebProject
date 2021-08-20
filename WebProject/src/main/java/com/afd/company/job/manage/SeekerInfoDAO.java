package com.afd.company.job.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.afd.DBUtil;
import com.afd.member.job.JobDTO;
import com.afd.member.job.SeekerDTO;

public class SeekerInfoDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public SeekerInfoDAO() {

		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("SeekerInfoDAO.SeekerInfoDAO()");
			e.printStackTrace();
		}

	}

	public ArrayList<SeekerInfoDTO> info(String jobPostSeq) {

		try {
			
			String sql = "select * from vwSeekerInfo where jobPostSeq = ?";

			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			rs = pstat.executeQuery();
			
			ArrayList<SeekerInfoDTO> list = new ArrayList<SeekerInfoDTO>();
			
			while(rs.next()) {
				
				SeekerInfoDTO resultDTO = new SeekerInfoDTO();
				
				System.out.println("이름"+rs.getString("name"));
				
				resultDTO.setMemberSeq(rs.getString("memberSeq"));
				resultDTO.setJobPostSeq(rs.getString("jobPostSeq"));
				resultDTO.setName(rs.getString("name"));
				resultDTO.setAcademicBackground(rs.getString("academicBackground"));
				resultDTO.setAvailableLanguage(rs.getString("availableLanguage"));
				resultDTO.setInterestOccupation(rs.getString("interestOccupation"));
				resultDTO.setCareer(rs.getString("career"));
				resultDTO.setMajor(rs.getString("major"));
				resultDTO.setAttachedFile(rs.getString("attachedFile"));
				
				list.add(resultDTO);

			}
			return list;
			
		} catch (Exception e) {
			System.out.println("");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
}
