<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>

.container li{
  margin-top:20px;
  cursor: pointer;
 }


.container span{
	font-size:17px;
	cursor: pointer;
	margin: 10px;

	
	
}

.btn11:hover{
	text-decoration: underline;
	color: #548CA8;
	
}
.btn11 {
	font-size:15px;
 	background-color:#F8F8FA;
 	  outline: none;
 	
}

.btn11:after  {

  background-color: #3e8e41;


  outline: none;

}
.container .nav li:hover{

color: #548CA8;
font-size: 23px;
  outline: none;



}


.container .table1{
	width: 830px;
}

.table1 { 
border-collapse: collapse;
}

.table1 td{
	border : 1px solid #e9e2e2;
}

#td2{
border-left:0px;
}

.container .table1 td{
	text-align: center;
			height:40px;
	
}

.container #tr1{
	background-color: #f3eded;
}

.container #td1{
text-align: center;
}

.container ul{
	list-style-type:none;
	
}

.container .table1 td:nth-child(1) { width: 0px; }
	.table1 td:nth-child(2) { width: auto; }
	
	.table1 td:nth-child(3) { width: 50px; }
	.table1 td:nth-child(4) { width: 50px; }
	.table1 td:nth-child(5) { width: 50px; }
	.table1 td:nth-child(6) { width:50px; }
	.table1 td:nth-child(7) { width: 120px; }
	.table1 td:nth-child(8) { width: 110px; }
	.table1 td:nth-child(2) { text-align: center; }
	.table1{
		margin-top:25px;
	}
.container .table1 #td2{
boder-left : 0px;
}	
	
	 .searchbox {
      text-align: center;
      margin-bottom: 20px;
      margin-left:85px;
    
   }
   
   .searchbox .form-control{
      display: inline-block;
      width: auto;
   }
   
   .searchbox #search{
      width: auto;
   }
   
   .searchBar { margin: 10px; text-align: center; }
   
 
   .pagebar { text-align: center; }
   
   
</style>
</head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

<body>


	<!--  -->
	 <%@ include file="/inc/header.jsp"%>
	<section class="container" style="width:1050px; height:auto;">
      
		<h1 class="page-header">커뮤니티</h1>
		
		<div style="display:flex;">
		
		
		 <form method="POST" action="/webproject/main/member/community/review.do">
		
		
		
		
		<div style="display:flex;">
		
      		<div class="siderbar" style="display: block;  color: #f8f8f8; height:100%; width: 150px;  z-index: 1000; font-size:20px; position: static;"  >
      		<ul class="nav" style="width:140px;">      			
      			<li id="allall" onclick="location.href='/webproject/main/member/community/list.do';">All</li>
      			<li id="livestory" onclick="location.href='/webproject/main/member/community/livestory.do';">사는 얘기</li>
      			<li id="itevent" onclick="location.href='/webproject/main/member/community/itevent.do';">IT 행사</li>
      			<li id= "review" onclick="location.href='/webproject/main/member/community/review.do';"  style="color: #548CA8;
