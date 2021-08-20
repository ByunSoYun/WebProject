package com.afd.member.community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/main/member/community/commentadd.do")
public class CommentAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		//할일
		//1. 데이터 가져오기(content, pseq)
		//2. DB 작업 > DAO 위임 > insert
		//3. 돌아가기 > view.do?seq=10
		
		//1.
		String pseq = req.getParameter("pseq"); //보고있던 글번호(= 작성중인 댓글의 부모 글번호)
		String content = req.getParameter("content");
		


		
		//2.
		CommunityDAO dao = new CommunityDAO();
		CommentDTO dto = new CommentDTO();
		
		HttpSession session = req.getSession();
		
		dto.setMemberseq(session.getAttribute("memberSeq").toString()); //댓글 작성자 아이디(= 로그인한 사람 세션)
		dto.setCommunityseq(pseq);
		dto.setContent(content);
		
		int result = dao.addComment(dto);
		
		//3.
		if(result == 1) {
			resp.sendRedirect("/webproject/main/member/community/view.do?seq=" + pseq); //보고 있던 글번호로 가지고 돌아가기
		}else {
				resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('댓글 쓰기 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
		}

	}

}

