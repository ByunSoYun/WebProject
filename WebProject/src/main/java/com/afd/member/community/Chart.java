package com.afd.member.community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main/member/community/chart.do")
public class Chart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CommunityDAO dao= new CommunityDAO();
		
		ArrayList<ChartDTO> categorylist = dao.category(); //카테고리별 리스트 값 가져옴 ,..
		ArrayList<ChartDTO> categorycommentlist = dao.categorycomment(); //카테고리별 댓글리스트 값 가져옴 ,..
		
		
		req.setAttribute("categorylist", categorylist);
		req.setAttribute("categorycommentlist", categorycommentlist);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/community/chart.jsp");
		dispatcher.forward(req, resp);

	}

}
