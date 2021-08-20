package com.afd.member.job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.afd.DBUtil;

public class CountDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public CountDAO() {

		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("CountDAO.CountDAO()");
			e.printStackTrace();
		}

	}

	public CountDTO genderCount(String jobPostSeq) {

		try {
			
			String sql = "select\r\n"
					+ "    count(case \r\n"
					+ "        substr(registrationnumber, 8, 1) when '2' then '여'\r\n"
					+ "    end) as woman, \r\n"
					+ "    count(case \r\n"
					+ "        substr(registrationnumber, 8, 1) when '1' then '남'\r\n"
					+ "    end) as man    \r\n"
					+ "from vwSeekerInfo where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, jobPostSeq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				CountDTO dto = new CountDTO();
				
				dto.setMan(rs.getInt("man"));
				dto.setWoman(rs.getInt("woman"));
				
				
				return dto;
			}
			
			
		} catch (Exception e) {
			System.out.println("CountDAO.genderCount");
			e.printStackTrace();
		}
		
		return null;
	}

	public CountDTO careerCount(String jobPostSeq) {

	try {
				
				String sql = "select \r\n"
						+ "    case career  when '신입' then '1'\r\n"
						+ "                     when '1년미만' then '2'\r\n"
						+ "                     when '1년이상~3년 미만' then '3'\r\n"
						+ "                     when '3년이상~5년 미만' then '4'\r\n"
						+ "                     when '5년 이상' then '5'  \r\n"
						+ "     end as career, "
						+ "     count(career) as count\r\n"
						+ "from vwSeekerInfo where jobPostSeq = ? group by career";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, jobPostSeq);
				
				rs = pstat.executeQuery();
				
				//CountDTO list = new CountDTO();
				
				CountDTO dto = new CountDTO();
				while(rs.next()) {
					
					
					if(rs.getString("career").equals("1")) {
						dto.setCareer1(rs.getInt("count"));
					}else if(rs.getString("career").equals("2")) {
						dto.setCareer2(rs.getInt("count"));
					}else if(rs.getString("career").equals("3")) {
						dto.setCareer3(rs.getInt("count"));
					}else if(rs.getString("career").equals("4")) {
						dto.setCareer4(rs.getInt("count"));
					}else if(rs.getString("career").equals("5")) {
						dto.setCareer5(rs.getInt("count"));
					}					
					
					
				}
				
				return dto;
				
				
			} catch (Exception e) {
				System.out.println("CountDAO.genderCount()");
				e.printStackTrace();
			}
			
			
			return null;
		}

	public int total(String jobPostSeq) {

		try {
			
			String sql = "select count(*) as count from vwSeekerInfo where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, jobPostSeq);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				return rs.getInt("count");
			}
			
		} catch (Exception e) {
			System.out.println("CountDAO.total()");
			e.printStackTrace();
		}
		
		return 0;
	}

	
}
