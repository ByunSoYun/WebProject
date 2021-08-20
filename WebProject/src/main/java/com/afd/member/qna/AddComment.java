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
 * 댓글을 작성하기 위해 필요한 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/addcomment.do")
public class AddComment extends HttpServlet {

	/**
	 * view.jsp에서 넘어온 게시글 번호와 게시글 내용을 받고, SQL문을 실행하여 view.do로 전달 위한 메소드
	 * @param req, resp
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		/**
		 * view.jsp에서 넘어온 게시글 번호와 게시글 내용을 String 변수로 저장
		 */
		String techQnaSeq = req.getParameter("techQnaSeq");
		String content = req.getParameter("content");

		QnaDAO dao = new QnaDAO();
		CommentDTO dto = new CommentDTO();

		HttpSession session = req.getSession();

		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		dto.setTechQnaSeq(techQnaSeq);
		dto.setContent(content);

		/**
		 * 게시글 번호와 게시글 내용을 토대로 해당 게시글에 댓글울 추가해주는 SQL문을 실행하는 메소드
		 */
		int result = dao.addComment(dto);

		/**
		 * 만약 댓글을 추가하는 SQL문을 실행하는 메소드가 성공적으로 실행되면 view.do로 넘어가게 하는 조건문
		 * 실패하면 '댓글 쓰기 실패' 알림창 띄우기
		 */
		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/view.do?techQnaSeq=" + techQnaSeq);
		} else {

			resp.setCharacterEncoding("UTF-8");

			PrintWriter writer = resp.getWriter();

			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('댓글 쓰기 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}

	}

}
