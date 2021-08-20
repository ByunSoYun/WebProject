package com.afd.admin.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 관리자가 기업회원의 목록을 보게 해주는 클래스
 * @author 3조
 *
 */
@WebServlet("/main/admin/manage/companylist.do")
public class CompanyList extends HttpServlet {

	/**
	 * 관리자가 기업회원의 목록을 보게 해주는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CompanyManageDAO dao = new CompanyManageDAO();
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		String column = req.getParameter("column");
		String search = req.getParameter("search");
		String isSearch = "n";
		
		System.out.println("column: " + column);
		System.out.println("search: " + search);
		System.out.println("isSearch: " + isSearch);
		
		if (column != null && search != null && !column.equals("") && !search.equals("")) {
			isSearch = "y";
		}
		
		map.put("column", column);
		map.put("search", search);
		map.put("isSearch", isSearch);
		
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 10; // 한 페이지당 출력할 게시물 수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // 가져올 게시물 시작 위치
		int end = 0; // 가져올 게시물 끝 위치
		int n = 0; // 페이지바 제작
		int loop = 0; // 페이지바 제작
		int blockSize = 10; // 페이지바 제작
		
		
		String page = req.getParameter("page");
		
		map.put("page", page);
		
		if (page == null || page.equals("")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		totalCount = dao.getTotalCount(map);
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		String pagebar = "	<nav>\r\n" + "			<ul class=\"pagination\">";
		
		
		loop = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		if (n == 1) {
			pagebar += pagebar += String.format(
					" <li class='disabled'><a href='#!' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ");
		} else {
			pagebar += pagebar += String.format(
					" <li><a href='/webproject/main/admin/manage/company.do?page=%d' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ",
					n - 1);
		}
		
		if (totalPage == 0) {
			pagebar += " <li class='active'><a href='#!'>1</a></li> ";
		}

		while (!(loop > blockSize || n > totalPage)) {
			if (n == nowPage) {
				pagebar += String.format(" <li class='active'><a href='#!'>%d</a></li> ", n);
			} else {
				pagebar += String.format(" <li><a href='/webproject/main/admin/manage/companylist.do?page=%d'>%d</a></li> ", n, n);
			}

			loop++;
			n++;

		}
		
		if (n > totalPage) {
			pagebar += String.format(
					" <li class='disabled'><a href='#!' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ");
		} else {
			pagebar += String.format(
					" <li><a href='/webproject/main/admin/manage/memberlist.do?page=%d' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ",
					n);
		}

		pagebar += "</ul>\r\n" + "		</nav>";
		
		ArrayList<CompanyManageDTO> list = dao.list(map);
		
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("pagebar", pagebar);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/admin/manage/companylist.jsp");
		dispatcher.forward(req, resp);
	}

}
;
