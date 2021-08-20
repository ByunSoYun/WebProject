<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>
   
   #list {
        width: 60%;
        margin: 0 auto;
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
   }
   .item {
      width: 500px;
      height: 300px;
      border: 1px solid #999;
      border-radius: 5px;
      margin: 10px;      
      padding: 15px;
      box-shadow: 2px 2px 4px #888;
   }
   .item .name {
        width: 100%;
      font-size: 33px;
      border-bottom: 1px dashed #CCC;
   }
   .item .name .manager {
      text-align: right;
      font-size: 25px;
   }
   
   .item span{
      width: 200px;
      margin-right: 20px;
      font-size: 18px;
   }
   
   .info {

      justify-content: space-between;
      padding-top: 30px;
      font-size: 18px;
      text-align: right;
   }
</style>

</head>
<body>
   <!-- profile.jsp -->
   <%@ include file="/inc/header1.jsp" %>
   
   <section class="main-section">
      
      <div id="list">
         <div class="item">
             <div class="name">
                <div class="companyname">${dto.name}</div>
                <div class="manager"><span>담당자:</span>${dto.managerName}</div>
             </div>
             <div class="info">
                <div class="number"><span>사업자 등록번호:</span>${dto.registrationNumber}</div>
                <div class="tel"><span>전화번호:</span>${dto.companyTel}</div>
                <div class="email"><span>이메일:</span>${dto.managerEmail}</div>
                <div class="url"><span>기업 홈페이지:</span>${dto.companyURL}</div>
             </div>
          </div>
       </div>
   </section>   
   
   <%@ include file="/inc/footer.jsp"%>
   <%@ include file="/inc/init.jsp" %>
   <script>
      
   </script>
</body>
</html>


