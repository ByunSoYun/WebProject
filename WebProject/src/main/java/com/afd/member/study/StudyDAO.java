package com.afd.member.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.afd.DBUtil;



public class StudyDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public StudyDAO() {
		
		try {

			conn = DBUtil.open();
			

		} catch (Exception e) {
			
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

	



	
	//List 서블릿이 게시판 목록
	public ArrayList<StudyDTO> list(HashMap<String, String> map) {
		
		try {

			String where = "";
			String sql ="";
			
			if (map.get("isSearch").equals("yb")) {
				
				if(map.get("column").equals("all")) {
					where = String.format(" (postTitle like '%%%s%%' or content like '%%%s%%')"
												,map.get("search"), map.get("search"));
				} else {
					where = String.format("  %s like '%%%s%%' ", map.get("column"), map.get("search"));
				}
				
				
				
				sql = String.format(
						"select * from\r\n"
						+ "(select b.*, rownum as rrnum from ( \r\n"
						+ "select * from vwstudy where %s) b) where rrnum between %s and %s "
						, where ,map.get("begin"), map.get("end"));
				
				
			} else if(map.get("isSearch").equals("ya")) {				
				

		         if (map.get("city") != null && !map.get("city").equals("all")) {

		            if (map.get("gu") != null && map.get("gu").equals("all")) {
		               where += String.format(" and city = '%s'", map.get("city"));
		            } else if (map.get("gu") != null && !map.get("gu").equals("all")) {
		               where += String.format(" and city = '%s' and gu = '%s' ", map.get("city"), map.get("gu"));
		            }
		         }
		         
		         if (map.get("period") != null && !map.get("period").equals("all")) {
		            where += String.format("and period = '%s' ", map.get("period"));
		         }

		         if (map.get("jobGroup") != null && !map.get("jobGroup").equals("all")) {
		            where += String.format("and jobGroup = '%s' ", map.get("jobGroup"));
		         }

				
	
		         sql = String.format(
							"select * from\r\n"
							+ "(select b.*, rownum as rrnum from ( \r\n"
							+ "select * from vwstudy where studypostseq > 0 %s) b) where rrnum between %s and %s "
							, where ,map.get("begin"), map.get("end"));
				
				
				
				
			
			} else { //(map.get("isSearch").equals("n")
				sql = String.format("select * from vwStudy where rnum between %s and %s %s"
						, map.get("begin")
						, map.get("end")
						, where);
				
			}
			
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			ArrayList<StudyDTO> list = new ArrayList<StudyDTO>();
			
			while (rs.next()) {
				
				StudyDTO dto = new StudyDTO();
				
				dto.setStudyPostSeq(rs.getString("studyPostSeq"));
				dto.setPostTitle(rs.getString("postTitle"));
				dto.setReadCount(rs.getString("readCount"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadCount(rs.getString("readCount"));
				dto.setScrapCount(rs.getString("scrapCount"));
				dto.setCommentCount(rs.getString("commentCount"));
				dto.setRecommendCount(rs.getString("recommendCount"));
				dto.setDecommendCount(rs.getString("decommendCount"));
				dto.setNickName(rs.getString("nickName"));
				dto.setIsnew(rs.getInt("isnew"));
				dto.setRnum(rs.getString("rnum"));
				dto.setClose(rs.getString("close"));
				
				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	//list 서블릿이 총 게시물 수 알려달라고 요청
	public int getTotalCount(HashMap<String, String> map) {
		try {

			String where = "";
			
			if (map.get("isSearch").equals("yb")) {
				
				if(map.get("column").equals("all")) {
					where = String.format("and postTitle like '%%%s%%' or content like '%%%s%%'"
												,map.get("search"), map.get("search"));
				} else {
					where = String.format(" and %s like '%%%s%%' ", map.get("column"), map.get("search"));
				}
				
			}
			
			if (map.get("isSearch").equals("ya")) {
				
//				where = String.format(" where city like '%%%s%%' and  gu like '%%%s%%' and period like '%%%s%%' and jobGroup like '%%%s%%'" ,
//						map.get("city"), map.get("gu"), map.get("period"), map.get("jobGroup"));
				
				if (map.get("city") != null && !map.get("city").equals("all")&& !map.get("city").equals("null")) {

		            if (map.get("gu") != null && map.get("gu").equals("all") && map.get("gu").equals("null")) {
		               where += String.format(" and city = '%s'", map.get("city"));
		            } else if (map.get("gu") != null && !map.get("gu").equals("all")&& !map.get("gu").equals("null")) {
		               where += String.format(" and city = '%s' and gu = '%s' ", map.get("city"), map.get("gu"));
		            }
		         }
		         
		         if (map.get("period") != null && !map.get("period").equals("all") && !map.get("period").equals("null")) {
		            where += String.format("and period = '%s' ", map.get("period"));
		         }

		         if (map.get("jobGroup") != null && !map.get("jobGroup").equals("all") && !map.get("jobGroup").equals("null")) {
		            where += String.format("and jobGroup = '%s' ", map.get("jobGroup"));
		         }
			
			}
			
			String sql = "select count(*) as cnt from vwStudy where studypostseq > 0 " + where;
			
			
			
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
			System.out.println(sql);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	

	//view에서 조회수 업데이트하기
	public void updateReadcount(String studyPostSeq) {
		
		try {

			String sql = "update tblStudyPost set readcount = readcount + 1 where studypostseq =" + studyPostSeq;
			
			pstat = conn.prepareStatement(sql);
			
			pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}


	//view 서블릿이 글번호 주고 게시물 받기
	public StudyDTO get(String studyPostSeq) {
		
		try {

			String sql ="select * from vwstudy where studyPostSeq =?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, studyPostSeq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				StudyDTO dto = new StudyDTO();
				
	
				
				
				dto.setStudyPostSeq(rs.getString("studyPostSeq"));
				dto.setMemberSeq(rs.getString("memberSeq"));
				dto.setPostTitle(rs.getString("postTitle"));
				dto.setContent(rs.getString("content"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadCount(rs.getString("readCount"));
				dto.setMemberCount(rs.getString("memberCount"));
				dto.setAgeGroup(rs.getString("ageGroup"));
				dto.setCareer(rs.getString("career"));
				dto.setMajor(rs.getString("major"));
				dto.setJobGroup(rs.getString("jobGroup"));
				dto.setLanguage(rs.getString("language"));
				dto.setPeriod(rs.getString("period"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setPurpose(rs.getString("purpose"));
				dto.setNickName(rs.getString("nickName"));
				dto.setScrapCount(rs.getString("scrapCount"));
				dto.setRecommendCount(rs.getString("recommendCount"));
				dto.setDecommendCount(rs.getString("decommendCount"));
				dto.setScrapCount(rs.getString("scrapCount"));
				dto.setCommentCount(rs.getString("commentCount"));
				dto.setScore(rs.getString("score"));
				dto.setCity(rs.getString("city"));
				dto.setGu(rs.getString("gu"));
				dto.setLatitude(rs.getString("latitude"));
				dto.setLongitude(rs.getString("longitude"));
				dto.setClose(rs.getString("close"));
			
				
				return dto;
				
			}
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return null;
	}

	//view에게 commentlist 댓글 목록 돌려주기
	public ArrayList<CommentDTO> listComment(String studyPostSeq) {
		
		try {

			String sql = "select * from vwcomment where studyPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, studyPostSeq);
			
			rs = pstat.executeQuery();
			
			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();
			
			
			while(rs.next()) {
				
				CommentDTO dto = new CommentDTO();
				dto.setCommentSeq(rs.getString("studyCommentSeq"));
				dto.setCommentPostSeq(rs.getString("studyPostSeq"));
				dto.setCommentMemberSeq(rs.getString("memberSeq"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				
				dto.setIsnew(rs.getString("isnew"));
				dto.setNickName(rs.getString("nickName"));
				
				
				clist.add(dto);
				
			}
			
			return clist;
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return null;
	}

	//view에 스크랩수 list를 돌려주세요
	public ArrayList<ScrapDTO> listScrap(String studyPostSeq) {
		
		try {

			String sql = "select * from tblStudyScrap where studyPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, studyPostSeq);
			
			rs = pstat.executeQuery();
			
			ArrayList<ScrapDTO> slist = new ArrayList<ScrapDTO>();
			
			
			while(rs.next()) {
				
				
				ScrapDTO dto = new ScrapDTO();
				dto.setScrapSeq(rs.getString("studyScrapSeq"));
				dto.setScrapMemberSeq(rs.getString("memberSeq"));
				dto.setScrapStudyPost(rs.getString("studyPostSeq"));
				
				
				slist.add(dto);
				
			}
			
			return slist;
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}


	//view에 추천비추천 list를 돌려주자~!
	public ArrayList<RecommendDTO> recommendScrap(String studyPostSeq) {
		
		try {

			String sql = "select * from tblStudyRecommend where studyPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, studyPostSeq);
			
			rs = pstat.executeQuery();
			
			ArrayList<RecommendDTO> rlist = new ArrayList<RecommendDTO>();
			
			
			while(rs.next()) {
				
				RecommendDTO dto = new RecommendDTO();
				
				
				dto.setStudyRecommendSeq(rs.getString("studyRecommendSeq"));
				dto.setRecommend(rs.getString("recommend"));
				dto.setRecommendMemberSeq(rs.getString("memberSeq"));
				dto.setRecommendPostSeq(rs.getString("studyPostSeq"));
				
				
				rlist.add(dto);
				
			}
			
			return rlist;
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return null;
	}

	//Scrap에서 스크랩을 추가! 
	public int addScrap(ScrapDTO dto) {
		
		try {

			String sql = "INSERT INTO tblStudyScrap (studyScrapSeq, memberSeq, studyPostSeq) values (studyScrapSeq.nextVal, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getScrapMemberSeq());
			pstat.setString(2, dto.getScrapStudyPost());
			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}

	//Scrap에서 스크랩 삭제
	public int delScrap(ScrapDTO dto) {
		
		try {

			String sql = "delete from tblStudyScrap where memberseq = ? and studypostseq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getScrapMemberSeq());
			pstat.setString(2, dto.getScrapStudyPost());
			
			return pstat.executeUpdate();

			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}

	//recommedOk.java에서 check= rec를  n -> y
	public int recChange(RecommendDTO dto) {
		
		try {

			String sql ="update tblStudyRecommend set recommend = 'y' where studyPostSeq= ? and memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getRecommendPostSeq());
			pstat.setString(2, dto.getRecommendMemberSeq());
			
			int result =  pstat.executeUpdate();
			return result;
			
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}


	//recommedOk.java에서 check= rec를  y -> n
	public int decChange(RecommendDTO dto) {
		
		try {

			String sql ="update tblStudyRecommend set recommend = 'n' where studyPostSeq= ? and memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getRecommendPostSeq());
			pstat.setString(2, dto.getRecommendMemberSeq());
			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
		
	}

	//recommedOk.java에서 check= emptyrec를  insert y
	public int recNew(RecommendDTO dto) {
		
		try {

			String sql ="INSERT INTO tblStudyrecommend (studyRecommendSeq, recommend, memberSeq, studyPostSeq) values (studyRecommendSeq.nextVal, 'y', ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getRecommendMemberSeq());
			pstat.setString(2, dto.getRecommendPostSeq());
			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}



	//recommedOk.java에서 check= emptyrec를  insert n
	public int decCNew(RecommendDTO dto) {

		try {

			String sql ="INSERT INTO tblStudyrecommend (studyRecommendSeq, recommend, memberSeq, studyPostSeq) values (studyRecommendSeq.nextVal, 'n', ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getRecommendMemberSeq());
			pstat.setString(2, dto.getRecommendPostSeq());
			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}


	//AddOk에서 tblStudyPost테이블에 레코드 삽입
	public int addPost(StudyDTO dto) {
		
		try {
			
			String sql ="INSERT INTO TblStudyPost (studyPostSeq, memberSeq, postTitle, content, name, regdate, readCount, memberCount, ageGroup, career, major, jobGroup, language, period, startDate, endDate, purpose, close) values "
					+ "(studyPostSeq.nextVal, ?, ?, ?, ?, sysdate, 0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
			
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getPostTitle());
			pstat.setString(3, dto.getContent()); 
			pstat.setString(4, dto.getName());
			pstat.setString(5, dto.getMemberCount());
			pstat.setString(6, dto.getAgeGroup());
			pstat.setString(7, dto.getCareer());
			pstat.setString(8, dto.getMajor());
			pstat.setString(9, dto.getJobGroup());
			pstat.setString(10, dto.getLanguage());
			pstat.setString(11, dto.getPeriod());
			pstat.setString(12, dto.getStartDate());
			pstat.setString(13, dto.getEndDate());
			pstat.setString(14, dto.getPurpose());

			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return 0;
	}
	

	//AddOk.java로 새글의 seq를 반환한다.
	public int maxPostSeq() {
		
		try {

			String sql = "select max(studypostseq) as studypostseq from TblStudyPost";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			
			while (rs.next()) {
				
				return rs.getInt("studypostseq");
			}
			
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		return 0;
	}

	

	//AddOk.java가 tblStudyLocation에 값을 넣는다.
	public int addLocation(StudyDTO dto) {
		
		try {

			String sql ="insert into tblStudyLocation VALUES (studyLocSeq.nextval, ?, ?, ? , ?, ?) "	;
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getStudyPostSeq());
			pstat.setString(2, dto.getCity());
			pstat.setString(3, dto.getGu()); 
			pstat.setString(4, dto.getLatitude()); 
			pstat.setString(5, dto.getLongitude()); 
			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		return 0;
	}


	//AddComment.java가 tblStudyComment에 값을 넣는다.
	public int addComment(CommentDTO dto) {
		
		try {
			//스터디댓글더미(고유번호, 스터디공고고유번호, 회원고유번호, 날짜, 내용)
			
			String sql ="insert into tblStudyComment values (studyCommentSeq.nextVal, ?, ?, sysdate, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getCommentPostSeq());
			pstat.setString(2, dto.getCommentMemberSeq());
			pstat.setString(3, dto.getContent());
			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return 0;
	}


	//CommentDelete.java가 tblStudyComment에 레코드를 삭제한다.
	public int delComment(String seq) {
		
		try {
			
			String sql ="delete from tblStudyComment where StudyCommentSeq = " + seq;
			
			stat = conn.createStatement();
			
			return stat.executeUpdate(sql);
			
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return 0;
	}


	//Delete.java에서 tblstudycomment에서 해당 레코드를 삭제한다.
	public int delAllComment(String seq) {
		
		try {

			String sql ="delete from tblstudycomment where studypostseq=" + seq;
			
			stat = conn.createStatement();
			
			return stat.executeUpdate(sql);
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return 0;
	}
	

	//Delete.java에서 tblstudyscrap에서 해당 레코드를 삭제한다.
	public int delAllScrap(String seq) {
		

		try {

			String sql ="delete from tblstudyscrap where studypostseq=" + seq;
			
			stat = conn.createStatement();
			
			return stat.executeUpdate(sql);
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}




	//Delete.java에서 tblstudyrecommend에서 해당 레코드를 삭제한다
	public int delAllRecomend(String seq) {
		
		try {

			String sql ="delete from tblstudyrecommend where studypostseq=" + seq;
			
			stat = conn.createStatement();
			
			return stat.executeUpdate(sql);
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}




	//Delete.java에서 tblstudylocation에서 해당 레코드를 삭제한다
	public int delAllLocation(String seq) {
		
		try {

			String sql ="delete from tblstudylocation where studypostseq=" + seq;
			
			stat = conn.createStatement();
			
			return stat.executeUpdate(sql);
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}




	//Delete.java에서 tblstudypost에서 해당 레코드를 삭제한다
	public int delAllStrudy(String seq) {
		
		try {

			String sql ="delete from tblstudypost where studypostseq=" + seq;
			
			stat = conn.createStatement();
			
			return stat.executeUpdate(sql);
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}





	//Apply.java에서 tblStudySeekerInfo에 레코드 추가한다.
	public int addApply(SeekerInfoDTO dto) {
		
		try {
			String sql ="INSERT INTO tblStudySeekerInfo (studySeekerInfoSeq, studyPostSeq, memberSeq, seekerCheck, evalComplete) values (studySeekerInfoSeq.nextVal, ?, ?, default, default)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getStudyPostSeq());
			pstat.setString(2, dto.getMemberSeq());
			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return 0;
	}





	//View.java에서 tblStudySeekerInfo에 있는 해당postseq인 리스트를 가져온대
	public ArrayList<SeekerInfoDTO> listApply(String studyPostSeq) {
		
		try {

			String sql ="select *from tblStudySeekerInfo where studypostseq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, studyPostSeq);
			
			rs = pstat.executeQuery();
			
			ArrayList<SeekerInfoDTO> alist = new ArrayList<SeekerInfoDTO>();
			
			while (rs.next()) {
				
				SeekerInfoDTO dto = new SeekerInfoDTO();
				
				dto.setSeekerInfoSeq(rs.getString("studySeekerInfoSeq"));
				dto.setStudyPostSeq(rs.getString("studyPostSeq"));
				dto.setMemberSeq(rs.getString("memberSeq"));
				dto.setSeekerCheck(rs.getString("seekerCheck"));
				dto.setEvalComplete(rs.getString("evalComplete"));
				
				alist.add(dto);
			}
			return alist;
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return null;
	}





	//ApplyDelete.java에서 tblStudySeekerInfo에 있는 해당 레코드 삭제
	public int delApply(SeekerInfoDTO dto) {

		try {

			String sql ="delete from tblStudySeekerInfo where studypostseq = ? and memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getStudyPostSeq());
			pstat.setString(2, dto.getMemberSeq());
			
			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}





	//Delete.java에서 tblstudySeeker에서 해당 레코드를 삭제한다
	public int delAllSeeker(String seq) {
		
		try {

			String sql ="delete from tblStudySeekerInfo where studypostseq=" + seq;
			
			stat = conn.createStatement();
			
			return stat.executeUpdate(sql);
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return 0;
	}




	//경력 차트 가져오기
	   public ChartStudyDTO careerCount(String studyPostSeq) {

		   try {
		            
		            String sql = "select case\r\n"
		            		+ "    when m.career = '신입' then '1'\r\n"
		            		+ "    when m.career = '1년미만' then '2'\r\n"
		            		+ "    when m.career = '1년이상~3년 미만' then '3'\r\n"
		            		+ "    when m.career = '3년이상~5년 미만' then '4'\r\n"
		            		+ "    when m.career = '5년 이상' then '5'\r\n"
		            		+ "end as career,\r\n"
		            		+ "count(*) as cnt\r\n"
		            		+ "    from tblstudyseekerinfo s\r\n"
		            		+ "        inner join tblMemberProfile m\r\n"
		            		+ "            on s.memberseq = m.memberseq where s.studypostseq = ? group by m.career    \r\n"
		            		+ "            ";
		            
		            pstat = conn.prepareStatement(sql);
		            pstat.setString(1, studyPostSeq);
		            
		            rs = pstat.executeQuery();
		            
		            //CountDTO list = new CountDTO();
		            
		            ChartStudyDTO dto = new ChartStudyDTO();
		            while(rs.next()) {
		               
		               
		               if(rs.getString("career").equals("1")) {
		                  dto.setCareer1(rs.getInt("cnt"));
		               }else if(rs.getString("career").equals("2")) {
		                  dto.setCareer2(rs.getInt("cnt"));
		               }else if(rs.getString("career").equals("3")) {
		                  dto.setCareer3(rs.getInt("cnt"));
		               }else if(rs.getString("career").equals("4")) {
		                  dto.setCareer4(rs.getInt("cnt"));
		               }else if(rs.getString("career").equals("5")) {
		                  dto.setCareer5(rs.getInt("cnt"));
		               }               
		               
		               
		            }
		            
		            return dto;
		            
		            
		         } catch (Exception e) {
		            System.out.println("CountDAO.genderCount()");
		            e.printStackTrace();
		         }
		         
		         
		         return null;
		      }





	public ArrayList<ChartStudyDTO> majorChart(String studyPostSeq) {
		
		try {
				
				String sql = "select \r\n"
						+ "m.major as major,\r\n"
						+ "count(*) as cnt\r\n"
						+ "    from tblstudyseekerinfo s\r\n"
						+ "        inner join tblMemberProfile m\r\n"
						+ "            on s.memberseq = m.memberseq where s.studypostseq = ? group by m.major";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, studyPostSeq);
				
				rs = pstat.executeQuery();
				
				ArrayList<ChartStudyDTO> list = new ArrayList<ChartStudyDTO>();
				
				while(rs.next()) {
					ChartStudyDTO dto = new ChartStudyDTO();
					list.add(dto);
					
				}
				return list;
				
	
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		
		
		return null;
		
	}

}
