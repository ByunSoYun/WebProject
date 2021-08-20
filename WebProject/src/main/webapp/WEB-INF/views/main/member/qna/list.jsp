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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<%@ include file="/inc/asset.jsp"%>

<style>
.btn-primary {
	float: right;
	width: 100px;
}

.btnWrite {
	margin-top: 20px;
}

.outline {
	margin-top: 8px;
}

.outline span {
	float: left;
	margin-right: 20px;
}

.table th:nth-child(1) {
	width: 60px;
}

.table th:nth-child(2) {
	width: auto;
}

.table th:nth-child(3) {
	width: 80px;
}

.table th:nth-child(4) {
	width: 120px;
}

.table th:nth-child(5) {
	width: 60px;
}

.table td:nth-child(2) {
	text-align: left;
}

.searchbox {
	text-align: center;
	margin-bottom: 20px;
}

.searchbox .form-control {
	display: inline-block;
	width: auto;
}

.searchbox #search {
	width: 300px;
}

.searchBar {
	margin: 10px;
	text-align: center;
}

.pagebar {
	text-align: center;
}
</style>
</head>
<body>
	<!-- list.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<div class="container">

		<h1 class="page-header">Q&A 메인페이지</h1>

		<div
			style="position: relative; display: table; border-collapse: separate;">
			<form action="/webproject/main/member/qna/list.do" method="GET">
				<div style="display: flex;">
					<select name="column" id="column" class="form-control"
						style="width: 150px; margin-right: 10px;">
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="nickName">닉네임</option>
						<option value="all">제목+내용</option>
					</select> <input type="text" name="search" id="search" class="form-control"
						required placeholder="검색어를 입력하세요."> <input type="submit"
						value="검색하기" class="btn btn-default">
				</div>
			</form>
		</div>

		<c:if test="${not empty id}">
			<div class="btnWrite">
				<button type="button" class="btn btn-primary"
					onclick="location.href='/webproject/main/member/qna/add.do'">글쓰기</button>
			</div>
		</c:if>

		<div style="margin-bottom: 15px; margin-top: 10px;">
			<button type="button" class="btn btn-outline-info" name="orderRegdate" value="regdate">최신순</button>
			<button type="button" class="btn btn-outline-info" name="orderRecommendCount" value="recommendCount">추천순</button>
			<button type="button" class="btn btn-outline-info" name="orderComment" value="ccnt">댓글순</button>
			<button type="button" class="btn btn-outline-info" name="orderReadCount" value="readCount">조회순</button>
		</div>

		<table class="table table-hover">
			<c:if test="${list.size() == 0}">
				<tr>
					<td colspan="2">게시물이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td style="width: 600px; padding-left: 20px; padding-top: 15px;">
						<a
						href="/webproject/main/member/qna/view.do?techQnaSeq=${dto.techQnaSeq}&column=${map.column}&search=${map.search}">${dto.title}</a>

						<c:if test="${dto.isNew < (24 / 24)}">
							<span class="label label-danger">New</span>
						</c:if>
					</td>
					<td>
						<div class="outline">
							<span> <i class="bi bi-hand-thumbs-up-fill"></i> ${dto.recommendCount}
							</span> <span> <i class="bi bi-hand-thumbs-down-fill"></i> ${dto.decommendCount}
							</span> <span> <i class="bi bi-chat-dots-fill"></i> ${dto.ccnt}
							</span> <span> <i class="bi bi-eye-fill"></i> ${dto.readCount}
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

		<div class="pagebar">${pagebar}</div>

	</div>

	<%@ include file="/inc/footer.jsp"%>
	<%@ include file="/inc/init.jsp"%>

	<script>
		<c:if test="${map.isSearch == 'y'}">

		//상태 복원
		$('#column').val('${map.column}');
		$('#search').val('${map.search}');

		</c:if>
		
		$("button[name=orderRegdate]").click(function () {
			location.href='/webproject/main/member/qna/list.do?orderRegdate=regdate';
		})
		
		$("button[name=orderRecommendCount]").click(function () {
			location.href='/webproject/main/member/qna/list.do?orderRecommendCount=recommendCount';
		})
		
		$("button[name=orderComment]").click(function () {
			location.href='/webproject/main/member/qna/list.do?orderComment=ccnt';
		})
		
		$("button[name=orderReadCount]").click(function () {
			location.href='/webproject/main/member/qna/list.do?orderReadCount=readCount';
		})
		
	</script>
</body>
</html>



