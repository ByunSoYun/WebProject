package com.afd.member.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/main/member/community/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//할일
				//1. 데이터 가져오기
				//2. DB작업 > DAO 위임 > insert
				//3. 결과 > 후처리
		
		req.setCharacterEncoding("UTF-8");

		String title = req.getParameter("title");
		String category = req.getParameter("category");
		String content = req.getParameter("content");
		
		
		CommunityDAO dao = new CommunityDAO();
		CommunityDTO dto = new CommunityDTO();
		
		HttpSession session = req.getSession();
		
		dto.setMemberseq(session.getAttribute("memberSeq").toString());
		dto.setTitle(title);
		dto.setContent(content);
		dto.setCategory(category);
		
		
		int result = dao.add(dto);
		
		System.out.println(dto.getTitle());
		
		
		//3.
		if(result == 1) {
			resp.sendRedirect("/webproject/main/member/community/list.do");
		} else {
			resp.sendRedirect("/webproject/main/member/community/add.do");
		}
		
//		CREATE TABLE tblCommunity (
//				 communitySeq number NOT NULL,
//				 memberSeq number NOT NULL,
//				 category varchar2(50) NOT NULL,
//				 title varchar2(200) NOT NULL,
//				 content varchar(4000) NOT NULL,
//				 regdate date NOT NULL,
//				 readCount number DEFAULT 0 NOT NULL
//				);
		
		
	
	}

}
