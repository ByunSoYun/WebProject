package com.afd.member.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 회원의 계정 정보를 수정하기 위해 데이터를 넘겨주는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/mypage/accountsetting.do")
public class AccountSetting extends HttpServlet {

	
	/**
	 * 회원의 계정 정보를 수정하기 위해 데이터를 넘겨주는 클래스
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String newPw = req.getParameter("newPw");
		String nickName = req.getParameter("nickName");
		String name = req.getParameter("name");
		String firstRegistrationNumber = req.getParameter("firstRegistrationNumber");
		String secondRegistrationNumber = req.getParameter("secondRegistrationNumber");
		String tel1 = req.getParameter("tel1");
		String tel2 = req.getParameter("tel2");
		String tel3 = req.getParameter("tel3");
		String postNumber = req.getParameter("postNumber");
		String address1 = req.getParameter("address1");
		String address2 = req.getParameter("address2");
		String address3 = req.getParameter("address3");
		String email = req.getParameter("email");
		String domain = req.getParameter("domain");

		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();
		
		HttpSession session = req.getSession();
		
		dto.setId(session.getAttribute("id").toString());
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		
		MyPageDTO list = dao.list(dto);
		MyPageDTO qnaScrapCount = dao.qnaScrapCount(dto);
		MyPageDTO studyScrapCount = dao.studyScrapCount(dto);
		MyPageDTO comScrapCount = dao.comScrapCount(dto);
		MyPageDTO jobPostScrapCount = dao.jobPostScrapCount(dto);
		MyPageDTO spaceScrapCount = dao.spaceScrapCount(dto);
		
		req.setAttribute("list", list);
		req.setAttribute("qnaScrapCount", qnaScrapCount);
		req.setAttribute("studyScrapCount", studyScrapCount);
		req.setAttribute("comScrapCount", comScrapCount);
		req.setAttribute("jobPostScrapCount", jobPostScrapCount);
		req.setAttribute("spaceScrapCount", spaceScrapCount);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/accountsetting.jsp");
		dispatcher.forward(req, resp);

	}

}
