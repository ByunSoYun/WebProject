package com.afd.member.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/member/community/recommend.do")
public class Recommend extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 받기
				//2. 데이터 가공
				//3. 결과 > 후처리
				//scrapok.do?memberseq=${memberSeq}&seq=${dto.seq}&check=emptydec';">
				//check= rec를  n -> y
				//check= dec를  y -> n
				//check= emptydec를  insert n
				//check= emptyrec를  inset y
				
				//1.
				String memberseq = req.getParameter("memberseq");
				String seq = req.getParameter("seq");
				String check = req.getParameter("check");
				
				//2. 
				CommunityDAO dao = new CommunityDAO();
				RecommendDTO dto = new RecommendDTO();
				
				dto.setCommunityseq(seq);
				dto.setMemberseq(memberseq);
				
				
				//2.
				
				int result = -1;
				
				if(check.equals("rec")) {
					result = dao.recChange(dto);
				} else if(check.equals("dec")) {
					result = dao.decChange(dto);
				} else if(check.equals("emptyrec")) {
					result = dao.recNew(dto);
				} else if(check.equals("emptydec")) {
					result = dao.decCNew(dto);
				} else {
					result = dao.reczoro(dto);
				}
				
				resp.sendRedirect("/webproject/main/member/community/view.do?seq=" + seq);

	
	}

}

