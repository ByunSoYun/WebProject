<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>
.table {
	width: 900px;
	margin: 15px auto;
}

.table th {
	width: 120px;
}

.table td {
	width: 680px;
}

.table #content {
	height: 300px;
}

.table div {
	text-align: center;
}

.table div:nth-child(1) {
	padding-top: 8px;
}

.table tr:nth-child(2) div {
	padding-top: 130px;
}

.table th {
	background-color: #EEE;
}

.btns {
	float: right;
	margin-right: 130px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<!--  -->
	<div class="container">
      
		<h1 class="page-header">Q&A 수정하기</h1>
		
		<form method="POST" action="/webproject/main/member/qna/editok.do">
			<table class="table table-bordered">
				<tr>
					<th>
						<div>제목</div>
					</th>
					<td><input type="text" name="title" id="subject"
						class="form-control" value="${dto.title}" required></td>
				</tr>
				<tr>
					<th>
						<div>내용</div>
					</th>
					<td><textarea name="content" id="content" class="form-control"
							required>${dto.content}</textarea></td>
				</tr>
			</table>

			<div class="btns">
				<button type="submit" class="btn btn-primary">수정하기</button>
				<button type="submit" class="btn btn-default" onclick="history.back()">돌아가기</button>
			</div>
			<input type="hidden" name="techQnaSeq" value="${dto.techQnaSeq}" />
		</form>
      
   </div>

   <script>
      
   </script>
</body>
</html>



