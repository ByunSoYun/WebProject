<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.afd.member.space.SpaceDAO"%>
<%@page import="com.afd.member.space.SpaceDTO"%>
<%@page import="com.afd.member.space.SpaceMainDTO"%>
<%@page import="com.afd.member.space.SpaceImageDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
     
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<%
		SpaceDAO dao = new SpaceDAO();
		
		ArrayList<SpaceMainDTO> list_dto = dao.selectSpaceAll();
		System.out.println(list_dto.size());
		
		String str_page = request.getParameter("page");
		int now_page = 1;
		
		if(str_page == null || str_page.length() == 0) { now_page = 1; }
		try {
			now_page = Integer.parseInt(str_page);
		} catch(NumberFormatException e) {
			now_page = 1;
		}
		
		int per_page = 9;
		int total_page = (list_dto.size()/per_page) + 1;
		int begin = (now_page-1) * per_page;
		int end = (now_page*per_page) - 1;
		
		if(end >= list_dto.size()) { end = list_dto.size()-1; }
		
		/* for(int i=begin; i <= end; i++) {
			ArrayList<SpaceImageDTO> imgList = dao.selectImg(list_dto.get(i).getRentalseq());
		}//end for */
	%>

    
    <style>
     
     	 p { margin:20px 0px; }
     	 
     	 .row {
     	 	width: 1200px;
     	 }
     	 
     	 
     	 
     	 .col-4 {
     	 	margin-bottom: 50px;
     	 }
     	 

     	 .carousel-control-prev-icon {
		  height: 25px;
		  width: 25px;
		  margin-right: 20px;
		  margin-top: 15px;
		}

		.carousel-control-next-icon {
		  height: 25px;
		  width: 25px;
		  margin-left: 20px;
		  margin-top: 15px;
		}
		
	
		

     	
     	 
    </style>
    
	<title></title>
	
	<%@ include file="/inc/asset.jsp"%>

	

</head>
<body>
<%@ include file="/inc/header.jsp" %>
	<!-- 공간대여서비스 메인 화면  -->
	
		<h1 class="page-header"></h1>
		
		 <div class="container">
      <div class="row">
      
      
      
      <%
      for(int i=begin; i <= end; i++) {
			ArrayList<SpaceImageDTO> imgList = dao.selectImg(list_dto.get(i).getRentalseq());
      %>
      
      
        <div class="col-4">
          <div class="card">
            <div id="carouselExampleIndicators<%=i %>" class="carousel slide" data-ride="carousel">
			  <ol class="carousel-indicators">
			    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			    <%
				for(int j = 1; j <imgList.size(); j++){
			    %>
			    <li data-target="#carouselExampleIndicators" data-slide-to="<%=j%>"></li> 
			   <%	}//end for %>
			  </ol>
			  <div class="carousel-inner">
			  
			  <%for(int j = 0; j <imgList.size(); j++){ 
			  
			  	if(j==0){
			 
			  %>
			    <div class="carousel-item active">
			      <img class="d-block w-100"  onclick="location.href='/webproject/main/member/space/clicklist.do?rentalseq=<%=list_dto.get(i).getRentalseq()%>';" style= " width : 368px; height : 218px;" src="/webproject/asset/images/space_images/<%=imgList.get(0).getImageName() %>">
			    </div>
			   <%}else{ %>
			    <div class="carousel-item">
			      <img class="d-block w-100"  onclick="location.href='/webproject/main/member/space/clicklist.do?rentalseq=<%=list_dto.get(i).getRentalseq()%>';" style= " width : 368px; height : 218px;"  src="/webproject/asset/images/space_images/<%=imgList.get(j).getImageName() %>" >
			    </div>
			    
			    <%
			 	  }//end if~else 
			  	}//end for
			  %>
			  </div>
			  <a class="carousel-control-prev" href="#carouselExampleIndicators<%=i %>" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleIndicators<%=i %>" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
			
			<div class="card-body">
              <h2 class="card-title"><%=list_dto.get(i).getName() %></h2>
              <h5 class="card-text" style="font-weight: bold">
               	<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
			  		<path d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94zM8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10z" />
			  		<path d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
               	</svg> <%=list_dto.get(i).getDong() %> 
               </h5>
               
               <div class="card-text">
              <h5> <%=list_dto.get(i).getHourpay() %> 원/시간 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  					<path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
				</svg>최대  <%=list_dto.get(i).getLimitperson()%>인</h5>    
           	  <input type="hidden" value = "<%=list_dto.get(i).getRentalseq() %>" />
           	  </div>
            </div>
          </div>
        </div>
        <%}//end for %>
    
      </div>
    </div>
    
    <%
    	for(int i=1; i<=total_page; i++) {
    %>
    <a href='/webproject/main/member/space/list.do?page=<%=i%>'><%=i %></a>
    <%} %>
    
    
 	<%@ include file="/inc/footer.jsp" %>	
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
<script>


</script>
</body>
</html>


