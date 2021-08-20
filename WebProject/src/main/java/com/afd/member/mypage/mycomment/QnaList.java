package com.afd.member.mypage.mycomment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afd.member.mypage.MyPageDAO;
import com.afd.member.mypage.MyPageDTO;

/**
 * Q&A에 작성한 자신의 게시글을 보여주는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/member/mypage/mycomment/qnalist.do")
public class QnaList extends HttpServlet {

	/**
	 * Q&A에 작성한 자신의 게시글을 보여주는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MyCommentDAO dao = new MyCommentDAO();
		MyCommentDTO dto = new MyCommentDTO();
		
		HttpSession session = req.getSession();
		
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		
		//System.out.println("memberSeq: " + session.getAttribute("memberSeq").toString());
		
		/**
		 * Q&A에 작성한 자신의 게시글을 보여주기 위해 필요한 SQL문을 실행하는 메소드
		 */
		ArrayList<MyCommentDTO> qnaList = dao.qnaList(dto);
		
		for (MyCommentDTO qlist : qnaList) {
			
			String regdate = qlist.getRegdate();
			regdate = regdate.substring(0, 10);
			qlist.setRegdate(regdate);
			
			String title = qlist.getTitle();
			
			title = title.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
			qlist.setTitle(title);
			
			if (title.length() > 50) {
				title = title.substring(0, 50) + "...";
				qlist.setTitle(title);
			}
			
		}
		
		//System.out.println("qnaList: " + qnaList.toString());
		
		req.setAttribute("qnaList", qnaList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/mycomment/qnalist.jsp");
		dispatcher.forward(req, resp);

	}

}
