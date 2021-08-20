package com.afd.company.job.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.afd.DBUtil;

public class PostDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public PostDAO() {
		
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("PostDAO.PostDAO()");
			e.printStackTrace();
		}
		
	}

	public int add(PostDTO dto) {

		try {
			
			String sql = "INSERT INTO tblJobPost (jobPostSeq, companySeq, postName, regdate, jobGroup, career, educationLevel, jobType, salary, attachedFile, postContent, startDate, endDate) "
					+ "values (jobPostSeq.nextVal, ?, ?, default, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getCompanySeq());
			pstat.setString(2, dto.getPostName());
			pstat.setString(3, dto.getJobGroup());
			pstat.setString(4, dto.getCareer());
			pstat.setString(5, dto.getEducationLevel());
			pstat.setString(6, dto.getJobType());
			pstat.setString(7, dto.getSalary());
			pstat.setString(8, dto.getAttachedFile());
			pstat.setString(9, dto.getPostContent());
			pstat.setString(10, dto.getStartDate());
			pstat.setString(11, dto.getEndDate());
			

			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("PostDAO.add()");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public int locAdd(LocationDTO locdto) {

		try {

			String sql = "insert into tblJobLocation VALUES "
					+ "(jobLocSeq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, locdto.getJobPostSeq());
			pstat.setString(2, locdto.getCity());
			pstat.setString(3, locdto.getGu());
			pstat.setString(4, locdto.getDong());
			pstat.setString(5, locdto.getAddress());
			pstat.setString(6, locdto.getLatitude());
			pstat.setString(7, locdto.getLongitude());

			return pstat.executeUpdate();

			
		} catch (Exception e) {
			System.out.println("PostDAO.locAdd()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public PostDTO findlastPost() {

		try {
			
			String sql = "select max(jobPostSeq) as jobPostSeq from tblJobPost";
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				PostDTO dto = new PostDTO();
				
				dto.setJobPostSeq(rs.getString("jobPostSeq"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("PostDAO.findlastPost()");
			e.printStackTrace();
		}
		
		return null;
	}

	public PostDTO postInfo(String jobPostSeq) {

		try {
			
			String sql = "select * from vwJobView where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				PostDTO dto = new PostDTO();
				
				dto.setJobPostSeq(rs.getString("jobPostSeq"));
				dto.setPostName(rs.getString("postName"));
				dto.setCareer(rs.getString("career"));
				dto.setEducationLevel(rs.getString("educationLevel"));
				dto.setJobGroup(rs.getString("jobGroup"));
				dto.setSalary(rs.getString("salary"));
				dto.setJobType(rs.getString("jobType"));
				dto.setAttachedFile(rs.getString("attachedFile"));
				dto.setPostContent(rs.getString("postContent"));
				dto.setPostName(rs.getString("postName"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				
				dto.setJobLocSeq(rs.getString("jobLocSeq"));
				dto.setCity(rs.getString("city"));
				dto.setGu(rs.getString("gu"));
				dto.setDong(rs.getString("dong"));
				dto.setAddress(rs.getString("address"));
				dto.setLatitude(rs.getString("latitude"));
				dto.setLongitude(rs.getString("longitude"));
								
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("PostDAO.postInfo()");
			e.printStackTrace();
		}
		
		return null;
	}

	public int edit(PostDTO dto) {

		try {
			String sql = "update tblJobPost set postName = ?, jobGroup=?, career=?, educationLevel=?, jobType=?,salary=?,attachedFile=?,postContent=?,startDate=?,endDate=? where jobPostSeq =?";
		
			pstat = conn.prepareStatement(sql);
						
			pstat.setString(1, dto.getPostName());
			pstat.setString(2, dto.getJobGroup());
			pstat.setString(3, dto.getCareer());
			pstat.setString(4, dto.getEducationLevel());
			pstat.setString(5, dto.getJobType());
			pstat.setString(6, dto.getSalary());
			pstat.setString(7, dto.getAttachedFile());
			pstat.setString(8, dto.getPostContent());
			pstat.setString(9, dto.getStartDate());
			pstat.setString(10, dto.getEndDate());
			pstat.setString(11, dto.getJobPostSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.edit()");
			e.printStackTrace();
		}
		
		return 0;
	
	}

	public int locedit(LocationDTO locdto) {


		try {
			String sql = "update tblJobLocation set city = ?, gu=?, dong=?, address=?, latitude=?, longitude=? where jobPostSeq =?";
		
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, locdto.getCity());
			pstat.setString(2, locdto.getGu());
			pstat.setString(3, locdto.getDong());
			pstat.setString(4, locdto.getAddress());
			pstat.setString(5, locdto.getLatitude());
			pstat.setString(6, locdto.getLongitude());
			pstat.setString(7, locdto.getJobPostSeq());

			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("PostDAO.locedit()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int postDelete(String jobPostSeq) {

		try {
			
			postScrapDelete(jobPostSeq);
			postSeekerDelete(jobPostSeq);
			postLocDelete(jobPostSeq);
			
			String sql = "delete from tblJobPost where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.postDelete()");
			e.printStackTrace();
		}
		
		return 0;
	}

	private void postLocDelete(String jobPostSeq) {

		try {
			
			String sql = "delete from tblJobLocation where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.postDelete()");
			e.printStackTrace();
		}
		
	}

	private void postSeekerDelete(String jobPostSeq) {
		
		try {
			
			String sql = "delete from tblJobSeekerInfo where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.postDelete()");
			e.printStackTrace();
		}
		
	}

	private void postScrapDelete(String jobPostSeq) {
		
		try {
			
			String sql = "delete from tblJobPostScrap where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.postDelete()");
			e.printStackTrace();
		}
		
	}
	
}
