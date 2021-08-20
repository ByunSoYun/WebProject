package com.afd.admin.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.afd.DBUtil;

/**
 * 관리자가 회원관리를 위해 필요한 데이터를 담은 클래스
 * @author 3조
 *
 */
public class MemberManageDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	
	/**
	 * 데이터베이스와 연결해주는 메소드
	 */
	public MemberManageDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("MyPageDAO.MyPageDAO()");
			e.printStackTrace();
		}

	}

	
	/**
	 * 관리자에게 일반 회원 목록을 보여주는 메소드
	 * @param map
	 * @return list, null
	 */
	public ArrayList<MemberManageDTO> list(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("isSearch").equals("y")) {
				
				if (!(map.get("column").equals("all"))) {
					
					where = String.format("and %s like '%%%s%%'", map.get("column"), map.get("search"));
					
				}
				
			}
			
			String sql = String.format("select * from vwMember2 where rnum between %s and %s %s order by memberSeq asc", map.get("begin"), map.get("end"), where);
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			ArrayList<MemberManageDTO> list = new ArrayList<MemberManageDTO>();
			
			while (rs.next()) {
				
				MemberManageDTO result = new MemberManageDTO();
				
				result.setMemberSeq(rs.getString("memberSeq"));
				result.setName(rs.getString("name"));
				result.setId(rs.getString("id"));
				result.setNickName(rs.getString("nickName"));
				result.setRegistrationNumber(rs.getString("registrationNumber"));
				result.setTel(rs.getString("tel"));
				result.setAddress(rs.getString("address"));
				result.setEmail(rs.getString("email"));
				result.setScore(rs.getString("score"));
				
				list.add(result);
				
			}
			
//			System.out.println("list: " + list.toString());
			
			return list;
			
		} catch (Exception e) {
			System.out.println("list");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 일반 회원 목록을 보여줄 때 페이징 처리를 위해 필요한 총 페이지수를 구해주는 메소드
	 * @param map
	 * @return rs.getInt("cnt"), 0
	 */
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("isSearch").equals("y")) {
				
				if (!(map.get("column").equals("all"))) {
					
					where = String.format("where %s like '%%%s%%'", map.get("column"), map.get("search"));
					
				}
				
			}
			
			String sql = String.format("select count(*) as cnt from vwMember %s", where);
			
			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("getTotalCount");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 일반 회원을 삭제하기 위한 메소드
	 * @param memberSeq
	 * @return 0
	 */
	public int deleteMember(String memberSeq) {
		
		try {
			
			String sql = "";
			
		} catch (Exception e) {
			System.out.println("deleteMember");
			e.printStackTrace();
		}
		
		return 0;
	}

}
