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

import com.afd.member.MemberDTO;
import com.afd.member.study.SeekerInfoDTO;
import com.afd.member.study.StudyDTO;

@WebServlet("/main/member/mypage/poststudy.do")
public class PostStudy extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.
		HttpSession session = req.getSession();
		String memberseq = session.getAttribute("memberSeq").toString();
		
		//2.
		MyStudyDAO dao = new MyStudyDAO();
		
		
		//내가 올린 스터디 공고 목록 가져오기
		ArrayList<StudyDTO> slist = dao.getStudy(memberseq);
		
		//공고지원 목록 가져오기
		ArrayList<SeekerInfoDTO> ilist = dao.getSeeker(memberseq);
		
		//프로필 목록 가져오기
		ArrayList<ProfileDTO> plist = dao.getMember();
		
		
		
		//3.
		req.setAttribute("slist", slist);
		req.setAttribute("ilist", ilist);
		req.setAttribute("plist", plist);

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/poststudy.jsp");
		dispatcher.forward(req, resp);
	}

}









