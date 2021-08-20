<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>

.box1 td{
	border : 1px solid  #e9e2e2;

}


#container .post{
	width: 700px;

}


#container .box1{
	width: 800px;
	border-collapse: collapse;
	margin: auto;
	margin-bottom:40px;
}
#container { 
 width: 900px;
 margin: auto;
}

option {
margin-left:10px;
}

option selected{
color: #e9e2e2;
}


</style>
</head>
<body>
	<!--  -->
	
	<%@ include file="/inc/header.jsp" %>
	
	<section  id="container" >
      
		<h1 class="page-header">게시글 수정하기</h1>
		
      <form method="POST" action="/webproject/main/member/community/editok.do">
      
			<table class="box1">
		<tr style="	height:50px;">
		 <td><span style="margin-left:20px; font-size:18px; color:#548CA8">${nickname}</span></td>
		</tr>
		
		<tr>
			<td>
				<div  class="post">
				
				<select style="width: 600px; height:30px; margin: 30px 100px 10px 100px;" name="category">
	   				 <option selected>${dto.category}</option>
				     <option>IT 행사</option>
				     <option>기술서적 리뷰</option>
				     <option>자격증 정보</option>
				</select>
				
				<div  class="post ">
				<input type="text" name ="title" style="width: 600px; height:30px; margin: 0px 100px;" required value="${dto.title}">
				</div>
				<textarea name="content" id="content" class="form-control" required  style="width:600px; height:500px; margin: 0px 100px; margin-top:20px; padding : 10px;  resize: vertical; margin-bottom:30px;">${dto.content}</textarea>
			
				</div>
					<div style="float:right; padding:20px;">
				   <button type="button" class="btn"  style="background- color: #F8F8FA;"
               		onclick="location.href='/webproject/main/member/community/list.do';">취소</button>
					
				
				   <button type="submit" class="btn" style="background-color: #548CA8; color:#F8F8FA;"> 수정하기</button>
				   
					<input type="hidden" name="seq" value="${dto.seq}">
				
					</div>
	
			</td>
		</tr>		
		</table>
		</form>
  
	</section>
	
		<%@ include file="/inc/footer.jsp"%>
	   <%@ include file="/inc/init.jsp"%>
	   
	   
   <script>
      
   </script>
</body>
</html>



