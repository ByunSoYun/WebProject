package com.afd.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 회원으로 로그인할 때 보여주는 페이지를 실행하는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/membermain.do")
public class MemberMain extends HttpServlet {

	/**
	 * 회원으로 로그인할 때 보여주는 페이지를 실행하는 메소드
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		
		MemberDTO result = dao.login(dto);
		if(result != null) {
			//인증 > 티켓 발급
			HttpSession session = req.getSession();
			
			session.setAttribute("id", result.getId()); //인증 티켓
			
			//부가정보
			session.setAttribute("name", result.getName());
			session.setAttribute("nickname", result.getNickName());
			session.setAttribute("memberSeq", result.getMemberSeq());
			
		
		}else {
			System.out.println("null");
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/membermain.jsp");
		dispatcher.forward(req, resp);
		

	}

}
