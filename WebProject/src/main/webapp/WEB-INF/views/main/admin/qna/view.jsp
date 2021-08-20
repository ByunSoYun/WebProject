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
* {
	box-sizing: border-box;
}

.table {
	width: 90%;
	justify-content: center;
	align-items: center;
	margin: 15px auto;
}

.table:nth-child(3) td:nth-child(1) {
	
}

#view tr:nth-child(1) td:nth-child(1) {
	border-right: 0;
}

.table tr:nth-child(2) td {
	width: 50%;
}

.table tr:nth-child(1) td:nth-child(2) {
	border-left: 0;
}

.table tr:nth-child(3) td {
	height: 300px;
}

#addComment {
	width: 80%;
}

#addComment td:nth-child(1) {
	width: 90%;
}

#listComment {
	width: 80%;
}

#listComment td:nth-child(1) {
	width: 90%;
}

#view tr:nth-child(1) td:nth-child(2) i:nth-child(2) {
	margin-left: 20px;
}

.content-function {
	position: relative;
	width: 100px;
	padding-top: 50px;
	padding-right: 40px;
	color: #666;
	float: right;
	text-align: center;
	font-size: 25px;
}

.content-function-group {
	margin-bottom: 30px;
}

.editDelete {
	float: right;
	font-size: 20px;
}

.editDelete div:nth-child(1) {
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<!--  -->
	<%@ include file="/inc/header.jsp"%>

	<div class="container">

		<h1 class="page-header">테크 Q&A 자세히보기</h1>

		<table id="view" class="table table-bordered">
			<tr>
				<td style="width: 85%">
					<div>${dto.nickName}</div>
					<div style="font-size: 10px; margin-top: 5px;">${dto.regdate}</div>
				</td>
				<td style="display: flex; border-bottom: 0">
					<div style="margin-right: 15px;">
						<i class="bi bi-chat-dots-fill"></i> ${dto.ccnt}
					</div>
					<div>
						<i class="bi bi-eye-fill"></i> ${dto.readCount}
					</div>
				</td>
			</tr>
			<tr>
				<td>${dto.title}</td>
				<td rowspan="2">
					<div id="content-function" class="content-function">
						<div class="content-function-group">
								<c:if test="${not empty id}">
									<div>
										<c:set var="recYes" value="n"></c:set>
										<c:forEach items="${recommendList}" var="rlist">
											<c:if test="${rlist.memberSeq == memberSeq && rlist.recommend == 'y'}">
												<c:set var="recYes" value="y"></c:set>
											</c:if>
										</c:forEach>
										
										<c:if test="${recYes == 'n'}">
										<a href="/webproject/main/member/qna/recommend.do?techQnaSeq=${dto.techQnaSeq}&memberSeq=${dto.memberSeq}">
										<span class="bi bi-chevron-up" title="추천"></span></a>
										</c:if>
										
										<c:if test="${recYes == 'y'}">
											<a href="#">
										<span class="bi bi-chevron-up" title="추천"></span></a>
										</c:if>
									</div>
								</c:if>
							<div title="추천수">${dto.recommendCount - dto.decommendCount}</div>
							<c:if test="${not empty id}">
								<div>
									<c:set var="recNo" value="n"></c:set>
									<c:forEach items="${recommendList}" var="rlist">
										<c:if test="${rlist.memberSeq == memberSeq && rlist.recommend == 'n'}">
											<c:set var="recNo" value="y"></c:set>
										</c:if>
									</c:forEach>
								
									<c:if test="${recNo == 'n'}">
										<a href="/webproject/main/member/qna/decommend.do?techQnaSeq=${dto.techQnaSeq}">
										<span class="bi bi-chevron-down" title="비추천"></span></a>
									</c:if>
									
									<c:if test="${recNo == 'y'}">
										<a href="#">
										<span class="bi bi-chevron-down" title="비추천"></span></a>
									</c:if>
								</div>
							</c:if>
						</div>
						<div>
							<div>
								<c:set var="scrapYes" value="n"></c:set>
								<c:forEach items="${scrapList}" var="scList">
									<c:if test="${scList.memberSeq == memberSeq}">
										<c:set var="scrapYes" value="y"></c:set>
									</c:if>
								</c:forEach>
								<c:if test="${scrapYes == 'n'}">
									<a href="/webproject/main/member/qna/scrap.do?techQnaSeq=${dto.techQnaSeq}"><i class="bi bi-bookmark-star" title="스크랩하기"></i></a>
									<div class="scrap-count">${scrapResult.scrapCount}</div>
								</c:if>
								<c:if test="${scrapYes == 'y'}">
									<a href="/webproject/main/member/qna/delscrap.do?techQnaSeq=${dto.techQnaSeq}&memberSeq=${memberSeq}"><i class="bi bi-bookmark-star-fill" title="스크랩 취소하기"></i></a>
									<div class="scrap-count">${scrapResult.scrapCount}</div>
								</c:if>
							</div>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>${dto.content}
					<div class="editDelete">
						<c:if test="${not empty id}">
							<c:if test="${dto.id == id}">
								<div>
									<a href="/webproject/main/member/qna/edit.do?techQnaSeq=${dto.techQnaSeq}" class="bi bi-pencil-square" title="수정하기"></a>
								</div>
								<div>
									<a href="/webproject/main/member/qna/delete.do?techQnaSeq=${dto.techQnaSeq}" class="bi bi-trash-fill" title="삭제하기"></a>
								</div>
							</c:if>
						</c:if>
					</div>
				</td>
			</tr>
		</table>

		<button type="button" class="btn btn-default" onclick="location.href='/webproject/main/member/qna/list.do?column=${column}&search=${search}'" style="margin-left: 60px;">돌아가기</button>

		<c:if test="${not empty id}">
			<form action="/webproject/main/member/qna/addcomment.do" method="POST">
				<table id="addComment" class="table table-bordered">
					<tr>
						<td style="border-right: 0"><input type="text" name="content" id=""
							class="form-control" placeholder="댓글을 작성하세요." /></td>
						<td><input type="submit" value="댓글쓰기" class="btn btn-primary" />
						</td>
					</tr>
				</table>
				<input type="hidden" name="techQnaSeq" value="${dto.techQnaSeq}" />
			</form>
		</c:if>

		<table id="listComment" class="table table-bordered">
			<c:if test="${clist.size() == 0}">
				<tr>
					<td colspan="2">댓글이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${clist}" var="cdto">
				<tr>
					<td>
						<div style="font-size: 10px; margin-bottom: 12px;">
							<span style="margin-right: 12px;">${cdto.nickName}</span>
							<span>${cdto.regdate}</span>
						</div>
						<div>${cdto.content}</div>
					</td>
					<td>
						<c:if test="${not empty id}">
							<c:if test="${cdto.id == id}">
								<div style="padding-top: 12px;">
									<input type="button" value="삭제하기" class="btn btn-primary" onclick="location.href='/webproject/main/member/qna/deletecomment.do?techQnaCommentSeq=${cdto.techQnaCommentSeq}&techQnaSeq=${dto.techQnaSeq}'"/>
								</div>
							</c:if>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="/inc/footer.jsp"%>
	<%@ include file="/inc/init.jsp"%>

	<script>
	
	
	
	</script>
</body>
</html>



