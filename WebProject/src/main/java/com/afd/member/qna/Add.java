package com.afd.member.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

/**
 * 게시글을 작성하기 위해 필요한 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/qna/add.do")
public class Add extends HttpServlet {

	/**
	 * list.jsp에서 넘어온 게시글 번호를 add.jsp로 전달하기 위한 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/qna/add.jsp");
		dispatcher.forward(req, resp);

	}

}
