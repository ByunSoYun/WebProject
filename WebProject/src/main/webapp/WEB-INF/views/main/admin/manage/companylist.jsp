<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


<%@ include file="/inc/asset.jsp" %>

<style>
.aaa {
	border: 3px solid black;
}

.bbb {
	border-bottom: 3px solid #EEE;
	margin-bottom: 5px;
	padding: 15px;
}

.ccc, .ddd, .fff {
	border-bottom: 3px solid #EEE;
	margin-bottom: 10px;
	padding: 10px;
}

select[name=column] {
	width: 100px;
	margin-right: 5px;
}

input[name=search] {
	width: 200px;
}

.hhh {
	display: flex;
	margin-left: 50px;
}

.ggg {
	margin-left: 200px;
}

.ggg span {
	margin-right: 10px;
}

.pagebar {text-align: center;}
</style>

</head>
<body>

	<%@ include file="/inc/header.jsp" %>
   
	<section class="main-section">
      
		<h1>관리자 - 회원관리(기업회원)</h1>
		
		<div class="aaa">
			<div class="bbb">
				<span>회원 종류</span>
			</div>
			<div class="ccc">
				<span><input type="button" name="company" value="기업회원" class="btn btn-primary" /></span>
				<span><input type="button" name="member" value="일반회원" class="btn btn-primary" /></span>
			</div>
			<div class="ddd">
				<form action="/webproject/main/admin/manage/companylist.do" method="GET">
					<div style="display: flex;">
						<select name="column" id="column" class="form-control">
							<option value="name">기업명</option>
							<option value="id">아이디</option>
							<option value="managerName">담당자이름</option>
						</select> <input type="text" name="search" id="search" class="form-control"
							required placeholder="검색어를 입력하세요."> <input type="submit"
							value="검색하기" class="btn btn-default">
					</div>
				</form>
			</div>
			<c:forEach items="${list}" var="dto">
				<div class="fff">
					<div class="hhh">
						<span>${dto.name}</span>
						<div class="ggg">
							<span>
								<input type="button" value="기본정보 자세히보기" class="btn btn-primary" />
							</span>
							<span>
								<input type="button" value="프로필 자세히보기" class="btn btn-primary" />
							</span>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div class="pagebar">${pagebar}</div>
      
	</section>
	
	<%@ include file="/inc/footer.jsp" %>
	<%@ include file="/inc/init.jsp" %>
   
	<script>
	
		<c:if test="${map.isSearch == 'y'}">
		
			//상태 복원
			$('#column').val('${map.column}');
			$('#search').val('${map.search}');
	
		</c:if>
     
		$("input[name=company]").click(function () {
			location.href='/webproject/main/admin/manage/companylist.do';
		})
		
		$("input[name=member]").click(function () {
			location.href='/webproject/main/admin/manage/memberlist.do';
		})
		
		$("#selPage").change(function () {
			
			location.href='/webproject/main/admin/manage/memberlist.do?page=' + $(this).val();
			
		})
		
		$("#selPage").val("${nowPage}");
	
	</script>
</body>
</html>