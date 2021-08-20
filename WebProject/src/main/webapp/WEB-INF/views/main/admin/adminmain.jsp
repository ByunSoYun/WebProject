<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>
   .container {
      text-align: center;
      width: 1050px;
      margin-top: 20px
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
   <%@ include file="/inc/header.jsp" %>
   
   <section class="main-section">
      일반사용자 메인화면
      ${name}님 반갑습니다.
      ${id}
      <h1>일반사용자메인페이지</h1>

      <div class="main_img_container">
         <div id="main_img">
            <img src="http://localhost:8090/webproject/asset/images/main.png" />
         </div>
      </div>
      <div class="container">
         <div class="logo_img" onclick="location.href='/webproject/main/admin/community/list.do';">
            <div >
               <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70"
                  fill="currentColor" class="bi bi-layout-text-window-reverse"
                  viewBox="0 0 16 16">
                 <path d="M13 6.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm0 3a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm-.5 2.5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5z" />
                 <path d="M14 0a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12zM2 1a1 1 0 0 0-1 1v1h14V2a1 1 0 0 0-1-1H2zM1 4v10a1 1 0 0 0 1 1h2V4H1zm4 0v11h9a1 1 0 0 0 1-1V4H5z" />
               </svg>
            </div>
            <div class="main_content" >
               <h1>커뮤니티</h1>
               <h3>이제 원하는 정보를 한눈에!</h3>
               <span>개발자들끼리 카테고리별로 자유롭게 의사소통할 수 있는 공간입니다. 원하는 글을 스크랩 하세요!</span>
            </div>
         </div>

         <div class="logo_img" onclick="location.href='/webproject/main/admin/qna/list.do';">
            <div>
               <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70"
                  fill="currentColor" class="bi bi-question-square"
                  viewBox="0 0 16 16">
                 <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
                <path d="M5.255 5.786a.237.237 0 0 0 .241.247h.825c.138 0 .248-.113.266-.25.09-.656.54-1.134 1.342-1.134.686 0 1.314.343 1.314 1.168 0 .635-.374.927-.965 1.371-.673.489-1.206 1.06-1.168 1.987l.003.217a.25.25 0 0 0 .25.246h.811a.25.25 0 0 0 .25-.25v-.105c0-.718.273-.927 1.01-1.486.609-.463 1.244-.977 1.244-2.056 0-1.511-1.276-2.241-2.673-2.241-1.267 0-2.655.59-2.75 2.286zm1.557 5.763c0 .533.425.927 1.01.927.609 0 1.028-.394 1.028-.927 0-.552-.42-.94-1.029-.94-.584 0-1.009.388-1.009.94z" />
               </svg>
            </div>
            <div class="main_content" >
               <h1>Q&A</h1>
               <h3>전문가에게 물어보세요!</h3>
               <span>A4D의 Q&A 게시판에서 여러분의 궁금증을 해결하세요. 많은 사용자들이 빠르게 답변을 남깁니다.</span>
            </div>
         </div>

         <div class="logo_img" onclick="location.href='/webproject/main/admin/study/list.do';">
            <div>
               <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70"
                  fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
                 <path d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z" />
               </svg>
            </div>
            <div class="main_content" >
               <h1>스터디/정기모임</h1>
               <h3>스터디와 정기모임을 하나로!</h3>
               <span>평점 서비스를 통해 원하는 스터디에 지원하고, 좋은 조원들과 함께 스터디를 진행하세요.</span>
            </div>
         </div>

         <div class="logo_img" onclick="location.href='/webproject/main/admin/job/joblist.do';">
            <div >
               <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70"
                  fill="currentColor" class="bi bi-briefcase" viewBox="0 0 16 16">
                 <path d="M6.5 1A1.5 1.5 0 0 0 5 2.5V3H1.5A1.5 1.5 0 0 0 0 4.5v8A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-8A1.5 1.5 0 0 0 14.5 3H11v-.5A1.5 1.5 0 0 0 9.5 1h-3zm0 1h3a.5.5 0 0 1 .5.5V3H6v-.5a.5.5 0 0 1 .5-.5zm1.886 6.914L15 7.151V12.5a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5V7.15l6.614 1.764a1.5 1.5 0 0 0 .772 0zM1.5 4h13a.5.5 0 0 1 .5.5v1.616L8.129 7.948a.5.5 0 0 1-.258 0L1 6.116V4.5a.5.5 0 0 1 .5-.5z" />
               </svg>
            </div>
            <div class="main_content"  >
               <h1>채용공고</h1>
               <h3>더 나은 기회를 놓치지 마세요!</h3>
               <span>실력있는 사람들과 함께 성장 할 수 있는 행복한 여정 지금 A4D와 함께 시작해주세요</span>
            </div>
         </div>

         <div class="logo_img" onclick="location.href='/webproject/main/admin/space/list.do';">
            <div >
               <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70"
                  fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                 <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z" />
               </svg>
            </div>
            <div class="main_content">
               <h1>공간대여서비스</h1>
               <h3>이제 공간 걱정은 그만!</h3>
               <span>지역별로 나눠진 공간들 안에서 여러분들의 용도에 맞춰서 안정된 공간에서 여러분들을 맞이합니다!</span>
            </div>
         </div>
      </div>

      
   </section>   
   
   
   <%@ include file="/inc/init.jsp" %>
   <script>
      
   </script>
</body>
</html>
