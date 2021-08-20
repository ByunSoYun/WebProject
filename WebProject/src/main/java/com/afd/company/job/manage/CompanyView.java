package com.afd.company.job.manage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afd.company.CompanyDAO;
import com.afd.company.CompanyDTO;
import com.afd.member.job.CountDAO;
import com.afd.member.job.CountDTO;

@WebServlet("/main/company/job/manage/companyview.do")
public class CompanyView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String companySeq = session.getAttribute("companySeq").toString();
		
		System.out.println(companySeq);
		
		String jobPostSeq = req.getParameter("jobPostSeq");
		System.out.println("공고번호"+ jobPostSeq);
		
		
		CompanyDAO dao = new CompanyDAO();
		
		
		CompanyDTO resultdto = dao.view(jobPostSeq);
		
		if(resultdto==null) {
			System.out.println("공고 null");
		}
		
		
		try {
			Date date;
			String startDate = resultdto.getStartDate();
			startDate = startDate.substring(0, 10);
			resultdto.setStartDate(startDate);
			
			String endDate = resultdto.getEndDate();
			endDate = endDate.substring(0, 10);
			resultdto.setEndDate(endDate);
			
			Calendar getToday = Calendar.getInstance();
			getToday.setTime(new Date()); //금일 날짜
			
			date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			
			Calendar cmpDate = Calendar.getInstance();
			cmpDate.setTime(date); //특정 일자
			
			long diffSec = (cmpDate.getTimeInMillis() - getToday.getTimeInMillis()) / 1000;
			long diffDay = diffSec / (24*60*60); //일자수 차이
			
			if(diffDay != 0) {
				diffDay = diffDay + (long) 1.0;
			}
			
			req.setAttribute("diffDay", diffDay+"");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		CountDAO countdao = new CountDAO();
		
		CountDTO gresult = countdao.genderCount(jobPostSeq);
		
		CountDTO cresult = countdao.careerCount(jobPostSeq);

		int totalnum = countdao.total(jobPostSeq);
		
		req.setAttribute("totalnum", totalnum);
		req.setAttribute("gresult", gresult);
		req.setAttribute("cresult", cresult);
		
		req.setAttribute("resultdto", resultdto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/job/manage/companyview.jsp");
		dispatcher.forward(req, resp);

	}

}