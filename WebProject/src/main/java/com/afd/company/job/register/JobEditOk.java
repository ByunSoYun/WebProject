package com.afd.company.job.register;

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

@WebServlet("/main/company/job/register/jobeditok.do")
public class JobEditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String companySeq = session.getAttribute("companySeq").toString();


		String jobPostSeq = null;
		String postName = null;
		String jobGroup = null;
		String career = null;
		String educationLevel = null;
		String jobType = null;
		String salary = null;
		//attachedFile = req.getParameter("attachedFile");
		String postContent = null;
		String startDate = null;
		String endDate = null;
		
		String city = null;
		String gu = null;
		String dong = null;
		String address = null;
		String latitude = null;
		String longitude = null;
		
		
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
	       

	        jobPostSeq = multi.getParameter("jobPostSeq");
			postName = multi.getParameter("postName");
			jobGroup = multi.getParameter("jobGroup");
			career = multi.getParameter("career");
			educationLevel = multi.getParameter("educationLevel");
			jobType = multi.getParameter("jobType");
			salary = multi.getParameter("salary");
			//attachedFile = req.getParameter("attachedFile");
			postContent = multi.getParameter("postContent");
			startDate = multi.getParameter("startDate");
			endDate = multi.getParameter("endDate");
			
			city = multi.getParameter("city");
			gu = multi.getParameter("gu");
			dong = multi.getParameter("dong");
			address = multi.getParameter("address");
			latitude = multi.getParameter("latitude");
			longitude = multi.getParameter("longitude");

	       
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
		
		

		PostDAO dao = new PostDAO();
		
		PostDTO dto = new PostDTO();
		
		dto.setJobPostSeq(jobPostSeq);
		dto.setCompanySeq(companySeq);
		dto.setPostName(postName);
		dto.setJobGroup(jobGroup);
		dto.setCareer(career);
		dto.setEducationLevel(educationLevel);
		dto.setJobType(jobType);
		dto.setSalary(salary);
		dto.setAttachedFile(attachedFile);
		dto.setPostContent(postContent);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		
		System.out.println(educationLevel);
		System.out.println(startDate);
		System.out.println(jobType);

		int result = dao.edit(dto);
		
		System.out.println("공고 수정 결과: "+result);
	
		if (result > 0) {
			System.out.println("채용공고 수정 성공");
		}else {
			System.out.println("채용공고 수정 실패");
		}
		
		LocationDTO locdto = new LocationDTO();
		locdto.setJobPostSeq(jobPostSeq);
		locdto.setCity(city);
		locdto.setGu(gu);
		locdto.setDong(dong);
		locdto.setAddress(address);
		locdto.setLatitude(latitude);
		locdto.setLongitude(longitude);
		
		int locresult = dao.locedit(locdto);
	
		
		if (locresult > 0) {
			System.out.println("위치 수정 성공");
			resp.sendRedirect("/webproject/main/company/job/manage/companylist.do");
		}else {
			System.out.println("위치 수정 실패");
			resp.sendRedirect("/webproject/main/company/job/register/jobedit.do");
		}
		
	}

}
