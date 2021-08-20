<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

<%@ include file="/inc/asset.jsp"%>

<style>
.l input {
	margin-right: 85px;
	margin-top: 15px;
}

.f {
   height: 250px;
}

.f .g .h {
   margin-top: 20px;
   margin-left: 50px;
   height: auto;
}

.f .g .h.i .img img{
   width: 50px;
   height: auto;
   cursor: pointer;
}

 .f .g .view:hover {
   text-decoration: underline;
   color: darkblue;
}
 
.f .g .h .i .j{
   margin: 0px;
   padding: 0px;
   text-align: center;
}

.f .g .h .i .companyName {
   font-size: 18px;
   margin-top: 5px;
}

.f .g .h .i .postName {
   font-size: 15px;
}

.view {
}

.k {
	height: 250px;
}

.postName {
	width: 200px;
}
</style>
</head>
<body>
   <%@ include file="/inc/header.jsp" %>

	<div class="container">
      
		<h1 class="page-header">마이페이지 메인</h1>
		
		<div class="container2">
			<div class="a">
				<div class="b">
						<div><i class="bi bi-person-circle" style="font-size: 40px;"></i></div>
						<div>${list.name}</div>
						<div>${list.email}</div>
						<div>${list.tel}</div>
					<input type="button" value="프로필" name="profile" class="btn btn-primary" onclick="location.href='/webproject/main/member/mypage/myprofile.do';" />
				</div>
				<div class="c" style="cursor:pointer">
					<div class="myComment">내가 쓴 게시글</div>
					<div>채용 공고</div>
					<div onclick="location.href='/webproject/main/member/mypage/myreservation/myreservation.do';">공간대여 내역</div>

					<div>스터디 모임</div>
				</div>
				<div class="d">
					<div>스크랩 내역</div>
					<div>
						<span>커뮤니티</span>
						<span>${comScrapCount.comScrapCount}</span>
					</div>
					<div>
						<a href="/webproject/main/member/mypage/myscrap/qnalist.do"><span>Q&A</span></a>
						<span>${qnaScrapCount.qnaScrapCount}</span>
					</div>
					<div>
						<span>정기모임/스터디</span>
						<span>${studyScrapCount.studyScrapCount}</span>
					</div>
					<div>
						<span>채용공고</span>
						<span>${jobPostScrapCount.jobPostScrapCount}</span>
					</div>
					<div>
						<span>공간대여</span>
						<span>${spaceScrapCount.spaceScrapCount}</span>
					</div>
				</div>
				<div class="e">
					<a href="/webproject/main/member/mypage/accountsetting.do"><span>계정설정</span></a>
				</div>
			</div>
			
			<div class="f">
	            <div class="g">
	               <div>지원 현황</div>
	               <div class="h">
	                  <c:forEach items="${joblist}" var="dto">
	                     <div class="i"  >
	                        <div class="img" onclick="location.href='/webproject/main/member/job/jobview.do?jobPostSeq=${dto.jobPostSeq}';" style="cursor: pointer;">
	                           <img src="http://localhost:8090/webproject/files/${dto.attachedFile}" style="width: 200px;">
	                        </div>
	                        <div class="j companyName">${dto.companyName}</div>
	                        <div class="j postName">${dto.postName}</div>
	                     </div>
	                  </c:forEach>
	               </div>
	               	<div style="text-align: right;" class="view"> >> 전체 보기 </div>
            	</div>
         	</div>

			
		</div>
			<div class="k">
				<div class="l" style="padding: 20px;">
					<div>공간대여 서비스</div>
					<div class="m" style="margin-bottom: -5px; " >
						<div class="n" style="margin-left: 50px;">
							<div>
								<img src="/webproject/asset/images/space.png" alt="" style="width: 180px; height: 120px;" />
							</div>
							<div style="text-align: center; margin-left: 40px;">
								<input type="button" value="평가하러가기" class="btn btn-primary"/>
							</div>
						</div>
						<div class="n" style="margin-right: 35px;">
							<div>
								<img src="/webproject/asset/images/space2.png" alt="" style="width: 180px; height: 120px;" />
							</div>
							<div style="margin-left: 40px;">
								<input type="button" value="평가하러가기" class="btn btn-primary"/>
							</div>
						</div>
						<div class="n">
							<div>
								<img src="/webproject/asset/images/space3.png" alt="" style="width: 180px; height: 120px;" />
							</div>
							<div style="margin-left: 40px;">
								<input type="button" value="평가하러가기" class="btn btn-primary"/>
							</div>
						</div>
					</div>
				</div>
				<div class="l" style="position: relative; top: 50px; border: 2px solid #EEE;">
					<div>스터디/정기모임</div>
					<input type="button" value="내가 올린 스터디 공고 확인하기" class="btn btn-primary" onclick="location.href='/webproject/main/member/mypage/poststudy.do'" />
					<input type="button" value="내가 진행중인 스터디 공고 확인하기" class="btn btn-primary" onclick="location.href='/webproject/main/member/mypage/ongoingstudy.do'" />
					<input type="button" value="완료한 스터디 평가하기" class="btn btn-primary" onclick="location.href='/webproject/main/member/mypage/evaluation.do'" />
				</div>
			</div>
      
   </div>

	<%@ include file="/inc/footer.jsp" %>
   	<%@ include file="/inc/init.jsp" %>

   <script>
      
   		$(".myComment").click(function () {
			location.href = '/webproject/main/member/mypage/chart/chart.do';
		});
   
   </script>
</body>
</html>



