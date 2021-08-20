package com.afd.member.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * add.jsp에서 넘어오는 게시글 제목과 내용을 받기 위해 필요한 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/addok.do")
public class AddOk extends HttpServlet {

	/**
	 * add.jsp에서 넘어오는 게시글 제목과 내용을 받기 위해 필요한 메소드
	 * @param req, resp
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		/**
		 * add.jsp에서 넘어온 제목과 내용을 String 변수로 저장
		 */
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO();
		
		HttpSession session = req.getSession();
		
		/**
		 * 아이디, 멤버번호, 제목, 내용을 DTO에 저장
		 */
		dto.setId(session.getAttribute("id").toString());
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		dto.setTitle(title);
		dto.setContent(content);
		
		/**
		 * 게시글을 새로 추가해주는 쿼리문을 실행하기 위한 메소드
		 * 만약 성공하면 list.do로 넘어가고, 실패하면 다시 add.do로 돌아간다.
		 */
		int result = dao.add(dto);
		
		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/list.do");
		} else {
			resp.sendRedirect("/webproject/main/member/qna/add.do");
		}

	}

}
