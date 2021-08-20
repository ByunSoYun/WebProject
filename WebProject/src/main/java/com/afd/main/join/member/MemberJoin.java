package com.afd.main.join.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.afd.member.MemberDAO;
import com.afd.member.MemberDTO;

@WebServlet("/main/join/member/memberjoin.do")
public class MemberJoin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		MemberDAO dao = new MemberDAO();
		
        ArrayList<MemberDTO> list = dao.list();
        
        req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/join/memberjoin.jsp");
		dispatcher.forward(req, resp);

		
	}

}





