package com.afd.member.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/main/member/community/deleteok.do")
public class DeleteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//할일
		//1. 데이터 가져오기(seq)
		//2. DB 작업 > DAO 위임 > delete where seq
		//3. 결과 처리
		
		//1.
		String seq = req.getParameter("seq");
		
		//2.
		CommunityDAO dao = new CommunityDAO();
		
		HttpSession session = req.getSession();
		
		//2.5 현재 글에 달린 댓글부터 삭제하기(***)
		
		dao.delAllScrap(seq);
		
		dao.delAllRecommend(seq);
		
		dao.delAllComment(seq); //부모 글번호
		
		int result = dao.del(seq);
		
		//3.
		if(result == 1) {
			resp.sendRedirect("/webproject/main/member/community/list.do");
		} else {
			resp.sendRedirect("/webproject/main/member/delete.do?seq=" + seq);
		}


	}

	}


