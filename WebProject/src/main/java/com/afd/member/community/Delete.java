package com.afd.member.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/main/member/community/delete.do")
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			String seq = req.getParameter("seq");
			
		
			req.setAttribute("seq", seq);	
			
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/community/delete.jsp");
		dispatcher.forward(req, resp);

	}

}

