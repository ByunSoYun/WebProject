package com.afd.admin.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.afd.member.mypage.MyPageDAO;
import com.afd.member.mypage.MyPageDTO;

/**
 * 일반 회원의 프로필을 볼 수 있게 해주는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/admin/manage/profileview.do")
public class ProfileView extends HttpServlet {

	/**
	 * 일반 회원의 프로필을 볼 수 있게 해주는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberSeq = req.getParameter("memberSeq");
		
		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();
		
		dto.setMemberSeq(memberSeq);
		
		MyPageDTO result = dao.myProfileList(dto);
		MyPageDTO qnaScrapCount = dao.qnaScrapCount(dto);
		MyPageDTO studyScrapCount = dao.studyScrapCount(dto);
		MyPageDTO comScrapCount = dao.comScrapCount(dto);
		MyPageDTO jobPostScrapCount = dao.jobPostScrapCount(dto);
		MyPageDTO spaceScrapCount = dao.spaceScrapCount(dto);
		
		req.setAttribute("result", result);
		req.setAttribute("qnaScrapCount", qnaScrapCount);
		req.setAttribute("studyScrapCount", studyScrapCount);
		req.setAttribute("comScrapCount", comScrapCount);
		req.setAttribute("jobPostScrapCount", jobPostScrapCount);
		req.setAttribute("spaceScrapCount", spaceScrapCount);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/admin/manage/profileview.jsp");
		dispatcher.forward(req, resp);
	}

}
;
