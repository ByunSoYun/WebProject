package com.afd.member.study;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/member/study/recommendok.do")
public class RecommendOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 받기
		//2. 데이터 가공
		//3. 결과 > 후처리
		//scrapok.do?memberseq=${memberSeq}&seq=${dto.studyPostSeq}&check=emptydec';">
		//check= rec를  n -> y
		//check= dec를  y -> n
		//check= emptydec를  insert n
		//check= emptyrec를  inset y
		
		//1.
		String memberseq = req.getParameter("memberseq");
		String seq = req.getParameter("seq");
		String check = req.getParameter("check");
		
		//2. 
		StudyDAO dao = new StudyDAO();
		RecommendDTO dto = new RecommendDTO();
		
		dto.setRecommendPostSeq(seq);
		dto.setRecommendMemberSeq(memberseq);
		
		
		//2.
		
		int result = -1;
		
		if(check.equals("rec")) {
			result = dao.recChange(dto);
		} else if(check.equals("dec")) {
			result = dao.decChange(dto);
		} else if(check.equals("emptyrec")) {
			result = dao.recNew(dto);
		} else {
			result = dao.decCNew(dto);
		}
		
		resp.sendRedirect("/webproject/main/member/study/view.do?seq=" + seq);

		
	}

}