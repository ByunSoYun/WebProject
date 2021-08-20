<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>
   
   .login-box{
      width: 60%;
      margin: 0 auto;
      padding-top: 50px;
   }

   .logo{
      width: 330px;
      font-size: 35px;
      color: #476072;
      margin: 0 auto;
      margin-bottom: 30px;
   }

   
   .login-box input {
      width: 100%;
      height: 50px;
      margin-bottom: 10px;
      border-radius: 0px;
   }
   
   .login-box .logbutton {
      background-color: #476072;
      border: 0px;
      color: white;
   }
   
   .login-box input:focus {outline:1px solid #476072;}
   
   .login-box .login{
      border: 1px solid #ccc;
      width: 100%;
      padding: 50px 30px;
      margin: 0 20px;
   }
   
   .login-box .login legend{
      text-align: center;
   }
   
</style>
   
</head>
<body>
   <!-- login.jsp -->
   <%@ include file="/inc/header.jsp" %>
   
   <section class="main-section">
      
      <div class="login-box">
         <div class="logo">All For Developer</div>
         
         <form method="POST" action="/webproject/main/member/membermain.do" style="float: left;">
            <fieldset class="login">
               <legend>일반 사용자</legend>
               <input type="text" name="id" class="form-control" id="id1" required placeholder="아이디">
               <input type="password" name="pw" class="form-control" id="pw1" required placeholder="비밀번호">
               <input type="submit" value="로그인" class="logbutton" id="logbutton1">
            	<label for="cb1">
              		<input type="checkbox" name="" id="cb1" style="width: 10px; height: 10px;" /> 아이디 저장하기
              	</label>
            </fieldset>
         </form>
         
         <form method="POST" action="/webproject/main/company/companymain.do" style="float: left;">
            <fieldset class="login">
               <legend>기업 사용자</legend>
               <input type="text" name="id" class="form-control" id="id2" required placeholder="아이디">
               <input type="password" name="pw" class="form-control" required placeholder="비밀번호">
               <input type="submit" value="로그인" class="logbutton" id="logbutton2">
               <label for="cb2">
              		<input type="checkbox" name="" id="cb2" style="width: 10px; height: 10px;" /> 아이디 저장하기
              	</label>
            </fieldset>
         </form>
      </div>
      
   </section>   
   
   
   <%@ include file="/inc/init.jsp" %>
   <script src="<%=request.getContextPath()%>/asset/js/cookie.js"></script>
   <script>
      $('#id1').focus();
      
      $("#logbutton1").click(function () {
		
    	  if ($("#cb1").prop('checked')) {
				//아이디 저장하기 O
				setCookie('id1', $("#id1").val(), 100); //100일 동안 저장
				
			} else {
				//로그인 + 아이디 저장하기 X
				//만료 시간을 현재 시간보다 과거로 지정 > 쿠키 자동 소멸
				setCookie('id1', '', -1);
			}
    	  
		})
		
		$("#logbutton2").click(function () {
		
    	  if ($("#cb2").prop('checked')) {
				//아이디 저장하기 O
				setCookie('id2', $("#id2").val(), 100); //100일 동안 저장
				
			} else {
				//로그인 + 아이디 저장하기 X
				//만료 시간을 현재 시간보다 과거로 지정 > 쿠키 자동 소멸
				setCookie('id2', '', -1);
			}
    	  
		})
		
		if (getCookie('id1') != "") {
			$("#id1").val(getCookie('id1'));
			$("#cb1").prop('checked', true);
			$("#pw1").focus();
		} else {
			$("#id1").focus();
		}
      
      if (getCookie('id2') != "") {
			$("#id2").val(getCookie('id2'));
			$("#cb2").prop('checked', true);
			$("#pw2").focus();
		} else {
			$("#id2").focus();
		}
   </script>
</body>
</html>
