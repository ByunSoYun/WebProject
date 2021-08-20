<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp"%>

<style>
	.jobGroup-topBox {
		width: 100%;
		padding-bottom: 15px;
		border-bottom: 1px solid #eee;
	}
	
	.jobGroup li {
		font-size: 18px;
		color: #ccc;
	}
	
	.jobGroup .jobgroup{
		color: #555;
	}
	
	.jobGroup-topBox {
		text-aling: center;
	}

	.jobGroup-topBox ul li, .jobGroup-topBox ul li{
		list-style: none;
		display: inline-block;
	}
	
	.jobGroup-titleBox .title{
		margin: 25px;
	}
	
	.jobGroup-titleBox .title li {
		width: 140px;
		height: 80px;
		border: 1px solid #eee;
		border-radius: 8px;
		margin: 5px;
		font-size: 18px;
		text-align: center;
		cursor: pointer;
	}
	
	.jobGroup-titleBox .title li img{
		width: 140px;
		height: 80px;
		opacity: 0.5;
		filter: alpha(opacity=30);
	}
	
	.jobGroup-titleBox .title li img:hover{
		opacity: 1;
		filter: alpha(opacity=0);
	}
	
	.jobGroup-filterBox {
		padding: 30px;
		font-size: 15px;
	}
	
	.filter select{
		width: 120px;
		height: 40px;
		margin-right: 30px;
		border: 1px solid #eee;
		cursor: pointer;
		border-radius: 5px;
	}
	
	.filter .filtermargin{
		margin-right: 15px;
	}
	
	.filter span{
		margin-right: 10px;
	}
	
	.filter .search{
		border-radius: 5px;
		margin:0px;
		width: 60px;
		height: 38px;
		border: 1px solid #eee;
		background-color: #548CA8;
		font-size: 15px;
		color: white;
	}
	
	.filter .range {
		width: 120px;
		float: right;
	}
	
	.jobGroup-list{
		cursor: pointer;
		margin-top: 50px;
	} 
	
	.jobGroup-list ul li{
		list-style: none;
		display: inline-block;
	}
	
	.jobGroup-list .jobList-box .job-img{
		width: 300px;
		height:220px;
		margin:15px;
	}
	
	.job-img img{
		width: 100%;
		height: 100%;
		border-radius: 10px;
	}
	
	.jobGroup-list .jobList-box .job-body{
		height: 150px;
		padding-left:30px;
		margin-bottom:50px;
	}
	
	.jobList-box .postName{
		width: 240px;
		height:50px;
		margin-top: 13px;
		font-size: 20px;
		color: #333;
		margin-bottom:15px;
	}
	
	.jobList-box .postName .dday{
		color: tomato;
		font-size: 15px;
	}
	
	.jobList-box .companyName{
		margin-top: 7px;
		font-size: 18px;
		color: #333;
	}
	
	.jobList-box .location{
		margin-top: 7px;
		font-size: 16px;
		color: #777;
	}
	
	
	.jobList-box .location .career{
		font-size: 15px;
	}
	
	.pagebar { text-align: center; }
	

</style>

