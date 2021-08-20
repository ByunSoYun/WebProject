package com.afd.member.mypage.chart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 자신이 작성한 게시글 내역을 차트로 보여주는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/mypage/chart/chart.do")
public class Chart extends HttpServlet {

	/**
	 * 자신이 작성한 게시글 내역을 차트로 보여주는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ChartDAO dao = new ChartDAO();
		ChartDTO dto = new ChartDTO();
		
		HttpSession session = req.getSession();
		
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		
		ChartDTO boardCount = dao.boardCount(dto);
		ChartDTO commentCount = dao.commentCount(dto);
		
		req.setAttribute("boardCount", boardCount);
		req.setAttribute("commentCount", commentCount);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/chart/chart.jsp");
		dispatcher.forward(req, resp);

	}

}
