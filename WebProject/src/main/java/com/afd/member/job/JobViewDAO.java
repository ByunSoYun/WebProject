package com.afd.member.job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.afd.DBUtil;


public class JobViewDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public JobViewDAO() {

		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("JobViewDAO.JobViewDAO()");
			e.printStackTrace();
		}

	}


	public JobDTO view(String jobPostSeq) {

		try {

			String sql = "select * from vwJobView where jobPostSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, jobPostSeq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				JobDTO resultDTO = new JobDTO();
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
			System.out.println("JobDAO.view()");
			e.printStackTrace();
		}

		return null;
	}
	
	public int scrap(HashMap<String, String> map) {

		try {
			
			String sql = "select * from vwJobScrap where jobPostSeq = ? and memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("jobPostSeq"));
			pstat.setString(2, map.get("memberSeq"));
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return 1;
			}
			

		} catch (Exception e) {
			System.out.println("JobViewDAO.scrap()");
			e.printStackTrace();
		}

		return 0;
	}



	public void scrapInsert(HashMap<String, String> map) {
		try {

			String sql = "insert into tblJobPostScrap(jobScrapSeq, jobPostSeq, memberSeq) values (jobScrapSeq.nextVal, ?,?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("jobPostSeq"));
			pstat.setString(2, map.get("memberSeq"));
			
			if(pstat.executeUpdate() == 1) {
				System.out.println("스크랩 인서트 성공");
			}else{
				System.out.println("스크랩 인서트 실패");
			}
			
		} catch (Exception e) {
			System.out.println("JobViewDAO.scrapUpdate()");
			e.printStackTrace();
		}
		
	}


	public void scrapDelete(HashMap<String, String> map) {
		try {

			String sql = "delete from tblJobPostScrap where jobPostSeq=? and memberSeq=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("jobPostSeq"));
			pstat.setString(2, map.get("memberSeq"));
			
			if(pstat.executeUpdate() > 0) {
				System.out.println("스크랩 딜리트 성공");
			}else {
				System.out.println("스크랩 딜리트 실패");
			}
			
		} catch (Exception e) {
			System.out.println("JobViewDAO.scrapUpdate()");
			e.printStackTrace();
		}
		
		
		
	}


	public JobDTO enrollView(String jobPostSeq) {
		
		try {

			String sql = "select * from vwJobPost where jobPostSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, jobPostSeq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				JobDTO resultDTO = new JobDTO();
				resultDTO.setCompanySeq(rs.getString("companySeq"));
				resultDTO.setName(rs.getString("name"));
				resultDTO.setJobPostSeq(rs.getString("jobPostSeq"));
				resultDTO.setPostName(rs.getString("postName"));
				resultDTO.setName(rs.getString("name"));
				resultDTO.setJobGroup(rs.getString("jobGroup"));
				resultDTO.setCareer(rs.getString("career"));
				resultDTO.setEducationLevel(rs.getString("educationLevel"));
				
				return resultDTO;
			}

		} catch (Exception e) {
			System.out.println("JobDAO.view()");
			e.printStackTrace();
		}

		return null;
	}











}
