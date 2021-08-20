package com.afd.member.study;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/main/member/study/list.do")
public class List extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPostGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPostGet(req, resp);
		
	}

	
	private void doPostGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String column = req.getParameter("column");
		String search = req.getParameter("search");
		
		String city = req.getParameter("city");
		String gu = req.getParameter("gu");
		String period = req.getParameter("period");
		String jobGroup = req.getParameter("jobGroup");
		
		
		String isSearch = "n";
		

		
		
		if(city != null && gu != null && period != null && jobGroup != null && !city.equals("") && !gu.equals("") && !period.equals("") && !jobGroup.equals("")) {
			isSearch = "ya";
		}
		
		if(column != null && search != null && !column.equals("") && !search.equals("") && !column.equals("null") && !search.equals("null")) {
			isSearch = "yb";
		}
		
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("column", column);
		map.put("search", search);
		map.put("isSearch", isSearch);
		map.put("city", city);
		map.put("gu", gu);
		map.put("period", period);
		map.put("jobGroup", jobGroup);
		
		
		//페이징 처리
		// -> 보고싶은 페이지를 정하기 위한 처리
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;;	//총 게시물 수
		int pageSize = 10;		//한 페이지당 출력할 게시물 수
		int begin = 0;			//총 페이지 수
		int end = 0;			//가져올 게시물 끝 위
		int n = 0;				//페에지바 제작
		int loop = 0;			//페이지바 제작
		int blockSize = 10;		//페이지바 제작
		int totalPage = 0;
		
		
		
		String page = req.getParameter("page");
		
		
		if(page == null || page.equals("page")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		
		begin = ((nowPage -1) * pageSize) + 1;
		end = begin + pageSize -1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		//1.
		StudyDAO dao = new StudyDAO();
		totalCount = dao.getTotalCount(map);
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		String pagebar = "<nav>\r\n"
				+ "			<ul class=\"pagination\">";
		
		loop = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		search(map);
		
		
		//이전 10페이지
		if (n == 1) {
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li> ");			
		} else {
			pagebar += String.format(" <li><a href='/webproject/main/member/study/list.do?page=%d&column=%s&search=%s&city=%s&gu=%s&period=%s&jobGroup=%s&isSearch=%s' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li> ", n-1, column, search, map.get("city"), map.get("gu"), map.get("period"), map.get("jobGroup"), isSearch);			
		}
		
		
		if (totalPage == 0) {
			pagebar += "<li class='active'><a href='#!'>1</a></li>";
		}
		
		while(!(loop > blockSize || n > totalPage)) {
			if (n == nowPage) {
				pagebar += String.format("<li class='active"
						+ "'><a href='#!'>%d</a></li>", n);
			} else {
				pagebar += String.format("<li><a href='/webproject/main/member/study/list.do?page=%d&column=%s&search=%s&city=%s&gu=%s&period=%s&jobGroup=%s&isSearch=%s'>%d</a></li>", n, column, search, map.get("city"), map.get("gu"), map.get("period"), map.get("jobGroup"), isSearch, n);
			}
			loop++;
			n++;
			
		};
		
		
		
		//다음 10페이지
		if (n > totalPage) {
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li> ");			
		} else {
			pagebar += String.format(" <li><a href='/webproject/main/member/study/list.do?page=%d&column=%s&search=%s&city=%s&gu=%s&period=%s&jobGroup=%s&isSearch=%s' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li> ", n, column, search, map.get(city), map.get(gu), map.get(period), map.get(jobGroup), isSearch, n);
		}
		
		pagebar += "</ul>\r\n"
				+ "		 </nav>";
		
		
		
		//2. 
		ArrayList<StudyDTO> list = dao.list(map);
		
		
		//2.날짜
		for (StudyDTO dto: list) {
			
			String regdate = dto.getRegdate();
			regdate = regdate.substring(0, 10);
			dto.setRegdate(regdate);
			
			String subject = dto.getPostTitle();
			
			subject = subject.replace("<script", "&lt;script").replace("</script>", "&ltscript&gt");
			dto.setPostTitle(subject);
			
			if (subject.length() > 38) {
				subject = subject.substring(0, 38) + "..";
				dto.setPostTitle(subject);
			}
			
		}
		
		
		//새로고침에 의한 조회수 증가 방지 티켓
		HttpSession session = req.getSession();
		
		session.setAttribute("read", "n");
		
		
		//3.
		req.setAttribute("list", list);
		req.setAttribute("map", map);//*****
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		
		req.setAttribute("pagebar", pagebar);
		
		RequestDispatcher dispatcher =
				  req.getRequestDispatcher("/WEB-INF/views/main/member/study/list.jsp");
				  dispatcher.forward(req, resp); 
	}

	

	private HashMap<String, String> search(HashMap<String, String> map) {

	      String city = map.get("city");
	      String gu = map.get("gu");
	      String period = map.get("period");
	      String jobGroup = map.get("jobGroup");
	      String column = map.get("column");
	      String search = map.get("search");
	      
	      
	      if(city == null || city.equals("null")) {
	         city="all";
	         map.put("city", city);
	      }
	      
	      if(gu == null || gu.equals("null")) {
	         gu="all";
	         map.put("gu", gu);
	      }
	      
	      if(period == null || period.equals("null")) {
	    	  period="all";
	         map.put("period", period);
	      }
	      
	      if(jobGroup == null || jobGroup.equals("null")) {
	    	  jobGroup="all";
	         map.put("jobGroup", jobGroup);
	      }
	      
	      if(column == null || column.equals("null")) {
	    	  column="";
	    	  map.put("column", column);
	      }
	      
	      if(search == null || search.equals("null")) {
	    	  search="";
	    	  map.put("search", search);
	      }
	      
	     
	      
	      return map;

	      
	   }



}
