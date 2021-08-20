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
.bb, .cc, .dd, .ee, .ff, .gg {
	display: flex;
}
</style>
</head>
<body>

	<%@ include file="/inc/header.jsp" %>

	<!--  -->
	<div class="container">
      
		<h1 class="page-header">마이페이지 프로필</h1>
		
		<div class="container2">
			<div class="a">
				<div class="b">
						<div><i class="bi bi-person-circle" style="font-size: 40px;"></i></div>
						<div>${result.name}</div>
						<div>${result.email}</div>
						<div>${result.tel}</div>
					<input type="button" value="프로필" name="profile" class="btn btn-primary" onclick="location.href='/webproject/main/member/mypage/myprofile.do';" />
				</div>
				<div class="c">
					<div class="myComment" onclick="location.href='/webproject/main/member/mypage/chart/chart.do'">내가 쓴 게시글</div>
					<div>채용 공고</div>
					<div>공간대여 내역</div>
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
						<span>${jobPostScrapCount.spaceScrapCount}</span>
					</div>
					<div>
						<span>공간대여</span>
						<span>${spaceScrapCount.spaceScrapCount}</span>
					</div>
				</div>
				<div class="e">
					<span>계정설정</span>
				</div>
			</div>
		</div>
		
		<form method="POST" action="/webproject/main/member/mypage/myprofileedit.do?memberSeq=${myProfileList.memberSeq}">
			<div class="editbox">
				<div class="aa">
					<div class="bb">
						<span>성별</span>
						<select name="gender" id="gender" class="form form-control" style="width: 100px; height: 35px;" disabled>
							<option value="남자">남자</option>
							<option value="여자">여자</option>
						</select>
					</div>
				</div>
				
				<div class="cc">
					<span>경력</span>
					<select name="career" id="career" class="form form-control" style="width: 200px; height: 35px;" disabled>
						<option value="신입">신입</option>
						<option value="경력(1년 미만)">경력(1년 미만)</option>
						<option value="1년이상~3년 미만">1년이상~3년 미만</option>
						<option value="3년이상~5년 미만">3년이상~5년 미만</option>
						<option value="5년 이상">5년 이상</option>
						<option value="무관">무관</option>
					</select>
				</div>
				
				<div class="dd">
					<span>학력</span>
					<select name="academicBackground" id="academicBackground" class="form form-control" style="width: 180px; height: 35px;" disabled>
						<option value="고졸">고졸</option>
						<option value="대졸(2~3년제)">대졸(2~3년제)</option>
						<option value="대졸(4년제)">대졸(4년제)</option>
						<option value="졸업예정">졸업예정</option>
						<option value="재학">재학</option>
					</select>
				</div>
				
				<div class="ee">
					<span>관심직종</span>
					<select name="interestOccupation" id="interestOccupation" class="form form-control" style="width: 200px; height: 35px;" disabled>
						<option value="웹개발">웹개발</option>
						<option value="응용프로그램개발">응용프로그램개발</option>
						<option value="시스템개발">시스템개발</option>
						<option value="서버네트워크보안">서버네트워크보안</option>
						<option value="ERP시스템분석설계">ERP시스템분석설계</option>
						<option value="데이터베이스DBA">데이터베이스DBA</option>
						<option value="퍼블리싱UI개발">퍼블리싱UI개발</option>
						<option value="웹디자인">웹디자인</option>
						<option value="소프트웨어">소프트웨어</option>
						<option value="게임">게임</option>
						<option value="웹기획PM">웹기획PM</option>
						<option value="컨텐츠사이트운영">컨텐츠사이트운영</option>
						<option value="인공지능빅데이터">인공지능빅데이터</option>
					</select>
				</div>
				
				<div class="ff">
					<span>사용가능언어</span>
					<select name="availableLanguage" id="availableLanguage" class="form form-control" style="width: 150px; height: 35px;" disabled>
						<option value="c">c</option>
						<option value="cplus">cplus</option>
						<option value="Python">Python</option>
						<option value="java">java</option>
						<option value="css">css</option>
						<option value="js">js</option>
						<option value="db">db</option>
						<option value="linux">linux</option>
						<option value="React">React</option>
						<option value="html">html</option>
						<option value="Kotlin">Kotlin</option>
						<option value="XML">XML</option>
						<option value="GO">GO</option>
					</select>
				</div>
				
				<div class="gg">
					<span>학과</span>
					<select name="major" id="major" class="form form-control" style="width: 100px; height: 35px;" disabled>
						<option value="전공">전공</option>
						<option value="비전공">비전공</option>
					</select>
				</div>
			</div>
			<div class="btns">
				<input type="submit" value="수정하기" class="btn btn-primary" disabled />
				<input type="button" value="돌아가기" class="btn btn-default" onclick="history.back()" />
			</div>
		</form>
   </div>

	<%@ include file="/inc/footer.jsp" %>
   	<%@ include file="/inc/init.jsp" %>

   <script>
      
   		$('#gender').val("${result.gender}");
 		$('#career').val("${result.career}");
 		$("#academicBackground").val("${result.academicBackground}")
 		$("#interestOccupation").val("${result.interestOccupation}")
 		$("#availableLanguage").val("${result.availableLanguage}")
 		$("#major").val("${result.major}")
   
   </script>
</body>
</html>