font-size: 23px;">기술 서적 리뷰</li>
      			<li id= "license" onclick="location.href='/webproject/main/member/community/license.do';">자격증 정보</li>
      			      			<li  onclick="location.href='/webproject/main/member/community/chart.do';">카테고리 차트</li>
      			
      		</ul>
      		
      		</div>
      		
      	</form>
    
      	<div class = "post"  style="  margin-left: 35px; ">
      		<div style="height:50px; width:830px; display:flex;">
      	<button type="button" class="btn btn11" name="orderRegdate" value="regdate">최신순</button>
         <button type="button" class="btn btn11" name="orderRecommendCount" value="recommendCount">추천순</button>
         <button type="button" class="btn btn11" name="orderComment" value="ccnt">댓글순</button>
         <button type="button" class="btn btn11" name="orderReadCount" value="readCount">조회순</button>
			<div class="searchbox">
		         <!--  
		            대부분(99%)의 <form은 method="POST"를 사용한다.
		            예외로.. 전송 당시의 상태를 유지하고 싶을 대 method="GET"을 사용한다.(ex: 검색결과의 북마크)
		         -->
		         <form method="GET" action="/webproject/main/member/community/review.do">
		            <select name="column" id="column" class="form-control" style= "width:110px; margin-left:110px;">
		               <option value="title">제목</option>
		               <option value="content">내용</option>
		               <option value="nickname">닉네임</option>
		               <option value="all">제목+내용</option>
		            </select>
		            <input type="text" name="search" id="search" class="form-control" required placeholder="검색어를 입력하세요.">
		            <input type="submit" value="검색" class="btn btn-default">
					
		         </form>
		      </div>      		
		      
		      </div>
      		
      		
      		 <c:if test="${map.isSearch == 'y' }">
	        	 <div class="searchBar">
		            '${map.search}'으로 검색한 결과 ${list.size()}개의 게시물이 있습니다.
		         </div>
      		</c:if>
      		
      		
      	
      		<table class="table1">
			<tr id="tr1">
				<td  style="border-right:hidden;">
				</td>	
				<td id="td1">제목</td>
				<td style="border-left:hidden;" ></td>
				<td style="border-left:hidden;"></td>
				<td style="border-left:hidden;"></td>
				<td style="border-left:hidden;"></td>
				<td>닉네임</td>
				<td>날짜</td>
			</tr>
			<c:if test="${list.size() == 0}">
				<td colspan="8">
				 게시글이 없습니다.
				</td>
			</c:if> 
			<c:forEach items="${list}" var="dto"> 
			<tr>
				<td  style="border-right:hidden;">
				</td>	
				<td>
					<a href="/webproject/main/member/community/view.do?seq=${dto.seq}&column=${map.column}&search=${map.search}" >${dto.title}<span style="font-size:15px;">
					(${dto.commentcount})</span></a>
					<c:if test="${dto.isnew < (24 / 24)}">
							<span class="label label-danger" style="font-size:8px; margin-left:5px;">New</span>
						</c:if>
				</td>
				<td  style="font-size:13px; border-left:hidden;"><i class="bi bi-hand-thumbs-up-fill"></i>    ${dto.recommendcount}</td>
				<td  style="font-size:13px; border-left:hidden;"><i class="bi bi-hand-thumbs-down-fill"></i>    ${dto.decommendcount}</td>
				<td style="font-size:13px; border-left:hidden;"><i class="bi bi-bookmarks-fill"></i>  ${dto.scrapcount}</td>
				<td  style="font-size:13px; border-left:hidden;"><i class="bi bi-eye-fill"></i>  ${dto.readcount}</td>
				<td>${dto.nickname}</td>
				<td>${dto.regdate}</td>
				
				
			</tr>
			
				
			</c:forEach> 
		</table>
		</form>
		
		
		<c:if test="${not empty id}"> 
		
		<input type="button" value= "글쓰기" class="btn btn-primary"  style="background-color: #548CA8; margin-top:20px; margin-left: 720px; color:#F8F8FA; font-size:16px; width:100px; height:40px;"
							onclick="location.href='/webproject/main/member/community/add.do';">
	
		</c:if>
		
	<c:if test="${map.isSearch == 'n'}">
		
		<div class="pagebar" style="margin-top: 20px;">
         ${pagebar}
      </div>
      
      </c:if>
   
   

   </section>
 
   	<div style="margin-top:100px;"></div>
   
      <%@ include file="/inc/footer.jsp"%>
	   <%@ include file="/inc/init.jsp"%>

   <script>
   
		  <c:if test="${map.isSearch == 'y'}">
		   
		   //상태 복원
		   $('#column').val('${map.column}');
		   $('#search').val('${map.search}');
		
		</c:if>
		
		
			
		 $('#selPage').change(function(){
		      location.href='/webproject/main/member/community/review.do?page=' + $(this).val();
		      
		   });
		 
		 
		   $('#selPage').val('${nowPage}');
		   
		 	
		   $("button[name=orderRegdate]").click(function () {
		         location.href='/webproject/main/member/community/review.do?orderRegdate=regdate';
		      })
		      
		      $("button[name=orderRecommendCount]").click(function () {
		         location.href='/webproject/main/member/community/review.do?orderRecommendCount=recommendCount';
		      })
		      
		      $("button[name=orderComment]").click(function () {
		         location.href='/webproject/main/member/community/review.do?orderComment=ccnt';
		      })
		      
		      $("button[name=orderReadCount]").click(function () {
		         location.href='/webproject/main/member/community/review.do?orderReadCount=readCount';
		      })
	
			 
		   
		   
	</script>
</body>
</html>



