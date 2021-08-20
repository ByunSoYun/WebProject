<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.afd.member.space.SpaceReservationDTO"%>
<%@page import="com.afd.member.space.SpaceDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>


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

	.reservation-div { width:500px; overflow:auto; margin: 0 auto;}
	.reservation-table { white-space:nowrap; border-collapse:collapse }
	.reservation-td { width:80px; height: 60px; border: 1px solid black;}
	.reservation-text { width:80px; height: 60px; text-align: left; padding-top: 30px; margin-left: -5px; }

</style>
</head>
<body>
	<div class="container">
		<h1 class="page-header">시간 예약하기</h1>
		
		
	</div>
	
	   <div class="reservation-div">
		<table class = "reservation-table">
			<tr id="reservation-tr">
				<td><div class="reservation-text" ></div></td>
  				<% for(int i=1; i<25; i++) { %>
    			<td><div class="reservation-text" ><%=i %></div></td>
    			<% } %>
 			</tr>
  
  			<tr id="reservation-tr">
  				<% for(int i=0; i<24; i++) { %>
    			<td><div class="reservation-td" ></div></td>
    			<% } %>
 			</tr>
		</table>
	</div>
	
	<%@ include file="/inc/footer.jsp" %>		
	<script>
		
	</script>
</body>
</html>






