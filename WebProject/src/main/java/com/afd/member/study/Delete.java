package com.afd.member.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/member/study/delete.do")
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 가져오기
		//2. db작업
		
		//1.
		String seq = req.getParameter("seq");
		
		
		//2. db작업
		StudyDAO dao = new StudyDAO();
		
		//2.1 글에 달린 댓글 삭제
		int cResult = dao.delAllComment(seq);
		
		//2.2 스크랩 삭제
		int scResult = dao.delAllScrap(seq);
		
		//2.3 추천 비추천 삭제
		int rResult = dao.delAllRecomend(seq);
		
		//2.4 위치 레코드 삭제
		int lResult = dao.delAllLocation(seq);
		
		//2.5 지원자들 삭제
		int skResult = dao.delAllSeeker(seq);
		
		//2.6 공고 삭제
		int stResult = dao.delAllStrudy(seq);
		
		
		if(cResult == 0) {
			System.out.println("댓글삭제 실패");
		}
		if(scResult == 0) {
			System.out.println("스크랩삭제 실패");
		}
		if(rResult == 0) {
			System.out.println("추천삭제 실패");
		}
		if(lResult == 0) {
			System.out.println("위치삭제 실패");
		}
		if(skResult == 0) {
			System.out.println("지원자들 삭제 실패");
		}
		if(stResult == 0) {
			System.out.println("공고삭제 실패");
		}
		
		
		if (lResult == 1 && stResult == 1) {
			
			resp.sendRedirect("/webproject/main/member/study/list.do"); 
			
		} else {
			
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('글 삭제 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
			
		}
		
		
		
		
		
	}

}
