package com.afd.member.mypage.myreservation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/main/member/mypage/myreservation/myreservation.do")
public class MyReservation extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		MySpaceDAO dao = new MySpaceDAO();
		ArrayList<MySpaceDTO> dto = new ArrayList<MySpaceDTO>();
		ArrayList<MySpaceImageDTO> imgdto = new ArrayList<MySpaceImageDTO>();
		
		HttpSession session = req.getSession();
		
		int memberseq = Integer.parseInt(session.getAttribute("memberSeq").toString());
		
		dto = dao.selectMySpaceAll(memberseq);
		imgdto = dao.selectMyImg(memberseq);  // 얘를 for문돌려서 갖고와야되는데 이렇게 하나밖에 없네여 잘못새각
		req.setAttribute("list", dto);
		req.setAttribute("img", imgdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views//main/member/mypage/myreservation/myreservation.jsp");
		dispatcher.forward(req, resp);

	}
}

