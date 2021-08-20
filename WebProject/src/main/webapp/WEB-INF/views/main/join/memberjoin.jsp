<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>
   input::placeholder { 
    color: #d8d5d5;

}

.form{
   display:inline;
}

   
</style>

</head>
<body>
   <!-- memberjoin.jsp -->
   <%@ include file="/inc/header.jsp" %>
   
   <section class="main-section">
      
      <div class="container" style="width:750px;">
     
   
            
     <form method="POST" action="/webproject/main/join/member/memberjoinok.do"  style=" margin: auto; width:800px;" >
   <fieldset >
      <legend style="font-size:25px; margin-bottom:20px; padding:15px;"><span style="margin-left:280px; color:#476072; ">계정 만들기</span></legend>

      
         <div style="width:550px; margin-left:100px; margin-right:100px; padding-left:10px; margin-top:20px;">
      
    
            <span style="font-size: 18px; margin-right:48px;">이름</span>

            <input class="form form-control"
               style="height: 30px; font-size: 15px; margin-bottom: 20px; margin-left : 25px; width:150px;"
               name="name" id="name" type="text" id="name">
                <span class ="alert alert-danger" id="namedangerzero" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">이름을 입력해주세요.</span>
                <span class ="alert alert-danger" id="namedanger" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">이름을 다시 입력해주세요.</span>
               
            <br>
            <span style="font-size: 18px; margin-right:50px;">아이디</span>
         
            <input class="form form-control"
               style="height: 30px; font-size: 15px;  margin-bottom: 20px; margin-left : 8px; width:150px;"
               name="id" id="id" type="text" maxlength="20"> 
               <span class ="alert alert-danger"  name="doubleid" id="doubleid" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">중복된 아이디입니다.</span>
               <span class ="alert alert-success" name="collectid" id="collectid" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">사용가능한 아이디입니다.</span>
               
            
<!--                <input type="button" value="중복확인" style="margin-left: 10px;" onclick="window.open('/webproject/main/join/member/idconfirm.do','child' ,'width=400, height=300, left=500, top=100;')">
 -->            <br>
            
                        
               <span style="font-size: 18px; margin-right:50px;">닉네임</span>
            
            <input class="form form-control" 
               style="height: 30px; font-size: 15px;  margin-bottom: 20px; margin-left : 8px; width:150px;"
               name="nickname" id="nickname" type="text" > 
                <span class ="alert alert-danger" name="doublenickname" id="doublenickname" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">중복된 닉네임입니다.</span>
               <span class ="alert alert-success" name="collectnickname" id="collectnickname" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">사용가능한 닉네임입니다.</span>
               
               
