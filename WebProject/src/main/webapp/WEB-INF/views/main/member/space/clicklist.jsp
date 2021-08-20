<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.afd.member.space.SpaceDAO"%>
<%@page import="com.afd.member.space.SpaceImageDTO"%>
<%@page import="com.afd.member.space.SpaceClickInfoDTO"%>
<%@page import="java.util.ArrayList"%>



<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
     
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>

.col-4 {
     	 	margin-bottom: 50px;
     	 }
     	 

     	 .carousel-control-prev-icon {
		  height: 43px;
		  width: 43px;
		  margin-right: 33px;
		  margin-top: 23px;
		}

		.carousel-control-next-icon {
		   height: 43px;
		  width: 43px;
		  margin-left: 33px;
		  margin-top: 23px;
		}

		
</style>
</head>
<body>
<% int rentalseq = Integer.parseInt(request.getParameter("rentalseq"));
	
	SpaceDAO dao = new SpaceDAO();

	 SpaceClickInfoDTO dto = dao.selectclickinfo(rentalseq); 
	
	ArrayList<SpaceImageDTO> imgList = dao.selectImg(rentalseq);
 
%>
<%@ include file="/inc/header.jsp" %>


		<div class="container" >

		<p style="float:right">
		<button type="button" class="btn btn-secondary" onclick="location.href='/webproject/main/member/space/booklist.do?rentalseq=<%=rentalseq%>&limit=<%=dto.getLimitperson() %>&hourpay=<%=dto.getHourpay() %>';" style="position: fixed; width: 100px; height: 50px;">예약하기</button>
		</p>

		<h1 class="page-header"  style="font-size: 40px;"> <%=dto.getName() %> </h1>
		
		<div class="image" style=" width:600px; height: 300px;  margin: 0 auto; margin-top: 50px; margin-bottom: 120px;">
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
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
			      <img class="d-block w-100" src="/webproject/asset/images/space_images/<%=imgList.get(0).getImageName() %>">
			    </div>
			   <%}else{ %>
			    <div class="carousel-item">
			      <img class="d-block w-100"   src="/webproject/asset/images/space_images/<%=imgList.get(j).getImageName() %>" >
			    </div>
			    
			    <%
			 	  }//end if~else 
			  	}//end for
			  %>
			  </div>
			  <a class="carousel-control-prev"  href="#carouselExampleIndicators" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next"  href="#carouselExampleIndicators" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
		</div>
		
		<h1 class= "title1"  style="font-size: 30px">공간소개</h1>
		<div class="content1" style=" white-space:pre-line; line-height: 200%;"><%=dto.getContent1()%></div><br><br><br>
		
		<h1 class= "title2"  style="font-size: 30px">시설 안내</h1>
		<div class="content2" style=" white-space:pre-line; line-height: 200%;"><%=dto.getContent2() %></div><br><br><br>
		
		<h1 class = "titme6" style="font-size: 30px">공간 용도</h1>
		<div class="content2" style=" white-space:pre-line; line-height: 200%;"><%=dto.getPurpose() %></div><br><br><br>
		
		<h1 class= "title3"  style="font-size: 30px">예약시 주의사항</h1>
		<div class="content3" style=" white-space:pre-line; line-height: 200%;"><%=dto.getContent3() %></div><br><br><br>
		
		<h1 class= "title4"  style="font-size: 30px"> 환불규정 안내 </h1>
		<div class="content4" style=" white-space:pre-line; line-height: 200%;"><%=dto.getContent4() %></div><br><br><br>
		
		<h1 class= "title5"  style="font-size: 30px"> 위치 안내 </h1>
		<div class="location" style=" width: 600px; height:800px; margin: 0 auto; margin-top: 100px; ">
			<p style="font-size: 27px;"><%=dto.getName() %></p>
			<p style="font-size: 15px;"><%=dto.getAddress() %></p>
			<div id="map" style="border:1px solid black; width: 600px; height:600px; margin: 0 auto; ">
		
			</div>
		</div>
		
	</div><!--fin container  -->
<%@ include file="/inc/footer.jsp" %>		
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b910140a97b09496b35bc0ec51aa430c"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(<%=dto.getLatitude() %>, <%=dto.getLongitude()%>),
			level: 3
		};
	
		var map = new kakao.maps.Map(container, options);
		
		var position =  new kakao.maps.LatLng(<%=dto.getLatitude() %>, <%=dto.getLongitude()%>);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		  position: position
		});

		// 마커를 지도에 표시합니다.
		marker.setMap(map);

		// 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
		var iwContent = '<div style="padding:8px;"><%=dto.getName() %></div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

		// 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
		    content : iwContent
		});

		// 마커에 마우스오버 이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'mouseover', function() {
		  // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
		    infowindow.open(map, marker);
		});

		// 마커에 마우스아웃 이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'mouseout', function() {
		    // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
		    infowindow.close();
		});
	</script>
</body>
</html>






