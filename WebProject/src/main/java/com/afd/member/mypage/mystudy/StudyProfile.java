package com.afd.member.mypage.mystudy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afd.member.study.StudyDTO;

@WebServlet("/main/member/mypage/studyprofile.do")
public class StudyProfile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String seq = req.getParameter("seq");
		
		//2.
		MyStudyDAO dao = new MyStudyDAO();
		
		
		System.out.println("번호는" + seq);
		//멤버프로필 가져오기
		ProfileDTO dtonew = dao.getProfileChild(seq);
		
		req.setAttribute("dto", dtonew);
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/studyprofile.jsp");
		dispatcher.forward(req, resp);
	}

}
