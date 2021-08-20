<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>
   
   .register-box{
	border: 1px solid #476072;
   	width: 70%;
   	margin: 80px auto;
   	height: auto;
   	background-color: #FAFBFC;
	
   }
   
   .register-box .register-content .title{
    border-bottom: 1px solid #ccc;
   	padding: 20px;
   	font-size: 25px;
   	font-weight: bold;
   	color: #548CA8;
   }
   
   .register-tbl{
   	margin-top: 5px;
   	width: 100%;
	font-size: 18px;
	padding: 10px;
   }
   
   .register-tbl tr th{
	   	width: 130px;
	   	padding: 12px;
	   	padding-left: 30px;
   }
   
    .register-tbl tr td{
    	padding: 12px;
    }
   
   .register-tbl td input {
   	border: 1px solid #ccc;
   	width: 320px;
   	height: 50px;
   	padding: 5px;
   }
   .register-tbl td select {
   	border: 1px solid #ccc;
   	width: 230px;
   	height: 50px;
   	padding: 5px;
   }
   
   .register-tbl .date input{
   	width: 170px;
   	font-size: 16px;
   }
   
   .register-tbl .date span{
   	margin: 5px;
   }
   
   .register-tbl #address input{
   	width: 150px;
   	text-align: right;
   }
   
   #detail-address #search{
   	width: 60px;
   	height: 48px;
   	font-size: 13px;
   	border: 0px;
   }
   
   .postContent {
    border: 1px solid #ccc;
   	width: 500px;
   	height: 400px;
   	font-size: 20px;
   	padding: 5px;
   	}
   	
   	.register-tbl .attachedFile{
   		width: 250px;
   	}
   	
   	.register-tbl #map-box input{
   		width: 140px;
   		font-size:16px;
   	}
   
   .coltd{
   	text-align: center;
   }
   
   .register-tbl .registerBtn{
   	background-color: #548CA8;
   	color: white;
   	width: 150px;   	
   }
   
   
</style>

</head>
<body>
   <!-- jobregister.jsp -->
   <%@ include file="/inc/header.jsp" %>
   
   <section class="main-section">
      
      <div class="register-box">
      	<div class="register-content">
      		<div class="title">${dto.name} 지원하기</div>
      		
      	<form method="POST" action="/webproject/main/member/job/jobenrollok.do?jobPostSeq=${dto.jobPostSeq}" enctype="multipart/form-data">
      		<table class="register-tbl">
      			<tr>
      				<th>공고명</th>
      				<td><input type="text" value="${dto.postName}" readonly></td>
      			</tr>
      			<tr>
      				<th>이름</th>
      				<td><input type="text" value="${name}" readonly></td>
      			</tr>
      			<tr>
      				<th>날짜</th>
      				<td class="date">
      					<input type="date" id="today" readonly>
      				</td>
      			</tr>
      			<tr>
      				<th>직군</th>
      				<td><input type="text" value="${dto.jobGroup}" readonly></td>
      			</tr>
      			<tr>
      				<th>학력</th>
      				<td><input type="text" value="${dto.educationLevel }" readonly></td>
      			</tr>
      			<tr>
      				<th>경력</th>
      				<td><input type="text" value="${dto.career}" readonly></td>
      			</tr>
      			
      			<tr>
      				<th>첨부 파일</th>
      				<td>
      					<input type="file" name ="attachedFile" class="attachedFile" required>
      				</td>
      			</tr>      			
      			<tr>
      				<td colspan="2" class="coltd">
	      				
						<input type="submit" value="등록" class="registerBtn">
					</td>
      			</tr>
            
      		</table>
      		<input type="hidden" name="jobPostSeq" value="${dto.jobPostSeq}">
	      	<input type="hidden" name="memberSeq" value="${memberSeq}">
      		</form>
      	</div>
      </div>

      
      
   </section>   
   
   <%@ include file="/inc/footer.jsp"%>
   <%@ include file="/inc/init.jsp" %>
	
   <script>
	   window.onload = function() {
			today = new Date();
			console.log("today.toISOString() >>>" + today.toISOString());
			today = today.toISOString().slice(0, 10);
			console.log("today >>>> " + today);
			bir = document.getElementById("today");
			bir.value = today;
		}
   </script>
</body>
</html>



