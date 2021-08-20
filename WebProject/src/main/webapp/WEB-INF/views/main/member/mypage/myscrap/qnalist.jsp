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
.table {
	width: 800px;
	position: relative;
	left: 250px;
	top: -600px;
}
</style>

</head>
<body>

	<%@ include file="/inc/header.jsp" %>
   
	<section class="main-section">
      
		<h1>마이페이지 - Q&A 스크랩</h1>
      
      	<div class="a">
			<div class="b">
					<div><i class="bi bi-person-circle" style="font-size: 40px;"></i></div>
					<div>${list.name}</div>
					<div>${list.email}</div>
					<div>${list.tel}</div>
				<input type="button" value="프로필" name="profile" class="btn btn-primary" onclick="location.href='/webproject/main/member/mypage/myprofile.do';" />
			</div>
			<div class="c">
				<a href="/webproject/main/member/mypage/chart/chart.do"><div class="myComment">내가 쓴 게시글</div></a>
				<div>채용 공고</div>
				<div>공간대여 내역</div>
				<div>스터디 모임</div>
			</div>
			<div class="d">
				<div>스크랩 내역</div>
				<div>
					<span>커뮤니티</span>
					<span>${scrapCount.communityScrapCount}</span>
				</div>
				<div>
					<a href="/webproject/main/member/mypage/myscrap/list.do"><span>Q&A</span></a>
					<span>${scrapCount.qnaScrapCount}</span>
				</div>
				<div>
					<span>정기모임/스터디</span>
					<span>${scrapCount.studyScrapCount}</span>
				</div>
				<div>
					<span>채용공고</span>
					<span>${scrapCount.jobPostScrapCount}</span>
				</div>
				<div>
					<span>공간대여</span>
					<span>${scrapCount.spaceScrapCount}</span>
				</div>
			</div>
			<div class="e">
				<a href="/webproject/main/member/mypage/accountsetting.do"><span>계정설정</span></a>
			</div>
		</div>
		
		<table class="table table-hover">
			<c:if test="${scrapList.size() == 0}">
				<tr>
					<td colspan="3" style="width: 500px; padding-top: 15px; padding-left: 20px;">작성한 게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${scrapList}" var="dto">
			<tr>
				<td class="title" style="width: 500px; padding-top: 15px; padding-left: 20px; text-align: left;">
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
      
	</section>   
   
	<%@ include file="/inc/footer.jsp" %>
   	<%@ include file="/inc/init.jsp" %>
   
	<script>
     
		$(".qna").click(function () {
			location.href='/webproject/main/member/mypage/mycomment/qnalist.do';
		})
	
	</script>
</body>
</html>