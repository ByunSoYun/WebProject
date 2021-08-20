package com.afd.member.study;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/main/member/study/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//할일
		//1. 데이터 가져오기(seq)
		//2. DB 작업 > DAO 위임 > select where seq
		//3. BoardDTO 반환 > JSP 호출하기 + 전달하기
		HttpSession session = req.getSession();
		
		String studyPostSeq = req.getParameter("seq");
		
		//2.
		StudyDAO dao = new StudyDAO();
		
		//조회수 올리기
		if(session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")) {
			dao.updateReadcount(studyPostSeq);
			
			session.setAttribute("read", "y");
		}
		
		
		
		StudyDTO dto = dao.get(studyPostSeq);
		String postTile = dto.getPostTitle();
		String content = dto.getContent();
		
		//System.out.println(dto.getContent());
		
		//<script>태그 비활성화
		postTile = postTile.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
	    dto.setPostTitle(postTile);
	      
	    content = content.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
	    dto.setContent(content);
	    
	    
	   //글 내용에 개행 문자 처리하기
  		content = content.replace("\r\n", "<br>");
  		dto.setContent(content);
  		
  		
  		//댓글 목록 가져오기
  		ArrayList<CommentDTO> clist = dao.listComment(studyPostSeq);
  		
  		//스크랩, 추천목록 가져오기
  		ArrayList<ScrapDTO> slist = dao.listScrap(studyPostSeq);
  		ArrayList<RecommendDTO> rlist = dao.recommendScrap(studyPostSeq);
  		
  		//스터디 공고 목록 가져오기
  		ArrayList<SeekerInfoDTO> alist = dao.listApply(studyPostSeq);
  		
  		//경력 차트 가져오기
  		ChartStudyDTO cresult = dao.careerCount(studyPostSeq);
  		
  		//전공차트 가져오기
  		//ArrayList<ChartStudyDTO> mojorlist = dao.majorChart(studyPostSeq);
		
	    
	    req.setAttribute("dto", dto);
	    req.setAttribute("clist", clist);
	    req.setAttribute("slist", slist);
	    req.setAttribute("rlist", rlist);
	    req.setAttribute("alist", alist);
	    req.setAttribute("cresult", cresult);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/study/view.jsp");
		dispatcher.forward(req, resp);
		
		
		
		
		
	}

}
