package com.afd.member.study;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/member/study/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1.데이터 가져오기
		//2. db작업
		//3. 결과
		req.setCharacterEncoding("UTF-8");
		
		//1.
		String subject = req.getParameter("subject");
		String name = req.getParameter("title");
		String content = req.getParameter("content");
		String period = req.getParameter("period");
		String city = req.getParameter("city");
		String gu = req.getParameter("gu");
		String startDate = req.getParameter("startDate");
		String major = req.getParameter("major");
		String ageGroup = req.getParameter("ageGroup");
		String endDate = req.getParameter("endDate");
		String career = req.getParameter("career");
		String purpose = req.getParameter("purpose");
		String memberCount = req.getParameter("memberCount");
		String[] languageA = req.getParameterValues("language");
		String[] jobGroupA = req.getParameterValues("jobGroup");
		
		String lat = req.getParameter("lat");
		String lng = req.getParameter("lng");
		
		
		String language = "";
		String jobGroup = "";
		
		for(String item: languageA) {
			language += "," + item;
		}
		
		
		for(String item: jobGroupA) {
			jobGroup += "," + item;
		}
		
		language = language.substring(1);
		jobGroup = jobGroup.substring(1);
		
		
		//2. 
		StudyDAO dao = new StudyDAO();
		StudyDTO dto = new StudyDTO();
		
		HttpSession session = req.getSession();
		
		//INSERT INTO TblStudyPost values (studyPostSeq.nextVal, 일반회원고유번호, '스터디공고명', '스터디내용', '스터디명', '작성날짜', 조회수, 스터디원수, '구성원나이대', '경력', '학과', '직군', '사용가능언어', '기간', '시작날짜', '종료날짜', '용도');
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		dto.setPostTitle(subject);
		dto.setContent(content);
		dto.setName(name);
		dto.setMemberCount(memberCount);
		dto.setAgeGroup(ageGroup);
		dto.setCareer(career);
		dto.setMajor(major);
		dto.setJobGroup(jobGroup);
		dto.setLanguage(language);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setPeriod(period);
		dto.setPurpose(purpose);
		dto.setCity(city);
		dto.setGu(gu);
		dto.setLongitude(lng);
		dto.setLatitude(lat);
		
		
		int resultLocation = 0;
		
		//tblStudyPost새 글 추가
		int resultPost = dao.addPost(dto);
		
		if(resultPost == 1) {
			
			//tblStudyPost에서 최근 댓글 postseq 받기
			int maxPostSeq = dao.maxPostSeq();
			if (maxPostSeq > 0) {
				
				//tblStudyLocation새 위치 추가
				dto.setStudyPostSeq(maxPostSeq + "");
				resultLocation = dao.addLocation(dto);
				
			}else {
				System.out.println("새 글 seq 받기 실패");
			}
		}else {
			System.out.println("새 글 추가 실패");
		}
		
		
		if(resultLocation == 1) {
			
			resp.sendRedirect("/webproject/main/member/study/list.do");
		} else {
			System.out.println("위치추가 실패");
			resp.sendRedirect("/webproject/main/member/study/list.do");
		}
		
	}

}
