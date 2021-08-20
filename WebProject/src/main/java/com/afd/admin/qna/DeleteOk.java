package com.afd.admin.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/admin/qna/deleteok.do")
public class DeleteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String techQnaSeq = req.getParameter("techQnaSeq");

		QnaDAO dao = new QnaDAO();

		dao.delAllRecommend(techQnaSeq);
		dao.delAllScrap(techQnaSeq);
		dao.delAllComment(techQnaSeq);

		int result = dao.del(techQnaSeq);

		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/list.do");
		} else {
			resp.sendRedirect("/webproject/main/member/qna/delete.do?techQnaSeq=" + techQnaSeq);
		}

	}

}
