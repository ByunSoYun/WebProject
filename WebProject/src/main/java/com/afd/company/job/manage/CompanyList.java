package com.afd.company.job.manage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.afd.member.job.JobDTO;

@WebServlet("/main/company/job/manage/companylist.do")
public class CompanyList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();

		String companySeq = session.getAttribute("companySeq").toString();
		
		CompanyDAO dao = new CompanyDAO();
		
		ArrayList<CompanyDTO> list = dao.list(companySeq);
		
		if(list == null) {
			System.out.println("CompanyList.java null");
		}
		
		for(CompanyDTO dto : list) {
			
			try {
				Date date;
				
				String startDate = dto.getStartDate();
				startDate = startDate.substring(0, 10);
				dto.setStartDate(startDate);
				
				String endDate = dto.getEndDate();
				endDate = endDate.substring(0, 10);
				dto.setEndDate(endDate);
				
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		req.setAttribute("list", list);
	

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/job/manage/companylist.jsp");
		dispatcher.forward(req, resp);

	}

}