package com.afd.member.mypage.mystudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.afd.member.study.SeekerInfoDTO;

@WebServlet("/main/member/mypage/mystudy/passseeker.do")
public class PassSeeker extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		String passResult = req.getParameter("passSeeker");
		
		MyStudyDAO dao = new MyStudyDAO();
		SeekerInfoDTO dto = new SeekerInfoDTO();
		
		dto.setSeekerInfoSeq(seq);
		dto.setSeekerCheck(passResult);
		
		int result = dao.changeSeekerInfo(dto);
		
		if (result == 1) {
			
			resp.sendRedirect("/webproject/main/member/mypage/poststudy.do");
			
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
