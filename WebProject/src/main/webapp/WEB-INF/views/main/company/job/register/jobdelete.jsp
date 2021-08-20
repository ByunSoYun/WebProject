<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>
   

   
</style>

</head>
<body>
   <!-- jobdelete.jsp -->
   <%@ include file="/inc/header1.jsp" %>
   
   <section class="main-section">
     	
     	<div class="confirm">
			<div class="alert alert-danger">공고를 정말 삭제하시겠습니까?</div>
			<input type="button" value="삭제하기" class="btn btn-default" onclick="location.href='/webproject/main/company/job/register/jobdeleteok.do?jobPostSeq=${jobPostSeq}';">
			
			<input type="button" value="목록보기" class="btn btn-default" onclick="location.href='/webproject/main/company/job/manage/companyview.do?jobPostSeq=${jobPostSeq}';">
		</div>
      
   </section>   
   
   <%@ include file="/inc/footer.jsp"%>
   <%@ include file="/inc/init.jsp" %>
   <script>
      
   </script>
</body>
</html>



