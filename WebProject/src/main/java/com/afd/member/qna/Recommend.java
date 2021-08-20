package com.afd.member.qna;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 사용자들의 게시글 추천을 추가하는 것을 관리하는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/recommend.do")
public class Recommend extends HttpServlet {

	/**
	 * 사용자들의 게시글 추천을 추가하는 것을 실행하는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * view.jsp에서 받은 게시글 번호, 추천수, 회원 번호를 String 변수에 저장
		 */
		String techQnaSeq = req.getParameter("techQnaSeq");
		String againRecommend = req.getParameter("againRecommend");
		String memberSeq = req.getParameter("memberSeq");
		

		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO();

		
		HttpSession session = req.getSession();

		dto.setTechQnaSeq(techQnaSeq);
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		dto.setRecommendCount(session.getAttribute("recommend").toString());

		int result = 0;
		
		/**
		 * 게시글의 추천을 추가하는 메소드로써 성공하면 원래 게시글로 돌아가고, 실패하면 '추천 실패' 알림창을 띄우는 메소드
		 */
		result = dao.recommend(dto);

		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/qna/view.do?techQnaSeq=" + techQnaSeq);
		} else {

			resp.setCharacterEncoding("UTF-8");

			PrintWriter writer = resp.getWriter();

			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('추천 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}

	}

}
