<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.afd.member.space.SpaceDAO"%>
<%@page import="com.afd.member.space.SpaceDTO"%>
<%@page import="com.afd.member.space.SpaceMainDTO"%>
<%@page import="com.afd.member.space.SpaceImageDTO"%>
<%@page import="com.afd.member.mypage.myreservation.MySpaceDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>
.card-img-top {
	width: 400px;
	height: 400px;
}

.card-body {
	width: 400px;
	height: 400px;
}

div.card.mb-3 {
	width: 400px;
	height: 600px;
}

#pay {
	font-size: 16px;
	font-style: bold;
	color: blue;
	text-align: center;
}
</style>
</head>
<body>

	<%@ include file="/inc/header.jsp"%>

	<div class="container">
		<h1>예약한 공간 내역</h1>
		<div class="main">
			<c:forEach items="${list}" var="list_dto">
				<div class="card mb-3" style="float:left; margin: 30px;">
					<c:forEach items="${img}" var="img_dto">
						<img class="card-img-top"
							onclick="location.href='/webproject/main/member/space/clicklist.do?rentalseq=${list_dto.rentalseq}';"
							src="/webproject/asset/images/space_images/${img_dto.imageName} ">
					</c:forEach>
					<div class="card-body">
						<h1 class="card-title">${list_dto.name}</h1>
						<h3 class="card-text">${list_dto.hourpay}(원/시간)
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
								fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  		<path
									d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" />
		</svg>
							최대${list_dto.limitperson}인
						</h3>
						<h3>예약인원: ${list_dto.personcount}명</h3>
						<h3>예약목적: ${list_dto.purpose}</h3>
						<h3>공간예약날짜: "${list_dto.paydate}"</h3>
						<h3>공간사용날짜: "${list_dto.reservationdate}"</h3>
						<h3>예약시간: ${list_dto.startdate}:00 ~ ${list_dto.enddate}:00</h3>
						<h3>
							총가격:
							<p id="pay">${list_dto.totalpay}원</p>
						</h3>
					</div>
				</div>
		</div>
		</c:forEach>
	</div>


	<script>

	
	</script>
</body>
</html>






