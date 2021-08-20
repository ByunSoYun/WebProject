package com.afd.admin.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/admin/qna/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String techQnaSeq = req.getParameter("techQnaSeq");
		String column = req.getParameter("column");
		String search = req.getParameter("search");
		String memberSeq = req.getParameter("memberSeq");
		
		QnaDAO dao = new QnaDAO();

		HttpSession session = req.getSession();

		if (session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")) {

			dao.updateReadCount(techQnaSeq);
			
			session.setAttribute("read", "y");
		}

		QnaDTO dto = dao.get(techQnaSeq);
		
		String title = dto.getTitle();
		String content = dto.getContent();
		
		title = title.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
		dto.setTitle(title);
		
		content = content.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
		dto.setContent(content);
		
		//글 내용에 개행 문자 처리하기 	
		content = content.replace("\r\n", "<br>");
		dto.setContent(content);
		
		//내용으로 검색 중일 때 검색어 부각 시키기
		if (column != null && search != null && column.equals("content")) {
			content = content.replace(search, "<span style='color:tomato;background-color:yellow;'>" + search + "</span>");
			dto.setContent(content);
		}
		
		ArrayList<QnaDTO> recommendList = dao.recommendList(techQnaSeq);
		
		ArrayList<QnaDTO> scrapList = dao.scrapList(techQnaSeq);
		
		QnaDTO scrapResult = dao.scrap(techQnaSeq);
		

		ArrayList<CommentDTO> clist = dao.commentList(techQnaSeq);
		
		session.setAttribute("recommend", "y");
		session.setAttribute("decommend", "n");

		req.setAttribute("recommendList", recommendList);
		req.setAttribute("dto", dto);
		req.setAttribute("clist", clist);
		req.setAttribute("search", search);
		req.setAttribute("column", column);
		req.setAttribute("scrapResult", scrapResult);
		req.setAttribute("scrapList", scrapList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/qna/view.jsp");
		dispatcher.forward(req, resp);

	}

}
