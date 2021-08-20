<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>


	
	
	
</style>
</head>
<body>
	<!--  -->

      <%@ include file="/inc/header.jsp" %>
	
	<section class="container" style="width:800px; margin:auto;">	
		
		<h1 class="page-header">게시글 삭제하기</h1>
			
		<form method="POST" action="/webproject/main/member/community/deleteok.do">
		<div style="width:600px; margin:80px auto;">
			<table>
				<tr>
					<td><div style="font-size:18px; margin-left:100px;">${seq}번 게시물을 삭제합니다.</div></td>
				</tr>
			</table>
			
			<div class="btns" style="margin-bottom: 50px; float:right; padding-right:50px;">
				<button type="submit" class="btn" style="background-color: #548CA8; color:white;">삭제하기</button>
				<button type="button" class="btn btn-default"
					onclick="location.href='/webproject/main/member/community/view.do?seq=${seq}';" >돌아가기</button>
			</div>
			
			<input type="hidden" name="seq" value="${seq}">
		</div>
		</form>


	</section>	
	
      
   
  	<%@ include file="/inc/footer.jsp"%>
	   <%@ include file="/inc/init.jsp"%>
   <script>
      
   </script>
</body>
</html>



