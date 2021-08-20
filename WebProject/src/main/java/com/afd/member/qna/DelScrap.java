package com.afd.member.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 스크랩 내역 삭제를 관리하는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/delscrap.do")
public class DelScrap extends HttpServlet {

	/**
	 * 스크랩 내역 삭제를 실행하는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * view.jsp에서 받은 게시글 번호와 회원 번호를 String 변수에 저장한다.
		 */
		String techQnaSeq = req.getParameter("techQnaSeq");
		String memberSeq = req.getParameter("memberSeq");
		
		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO();
		
		dto.setTechQnaSeq(techQnaSeq);
		dto.setMemberSeq(memberSeq);
		
		/**
		 * 스크랩 내역 삭제를 실행하는 메소드로써, 성공하면 해당 게시글로 돌아가게 된다.
		 */
		int result = dao.delScrap(dto);
		
		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/view.do?techQnaSeq=" + techQnaSeq);
		}

	}

}
