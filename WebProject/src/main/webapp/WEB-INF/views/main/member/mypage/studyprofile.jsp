<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Child</title>

<%@ include file="/inc/asset.jsp"  %>

<style>

	.table{ width: 100%}
	
</style>
</head>
<body>
	<div class="container">
		<h1 class="page-header">${dto.name}님 프로필</h1>
		
		<c:if test="${dto.gender == null}">
				 프로필이 등록되지 않았습니다.
		</c:if>
		<c:if test="${dto.gender != null}">
		<table class="table">
			<tr>
				<td>이름(닉네임) </td>
				<td>${dto.name}(${dto.nickName})</td>
			</tr>
			<tr>
				<td>성별 </td>
				<td>
				${dto.gender}
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${dto.email}</td>
			</tr>
			<tr>
				<td>학력</td>
				<td>${dto.academicBackground}</td>
			</tr>
			<tr>
				<td>전공</td>
				<td>${dto.major}</td>
			</tr>
			<tr>
				<td>사용가능언어</td>
				<td>${dto.availableLanguage}</td>
			</tr>
			<tr>
				<td>경력</td>
				<td>${dto.career}</td>
			</tr>
		
		</table>
		</c:if>
		<input type="button" value="창닫기" onclick="window.close()">

		
		
	</div>
   	<%@ include file="/inc/init.jsp"%>
	<script>
	function setParentText(){ 
		opener.document.getElementById("pInput").value = document.getElementById("cInput").value }

	</script>
</body>
</html>











