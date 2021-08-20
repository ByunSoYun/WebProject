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
 * 관리자가 회원의 계정 정보를 볼 수 있게 해주는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/admin/manage/accountview.do")
public class AccountView extends HttpServlet {

	
	/**
	 * 관리자가 회원의 계정 정보를 볼 수 있게 해주는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 회원의 마이페이지 메인화면에서 받은 회원 번호를 String 변수에 저장
		 */
		String memberSeq = req.getParameter("memberSeq");
		
		System.out.println("memberSeq: " + memberSeq);
		
		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();
		
		dto.setMemberSeq(memberSeq);
		
		/**
		 * 회원의 계정 정보를 보기 위해 필요한 메소드들을 새로운 타입의 변수에 저장
		 */
		MyPageDTO result = dao.accountView(memberSeq);
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

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/admin/manage/accountview.jsp");
		dispatcher.forward(req, resp);
	}

}
;
