package com.afd.member.study;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/member/study/commentdelete.do")
public class CommentDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		String pseq = req.getParameter("pseq");
		
		StudyDAO dao = new StudyDAO();
		
		int result = dao.delComment(seq);
		
		resp.sendRedirect("/webproject/main/member/study/view.do?seq=" + pseq);
	}

}
