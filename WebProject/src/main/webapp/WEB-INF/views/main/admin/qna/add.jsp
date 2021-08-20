<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

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
	<%@ include file="/inc/header.jsp"%>

	<div class="container">

		<h1 class="page-header">테크 Q&A 글쓰기</h1>

		<form method="POST" action="/webproject/main/member/qna/addok.do">
			<table class="table table-bordered">
				<tr>
					<th>
						<div>제목</div>
					</th>
					<td><input type="text" name="title" id="subject"
						class="form-control" required></td>
				</tr>
				<tr>
					<th>
						<div>내용</div>
					</th>
					<td><textarea name="content" id="content" class="form-control"
							required></textarea></td>
				</tr>
			</table>

			<div class="btns">
				<button type="submit" class="btn btn-primary">글쓰기</button>
			</div>

		</form>

	</div>

	<%@ include file="/inc/footer.jsp"%>
	<%@ include file="/inc/init.jsp"%>

	<script>
		
	</script>
</body>
</html>



