package com.afd.company.job.manage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afd.company.CompanyDAO;
import com.afd.company.CompanyDTO;

@WebServlet("/main/company/job/manage/joblist.do")
public class JobList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String companySeq = session.getAttribute("companySeq").toString();
		
		System.out.println("회사 고유번호: "+session.getAttribute("companySeq"));

		CompanyDAO dao = new CompanyDAO();
		
		ArrayList<CompanyDTO> list = dao.list(companySeq);
		
		if(list == null) {
			System.out.println("공고 list null");
		}
		
		req.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/job/manage/companylist.jsp");
		dispatcher.forward(req, resp);

	}

}