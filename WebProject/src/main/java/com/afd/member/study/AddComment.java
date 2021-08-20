package com.afd.member.study;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/member/study/addcomment.do")
public class AddComment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		//1.
		String seq = req.getParameter("seq");
		String memberSeq = req.getParameter("memberSeq");
		String content = req.getParameter("content");
		
		//2. db에 추가
		StudyDAO dao = new StudyDAO();
		CommentDTO dto = new CommentDTO();
		
		dto.setCommentPostSeq(seq);
		dto.setCommentMemberSeq(memberSeq);
		dto.setContent(content);
		
		int result = dao.addComment(dto);

		resp.sendRedirect("/webproject/main/member/study/view.do?seq=" + seq);
	}

}