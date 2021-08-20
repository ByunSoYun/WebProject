package com.afd.member.job;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/main/member/job/jobview.do")
public class JobView extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPostGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		doPostGet(req, resp);

	}

	
	private void doPostGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.removeAttribute("isscrap");
		System.out.println("==========================");
		System.out.println("is스크랩:"+session.getAttribute("isscrap"));
		
		String memberSeq = session.getAttribute("memberSeq").toString();
		//System.out.println("memberSeq: "+memberSeq);
		
		//String companySeq = req.getParameter("companySeq");
		String jobPostSeq = req.getParameter("jobPostSeq");
		//System.out.println("jobPostSeq: "+jobPostSeq);
		
		String scrap = req.getParameter("scrap");
		System.out.println("scrap여부: "+scrap);
		
		JobViewDAO dao = new JobViewDAO();

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("memberSeq", memberSeq);
		map.put("jobPostSeq", jobPostSeq);
		map.put("scrap", scrap);
		
		
		if(scrap != null) {
			if(scrap.equals("y")) {
				System.out.println("인서트 시작");
				dao.scrapInsert(map);
				System.out.println("인서트 종료");
			}
			if(scrap.equals("n")){
				System.out.println("딜리트 시작");
				dao.scrapDelete(map);
				System.out.println("딜리트 종료");
			}
		}
	
		JobDTO dto = dao.view(jobPostSeq);

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
			
			map.put("diffDay", diffDay+"");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if(dto==null) {
			System.out.println("공고 null");
		}
		
		System.out.println("공고 번호: "+dto.getJobPostSeq());
		
		int result = dao.scrap(map);
		System.out.println("result: "+result);
		
		if(result > 0) {
			session.setAttribute("isscrap", "y");
			System.out.println("is스크랩여부: y");
		}else {
			session.setAttribute("isscrap", "n");
			System.out.println("is스크랩여부: n");
		}
		
		CountDAO countdao = new CountDAO();
		
		CountDTO gresult = countdao.genderCount(jobPostSeq);
		
		CountDTO cresult = countdao.careerCount(jobPostSeq);

		int totalnum = countdao.total(jobPostSeq);
		
		req.setAttribute("totalnum", totalnum);
		req.setAttribute("gresult", gresult);
		req.setAttribute("cresult", cresult);
		req.setAttribute("dto", dto);
		req.setAttribute("map", map);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/job/jobview.jsp");
		dispatcher.forward(req, resp);

	}

}