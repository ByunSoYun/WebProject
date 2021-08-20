package com.afd.admin.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.afd.DBUtil;

public class QnaDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public QnaDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("QnaDAO.QnaDAO()");
			e.printStackTrace();
		}

	}

	public ArrayList<QnaDTO> list(HashMap<String, String> map) {

		try {

			//이 메소드 입장
			//1. 목록보기
			//2. 검색하기
			
			String where = "";
			String sql = "";
			
			if (map.get("isSearch").equals("y")) {
				
				if (map.get("column").equals("all")) {
					where = String.format("title like '%%%s%%' or content like '%%%s%%'"
											, map.get("search"), map.get("search"));
				} else if (map.get("column").equals("title") || map.get("column").equals("content") || map.get("column").equals("nickName")) {
					where = String.format("%s like '%%%s%%'"
											, map.get("column"), map.get("search"));
				}
				
				sql = String.format("select b.*, rownum as rnum from (select a.*, rownum from\r\n"
						+ "                (select\r\n"
						+ "                techQnaSeq,\r\n"
						+ "                memberSeq,\r\n"
						+ "                title,\r\n"
						+ "                content,\r\n"
						+ "                regdate,\r\n"
						+ "                (sysdate - regdate) as isNew,\r\n"
						+ "                readCount,\r\n"
						+ "                image,\r\n"
						+ "                (select nickName from tblMember where memberSeq = tblTechQna.memberSeq) as nickName,\r\n"
						+ "                (select id from tblMember where memberSeq = tblTechQna.memberSeq) as id,\r\n"
						+ "                (select count(*) from tblTechQnaComment where techQnaSeq = tblTechQna.techQnaSeq) as ccnt,\r\n"
						+ "                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'y') as recommendCount,\r\n"
						+ "                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'n') as decommendCount\r\n"
						+ "from tblTechQna order by regdate desc) a where rownum between %s and %s and %s) b", map.get("begin"), map.get("end"), where);
				
			} else if (map.get("isSearch").equals("n")) {
				
				if (sql == null || sql.equals("")) {
					
					sql = String.format("select * from vwTechQnaOrderRegdate where rnum between %s and %s", map.get("begin"), map.get("end"));
					
				}
				
				if (map.get("orderRegdate") != null && map.get("orderRegdate").equals("regdate")) {
					
					sql = String.format("select * from vwTechQnaOrderRegdate where rnum between %s and %s", map.get("begin"), map.get("end"));
					
				} else if (map.get("orderRecommendCount") != null && map.get("orderRecommendCount").equals("recommendCount")) {
					
					sql = String.format("select * from vwTechQnaOrderRecommendCount where rnum between %s and %s", map.get("begin"), map.get("end"));
					
				} else if (map.get("orderComment") != null && map.get("orderComment").equals("ccnt")) {
					
					sql = String.format("select * from vwTechQnaOrderCcnt where rnum between %s and %s", map.get("begin"), map.get("end"));
					
				} else if (map.get("orderReadCount") != null && map.get("orderReadCount").equals("readCount")) {
					
					sql = String.format("select * from vwTechQnaOrderReadCount where rnum between %s and %s", map.get("begin"), map.get("end"));
					
				}
				
			} 
			
//			System.out.println("SQL문: " + sql);
				
			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();

			while (rs.next()) {

				QnaDTO dto = new QnaDTO();

				dto.setTechQnaSeq(rs.getString("techQnaSeq"));
				dto.setMemberSeq(rs.getString("memberSeq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setImage(rs.getString("image"));
				dto.setNickName(rs.getString("nickName"));
				dto.setId(rs.getString("id"));
				dto.setCcnt(rs.getString("ccnt"));
				dto.setIsNew(rs.getString("isNew"));
				dto.setReadCount(rs.getString("readCount"));
				dto.setRecommendCount(rs.getString("recommendCount"));
				dto.setDecommendCount(rs.getString("decommendCount"));

				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public QnaDTO get(String techQnaSeq) {

		try {

			QnaDTO dto = new QnaDTO();

			String sql = "select * from vwTechQna where techQnaSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, techQnaSeq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				dto.setTechQnaSeq(rs.getString("techQnaSeq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setNickName(rs.getString("nickName"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setId(rs.getString("id"));
				dto.setReadCount(rs.getString("readCount"));
				dto.setCcnt(rs.getString("ccnt"));
				dto.setRecommendCount(rs.getString("recommendCount"));
				dto.setDecommendCount(rs.getString("decommendCount"));
				dto.setMemberSeq(rs.getString("memberSeq"));
				dto.setId(rs.getString("id"));
				

				return dto;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int add(QnaDTO dto) {

		try {

			String sql = "insert into tblTechQna (techQnaSeq, memberSeq, title, content, regdate, readCount) values (techQnaSeq.nextVal, ?, ?, ?, default, default)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContent());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<CommentDTO> commentList(String techQnaSeq) {

		try {

			String sql = "select * from vwTechQnaComment where techQnaSeq = ? order by techQnaCommentSeq desc";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, techQnaSeq);

			rs = pstat.executeQuery();

			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();

			while (rs.next()) {

				CommentDTO dto = new CommentDTO();

				dto.setTechQnaCommentSeq(rs.getString("techQnaCommentSeq"));
				dto.setTechQnaSeq(rs.getString("techQnaSeq"));
				dto.setMemberSeq(rs.getString("memberSeq"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setContent(rs.getString("content"));
				dto.setNickName(rs.getString("nickName"));
				dto.setId(rs.getString("id"));

				clist.add(dto);

			}

			return clist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int del(String techQnaSeq) {

		try {

			String sql = "delete from tblTechQna where techQnaSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, techQnaSeq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public void delAllComment(String techQnaSeq) {

		try {

			String sql = "delete from tblTechQnaComment where techQnaSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, techQnaSeq);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delAllRecommend(String techQnaSeq) {

		try {

			String sql = "delete from tblTechQnaRecommend where techQnaSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, techQnaSeq);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delAllScrap(String techQnaSeq) {

		try {

			String sql = "delete from tblTechQnaScrap where techQnaSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, techQnaSeq);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int edit(QnaDTO dto) {

		try {

			String sql = "update tblTechQna set title = ?, content = ? where techQnaSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getTechQnaSeq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public void updateReadCount(String techQnaSeq) {

		try {

			String sql = "update tblTechQna set readCount = readCount + 1 where techQnaSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, techQnaSeq);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getTotalCount(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("isSearch").equals("y")) {

				if (map.get("column").equals("all")) {
					where = String.format(" where title like '%%%s%%' or content like '%%%s%%' ", map.get("search"),
							map.get("search"));
				} else {
					where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
				}

			}

			String sql = String.format("select count(*) as cnt from vwTechQna %s", where);

			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int addComment(CommentDTO dto) {

		try {

			String sql = "insert into tblTechQnaComment (techQnaCommentSeq, techQnaSeq, memberSeq, regdate, content) values (techQnaCommentSeq.nextVal, ?, ?, default, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getTechQnaSeq());
			pstat.setString(2, dto.getMemberSeq());
			pstat.setString(3, dto.getContent());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int delComment(String techQnaCommentSeq) {

		try {

			String sql = "delete from tblTechQnaComment where techQnaCommentSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, techQnaCommentSeq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int recommend(QnaDTO dto) {

		try {

			String sql = "insert into tblTechQnaRecommend (techQnaRecSeq, memberSeq, techQnaSeq, recommend) values (techQnaRecSeq.nextVal, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getTechQnaSeq());
			pstat.setString(3, dto.getRecommendCount());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int decommend(QnaDTO dto) {

		try {

			String sql = "insert into tblTechQnaRecommend (techQnaRecSeq, memberSeq, techQnaSeq, recommend) values (techQnaRecSeq.nextVal, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getTechQnaSeq());
			pstat.setString(3, dto.getDecommendCount());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public QnaDTO scrap(String techQnaSeq) {
		
		try {
			
			String sql = "select count(*) as cnt from tblTechQnaScrap where techQnaSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, techQnaSeq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				QnaDTO dto = new QnaDTO();
				
				dto.setScrapCount(rs.getString("cnt"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int addScrap(QnaDTO dto) {
		
		try {
			
			String sql = "insert into tblTechQnaScrap (techQnaScSeq, memberSeq, techQnaSeq) values (techQnaScSeq.nextVal, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getTechQnaSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<QnaDTO> recommendList(String techQnaSeq) {
		
		ArrayList<QnaDTO> recommendList = new ArrayList<QnaDTO>();
		
		try {
			
			
			String sql = "select re.*, (select id from tblMember where memberSeq = re.memberSeq) as id from tblTechQnaRecommend re where techQnaSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, techQnaSeq);
			
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				
				QnaDTO recommendListDTO = new QnaDTO();
				
				recommendListDTO.setTechQnaSeq(rs.getString("techQnaSeq"));
				recommendListDTO.setMemberSeq(rs.getString("memberSeq"));
				recommendListDTO.setRecommend(rs.getString("recommend"));
				recommendListDTO.setId(rs.getString("id"));
				
				
				
				recommendList.add(recommendListDTO);
				
			}
			
			return recommendList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<QnaDTO> scrapList(String techQnaSeq) {
		
		try {
			
			ArrayList<QnaDTO> scrapList = new ArrayList<QnaDTO>();
			
			String sql = "select * from tblTechQnaScrap where techQnaSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, techQnaSeq);
			
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				
				QnaDTO dto = new QnaDTO();
				
				dto.setMemberSeq(rs.getString("memberSeq"));
				
				scrapList.add(dto);
				
			}
			
			return scrapList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int delScrap(QnaDTO dto) {
		
		try {
			
			String sql = "delete from tblTechQnaScrap where techQnaSeq = ? and memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getTechQnaSeq());
			pstat.setString(2, dto.getMemberSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	

	


}
