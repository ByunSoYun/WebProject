package com.afd.company.job.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/company/job/register/jobedit.do")
public class JobEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jobPostSeq = req.getParameter("jobPostSeq");
		
		PostDAO dao = new PostDAO();

		PostDTO dto = dao.postInfo(jobPostSeq);
		
		String startDate = dto.getStartDate();
		startDate = startDate.substring(0, 10);
		dto.setStartDate(startDate);
		
		String endDate = dto.getEndDate();
		endDate = endDate.substring(0, 10);
		dto.setEndDate(endDate);
		
		
		/* req.setAttribute("jobPostSeq", jobPostSeq); */
		req.setAttribute("dto", dto);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/job/register/jobedit.jsp");
		dispatcher.forward(req, resp);

	}

}
