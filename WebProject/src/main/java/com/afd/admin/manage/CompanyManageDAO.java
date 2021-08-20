package com.afd.admin.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.afd.DBUtil;

/**
 * 관리자의 기업회원 관리를 위한 DAO
 * @author 3조
 *
 */
public class CompanyManageDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	/**
	 * DAO를 데이터베이스와 연결하는 메소드
	 */
	public CompanyManageDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("MyPageDAO.MyPageDAO()");
			e.printStackTrace();
		}

	}

	
	/**
	 * 기업회원의 목록을 보여주는 메소드
	 * @param map
	 * @return list, null
	 */
	public ArrayList<CompanyManageDTO> list(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("isSearch").equals("y")) {

				if (!(map.get("column").equals("all"))) {

					where = String.format("and %s like '%%%s%%'", map.get("column"), map.get("search"));

				}

			}

			String sql = String.format("select * from vwCompany where rnum between %s and %s %s", map.get("begin"), map.get("end"), where);

			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			ArrayList<CompanyManageDTO> list = new ArrayList<CompanyManageDTO>();
			
			System.out.println("SQL" + sql);

			while (rs.next()) {

				CompanyManageDTO dto = new CompanyManageDTO();

				dto.setCompanySeq(rs.getString("companySeq"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setRegistrationNumber(rs.getString("registrationNumber"));
				dto.setCompanyTel(rs.getString("companyTel"));
				dto.setManagerName(rs.getString("managerName"));
				dto.setManagerEmail(rs.getString("managerEmail"));
				dto.setCompanyURL(rs.getString("companyURL"));

				list.add(dto);

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
	 * 페이징 처리를 위해 필요한 총 페이지수를 구하는 메소드
	 * @param map
	 * @return pstat.executeQuery(), 0
	 */
	public int getTotalCount(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("isSearch").equals("y")) {

				if (!(map.get("column").equals("all"))) {

					where = String.format("where %s like '%%%s%%'", map.get("column"), map.get("search"));

				}

			}

			String sql = String.format("select count(*) as cnt from tblCompany %s", where);

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

}
