package com.afd.member.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 게시글의 삭제를 관리하는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/delete.do")
public class Delete extends HttpServlet {

	/**
	 * 게시글의 삭제를 실행하는 메소드
	 * 게시글 삭제가 성공하면 delete.jsp로 넘어간다.
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * view.jsp에서 받은 게시글 번호를 String 변수에 저장
		 */
		String techQnaSeq = req.getParameter("techQnaSeq");
		
		/**
		 * String 변수를 DTO 값으로 저장
		 */
		req.setAttribute("techQnaSeq", techQnaSeq);

		/**
		 * 게시글 삭제가 성공하면 delete.jsp로 넘어간다.
		 */
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/qna/delete.jsp");
		dispatcher.forward(req, resp);

	}

}