</head>
<body>
	<!-- joblist.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<div class="jobGroup-topBox">
			<div class="jobGroup">
				<ul>
					<li>IT 전체 ▶</li>
					<li>개발</li>
					<c:if test="${not empty jobGroup}">
						<li class="jobgroup">▶ ${jobGroup}</li>
					</c:if>
				</ul>
			</div>

			<div class="jobGroup-titleBox">
				<ul class="title">
					<li onclick="location.href='/webproject/main/member/job/joblist.do?jobGroup=1&city=${map.city}&gu=${map.gu}&career=${map.career}&educationLevel=${map.educationLevel}&filter=${map.filter}';">
						<img src="http://localhost:8090/webproject/asset/images/jobfilter/logo1.png">
					</li>
					<li onclick="location.href='/webproject/main/member/job/joblist.do?jobGroup=2&city=${map.city}&gu=${map.gu}&career=${map.career}&educationLevel=${map.educationLevel}&filter=${map.filter}';">
						<img src="http://localhost:8090/webproject/asset/images/jobfilter/logo2.png">
					</li>
					<li onclick="location.href='/webproject/main/member/job/joblist.do?jobGroup=3&city=${map.city}&gu=${map.gu}&career=${map.career}&educationLevel=${map.educationLevel}&filter=${map.filter}';">
						<img src="http://localhost:8090/webproject/asset/images/jobfilter/logo3.png">
					</li>
					<li onclick="location.href='/webproject/main/member/job/joblist.do?jobGroup=4&city=${map.city}&gu=${map.gu}&career=${map.career}&educationLevel=${map.educationLevel}&filter=${map.filter}';">
						<img src="http://localhost:8090/webproject/asset/images/jobfilter/logo4.png">
					</li>
					<li onclick="location.href='/webproject/main/member/job/joblist.do?jobGroup=5&city=${map.city}&gu=${map.gu}&career=${map.career}&educationLevel=${map.educationLevel}&filter=${map.filter}';">
						<img src="http://localhost:8090/webproject/asset/images/jobfilter/logo5.png">
					</li>
					<li onclick="location.href='/webproject/main/member/job/joblist.do?jobGroup=6&city=${map.city}&gu=${map.gu}&career=${map.career}&educationLevel=${map.educationLevel}&filter=${map.filter}';">
						<img src="http://localhost:8090/webproject/asset/images/jobfilter/logo6.png">
					</li>
					<li onclick="location.href='/webproject/main/member/job/joblist.do?jobGroup=7&city=${map.city}&gu=${map.gu}&career=${map.career}&educationLevel=${map.educationLevel}&filter=${map.filter}';">
						<img src="http://localhost:8090/webproject/asset/images/jobfilter/logo7.png">
					</li>
					<li onclick="location.href='/webproject/main/member/job/joblist.do?jobGroup=8&city=${map.city}&gu=${map.gu}&career=${map.career}&educationLevel=${map.educationLevel}&filter=${map.filter}';">
						<img src="http://localhost:8090/webproject/asset/images/jobfilter/logo8.png">
					</li>
					<li onclick="location.href='/webproject/main/member/job/joblist.do?jobGroup=9&city=${map.city}&gu=${map.gu}&career=${map.career}&educationLevel=${map.educationLevel}&filter=${map.filter}';">
						<img src="http://localhost:8090/webproject/asset/images/jobfilter/logo9.png">
					</li>
				</ul>
			</div>

		</div>
		<div class="jobGroup-bottomBox">
			<div class="jobGroup-filterBox">
				<form method="GET" action="/webproject/main/member/job/joblist.do">
					<div class="filter">
						<span>지역</span>
						<input type="hidden" name="jobGroup" value="${map.jobNum}" id="jobGroup">
						<select name="city" class="filtermargin" id="city" onchange="category(this)">
							<option value="all" selected>전체</option>
							<option value="서울시">서울시</option>
							<option value="경기도">경기도</option>
							<option value="인천시">인천시</option>
						</select>
						<select name="gu" id="gu">	
							<c:if test="${map.gu == null}">
							<option value="all" selected>전체</option>
							</c:if>
							<c:if test="${map.gu != 'all'}">				
								<option value="${map.gu}" selected>${map.gu}</option>	
							</c:if>					
						</select>
						<span>경력</span>
						<select name="career" id="career">
							<option value="all" selected>전체</option>
							<option value="신입·경력">신입·경력</option>
							<option value="신입">신입</option>
							<option value="1">경력(1년이상)</option>
							<option value="3">경력(3년이상)</option>
							<option value="5">경력(5년이상)</option>
						</select>
						<span>학력</span>
						<select name="educationLevel" class="filtermargin" id="educationLevel">
							<option value="all" selected>전체</option>
							<option value="학력무관">학력무관</option>
							<option value="대졸">대학졸업</option>
							<option value="대졸(4년제)">대학졸업(4년제)</option>
						</select>
						<button type="submit" class="search">검색</button>	
						<select class="range" name="filter" id="filter">
							<option>최신순</option>
							<option>마감임박순</option>
						</select>
					</div>
					
				</form>
			</div>
			
			<div class="jobGroup-list">
				<ul>
					<c:forEach items="${list}" var="dto">
						<li class="jobList-box" onclick="location.href='/webproject/main/member/job/jobview.do?jobPostSeq=${dto.jobPostSeq}';">
							<div class="job-img">
								<img src="http://localhost:8090/webproject/files/${dto.attachedFile}">
							</div>
							
							<div class="job-body">
								<p class="postName" name="postname">${dto.postName}  
									<span class="dday">D-${dto.diffDay}</span>
								</p>
								<p class="companyName" name="name">${dto.name}</p>
								<p class="location" name="si">${dto.city} 
									<span name="gu">${dto.gu}</span>
									<span class="career">· ${dto.career} · ${dto.educationLevel}</span>
								</p>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="pagebar">
				${pagebar}
			</div>
		</div>




	</section>

	<%@ include file="/inc/footer.jsp"%>
	<%@ include file="/inc/init.jsp"%>
	<script>
      
	
		function category(e){
				
			var target = document.getElementById("gu");
			
			if(e.value=="서울시"){
				var gu = ["전체", "성동구", "마포구", "영등포구", "구로구", "관악구", "중구", "송파구", "강남구", "서초구"];
			}else if(e.value=="경기도"){
				var gu = ["수지구"];
			}else if(e.value=="인천시"){
				var gu = ["미추홀구"];
			}
			
			target.options.length = 0;
			
			for(x in gu){
				
				var option = document.createElement("option");
				option.value = gu[x];
				option.innerHTML = gu[x];
				target.appendChild(option);
				
			}
			
		}
		
		<c:if test="${map.isSearch == 'y'}">
			
			//상태 복원
			$('#city').val('${map.city}');
			$('#gu').val('${map.gu}');
			$('#career').val('${map.career}');
			$('#educationLevel').val('${map.educationLevel}');
			$('#jobGroup').val('${map.jobNum}');
		</c:if>
		
		<c:if test="${map.isFilter != 'n'}">
			
			//상태 복원
			$('#filter').val('${map.filter}');

		</c:if>
	
 		$('#filter').change(function(){
 			<c:if test="${empty map.jobNum}">
				location.href='/webproject/main/member/job/joblist.do?city='+$("#city").val()+'&gu=' + $("#gu").val()+'&career=' + $("#career").val()+'&educationLevel=' + $("#educationLevel").val()+'&filter=' + $(this).val();
			</c:if>	
			<c:if test="${not empty map.jobNum}">
				location.href='/webproject/main/member/job/joblist.do?jobGroup='+${map.jobNum}+'&city='+$("#city").val()+'&gu=' + $("#gu").val()+'&career=' + $("#career").val()+'&educationLevel=' + $("#educationLevel").val()+'&filter=' + $(this).val();
			</c:if>
				/* 	alert($('#city').val()); */
		});
		 
	/* 	$('#filter').val('${nowPage}');
	 */
	
   </script>
</body>
</html>



