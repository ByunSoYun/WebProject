package com.afd.member.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/member/community/scrap.do")
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
				//memberseq=${memberSeq}&seq=${dto.seq}$check=n
		
		
				String seq = req.getParameter("seq");
				String memberseq = req.getParameter("memberseq");
				String check = req.getParameter("check");
				
				//2.
				CommunityDAO dao = new CommunityDAO();
				ScrapDTO dto = new ScrapDTO();
				
				dto.setCommunityseq(seq);
				dto.setMemberseq(memberseq);
				
				HttpSession session = req.getSession();
				
				int result = 0;
				
				if(check.equals("y")) {
					result = dao.addScrap(dto);
				} else {
					result = dao.delScrap(dto);
					
				}
				 
				if(result == 1) {
					resp.sendRedirect("/webproject/main/member/community/view.do?seq=" + seq);
				}

			
				
	}

}
