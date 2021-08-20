package com.afd.member.mypage.mystudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.afd.DBUtil;
import com.afd.member.study.ChartStudyDTO;
import com.afd.member.study.SeekerInfoDTO;
import com.afd.member.study.StudyDTO;

public class MyStudyDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public MyStudyDAO() {
		
		try {

			conn = DBUtil.open();
			

		} catch (Exception e) {
			
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

	
	
	//PostStudy.java에서 내가 올린 스터디 공고 가져오기
	public ArrayList<StudyDTO> getStudy(String memberseq) {
		
		try {

			String sql ="select * from vwStudy where memberSeq = ? order by regdate desc";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, memberseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<StudyDTO> list = new ArrayList<StudyDTO>();
			
			while (rs.next()) {
				
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


	//PostStudy.java에서 공고 지원 목록 가져오기
	public ArrayList<SeekerInfoDTO> getSeeker(String memberseq) {
		
		try {

			String sql ="select * from tblStudySeekerInfo";

			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			ArrayList<SeekerInfoDTO> ilist = new ArrayList<SeekerInfoDTO>();
			
			while (rs.next()) {
				
				SeekerInfoDTO dto = new SeekerInfoDTO();
				
				dto.setSeekerInfoSeq(rs.getString("studyseekerInfoSeq"));
				dto.setStudyPostSeq(rs.getString("studyPostSeq"));
				dto.setMemberSeq(rs.getString("memberSeq"));
				dto.setSeekerCheck(rs.getString("seekerCheck"));
				dto.setEvalComplete(rs.getString("evalComplete"));
				
				ilist.add(dto);
			}
			return ilist;

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		return null;
	}


	//PostStudy.java에서 멤버프로필 목록 가져오기
	public ArrayList<ProfileDTO> getMember() {
		
		try {

			String sql ="select * from vwmempro";

			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			ArrayList<ProfileDTO> plist = new ArrayList<ProfileDTO>();
			
			while (rs.next()) {
				
				ProfileDTO dto = new ProfileDTO();

				dto.setMemberSeq(rs.getString("memberSeq"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setNickName(rs.getString("nickName"));
				dto.setRegistrationNumber(rs.getString("registrationNumber"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				dto.setMemberProfileSeq(rs.getString("memberProfileSeq"));
				dto.setCareer(rs.getString("career"));
				dto.setAcademicBackground(rs.getString("academicBackground"));
				dto.setGender(rs.getString("gender"));
				dto.setInterestOccupation(rs.getString("interestOccupation"));
				dto.setAvailableLanguage(rs.getString("availableLanguage"));
				dto.setMajor(rs.getString("major"));
				dto.setScore(rs.getString("score"));
				
				plist.add(dto);
			}
			return plist;

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return null;
	}


	//PassSeeker.java가 info check값을 변경
	public int changeSeekerInfo(SeekerInfoDTO dto) {

		try {

			String sql ="update tblStudySeekerInfo set seekerCheck = ? where studySeekerInfoSeq= ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSeekerCheck());
			pstat.setString(2, dto.getSeekerInfoSeq());
			
			
			return pstat.executeUpdate();
			
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
		
	}


	//CloseStudy.java에서 스터디 공고 마감
	public int closeStudy(String seq) {
		
		try {

			String sql ="update tblstudypost set close = 'y' where studypostseq= ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			
			return pstat.executeUpdate();
			
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
		
	}


	//OngoingStudy.java가 현재 진행중인 스터디 목록의 정보를 가져온다.
	public ArrayList<StudyDTO> getOngoingStudy(String memberseq) {
		
		try {

			String sql ="select * from vwStudy where close = 'y' and memberseq = ? or studypostseq in (select studypostseq from tblStudySeekerInfo where memberseq = ? and seekercheck = 'p') order by regdate desc";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, memberseq);
			pstat.setString(2, memberseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<StudyDTO> list = new ArrayList<StudyDTO>();
			
			while (rs.next()) {
				
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


	//Evaluation.java가 종료기간이 지난 스터디 목록의 정보를 가져온다.
	public ArrayList<StudyDTO> getOverStudy(String memberseq) {
		
		try {

			String sql ="select * from vwStudy where close = 'y' and  to_char(vwstudy.enddate, 'yyyymmdd') <= to_char(sysdate, 'yyyymmdd') and ((memberseq = ?) or (studypostseq in (select studypostseq from tblStudySeekerInfo where memberseq = ? and seekercheck = 'p'))) order by regdate desc";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, memberseq);
			pstat.setString(2, memberseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<StudyDTO> list = new ArrayList<StudyDTO>();
			
			while (rs.next()) {
				
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


	//EvaluationOk.java에서 tblseekerinfo의 evaluation을 'y'로 업데이트
	public int evaluationChange(SeekerInfoDTO idto) {
		
		try {

			String sql ="update tblStudySeekerInfo set evalComplete = 'y' where memberseq= ? and studypostseq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, idto.getMemberSeq());
			pstat.setString(2, idto.getStudyPostSeq());
			
			
			return pstat.executeUpdate();
			
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
		
	}



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
		            		+ "            on s.memberseq = m.memberseq where s.studypostseq = 10 group by m.career;    \r\n"
		            		+ "            ";
		            
		            pstat = conn.prepareStatement(sql);
		            pstat.setString(1, studyPostSeq);
		            
		            rs = pstat.executeQuery();
		            
		            //CountDTO list = new CountDTO();
		            
		            ChartStudyDTO dto = new ChartStudyDTO();
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

	//EvaluationOk.java에서 tblmemberprofile의 score값을 받는다.
	public int getEvaluation(String seq) {
		
		try {
			
			String sql = "select score from tblmemberprofile where memberseq = "+ seq;
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
            
            if(rs.next()) {
            	return rs.getInt("score");
            }
			
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		return 0;
	}



	public int scoreChange(String afterScore, String string) {
		
		try {

			String sql ="update tblMemberProfile set score = ? where memberSeq= ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, afterScore);
			pstat.setString(2, string);
			
			
			return pstat.executeUpdate();
			
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}

	//StudyProfile.java에서 맴버 프로필 가져가기
	
	public ProfileDTO getProfileChild(String seq) {
		try {

			String sql ="select * from vwmempro where memberseq = " + seq;
			

			pstat = conn.prepareStatement(sql);
			
			
			
			rs = pstat.executeQuery();
			
			
			ProfileDTO dto1 = new ProfileDTO();
			
			while (rs.next()) {
				
				

				dto1.setMemberSeq(rs.getString("memberSeq"));
				dto1.setName(rs.getString("name"));
				dto1.setId(rs.getString("id"));
				dto1.setPw(rs.getString("pw"));
				dto1.setNickName(rs.getString("nickName"));
				dto1.setRegistrationNumber(rs.getString("registrationNumber"));
				dto1.setTel(rs.getString("tel"));
				dto1.setAddress(rs.getString("address"));
				dto1.setEmail(rs.getString("email"));
				dto1.setMemberProfileSeq(rs.getString("memberProfileSeq"));
				dto1.setCareer(rs.getString("career"));
				dto1.setAcademicBackground(rs.getString("academicBackground"));
				dto1.setGender(rs.getString("gender"));
				dto1.setInterestOccupation(rs.getString("interestOccupation"));
				dto1.setAvailableLanguage(rs.getString("availableLanguage"));
				dto1.setMajor(rs.getString("major"));
				dto1.setScore(rs.getString("score"));
				
				return dto1;
				}

			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			
			return null;
			
		}
			
	



	



}
