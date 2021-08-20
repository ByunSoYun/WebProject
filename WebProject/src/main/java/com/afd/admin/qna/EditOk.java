package com.afd.admin.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/admin/qna/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String techQnaSeq = req.getParameter("techQnaSeq");
		
		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO();
		
		dto.setTitle(title);
		dto.setContent(content);
		dto.setTechQnaSeq(techQnaSeq);
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/view.do?techQnaSeq=" + techQnaSeq);
		} else {
			resp.sendRedirect("/webproject/main/member/qna/edit.do?techQnaSeq=" + techQnaSeq);
		}

	}

}
