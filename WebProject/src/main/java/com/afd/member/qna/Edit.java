package com.afd.member.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 게시글 수정을 관리하는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/edit.do")
public class Edit extends HttpServlet {

	/**
	 * 게시글 수정을 실행하는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * view.jsp에서 받은 게시글 번호를 String 변수에 저장한다.
		 */
		String techQnaSeq = req.getParameter("techQnaSeq");
		
		QnaDAO dao = new QnaDAO();
		
		/**
		 * 게시글 수정을 실행하는 메소드로써, 성공하면 edit.jsp로 넘어간다.
		 */
		QnaDTO dto = dao.get(techQnaSeq);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/qna/edit.jsp");
		dispatcher.forward(req, resp);

	}

}
