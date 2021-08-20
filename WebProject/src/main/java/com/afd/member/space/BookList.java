package com.afd.member.space;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

	@WebServlet("/main/member/space/booklist.do")
	public class BookList extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
				req.setCharacterEncoding("UTF-8");
			
				HttpSession session = req.getSession();
				
				String memberSeq = session.getAttribute("memberSeq").toString();
				
				req.setAttribute("memberSeq", memberSeq);
		
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/space/booklist.jsp");
			dispatcher.forward(req, resp);

		}
	}
