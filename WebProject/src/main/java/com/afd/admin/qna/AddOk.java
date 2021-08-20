package com.afd.admin.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/admin/qna/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO();
		
		HttpSession session = req.getSession();
		
		dto.setId(session.getAttribute("id").toString());
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		dto.setTitle(title);
		dto.setContent(content);
		
		int result = dao.add(dto);
		
		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/list.do");
		} else {
			resp.sendRedirect("/webproject/main/member/qna/add.do");
		}

	}

}
