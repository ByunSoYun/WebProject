<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>
.btnss {
	float: right;
	margin-right: 40px;
	margin-bottom: 200px;
}
</style>
</head>
<body>
	<!--  -->
	<div class="container">
	
		<%@ include file="/inc/header.jsp"%>

		<h1>Q&A 삭제하기</h1>

		<form method="POST" action="/webproject/main/member/qna/deleteok.do">
			<table class="table table-bordered">
				<tr>
					<td>${techQnaSeq}번 게시물을 삭제하겠습니까?</td>
				</tr>
			</table>

			<div class="btnss">
				<button type="submit" class="btn btn-primary">삭제하기</button>
				<button type="button" class="btn btn-default"
					onclick="history.back()">돌아가기</button>
			</div>

			<input type="hidden" name="techQnaSeq" value="${techQnaSeq}">
		</form>


	</div>

	<%@ include file="/inc/footer.jsp"%>
	<%@ include file="/inc/init.jsp"%>

	<script>
		
	</script>
</body>
</html>



