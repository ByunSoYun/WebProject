package com.afd.member.space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/main/member/space/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
	
		SpaceDAO dao = new SpaceDAO();
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/space/list.jsp");
		dispatcher.forward(req, resp);

	}
}