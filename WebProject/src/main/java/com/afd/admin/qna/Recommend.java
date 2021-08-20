package com.afd.admin.qna;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/admin/qna/recommend.do")
public class Recommend extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String techQnaSeq = req.getParameter("techQnaSeq");
		String againRecommend = req.getParameter("againRecommend");
		String memberSeq = req.getParameter("memberSeq");
		

		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO();

		
		HttpSession session = req.getSession();

		dto.setTechQnaSeq(techQnaSeq);
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		dto.setRecommendCount(session.getAttribute("recommend").toString());

		int result = 0;
		
		result = dao.recommend(dto);

		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/view.do?techQnaSeq=" + techQnaSeq);
		} else {

			resp.setCharacterEncoding("UTF-8");

			PrintWriter writer = resp.getWriter();

			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('댓글 삭제 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}

	}

}
