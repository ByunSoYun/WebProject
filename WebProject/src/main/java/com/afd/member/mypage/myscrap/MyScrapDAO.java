package com.afd.member.mypage.myscrap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.afd.DBUtil;

/**
 * 자신의 스크랩 내역을 보여주기 위해 필요한 DAO
 * @author 3조
 *
 */
public class MyScrapDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	/**
	 * MyScrapDAO를 데이터베이스와 연결하는 메소드
	 */
	public MyScrapDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("MyPageDAO.MyPageDAO()");
			e.printStackTrace();
		}

	}

	/**
	 * 회원 한명의 정보를 보여주는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public MyScrapDTO list(MyScrapDTO dto) {
		
		try {
			
			String sql = "select * from tblMember where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setRegistrationNumber(rs.getString("registrationNumber"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println("list");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 회원 한명의 스크랩 내역을 보여주는 메소드
	 * @param dto
	 * @return scrapList, null
	 */
	public ArrayList<MyScrapDTO> scrapList(MyScrapDTO dto) {
		
		try {
			
			String sql = "select * from vwTechQna q\r\n"
					+ "    inner join tblTechQnaScrap s\r\n"
					+ "        on q.techQnaSeq = s.techQnaSeq\r\n"
					+ "            where s.memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			ArrayList<MyScrapDTO> scrapList = new ArrayList<MyScrapDTO>();
			
			while (rs.next()) {
				
				MyScrapDTO result = new MyScrapDTO();
				
				result.setTechQnaSeq(rs.getString("techQnaSeq"));
				result.setMemberSeq(rs.getString("memberSeq"));
				result.setTitle(rs.getString("title"));
				result.setContent(rs.getString("content"));
				result.setRegdate(rs.getString("regdate"));
				result.setReadCount(rs.getString("readCount"));
				result.setNickName(rs.getString("nickName"));
				result.setCcnt(rs.getString("ccnt"));
				result.setRecommendCount(rs.getString("recommendCount"));
				result.setDecommendCount(rs.getString("decommendCount"));
				
				scrapList.add(result);
				
			}
			
			return scrapList;
			
			
			
		} catch (Exception e) {
			System.out.println("scrapList");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 회원 한명의 스크랩 수를 보여주는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public MyScrapDTO scrapCount(MyScrapDTO dto) {
		
		try {
			
			String sql = "select name, (select count(*) from tblComScrap where memberSeq = ?) as communityScrapCount, (select count(*) from tblTechQnaScrap where memberSeq = ?) as qnaScrapCount, (select count(*) from tblStudyScrap where memberSeq = ?) as studyScrapCount, (select count(*) from tblJobPostScrap where memberSeq = ?) as jobPostScrapCount, (select count(*) from tblSpaceScrap where memberSeq = ?) as spaceScrapCount from tblMember where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getMemberSeq());
			pstat.setString(3, dto.getMemberSeq());
			pstat.setString(4, dto.getMemberSeq());
			pstat.setString(5, dto.getMemberSeq());
			pstat.setString(6, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setCommunityScrapCount(rs.getString("communityScrapCount"));
				dto.setQnaScrapCount(rs.getString("qnaScrapCount"));
				dto.setStudyScrapCount(rs.getString("studyScrapCount"));
				dto.setJobPostScrapCount(rs.getString("jobPostScrapCount"));
				dto.setSpaceScrapCount(rs.getString("spaceScrapCount"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println("scrapCount");
			e.printStackTrace();
		}
		
		return null;
	}

	

}
