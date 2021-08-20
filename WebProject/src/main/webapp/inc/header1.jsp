<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="main-header">
   <section>
      <nav>
         <!-- <div><img src="/webproject/asset/images/logo.png"></div> -->
         <ul>
            <li><img src="/webproject/asset/images/logo.png"></li>
            <li style="margin-right: 80px;" onclick="location.href='/webproject/main/company/companymain.do'">Home</li>
            <li style="margin-right: 80px;" onclick="location.href='/webproject/main/company/job/manage/companylist.do';">공고 조회</li>
            <li style="margin-right: 80px;" onclick="location.href='/webproject/main/company/job/register/jobregister.do';">공고 등록</li>
            <li style="margin-right: 80px;" onclick="location.href='/webproject/main/company/mypage/profile.do';">기업 페이지</li>
            <c:if test="${not empty id}">      
            <li style="margin-right: 80px;">
               <div>${name}(${id})</div>
               <div onclick="location.href='/webproject/main/login/logout.do';" title="로그아웃">Logout</div>
            </li>
            </c:if>   
            <c:if test="${empty id}">
            <li style="margin-left: 70px;">
               <div onclick="location.href='/webproject/main/login/login.do';" title="로그인">Login</div>
            </li>
            <li>
               <div onclick="location.href='/webproject/main/join/memberjoin.do';" title="회원가입" >Join</div>
            </li>
            </c:if>
         </ul>
      </nav>
   </section>
</header>







