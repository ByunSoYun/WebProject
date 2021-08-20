<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<%@ include file="/inc/asset.jsp"%>

<style>
.outline {
	margin-top: 8px;
}

.outline span {
	float: left;
	margin-right: 20px;
}

.title {
	width: 590px;
	padding-top: 15px;
	padding-left: 20px;
}

.qna {
	cursor: pointer;
}

.container2 {
	float: left;
	margin-bottom: 200px;
}

.table {
	margin-left: 30px;
}
</style>
</head>
<body>

	<%@ include file="/inc/header.jsp"%>

	<!--  -->
	<div class="container">
      
		<h1 class="page-header">내가 쓴 게시글 - Q&A</h1>
		
		<div class="container2">
			<div class="a" style="width: 200px;">
				<div class="c" style="border-bottom: 0;">
					<div>커뮤니티</div>
					<div class="qna">Q&A</div>
					<div>스터디/정기모임 내역</div>
					<div>공간대여 내역</div>
				</div>
			</div>
			
			<table class="table table-hover">
				<c:if test="${qnaList.size() == 0}">
					<tr>
						<td colspan="3" style="width: 570px; padding-top: 15px; padding-left: 20px;">작성한 게시글이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${qnaList}" var="dto">
				<tr>
					<td class="title" style="width: 570px; padding-top: 15px; padding-left: 20px;">
						<a href="/webproject/main/member/qna/view.do?techQnaSeq=${dto.techQnaSeq}">${dto.title}</a>
					</td>
					<td>
						<div class="outline">
							<span>
								<i class="bi bi-hand-thumbs-up-fill">  ${dto.recommendCount}</i>
							</span>
							<span>
								<i class="bi bi-hand-thumbs-down-fill">  ${dto.decommendCount}</i>
							</span>
							<span>
								<i class="bi bi-chat-dots-fill">  ${dto.ccnt}</i>
							</span>
							<span>
								<i class="bi bi-eye-fill">  ${dto.readCount}</i>
							</span>
						</div>
					</td>
					<td>
						<div>${dto.nickName}</div>
						<div style="font-size: 11px;">${dto.regdate}</div>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
      
   </div>
   
   <%@ include file="/inc/footer.jsp"%>
   <%@ include file="/inc/init.jsp"%>

   <script>
      
	   $(".qna").click(function () {
			location.href='/webproject/main/member/mypage/mycomment/qnalist.do';
		})
   
   </script>
</body>
</html>



