<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>

	.seeker-box {
		border-radius: 0px;
	   	width: 70%;
	   	margin: 80px auto;
	   	height: auto;
	}
	
	.seeker-box .title{
		text-align: center;
	   	font-size: 25px;
	   	font-weight: bold;
	   	color: #548CA8;
	   	margin-bottom: 20px;
	}
	
	.seeker-info {
		width:100%;
		margin: 0 auto;
	}
	
	.seeker-info

	.seeker-info tr th:nth-child(1){ width: auto; }
	.seeker-info tr th:nth-child(2){ width: auto; }
	.seeker-info tr th:nth-child(3){ width: auto; }
	.seeker-info tr th:nth-child(4){ width: auto; }
	.seeker-info tr th:nth-child(5){ width: auto; }
	.seeker-info tr th:nth-child(6){ width: auto; }
	.seeker-info tr td {height: 50px};
 
	

</style>

</head>
<body>
   <!-- jobseekerinfo.jsp -->
   <%@ include file="/inc/header1.jsp" %>
   
   <section class="main-section">
      
      <div class="seeker-box">
		<div class="seeker-info">
			<div class="title">지원자 정보</div>
			<table class="table table-bordered">
				<tr>
					<th>이름</th>
					<th>학력</th>
					<th>경력</th>
					<th>사용 가능 언어</th>
					<th>관심직종</th>
					<th>첨부파일</th>
				</tr>
				<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.name}</td>
					<td>${dto.academicBackground}</td>
					<td>${dto.career}</td>
					<td>${dto.availableLanguage}</td>
					<td>${dto.interestOccupation }</td>
					<td><a href="/webproject/files/${dto.attachedFile}" download class="click">${dto.attachedFile}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
      </div>
      
      <%-- <div class="seeker-box">
		<div class="title"> 지원자 정보</div>
		<div class="seeker-info">
			
				<button type="button">${dto.name}</button>
				<input type="button" class="seeker" value="">
				<div class="info" style="display:none">
					<span>학력: <input type="text" value="${dto.academicBackground}"></span><br>
					<span>경력: <input type="text" value="${dto.career}"></span><br>
					<span>사용 가능 언어: <input type="text" value="${dto.availableLanguage}"></span><br>
					<span>관심직종: <input type="text" value="${dto.interestOccupation }"></span><br>
					<span>첨부파일: <a href="/webproject/files/${dto.attachedFile}" download class="click">${dto.attachedFile}</span>
				</div>
			
		</div>
      </div> --%>
      

      
   </section>   
   
   <%@ include file="/inc/footer.jsp"%>
   <%@ include file="/inc/init.jsp" %>
	
   <script>
	   
	   $('.seeker').click(function () {  
		   var index = $('.seeker').index(this);
		   

		    //$('.seeker-info').children('.info').eq(index).css({"background-color": "yellow"});
	
		    if($('.seeker-info').children('.info').eq(index).css("display") == "none"){   
	 
		    	$('.seeker-info').children('.info').eq(index).css({"display": "block"});   
		      
		    } else {  
		    	$('.seeker-info').children('.info').eq(index).css({"display": "none"});   
		    } 
		    
		}); 
	   

   </script>
</body>
</html>