<!--                   <input type="button" value="중복확인" style="margin-left: 10px; ">
 -->            <br>
            
            <span style="font-size: 18px; margin-right:35px;">비밀번호</span>
            
            <input class="form form-control"
               style="height: 30px; font-size: 15px;  margin-bottom: 20px; margin-left : 8px; width:150px;"
               name="pw" id="pw" type="password" > 
            <br>

            
            <span style="font-size: 18px; margin-right:5px;">비밀번호확인</span>
            
            <input class="form form-control"
               style="height: 30px; font-size: 15px;   margin-bottom: 20px; margin-left : 8px; width:150px;"
                type="password" id="pw2" > 
                <span class ="alert alert-success" id="alert-success" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">비밀번호가 일치합니다.</span>
                
                <span class ="alert alert-danger" id="alert-danger" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">비밀번호가 일치하지 않습니다.</span>
            <br> 
         
               <span style="font-size: 18px; margin-right:34px;">주민번호</span>
               <input class="form form-control"
               style="height: 30px; width:100px; font-size: 15px;  margin-left : 8px;"
               name="resgistrationnumber1" id="resgistrationnumber1" type="text" > 
               <span>-</span>
               
                  <input class="form form-control"
               style="height: 30px; width:100px; font-size: 15px; display:inline; "
               name="resgistrationnumber2" id="resgistrationnumber2" type="password" > 
             
                 <span class ="alert alert-danger" id="zuminzero" style="background-color:#F8F8FA; border:hidden; width:200px; font-size:15px;">주민번호를 입력해주세요.</span>
                 <span class ="alert alert-danger" id="zumin" style="background-color:#F8F8FA; border:hidden; width:200px; font-size:14px;">주민번호를 다시 확인해주세요.</span>
               
               <br>
               
               <br>
               <span style="font-size: 18px; margin-right:50px;">이메일</span>
               
                  
            <input class="form form-control"
               style="height: 30px; width: 100px; font-size: 15px;  margin-bottom: 20px; margin-left : 8px;"
               name="email1" type="text"> <span>@</span> 
                  <input class="form form-control"
               style="height: 30px; width:150px; font-size: 15px;"
               name="email2" id= "email2" type="text">
               
               
             <select  id="email_addr" name ="email_addr" 
                  style="height: 30px; display:inline; width : 150px;font-size: 15px; padding:0px;" class="form form-control">
                    <option disabled selected>이메일을 선택해주세요.</option>
                    <option>직접입력</option>
                <option>hanmail.net</option>
                <option>gmail.com</option>
                <option>naver.com</option>
                <option>yahoo.co.kr</option>
                <option>nate.com</option>
             
            </select>
             <!--  <span class ="alert alert-danger" id="emailzero" style="background-color:#F8F8FA; border:hidden; width:200px; font-size:15px;">이메일을 입력해주세요.</span>
               <span class ="alert alert-danger" id="email" style="background-color:#F8F8FA; border:hidden; width:200px; font-size:15px;">이메일을 확인해주세요.</span>
                -->
            
            <br>
            <span style="font-size: 18px; margin-right:50px;">연락처</span>
            <select name="tel1"
                  style="height: 30px; width : 60px;font-size: 15px; margin-left:8px; text-align:left; padding:0px;" class="form form-control">
                  <option>010</option>
                  <option>011</option>
                  <option>019</option>
                  <option>016</option>
                  <option>017</option>
            </select>
            <span>-</span>
            <input class="form form-control"
               style="height: 30px; width:70px; font-size: 15px;  margin-bottom: 20px;"
               name="tel2" type="text" id="tel2"> 
               <span>-</span>
            <input class="form form-control"
               style="height: 30px; width:70px; font-size: 15px;  margin-bottom: 20px;"
               name="tel3" type="text" id="tel3"> 
           
            <span class ="alert alert-danger" id="telzero" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">번호를 입력해주세요.</span>
                <span class ="alert alert-danger" id="tel" style="background-color:#F8F8FA; border:hidden; width:40px; font-size:15px;">번호를 다시 입력해주세요.</span>
               <br>
            <span style="font-size: 18px; margin-left:3px;">주소</span>
               <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
            
              <div style="height:50px;">
                        <span style="margin-right: 15px;">
                           <input type="text" id="sample6_postcode" placeholder="우편번호" class="form form-control" name="postNumber" style=" width:200px; display:inline; margin-top:10px;">
                        </span>
                        <span><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="btn" style=" background-color:#476072; color:white;"><br><br></span>
                     </div>
                     <input type="text" id="sample6_address" placeholder="주소" class="form form-control" style="width: 520px;" name="address1"><br>
                     <div style="display: flex; margin-top:5px;">
                        <input type="text" id="sample6_detailAddress" placeholder="상세주소" class="form form-control" style="width: 260px; margin-right: 15px;" name="address2">
                        <input type="text" id="sample6_extraAddress" placeholder="참고항목" class="form form-control" style="width: 260px;" name="address3">
                     </div>
            
            </div>
            
            
            <div style="margin-top: 20px; margin-left:600px; ">
            <button type="submit" class="btn" style=" background-color:#476072; color:white;" id="submit" >등록하기</button>
            <button type="button" class="btn btn-default"
               onclick="location.href='/webproject/main/mainpage.do';">돌아가기</button>
            </div>
            </fieldset>
         </form>
      
   
         <c:forEach items="${list}" var="dto"> 
         
         <input type="hidden" class ="hidden" value= "${dto.id}">
         <input type="hidden" class ="hidden1" value= "${dto.nickName}">
         
         </c:forEach>
         

         
   
      
      
   </section>   
   
   <%@ include file="/inc/footer.jsp"%>
   <%@ include file="/inc/init.jsp" %>
   
   <script>
   
         $('#doubleid').hide();
         $('#collectid').hide();

         
         
         
         id.onchange = function(){
            
            var id = document.getElementById("id");
               var hiddenid = document.getElementsByClassName('hidden');
               
            for(let i=0; i<hiddenid.length; i++){
               if(hiddenid[i].value == id.value){
                     $('#doubleid').show();
                  $('#collectid').hide();

                     break;

               }else{
                  $('#doubleid').hide();
                  $('#collectid').show();
                  

               }
            }
         }
         
         
         $('#doublenickname').hide();
         $('#collectnickname').hide();

         
         
         
         nickname.onchange = function(){
            
            var nickname = document.getElementById("nickname");
               var hiddennickname = document.getElementsByClassName('hidden1');
               
            for(let i=0; i<hiddennickname.length; i++){
               if(hiddennickname[i].value == nickname.value){
                     $('#doublenickname').show();
                  $('#collectnickname').hide();

                     break;

               }else{
                  $('#doublenickname').hide();
                  $('#collectnickname').show();
                  

               }
            }
         }

         
         
      $("#email2").prop("disabled", true);

       $("#email_addr").on("change",function(){
      
          if($(this).val() == "직접입력"){
             $("#email2").attr("placeholder", "주소를 입력해주세요.");
            $("#email2").val("");
           $("#emailzero").hide();

             $("#email2").prop("disabled", false);
            }else {
               var $selected = $(this).val();
               $("#emailzero").hide();
               $("#email2").val($selected);
                   $("#email2").prop("disabled", true);
                  
            }
       });
       
         
        /* $("resgistrationnumber1").on("change",function(){

           if("")
        }); */

       
       $("#alert-success").hide();
       $("#alert-danger").hide();
       
       $("#pw2").on("change",function(){
          var pw = $("#pw").val();
          var pw2 = $("#pw2").val();
          
          if(pw != "" || pw2 == ""){
             if(pw==pw2){
               $("#alert-success").show();
               $("#alert-danger").hide();
               $("#submit").prop("disabled", false);
             }else{
               $("#alert-success").hide();
             $("#alert-danger").show();
             $("#submit").prop("disabled", true);

          }
          }
          
       
       });
       
        $("#zuminzero").hide();
        $("#zumin").hide();
        
         var resgistrationnumber1 = $("#resgistrationnumber1").val();
         var resgistrationnumber2 = $("#resgistrationnumber2").val();
        
     /*     if(resgistrationnumber1 == "" || resgistrationnumber2 == ""){
            
         $("#zuminzero").show();
         $("#submit").prop("disabled", true);

      } */
         
        $("#resgistrationnumber1").on("change",function(){
            var resgistrationnumber1 = $("#resgistrationnumber1").val();
          let regex = /^[0-9]{6}$/ ;

         if(resgistrationnumber1 == ""){
            alert("생년월일을 입력해주세요.");
            
            
             
          }else if (regex.test(resgistrationnumber1)){
             $("#zumin").hide();
             $("#submit").prop("disabled", false);

          }else{
             $("#zumin").show();
              $("#zuminzero").hide();
            $("#submit").prop("disabled",true);

         }
         
      });
        
        
       
        $("#resgistrationnumber2").on("change",function(){
            var resgistrationnumber2 = $("#resgistrationnumber2").val();
          let regex = /^[0-9]{7}$/ ;

         if(resgistrationnumber2 == ""){
            
            $("#zuminzero").show();
             $("#submit").prop("disabled", true);
             
          }else if (regex.test(resgistrationnumber2)){
             $("#zumin").hide();
              $("#zuminzero").hide();
             $("#submit").prop("disabled", false);

          }else{
             $("#zumin").show();
              $("#zuminzero").hide();
            $("#submit").prop("disabled",true);

         }
         
      });
        
        
       
         
             $("#namedanger").hide();
           $("#namedangerzero").hide();
          var name = $("#name").val();  
          
          if(name == ""){
             $("#namedangerzero").show();
             $("#submit").prop("disabled", true);
          }
          
          $("#name").on("change",function(){
              var name = $("#name").val();  
              let regex = /^[가-힣a-zA-Z]{2,10}$/ ;

             if(name == ""){
                
                $("#namedangerzero").show();
                 $("#submit").prop("disabled", true);
                 
              }else if (regex.test(name)){
                 $("#namedanger").hide();
                  $("#namedangerzero").hide();
                 $("#submit").prop("disabled", false);

              }else{
                 $("#namedanger").show();
                  $("#namedangerzero").hide();
                $("#submit").prop("disabled",true);

             }
             
          });
          
          
           
            $("#telzero").hide();
            $("#tel").hide();
            
             var tel2 = $("#tel2").val();
             var tel3 = $("#tel3").val();
            
             if(tel2 == "" || tel3 == ""){
                
             $("#telzero").show();
             $("#submit").prop("disabled", true);

          }
             
            $("#tel2").on("change",function(){
                var tel2 = $("#tel2").val();
              let regex = /^[0-9]{3,4}$/ ;

             if(tel2 == ""){
                
                $("#telzero").show();
                 $("#submit").prop("disabled", true);
                 
              }else if (regex.test(tel2)){
                 $("#tel").hide();
                 $("#submit").prop("disabled", false);

              }else{
                 $("#tel").show();
                  $("#telzero").hide();
                $("#submit").prop("disabled",true);

             }
             
          });
            
              $("#tel3").on("change",function(){
               var tel3 = $("#tel3").val();
             let regex = /^[0-9]{4}$/ ;

            if(tel3 == ""){
               
               $("#telzero").show();
                $("#submit").prop("disabled", true);
                
             }else if (regex.test(tel3)){
                $("#tel").hide();
                 $("#telzero").hide();
                $("#submit").prop("disabled", false);

             }else{
                $("#tel").show();
                 $("#telzero").hide();
               $("#submit").prop("disabled",true);

            }
            
         });
              
            $("#email").hide();
            
            
      
            /*  var email1 = $("#email1").val();
             var email2 = $("#email2").val();
            
             if(email1 == "" || email2 == ""){
                
             $("#emailzero").show();
             $("#submit").prop("disabled", true);

          }
             
            $("#email1").on("change",function(){
                var email1 = $("#email1").val();
              let regex = /^[0-9a-zA-z]$/ ;

             if(email1 == ""){
                
                $("#emailzero").show();
                 $("#submit").prop("disabled", true);
                 
              }else if (regex.test(email1)){
                 $("#email").hide();
                 $("#submit").prop("disabled", false);

              }else{
                 $("#email").show();
                  $("#emailzero").hide();
                $("#submit").prop("disabled",true);

             }
             
          }); */
            /* 
              $("#email2").on("change",function(){
               var email2 = $("#email2").val();
             let regex = /^[0-9a-zA-Z.]$/ ;

            if(email2 == ""){
               
               $("#emailzero").show();
                $("#submit").prop("disabled", true);
                
             }else if (regex.test(email2)){
                $("#email").hide();
              $("#emailzero").hide();
                $("#submit").prop("disabled", false);

             }else{
                $("#email").show();
                 $("#emailzero").hide();
               $("#submit").prop("disabled",true);

            }
            
         }); */
            
    /*     $("#resgistrationnumber1").on("change", function(){
          if($(this).val().length != 6 || $(this).val() ){
             alert("주민번호 앞자리를 다시 입력해주세요.")
          }
       });
         */
       
       
     /*  $(function(){
            $("#alert-success").hide();
            $("#alert-danger").hide();
            $("#pw2").keyup(function(){
              
               var pw =$("#pw").val();
               var pw2 =$("#pw2").val();
               
               if(pw != "" || pw2 = ""){
                  if(pw ==pw2){
                     $("#alert-success").show();
                     $("#alert-danger").hide();
                     $("#submit").removeAttr("disabled");
                  }else{
                     $("#alert-success").hide();
                     $("#alert-danger").show();
                     $("#submit").Attr("disabled", "disabled");

                  }
                  
               }
               
            });
            
         });  */

         /* $(document).ready(function(){
           $("#submit").click(function(){
              var email1_pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*$/i;
              var email2_pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
              var checkAddress = /[ㄱ-힣a-zA-Z]$/;
              var checkJumin = /^[1-4]\d{6}$/;
              var checkName = /[ㄱ-힣a-zA-Z]$/;
              
              if($("#name").val() == ''){
                 alert("이름을 입력해주세요");
                 $("#name").focus();
                 return false;
              }
              if(!checkName.test($("name").val())){
                 alert("이름은 한글,영어만 가능합니다.");
                 $("#name").val('');
                 $("#name").focus();
                 return false;
                 
              }
           })
         }) */
         
         
         
         function sample6_execDaumPostcode() {
             new daum.Postcode({
                 oncomplete: function(data) {
                     // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                     // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                     // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                     var addr = ''; // 주소 변수
                     var extraAddr = ''; // 참고항목 변수

                     //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                     if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                         addr = data.roadAddress;
                     } else { // 사용자가 지번 주소를 선택했을 경우(J)
                         addr = data.jibunAddress;
                     }

                     // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                     if(data.userSelectedType === 'R'){
                         // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                         // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                         if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                             extraAddr += data.bname;
                         }
                         // 건물명이 있고, 공동주택일 경우 추가한다.
                         if(data.buildingName !== '' && data.apartment === 'Y'){
                             extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                         }
                         // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                         if(extraAddr !== ''){
                             extraAddr = ' (' + extraAddr + ')';
                         }
                         // 조합된 참고항목을 해당 필드에 넣는다.
                         document.getElementById("sample6_extraAddress").value = extraAddr;
                     
                     } else {
                         document.getElementById("sample6_extraAddress").value = '';
                     }

                     // 우편번호와 주소 정보를 해당 필드에 넣는다.
                     document.getElementById('sample6_postcode').value = data.zonecode;
                     document.getElementById("sample6_address").value = addr;
                     // 커서를 상세주소 필드로 이동한다.
                     document.getElementById("sample6_detailAddress").focus();
                 }
             
             
             }).open();
         }
   </script>
</body>
</html>

