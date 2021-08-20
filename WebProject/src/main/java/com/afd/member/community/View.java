package com.afd.member.community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





@WebServlet("/main/member/community/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//할일
		//1. 데이터 가져오기(seq)
		//2. DB 작업 > DAO 위임 > select where seq
		//3. BoardDTO 반환 > JSP 호출하기 + 전달하기
		
		HttpSession session = req.getSession();
		
		
		//1.
		
		
		String seq = req.getParameter("seq");
		String column = req.getParameter("column");
		String search = req.getParameter("search");
		
		
		System.out.println(seq);
		
		
		//2.
		CommunityDAO dao = new CommunityDAO();
		
		
		if(session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")) {
			//2.3 조회수 증가하기
			dao.updateReadcount(seq);
			
			session.setAttribute("read", "y");
		}
		
		
	
		CommunityDTO dto = dao.get(seq);

		
		String content = dto.getContent();
		
		
		
		//글 내용에 개행 문자 처리하기
		content = content.replace("\r\n", "<br>");
		dto.setContent(content);
		
		
		
		//내용으로 검색 중일 때 검색어 부각 시키기
		if (column != null && search != null && column.equals("content")) {
			content = content.replace(search, "<span style='color:tomato;background-color:yellow;'>" + search+ "</span>");
			dto.setContent(content);
		}
		

		
	
		
		
		//2.7
		//- 현재 보고 있는 글에 달린 댓글 목록 가져오기
		ArrayList<CommentDTO> clist = dao.listComment(seq);//현재 글번호(= 댓글의 부모글 번호)
		
		// - 보고있는 글을 스크랩한 멤버의 값 가져오기 
		ArrayList<ScrapDTO> slist = dao.listScrap(seq); // 현재 글번호 ( = 스크랩 글번호)
		
		ArrayList<RecommendDTO> rlist = dao.listRecommend(seq); // 

		
		//3.
		req.setAttribute("dto", dto);
		req.setAttribute("column", column);
		req.setAttribute("search", search);
		req.setAttribute("clist", clist);
		req.setAttribute("slist", slist);
		req.setAttribute("rlist", rlist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/community/view.jsp");
		dispatcher.forward(req, resp);

	}

}
