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
	
	.jobGroup-list .addBtn{
		width: 100px;
		height: 50px;
		border: 0px;
		border-radius: 30px;
		background-color: #548CA8;
		color: white;
	}
	

</style>

</head>
<body>
	<!-- joblist.jsp -->
	<%@ include file="/inc/header1.jsp"%>

	<section class="main-section">

		<div class="jobGroup-bottomBox">
			
			<div class="jobGroup-list">
				<h1>채용중인 공고</h1>
				<ul>
					<c:forEach items="${list}" var="dto">
						<li class="jobList-box" onclick="location.href='/webproject/main/company/job/manage/companyview.do?jobPostSeq=${dto.jobPostSeq}';">
							<div class="job-img">
								<img src="http://localhost:8090/webproject/files/${dto.attachedFile}">
							</div>
							
							<div class="job-body">
								<p class="postName" name="postname">${dto.postName}  
									<span class="dday">D-${diffDay}</span>
								</p>
								<p class="companyName" name="name">${dto.name}</p>
								<p class="location" name="si">${dto.city} <span name="gu">${dto.gu}</span></p>
							</div>
						</li>
					</c:forEach>
				</ul>
			
				<c:if test="${not empty id}">
					<button type="button" class="addBtn" onclick="location.href='/webproject/main/company/job/register/jobregister.do';">공고 등록</button>
				</c:if>
			</div>
			
		</div>


	</section>

	<%@ include file="/inc/footer.jsp"%>
	<%@ include file="/inc/init.jsp"%>
	<script>
      	
   </script>
</body>
</html>



