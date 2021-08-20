package com.afd.member.mypage.chart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.afd.DBUtil;

/**
 * 자신이 작성한 게시글 내역을 차트로 보여주기 위해 필요한 DAO
 * @author 3조
 *
 */
public class ChartDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	/**
	 * 데이터베이스와 연결해주는 메소드
	 */
	public ChartDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("ChartDAO.ChartDAO()");
			e.printStackTrace();
		}

	}

	/**
	 * 자신이 작성한 게시글의 개수를 보여주는 SQL문을 실행하는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public ChartDTO boardCount(ChartDTO dto) {
		
		try {
			
			String sql = "select name, (select count(*) from tblTechQna where memberSeq = ?) as qnaCount, (select count(*) from tblCommunity where memberSeq = ?) as communityCount, (select count(*) from tblStudyPost where memberSeq = ?) as studyCount from tblMember where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getMemberSeq());
			pstat.setString(3, dto.getMemberSeq());
			pstat.setString(4, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setName(rs.getString("name"));
				dto.setQnaCount(rs.getString("qnaCount"));
				dto.setCommunityCount(rs.getString("communityCount"));
				dto.setStudyCount(rs.getString("studyCount"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 자신이 작성한 댓글수를 보여주는 SQL문을 실행하는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public ChartDTO commentCount(ChartDTO dto) {
		
		try {
			
			String sql = "select name, (select count(*) from tblTechQnaComment where memberSeq = ?) as qnaCommentCount, (select count(*) from tblCommunityComment where memberSeq = ?) as communityCommentCount, (select count(*) from tblStudyComment where memberSeq = ?) as studyCommentCount from tblMember where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getMemberSeq());
			pstat.setString(3, dto.getMemberSeq());
			pstat.setString(4, dto.getMemberSeq());
			
			/**
			 * SQL문이 성공하면 DTO에 이름과, 커뮤니티 댓글수, Q&A 댓글수, 스터디 댓글수를 저장한다.
			 */
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setName(rs.getString("name"));
				dto.setCommunityCommentCount(rs.getString("communityCommentCount"));
				dto.setQnaCommentCount(rs.getString("qnaCommentCount"));
				dto.setStudyCommentCount(rs.getString("studyCommentCount"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
