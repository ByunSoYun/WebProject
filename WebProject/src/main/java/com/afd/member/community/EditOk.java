package com.afd.member.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main/member/community/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//할일
		//1. 데이터 가져오기
		//2. DB 작업 > DAO 위임 > update
		//3. 결과 처리
		

		req.setCharacterEncoding("UTF-8");
		//1.
		String seq = req.getParameter("seq");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String category = req.getParameter("category");
		
		//2.
		CommunityDAO dao = new CommunityDAO();
		CommunityDTO dto = new CommunityDTO();
		
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setCategory(category);
		
		int result = dao.edit(dto);
		
		//3.
		if(result == 1) {
			resp.sendRedirect("/webproject/main/member/community/view.do?seq=" + seq);
		} else {
			resp.sendRedirect("/webproject/main/member/community/edit.do?seq=" + seq);
		}
		
	}

}
