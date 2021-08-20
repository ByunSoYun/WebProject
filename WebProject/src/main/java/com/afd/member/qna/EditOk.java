package com.afd.member.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 게시글 수정을 완료하는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/editok.do")
public class EditOk extends HttpServlet {

	/**
	 * 게시글 수정을 완료하는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * edit.jsp에서 받은 제목, 내용, 게시글 번호를 String 변수에 저장한다.
		 */
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String techQnaSeq = req.getParameter("techQnaSeq");
		
		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO();
		
		dto.setTitle(title);
		dto.setContent(content);
		dto.setTechQnaSeq(techQnaSeq);
		
		/**
		 * 게시글 수정을 완료하는 메소드로써, 성공하면 해당 게시글로 돌아가고 실패하면 다시 게시글을 수정하는 곳으로 되돌아간다.
		 */
		int result = dao.edit(dto);
		
		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/view.do?techQnaSeq=" + techQnaSeq);
		} else {
			resp.sendRedirect("/webproject/main/member/qna/edit.do?techQnaSeq=" + techQnaSeq);
		}

	}

}
