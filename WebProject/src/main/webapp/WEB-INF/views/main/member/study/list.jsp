<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"  %>

<style>
	.searchbox {
		text-align: center;
		margin-bottom: 20px;
		display: inline-block;
		float: left;
	}
	
	.searchbox .form-control {
		display: inline-block;
		width: auto;
	}
	
	.searchbox #search {
		width: 300px;
	}
	
	.nav {
		width: 600px display: inline-block;
		float: left;
	}
	
	.nav>ul {
		list-style: none;
		display: flex;
		align-items: center;
		padding: 0;
		margin: 0;
		width: 600px;
	}
	
	.nav>ul>li {
		margin-right: 20px;
		cursor: pointer;
		text-align: center;
		float: left;
	}
	
	.nav .sub {
		height: 100px;
	}
	
	.nav .sub li {
		display: flex;
		float: left;
	}
	
	.hide {
		display: none;
	}
	
	.selected {
		color: #476072;
		font-weight: bold;
	}
	
	.pagebar {
		text-align: center;
	}
	
	.table td: {
		height: 100px;
	}
	
	.searchArea {
		text-align: center;
		margin-bottom: 20px;
		display: inline-block;
		float: left;
	}
	
	.searchArea .form-control {
		display: inline-block;
		width: 200px;
	}
	
	.btn-change-div {
		display: inline-block;
		width: 150px;
		float: left;
	}

