package com.afd.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 관리자의 메인페이지를 실행하는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/admin/adminmain.do")
public class AdminMain extends HttpServlet {

	/**
	 * 관리자의 메인페이지를 실행하는 메소드
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 관리자의 아이디와 비밀번호를 String 변수에 저장
		 */
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		AdminDAO dao = new AdminDAO();
		AdminDTO dto = new AdminDTO();
		
		dto.setId(id);
		dto.setPw(pw);
		
		/**
		 * 관리자의 아이디와 비밀번호로 로그인 할 때 필요한 SQL문을 변수에 저장한다.
		 * 성공하면 로그인이 완료되고 실패하면 null값을 반환한다.
		 */
		AdminDTO result = dao.login(dto);
		
		if (result != null) {
			//인증 > 티켓 발급
			HttpSession session = req.getSession();
			
			session.setAttribute("id", result.getId()); //인증 티켓
			
			//부가정보
			session.setAttribute("adminSeq", result.getAdminSeq());
			
		
		} else {
			System.out.println("null");
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/admin/adminmain.jsp");
		dispatcher.forward(req, resp);

	}

}
