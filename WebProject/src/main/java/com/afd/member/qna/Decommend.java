package com.afd.member.qna;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 게시글의 비추천을 관리하는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/decommend.do")
public class Decommend extends HttpServlet {

	/**
	 * 게시글의 비추천을 관리하는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * view.jsp에서 받은 게시글 번호를 String 변수에 저장
		 */
		String techQnaSeq = req.getParameter("techQnaSeq");

		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO();

		HttpSession session = req.getSession();

		/**
		 * 게시글번호, 회원번호, 비추천수를 DTO에 저장
		 */
		dto.setTechQnaSeq(techQnaSeq);
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		dto.setDecommendCount(session.getAttribute("decommend").toString());

		/**
		 * 게시글 비추천을 해주는 SQL문을 실행하는 메소드
		 * 만약, 성공하면 view.do로 넘어가고 실패하면 '댓글 삭제 실패' 알림창을 띄운다.
		 */
		int result = dao.decommend(dto);

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
