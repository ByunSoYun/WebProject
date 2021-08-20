package com.afd.member.study;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/member/study/scrapok.do")
public class Scrap extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//할일
		//1. 데이터 가져오기
		//2. DB작업 (INSERT, UPDATE)
		//2.1 CHECK값이 Y INSERT 
		//2.2 CHECK값이 N UPDATE
		//3. 결과 > 후처리
		
		//1.
		//memberseq=${memberSeq}&seq=${dto.studyPostSeq}$check=n
		String seq = req.getParameter("seq");
		String memberseq = req.getParameter("memberseq");
		String check = req.getParameter("check");
		
		//2.
		StudyDAO dao = new StudyDAO();
		ScrapDTO dto = new ScrapDTO();
		
		dto.setScrapMemberSeq(memberseq);
		dto.setScrapStudyPost(seq);
		
		HttpSession session = req.getSession();
		
		int result = 0;
		
		if(check.equals("y")) {
			result = dao.addScrap(dto);
		} else {
			result = dao.delScrap(dto);
			
		}
		 
		if(result == 1) {
			resp.sendRedirect("/webproject/main/member/study/view.do?seq=" + seq);
		}
		
	}

}

