package com.afd.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.afd.DBUtil;

/**
 * 관리자에게 필요한 데이터를 담고있는 클래스
 * @author 3조
 *
 */
public class AdminDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	/**
	 * 데이터베이스와 연결해주는 메소드
	 */
	public AdminDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("AdminDAO.AdminDAO()");
			e.printStackTrace();
		}

	}

	/**
	 * 관리자가 로그인을 할 수 있게 해주는 메소드
	 * @param dto
	 * @return result, null
	 */
	public AdminDTO login(AdminDTO dto) {
		
		try {
			
			String sql = "select * from tblAdmin where id = ? and pw = ?";
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				AdminDTO result = new AdminDTO();
				
				result.setAdminSeq(rs.getString("adminSeq"));
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				
				return result;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