</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
	<%@ include file="/inc/header.jsp" %>
	<div class="container">
		<h1 class="page-header">정기모임/스터디</h1>
		
		<div class="btn-change-div">
			<input type="button" class="btn btn-change btn-primary" value="검색모드 변경"> 
		</div>

		<div class="searchArea">
			<form method="GET" action="/webproject/main/member/study/list.do">
				<span>지역</span>
				<select id="city" name="city" onchange="categoryChange(this)" class="form-control">
					<option value="all">전체</option>
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="인천">인천</option>
					<option value="전남">전남</option>
					<option value="전북">전북</option>
					<option value="경북">경북</option>
					<option value="경남">경남</option>
					<option value="강원도">강원도</option>
					<option value="충북">충북</option>
					<option value="충남">충남</option>
					<option value="제주도">제주도</option>
				</select>
				<select name="gu" id="gu" class="form-control">   
                     <option value="all">전체</option>
                 </select>
				
				<span>기간</span>
				<select  id="period" name="period" class="form-control">
					<option value="all">전체</option>
					<option class="1개월">1개월</option>
					<option class="2개월">2개월</option>
					<option class="3개월">3개월</option>
					<option class="6개월">6개월</option>
				</select>
				
				<span>분야</span>
				<select id="jobGroup" name="jobGroup" class="form-control">
					<option value="all">전체</option>
					<option value="웹개발">웹개발</option>
					<option value="응용프로그램개발">응용프로그램개발</option>
					<option value="시스템개발">시스템개발</option>
					<option value="서버네트워크보안">서버네트워크보안</option>
					<option value="시스템분석설계">ERP시스템분석설계</option>
					<option value="데이터베이스">데이터베이스DBA</option>
					<option value="퍼블리싱">퍼블리싱UI개발</option>
					<option value="웹디자인">웹디자인</option>
					<option value="소프트웨어">소프트웨어</option>
					<option value="게임">게임</option>
					<option value="웹기획PM">웹기획PM</option>
					<option value="컨텐츠사이트운영">컨텐츠사이트운영</option>
					<option value="인공지능빅데이터">인공지능빅데이터</option>
					<option value="무관">무관</option>
				</select>
				<input type="submit"value="검색하기" class="btn btn-default">
			</form>
		
		</div>

		<div class="searchbox">
			<form method="GET" action="/webproject/main/member/study/list.do">
				<select name="column" id="column" class="form-control">
					<option value="postTitle" a>제목</option>
					<option value="content">내용</option>
					<option value="nickName">닉네임</option>
					<option value="all">제목+내용</option>
				</select> 
				<input type="text" name="search" id="search" class="form-control"
					required placeholder="검색어를 입력하세요."> 
				<input type="submit"value="검색하기" class="btn btn-default">
			</form>
		</div>
		
		
		<div class="main-section">
			<table class="table">
			
			
			<c:if test="${list.size() == 0}">
				<tr>
				<td colspan="6">게시물이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.rnum}</td>
				<td>
					<a href="/webproject/main/member/study/view.do?seq=${dto.studyPostSeq}">${dto.postTitle} (${dto.commentCount})</a>
					<c:if test="${dto.isnew < ( 2 / 24 )}">
                  <span class="label label-danger">new</span>
               </c:if>
					</td>
				<td><i class="bi bi-hand-thumbs-up"></i> ${dto.recommendCount}</td>
				<td><i class="bi bi-hand-thumbs-down"></i> ${dto.decommendCount}</td>
				<td><i class="bi bi-eye"></i> ${dto.readCount}</td>
				<td>${dto.nickName}</td>
				<td>${dto.regdate}</td>
			</tr>
			</c:forEach>
			
			</table>
		</div>
		
		<c:if test="${not empty id}">
         <!-- 새글 쓰기 -->
            <button type="button" class="btn btn-primary" 
               onclick="location.href='/webproject/main/member/study/add.do?';">글쓰기</button>
         </c:if>
		
		<div class="pagebar">
        	 ${pagebar}
      	</div>
      	

	</div>
	<%@ include file="/inc/footer.jsp"%>
   	<%@ include file="/inc/init.jsp"%>
	<script>
	
		
		
		window.onload = function(){
			<c:if test="${map.isSearch == 'yb'}">
				$('.searchArea').addClass("hide");
			</c:if>
			<c:if test="${map.isSearch == 'ya'}">
				$('.searchbox').addClass("hide");
			</c:if>
			<c:if test="${map.isSearch == 'n'}">
				$('.searchArea').addClass("hide");
			</c:if>
			
			
		} 
		
	
		
		
		
		//지역마다 시, 구 검색 조건 설정하기
		function categoryChange(e) {
			var seoul =["강남구", "강동구", "강서구", "관악구", "광진구", "동작구", "마포구", "서초구", "서대문구", "영등포구"];
			var gyengki =["기흥구","단원구", "상록구", "부평구", "분당구", "소사구", "영통구"];
			var incheon =["미추홀구","부평구", "서초구"];
			var all=["전체보기"]
			var target = document.getElementById('gu');
			
			if(e.value == "서울") var d = seoul;
			else if(e.value == "경기") var d = gyengki;
			else if(e.value == "인천") var d = incheon;
			else if(e.value == "all") var d = all;
			else if(e.value == "전남") var d = all;
			else if(e.value == "전북") var d = all;
			else if(e.value == "전남") var d = all;
			else if(e.value == "경북") var d = all;
			else if(e.value == "경남") var d = all;
			else if(e.value == "강원도") var d = all;
			else if(e.value == "충북") var d = all;
			else if(e.value == "충남") var d = all;
			else if(e.value == "제주도") var d = all;
			
			target.options.length = 0;
			
			for(x in d){
				var opt = document.createElement("option");
				opt.value = d[x];
				if(d[x] == "전체보기"){
				opt.innerHTML = all;
					
				} else {
				opt.innerHTML = d[x];
					
				}
				target.appendChild(opt);
			}
			
		}
		
		//검색 모드 변경
		$('.btn-change').click(function(){
				
			if($('.searchbox').hasClass("hide")){
				$('.searchbox').removeClass("hide");
				$('.searchArea').addClass("hide")
				$('.btn-change').css("background-color", "tomato");
				$('.btn-change').css("outline", "0");
				$('.btn-change').css("border", "0");
			}else {
				$('.searchbox').addClass("hide")
				$('.searchArea').removeClass("hide");
				$('.btn-change').css("background-color", "cornflowerblue");
				$('.btn-change').css("outline", "0");
				$('.btn-change').css("border", "0");
			} 
		})
		
		<c:if test="${map.isSearch == 'yb'|| map.isSearch == 'ya'}">
	   		
		
	      	//상태 복원
		      $('#column').val('${map.column}');
		      $('#search').val('${map.search}');
		      $("#city").val('${map.city}').prop("selected", true);
		      $('#gu').val('${map.gu}').prop("selected", true);
		      $('#period').val('${map.period}').prop("selected", true);
		      $('#jobGroup').val('${map.jobGroup}').prop("selected", true);
		      
		     
	   	</c:if>
		
	</script>
</body>
</html>











