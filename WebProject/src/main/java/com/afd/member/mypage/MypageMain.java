package com.afd.member.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afd.member.MemberDAO;
import com.afd.member.MemberDTO;
import com.afd.member.qna.QnaDTO;

/**
 * 회원의 마이페이지 메인화면을 보여주는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/mypage/mypagemain.do")
public class MypageMain extends HttpServlet {

	
	/**
	 * 회원의 마이페이지 메인화면을 보여주는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();
		
		HttpSession session = req.getSession();
		String memberSeq = session.getAttribute("memberSeq").toString();
		
		dto.setId(session.getAttribute("id").toString());
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		
		/**
		 * 회원의 스크랩수, 채용공고, 스터디내역 등을 보여주기 위한 메소드를 실행하기 위한 변수 저장
		 */
		MyPageDTO list = dao.list(dto);
		MyPageDTO qnaScrapCount = dao.qnaScrapCount(dto);
		MyPageDTO studyScrapCount = dao.studyScrapCount(dto);
		MyPageDTO comScrapCount = dao.comScrapCount(dto);
		MyPageDTO jobPostScrapCount = dao.jobPostScrapCount(dto);
		MyPageDTO spaceScrapCount = dao.spaceScrapCount(dto);
		MyJobDAO jobdao = new MyJobDAO();
		ArrayList<MyJobDTO> joblist = jobdao.list(memberSeq);
	      
      	req.setAttribute("joblist", joblist);
		req.setAttribute("list", list);
		req.setAttribute("qnaScrapCount", qnaScrapCount);
		req.setAttribute("studyScrapCount", studyScrapCount);
		req.setAttribute("comScrapCount", comScrapCount);
		req.setAttribute("jobPostScrapCount", jobPostScrapCount);
		req.setAttribute("spaceScrapCount", spaceScrapCount);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/mypagemain.jsp");
		dispatcher.forward(req, resp);

	}

}
