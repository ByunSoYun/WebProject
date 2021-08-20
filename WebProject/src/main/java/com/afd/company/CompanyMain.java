package com.afd.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/main/company/companymain.do")
public class CompanyMain extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doPostGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doPostGet(req, resp);
	}

   protected void doPostGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String id = req.getParameter("id");
      String pw = req.getParameter("pw");
      
      CompanyDAO dao = new CompanyDAO();
      
      CompanyDTO dto = new CompanyDTO();
      dto.setId(id);
      dto.setPw(pw);
      
      CompanyDTO result = dao.login(dto);
      
      if(result != null) {
         //인증 > 티켓 발급
         HttpSession session = req.getSession();
         
         session.setAttribute("id", result.getId()); //인증 티켓
         
         //부가정보
         session.setAttribute("name", result.getName());
         session.setAttribute("companySeq", result.getCompanySeq());
      
         
      }else {

         System.out.println("null");
      }
      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/companymain.jsp");
      dispatcher.forward(req, resp);
      

   }

}