package com.afd.main.join.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.afd.member.MemberDAO;
import com.afd.member.MemberDTO;

@WebServlet("/main/join/member/memberjoinok.do")
public class MemberJoinOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

  	  String name = req.getParameter("name");
  	  String id = req.getParameter("id");
  	  String pw = req.getParameter("pw");
  	  String nickname = req.getParameter("nickname");
  	  String registrationNumber = req.getParameter("resgistrationnumber1") + "-" + req.getParameter("resgistrationnumber2");
  	  String tel = req.getParameter("tel1") +"-" + req.getParameter("tel2") + "-" + req.getParameter("tel3");
  	  String address = req.getParameter("address1") +  req.getParameter("address2") +  req.getParameter("address3") ;
  	  String email2="";
	  	
  	  if (req.getParameter("email_addr").equals("직접입력")) {
	        
	  		 email2 = req.getParameter("email2");
	        
	     } else {
	        
	    	 email2 = req.getParameter("email_addr");
	        
	     }
  
	  	  
  	  String email = req.getParameter("email1") + "@" +  email2 ;
 
    

  	  
  	
		MemberDAO dao = new MemberDAO();    
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setName(name);
		dto.setPw(pw);
		dto.setNickName(nickname);
		dto.setRegistrationNumber(registrationNumber);
		dto.setAddress(address);
		dto.setTel(tel);
		dto.setEmail(email);
	
		int result = dao.add(dto);
		
		int result1 = dao.addprofile(dto);
		
		if (result == 1 && result1 == 1 ) {
			resp.sendRedirect("/webproject/main/mainpage.do");
		} else {
			resp.sendRedirect("/webproject/main/login/login.do");
		}	
		
  	  
		
  	  }
	

	
}
