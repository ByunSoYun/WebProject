package com.afd.member.mypage.mystudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afd.member.MemberDTO;
import com.afd.member.study.SeekerInfoDTO;

@WebServlet("/main/member/mypage/evaluationok.do")
public class EvaluationOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		
		//1.
		HttpSession session = req.getSession();
		String memberseq = session.getAttribute("memberSeq").toString();
		String studyseq = req.getParameter("studyseq");
		String[] evaluation = req.getParameterValues("evaluation");
		String[] seq = req.getParameterValues("seq");
		
		//2.
		MyStudyDAO dao = new MyStudyDAO();
		MemberDTO mdto = new MemberDTO();
		SeekerInfoDTO idto = new SeekerInfoDTO();
		
		idto.setMemberSeq(memberseq);
		idto.setStudyPostSeq(studyseq);
		
		//tblseekerinfo evaluation 'y'로 만들기
		int result = dao.evaluationChange(idto);
		
		
		//tblmember 점수 변경하기
		int result1 = -1;
		
		for(int i=0; i<=evaluation.length - 1; i++) {
			//점수 계산하기
			int beforeScore = dao.getEvaluation(seq[i]);
			
			
			String afterScore;
			if(beforeScore == 0) {
				afterScore = Integer.parseInt(evaluation[i]) + "";
			} else {
				afterScore =  Math.round((Integer.parseInt(evaluation[i]) + beforeScore) / 2) + "";
			}
			
			result1 = dao.scoreChange(afterScore, seq[i]);
		}
		
		
		if (result == 1 && result1 == 1) {
			
			resp.sendRedirect("/webproject//main/member/mypage/evaluation.do");
			
		} else {
			
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('스코어 업데이트 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
			
		}
		
		
		
		

	}

}