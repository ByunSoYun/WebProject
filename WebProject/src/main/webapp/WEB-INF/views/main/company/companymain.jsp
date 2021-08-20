<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>

   .main_img_container{
   	margin-top:80px;
   }

   .container {
      text-align: center;
      width: 1050px;
      margin-top:50px;
   }
   
   .logo_img {
      text-align: center;
      display: inline-block;
      width: 200px;
      height: 250px;
      margin: 50px 50px;
   }
   

   #img_size {
      width: 200px;
      height: 200px;
   }
   
   .main_img_container {
      width: 100%;
      height: auto;
      margin-bottom: 50px;
   }
   
   #main_img img {
      width: 100%;
   }
   
   .container .logo_img:hover{
      cursor: pointer;
   }
   
</style>

</head>
<body>
   <!-- membermain.jsp -->
   <%@ include file="/inc/header1.jsp" %>
   
   <section class="main-section">

      <div class="main_img_container">
         <div id="main_img">
            <img src="http://localhost:8090/webproject/asset/images/main.png" />
         </div>
      </div>
      <div class="container">
         <div class="logo_img" onclick="location.href='/webproject/main/company/job/manage/companylist.do';">
            <div >
               <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70"
                  fill="currentColor" class="bi bi-briefcase" viewBox="0 0 16 16">
                 <path d="M6.5 1A1.5 1.5 0 0 0 5 2.5V3H1.5A1.5 1.5 0 0 0 0 4.5v8A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-8A1.5 1.5 0 0 0 14.5 3H11v-.5A1.5 1.5 0 0 0 9.5 1h-3zm0 1h3a.5.5 0 0 1 .5.5V3H6v-.5a.5.5 0 0 1 .5-.5zm1.886 6.914L15 7.151V12.5a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5V7.15l6.614 1.764a1.5 1.5 0 0 0 .772 0zM1.5 4h13a.5.5 0 0 1 .5.5v1.616L8.129 7.948a.5.5 0 0 1-.258 0L1 6.116V4.5a.5.5 0 0 1 .5-.5z" />
               </svg>
            </div>
            <div class="main_content" >
               <h1>공고 조회</h1>
               <h3>더 나은 기회를 놓치지 마세요!</h3>
               <span>실력있는 사람들과 함께 성장 할 수 있는 행복한 여정 지금 A4D와 함께 시작해주세요</span>
            </div>
         </div>
         <div class="logo_img" onclick="location.href='/webproject/main/company/job/manage/companylist.do';">
            <div >
               <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70"
                  fill="currentColor" class="bi bi-briefcase" viewBox="0 0 16 16">
                 <path d="M6.5 1A1.5 1.5 0 0 0 5 2.5V3H1.5A1.5 1.5 0 0 0 0 4.5v8A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-8A1.5 1.5 0 0 0 14.5 3H11v-.5A1.5 1.5 0 0 0 9.5 1h-3zm0 1h3a.5.5 0 0 1 .5.5V3H6v-.5a.5.5 0 0 1 .5-.5zm1.886 6.914L15 7.151V12.5a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5V7.15l6.614 1.764a1.5 1.5 0 0 0 .772 0zM1.5 4h13a.5.5 0 0 1 .5.5v1.616L8.129 7.948a.5.5 0 0 1-.258 0L1 6.116V4.5a.5.5 0 0 1 .5-.5z" />
               </svg>
            </div>
            <div class="main_content" >
               <h1>공고 등록</h1>
               <h3>더 나은 기회를 놓치지 마세요!</h3>
               <span>실력있는 사람들과 함께 성장 할 수 있는 행복한 여정 지금 A4D와 함께 시작해주세요</span>
            </div>
         </div>
      </div>

      
   </section>   
   
   
   <%@ include file="/inc/init.jsp" %>
   <script>
      
   </script>
</body>
</html>
