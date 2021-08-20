package com.afd.member.space;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main/member/space/addok.do")
public class AddOk extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
	
	
		//할일
		//1. 데이터 가져오기
		//2. DB 작업 > DAO 위임 > insert
		//3. 결과 처리
		
		//1.
		int memberseq = Integer.parseInt(req.getParameter("memberseq"));
		System.out.println("memberseq : " + memberseq);
		int rentalseq = Integer.parseInt(req.getParameter("rentalseq"));
		System.out.println("rentalseq : " + rentalseq);
		String purpose = req.getParameter("purpose");
		System.out.println("purpose : " + purpose);
		int year = Integer.parseInt(req.getParameter("year"));
		System.out.println("year : " + year);
		int month = Integer.parseInt(req.getParameter("month"));
		System.out.println("month : " + month);
		int day = Integer.parseInt(req.getParameter("day"));
		System.out.println("Day : " + day);
		Date date = new Date(year, month, day);
		System.out.println("date : " + date);
		String request = req.getParameter("request");
		System.out.println("request : " + request);
		int startdate = Integer.parseInt(req.getParameter("startdate"));
		System.out.println("startdate");
		int enddate = Integer.parseInt(req.getParameter("enddate"));
		System.out.println("enddate");
		int personcount = Integer.parseInt(req.getParameter("personcount"));
		System.out.println("personcount");
		int totalpay = Integer.parseInt(req.getParameter("totalpay2"));
		System.out.println("totalpay");
		
		
		//2.
		SpaceDAO dao = new SpaceDAO();
		SpaceReservationDTO dto = new SpaceReservationDTO();
		
		dto.setMemberseq(memberseq);
		dto.setRentalseq(rentalseq);
		dto.setPurpose(purpose);
		dto.setReservationdate(date);
		dto.setRequest(request);
		dto.setStartdate(startdate);
		dto.setEnddate(enddate);
		dto.setPersoncount(personcount);
		dto.setTotalpay(totalpay);
		
		dao.insert_reservation(dto);
		
		//3.
		resp.sendRedirect("/webproject/main/member/space/list.do");
		
	}

}