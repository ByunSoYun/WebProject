package com.afd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/mainpage.do")
public class MainPage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberSeq = req.getParameter("memberSeq");
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/mainpage.jsp");
		dispatcher.forward(req, resp);

	}

}
