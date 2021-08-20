package com.afd.member.job;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/member/job/joblist.do")
public class JobList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPostGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		doPostGet(req, resp);

	}

	private void doPostGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//할일
		//1. DB 작업 > DAO 위임 > select
		//2. ArrayList<BoardDTO> 반환
		//3. JSP 호출하기 + 2번 전달 
		
		req.setCharacterEncoding("UTF-8");
		
		JobDAO jobdao = new JobDAO();
		HashMap<String, String> map = new HashMap<String, String>();
		
		String filter = req.getParameter("filter");
		map.put("filter", filter);

		String isSearch = "n";
		String isFilter = "n";
		
		
		String city = req.getParameter("city");
		String gu = req.getParameter("gu");
		map.put("city", city);
		map.put("gu", gu);
		
		String career = req.getParameter("career");
		map.put("career", career);
		
		String educationLevel = req.getParameter("educationLevel");
		map.put("educationLevel", educationLevel);

		if(city != null || career != null || educationLevel != null) {
			isSearch = "y";
		}
		map.put("isSearch", isSearch);
		
		if(filter != null) {
			if(filter.equals("마감임박순")) {
				isFilter = "1";
			}else {
				isFilter = "2";
			}
		}else {
			isFilter = "2";
			
		}
		
		
		map.put("isFilter", isFilter);
		
		/*
		 * String where = String.format("career '%%s%' ", career);
		 * System.out.println("career" +where);
		 */
		
		//group데이터 저장 > 직군별 목록보기
		String jobGroup = req.getParameter("jobGroup"); 
		//System.out.println(jobGroup);
		String jobNum = jobGroup;
		map.put("jobNum", jobNum);
		
		
		if(jobGroup != null) {
			if(jobGroup.equals("1")){
				jobGroup="서버 개발자";
			}else if(jobGroup.equals("2")) {
				jobGroup="웹 개발자";
			}else if(jobGroup.equals("3")) {
				jobGroup="프론트엔드 개발자";
			}else if(jobGroup.equals("4")) {
				jobGroup="자바 개발자";
			}else if(jobGroup.equals("5")) {
				jobGroup="안드로이드 개발자";
			}else if(jobGroup.equals("6")) {
				jobGroup="IOS 개발자";
			}else if(jobGroup.equals("7")) {
				jobGroup="DB 관리자";
			}else if(jobGroup.equals("8")) {
				jobGroup="보안 엔지니어";
			}else if(jobGroup.equals("9")) {
				jobGroup="웹 디자이너";
			}
			
		}
		map.put("jobGroup", jobGroup);
		System.out.println("직업: "+jobGroup);
		/*
		 * select * from tblMember; commit;
		 */
		
		// 페이징 처리
		// -> 보고 싶은 페이지를 정하기 위한 처리
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int totalPage = 0;		//총 페이지 수
		int pageSize = 9;		//한 페이지당 출력할 게시물 수
		int begin = 0;			//가져올 게시물 시작 위치
		int end = 0;			//가져올 게시물 끝 위치
		int n = 0;				//페이지바 제작
		int loop = 0;			//페이지바 제작
		int blockSize = 10;		//페이지바 제작
		
		
		String page = req.getParameter("page");
		//System.out.println(page);
		
		if(page == null || page.equals("")) {
			nowPage = 1;
		}else {
			nowPage = Integer.parseInt(page);
			//System.out.println(nowPage);
		}
		
		// nowPage > 지금 보게될 페이지 번호
		// 1page > where rnum between 1 and 10
		// 2page > where runm between 11 and 20
		
		begin = ((nowPage-1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		//총 게시물 수 알아내기
		totalCount = jobdao.getTotalCount(map);
		//System.out.println(totalCount); 25
		
		//총 페이지 수 알아내기
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		//System.out.println(totalPage); 3


		//페이징 작업
		String pagebar = "<nav>\r\n"
				+ "  <ul class=\"pagination\">";
		

		loop = 1; //while 루프 변수
		n = ((nowPage - 1) / blockSize) * blockSize + 1; //출력되는 페이지 번호
		
		search(map);
		System.out.println("map=================");
		System.out.println(map.get("city"));
		System.out.println(map.get("gu"));
		System.out.println(map.get("career"));
		System.out.println(map.get("educationLevel"));
		System.out.println(map.get("filter"));
		System.out.println(map.get("jobGroup"));
	
		if( n == 1 ) {
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li> ");
		}else{
			pagebar += String.format(" <li><a href='/webproject/main/member/job/joblist.do?page=%d&jobGroup=%s&city=%s&gu=%s&career=%s&educationLevel=%s&filter=%s' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li> ", n-1, map.get("jobGroup"), map.get("city"), map.get("gu"), map.get("career"), map.get("educationLevel"), map.get("filter"));
		}
		//http://localhost:8090/webproject/main/member/job/joblist.do?page=2
		if(totalPage == 0) {
			pagebar += "<li class='active'><a href='#!'>1</a></li>";
		}
		
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (n == nowPage) {
				pagebar += String.format(" <li class='active'><a href='#!'>%d</a></li> ", n);				
			} else {
				
				pagebar += String.format(" <li><a href='/webproject/main/member/job/joblist.do?page=%d&jobGroup=%s&city=%s&gu=%s&career=%s&educationLevel=%s&filter=%s'>%d</a></li> ", n, map.get("jobGroup"), map.get("city"), map.get("gu"), map.get("career"), map.get("educationLevel") , map.get("filter"),n);
			}
			
			loop++;
			n++;
		}

		if (n > totalPage) {
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li> ");			
		} else {
			pagebar += String.format(" <li><a href='/webproject/main/member/job/joblist.do?page=%d&jobGroup=%s&city=%s&gu=%s&career=%s&educationLevel=%s&filter=%s' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li> ", n, map.get("jobGroup"), map.get("city"), map.get("gu"), map.get("career"), map.get("educationLevel"), map.get("filter"));
		}
		
		pagebar += "</ul>\r\n"
				+ "		</nav> ";
		
		ArrayList<JobDTO> list = jobdao.list(map);
		
		
		if(list == null) {
			System.out.println("JobList.java null");
		}
		
		for(JobDTO dto : list) {
			
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
				
				dto.setDiffDay(diffDay+"");

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		req.setAttribute("list", list);
		req.setAttribute("map", map); //***
		req.setAttribute("jobGroup", jobGroup);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("pagebar", pagebar);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/job/joblist.jsp");
		dispatcher.forward(req, resp);

	}

	private HashMap<String, String> search(HashMap<String, String> map) {

		String city = map.get("city");
		String gu = map.get("gu");
		String career = map.get("career");
		String educationLevel = map.get("educationLevel");
		String filter = map.get("filter");
		String jobGroup = map.get("jobGroup");
		
		
		if(city == null) {
			city="all";
			map.put("city", city);
		}
		
		if(gu == null) {
			gu="all";
			map.put("gu", gu);
		}
		
		if(career == null) {
			career="all";
			map.put("career", career);
		}
		
		if(educationLevel == null) {
			educationLevel="all";
			map.put("educationLevel", educationLevel);
		}
		
		if(filter == null) {
			filter="최신순";
		}else {
			if(filter.equals("마감임박순")) {
				filter="마감임박순";
			}
		}
		map.put("filter", filter);
		
		if(jobGroup == null) {
			jobGroup = "all";
			map.put("jobGroup", jobGroup);
		}
		System.out.println("jobGroup"+jobGroup);
		
		
		return map;

		
	}

}
