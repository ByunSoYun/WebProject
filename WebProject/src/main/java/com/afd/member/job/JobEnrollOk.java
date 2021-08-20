package com.afd.member.job;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/main/member/job/jobenrollok.do")

public class JobEnrollOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String memberSeq = session.getAttribute("memberSeq").toString();
		String jobPostSeq = req.getParameter("jobPostSeq");
		
		
		System.out.println("사용자 번호"+memberSeq);
		System.out.println("공고번호"+jobPostSeq);
		
	
		ServletContext application = getServletContext();

	    String path = application.getRealPath("/files");
	    // System.out.println(path);
	    
	    //2. 업로드 파일의 최대 크기 지정 
	    // - 최대한 작게 
	    // - 바이트 단위 
	    int size = 1024 * 1024 * 100; // 100MB
	    
	    //3. 변수 선언 

	    String filename = ""; //첨부파일명
	    String orgfilename = ""; // 첨부파일명
	    

	    
	    //서버가 보낸 한글 데이터를 안깨지도록 인코딩 
		req.setCharacterEncoding("UTF-8");

	    
	    try{
	       //파일 업로드 처리 -> 외부 입출력 -> try 필수 
	       
	       // request -> MultipartRequest
	       //com.oreilly.servlet.MultipartRequest();
	       //이 객체를 생성하는 순간 업로드된 파일은 처리를 마치고 첨부파일 폴더에 저장되어 있다.
	       MultipartRequest multi = new MultipartRequest(
			                             req, // 기존의 request Wrapping 클래스 
			                             path, //업로드 폴더 지정 
			                             size, // 업로드 크기 지정 
			                             "UTF-8", //인코딩 지정 
			                             new DefaultFileRenamePolicy()
	                            	);

	       
	       //실제로 저장된 파일명(넘버링O)
	       filename = multi.getFilesystemName("attachedFile"); // <input type="file" name="attach">
	        
	       //사용자가 올린 파일명 (넘버링X)
	       orgfilename = multi.getOriginalFileName("attachedFile");

	    		   
	    } catch(Exception e){
	    	System.out.println("파일 올리기 실패");
	       System.out.println(e);
	    }
	    

       String attachedFile= orgfilename;
		
		
		//System.out.println("파일 이름2"+part.getName());
		System.out.println("파일 이름: "+attachedFile);
		
		SeekerDAO dao = new SeekerDAO();
		
		SeekerDTO dto = new SeekerDTO();
		dto.setMemberSeq(memberSeq);
		dto.setJobPostSeq(jobPostSeq);
		dto.setAttachedFile(attachedFile);
		
		int result = dao.enroll(dto);
		
		if(result > 0) {
			System.out.println("지원 성공");
			resp.sendRedirect("/webproject/main/member/job/joblist.do");
		}else {
			System.out.println("지원 실패");
			resp.sendRedirect("/webproject/main/member/job/jobenroll.do");
		}
		

	}

}
