package com.afd.member.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 게시글 삭제를 관리하는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/deleteok.do")
public class DeleteOk extends HttpServlet {

	/**
	 * 게시글 삭제를 실행하는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		/**
		 * view.jsp에서 받은 게시글 번호를 String 변수에 저장한다.
		 */
		String techQnaSeq = req.getParameter("techQnaSeq");

		QnaDAO dao = new QnaDAO();

		dao.delAllRecommend(techQnaSeq);
		dao.delAllScrap(techQnaSeq);
		dao.delAllComment(techQnaSeq);

		/**
		 * 게시글 삭제를 실행하는 메소드로써, 성공하면 list.do로 넘어가고 실패하면 다시 원래 게시글로 돌아간다.
		 */
		int result = dao.del(techQnaSeq);

		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/list.do");
		} else {
			resp.sendRedirect("/webproject/main/member/qna/delete.do?techQnaSeq=" + techQnaSeq);
		}

	}

}
