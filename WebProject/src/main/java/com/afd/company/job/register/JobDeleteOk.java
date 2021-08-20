package com.afd.company.job.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/company/job/register/jobdeleteok.do")
public class JobDeleteOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jobPostSeq = req.getParameter("jobPostSeq");
		
		PostDAO dao = new PostDAO();
		
		int result = dao.postDelete(jobPostSeq);
		

		if (result > 0) {
			System.out.println("공고 삭제 성공");
			resp.sendRedirect("/webproject/main/company/job/manage/companylist.do");
		}else {
			System.out.println("공고 삭제 실패");
			resp.sendRedirect("/webproject/main/company/job/register/jobdelete.do");
		}
		
		

	}

}
