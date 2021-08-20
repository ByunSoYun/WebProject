package com.afd.member.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * AccountSetting.java에서 받은 데이터를 바탕으로 회원의 계정 정보를 수정하는 클래스
 * @author Seongyoon Kim
 *
 */
@WebServlet("/main/member/mypage/accountsettingedit.do")
public class AccountSettingEdit extends HttpServlet {

	/**
	 * AccountSetting.java에서 받은 데이터를 바탕으로 회원의 계정 정보를 수정하는 메소드
	 * @param req, resp
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();

		/**
		 * accountsetting.jsp에서 받은 데이터를 String 변수에 저장
		 */
		String newPw = req.getParameter("newPw");
		String nickName = req.getParameter("nickName");
		String name = req.getParameter("name");
		String firstRegistrationNumber = req.getParameter("firstRegistrationNumber");
		String secondRegistrationNumber = req.getParameter("secondRegistrationNumber");
		String tel1 = req.getParameter("tel1");
		String tel2 = req.getParameter("tel2");
		String tel3 = req.getParameter("tel3");
		String postNumber = req.getParameter("postNumber");
		String address1 = req.getParameter("address1");
		String address2 = req.getParameter("address2");
		String address3 = req.getParameter("address3");
		String email = req.getParameter("email");
		String domain = "";
		
		if (req.getParameter("selectDomain").equals("직접 입력")) {
			
			domain = req.getParameter("domain");
			
		} else {
			
			domain = req.getParameter("selectDomain");
			
		}
		
//		System.out.println("memberSeq: " + session.getAttribute("memberSeq").toString());
//		System.out.println("newPw: " + newPw);
//		System.out.println("nickName: " + nickName);
//		System.out.println("name: " + name);
//		System.out.println("registrationNumber: " + firstRegistrationNumber +"-" + secondRegistrationNumber);
//		System.out.println("tel: " + tel1 + "-" + tel2 + "-" + tel3);
//		System.out.println("address: " + address1 + ", " + address2 + " " + address3 + ", " + postNumber);
//		System.out.println("email: " + email + "@" + domain);
//		System.out.println("domain: " + domain);
		
		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();
		
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		dto.setPw(newPw);
		dto.setNickName(nickName);
		dto.setName(name);
		dto.setRegistrationNumber(firstRegistrationNumber + "-" + secondRegistrationNumber);
		dto.setTel(tel1 + "-" + tel2 + "-" + tel3);
		dto.setAddress(address1 + ", " + address2 + address3 + ", " + postNumber);
		dto.setEmail(email + "@" + domain);
		
		/**
		 * 회원의 계정 정보를 수정하기 위해 필요한 SQL문을 실행하는 메소드
		 * 성공하면 마이페이지 메인화면으로 넘어가고 실패하면 '계정설정 수정 실패' 알림창을 띄운다.
		 */
		int result = dao.accountSettingEdit(dto);
		
		System.out.println("result: " + result);
		
		if (result == 1) {
			
			resp.sendRedirect("/webproject/main/member/mypage/mypagemain.do");
			
		} else {
			
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();			
			
			writer.print("<html>");
			writer.print("<head><meta charset='UTF-8'></head>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('계정 수정 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
			
		}
		
	}

}
