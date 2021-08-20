package com.afd.member.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.afd.DBUtil;

/**
 * 회원의 마이페이지를 위해 필요한 DAO
 * @author 3조
 *
 */
public class MyPageDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	/**
	 * DAO 파일을 데이터베이스와 연결하는 메소드
	 */
	public MyPageDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("MyPageDAO.MyPageDAO()");
			e.printStackTrace();
		}

	}

	/**
	 * 마이페이지에서 필요한 회원 한명의 정보를 출력하는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public MyPageDTO list(MyPageDTO dto) {
		
		try {
			
			String sql = "select * from tblMember where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setMemberSeq(rs.getString("memberSeq"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setNickName(rs.getString("nickName"));
				dto.setRegistrationNumber(rs.getString("registrationNumber"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 회원 한명의 프로필 정보를 출력하는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public MyPageDTO myProfileList(MyPageDTO dto) {
		
		try {
			
			String sql = "select * from vwMemberProfile where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setMemberProfileSeq(rs.getString("memberProfileSeq"));
				dto.setMemberSeq(rs.getString("memberSeq"));
				dto.setCareer(rs.getString("career"));
				dto.setAcademicBackground(rs.getString("academicBackground"));
				dto.setGender(rs.getString("gender"));
				dto.setInterestOccupation(rs.getString("interestOccupation"));
				dto.setAvailableLanguage(rs.getString("availableLanguage"));
				dto.setMajor(rs.getString("major"));
				dto.setScore(rs.getString("score"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setNickName(rs.getString("nickName"));
				dto.setRegistrationNumber(rs.getString("registrationNumber"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Q&A에서 스크랩한 게시글의 수를 출력하는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public MyPageDTO qnaScrapCount(MyPageDTO dto) {
		
		try {
			
			String sql = "select count(*) as qnaScrapCount from tblTechQnaScrap where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setQnaScrapCount(rs.getString("qnaScrapCount"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 스터디에서 스크랩한 게시글의 수를 출력하는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public MyPageDTO studyScrapCount(MyPageDTO dto) {
		
		try {
			
			String sql = "select count(*) as studyScrapCount from tblStudyScrap where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setStudyScrapCount(rs.getString("studyScrapCount"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 커뮤니티에서 스크랩한 게시글의 수를 출력하는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public MyPageDTO comScrapCount(MyPageDTO dto) {
		
		try {
			
			String sql = "select count(*) as comScrapCount from tblComScrap where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setComScrapCount(rs.getString("comScrapCount"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 채용공고에서 스크랩한 공고의 수를 출력하는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public MyPageDTO jobPostScrapCount(MyPageDTO dto) {
		
		try {
			
			String sql = "select count(*) as cnt from tblJobPostScrap where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setJobPostScrapCount(rs.getString("cnt"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 공간대여에서 스크랩한 게시글의 수를 출력하는 메소드
	 * @param dto
	 * @return dto, null
	 */
	public MyPageDTO spaceScrapCount(MyPageDTO dto) {
		
		try {
			
			String sql = "select count(*) as cnt from tblSpaceScrap where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setSpaceScrapCount(rs.getString("cnt"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 회원의 프로필 정보를 수정하는 메소드
	 * @param dto
	 * @return pstat.executeUpdate(), 0
	 */
	public int myProfileEdit(MyPageDTO dto) {
		
		try {
			
			String sql = "update tblMemberProfile set career = ?, academicBackground = ?, gender = ?, interestOccupation = ?, availableLanguage = ?, major = ? where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getCareer());
			pstat.setString(2, dto.getAcademicBackground());
			pstat.setString(3, dto.getGender());
			pstat.setString(4, dto.getInterestOccupation());
			pstat.setString(5, dto.getAvailableLanguage());
			pstat.setString(6, dto.getMajor());
			pstat.setString(7, dto.getMemberSeq());
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 회원의 계정 정보를 수정하는 메소드
	 * @param dto
	 * @return pstat.executeUpdate(), 0
	 */
	public int accountSettingEdit(MyPageDTO dto) {
		
		try {
			
			String sql = "update tblMember set name = ?, pw = ?, nickName = ?, registrationNumber = ?, tel = ?, address = ?, email = ? where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			System.out.println("name: " + dto.getName());
			System.out.println("pw: " + dto.getPw());
			System.out.println("nickName: " + dto.getNickName());
			System.out.println("registrationNumber: " + dto.getRegistrationNumber());
			System.out.println("tel: " + dto.getTel());
			System.out.println("addresss: " + dto.getAddress());
			System.out.println("email: " + dto.getEmail());
			System.out.println("memberSeq: " + dto.getMemberSeq());
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getNickName());
			pstat.setString(4, dto.getRegistrationNumber());
			pstat.setString(5, dto.getTel());
			pstat.setString(6, dto.getAddress());
			pstat.setString(7, dto.getEmail());
			pstat.setString(8, dto.getMemberSeq());
			
			System.out.println("DTO: " + dto.toString());
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 회원의 계정 정보를 관리자가 보게 해주는 메소드
	 * @param memberSeq
	 * @return dto, null
	 */
	public MyPageDTO accountView(String memberSeq) {
		
		try {
			
			MyPageDTO dto = new MyPageDTO();
			
			String sql = "select * from vwMember where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, memberSeq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setNickName(rs.getString("nickName"));
				dto.setName(rs.getString("name"));
				dto.setRegistrationNumber(rs.getString("registrationNumber"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				
				System.out.println("nickName: " + dto.getNickName());
				System.out.println("name: " + dto.getName());
				System.out.println("registrationNumber: " + dto.getRegistrationNumber());
				System.out.println("tel: " + dto.getTel());
				System.out.println("address: " + dto.getAddress());
				System.out.println("email: " + dto.getEmail());
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println("accountView");
			e.printStackTrace();
		}
		
		return null;
	}

	

}
