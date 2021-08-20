package com.afd.member.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/main/member/study/apply.do")
public class Apply extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 가져오기
		//2. db연결
		//3. 결과
		
		
		//1.
		HttpSession session = req.getSession();
		String seq = req.getParameter("seq");
		String memberSeq = session.getAttribute("memberSeq").toString();
		
		//2.
		StudyDAO dao = new StudyDAO();
		SeekerInfoDTO dto = new SeekerInfoDTO();
		
		dto.setStudyPostSeq(seq);
		dto.setMemberSeq(memberSeq);
		
		int result = dao.addApply(dto);
		
		
		if(result == 1) {
			resp.sendRedirect("/webproject/main/member/study/view.do?seq=" + seq);
			
		}else {
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('지원하기 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
		}
		

	}

}
