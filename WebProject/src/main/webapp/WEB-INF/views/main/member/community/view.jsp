<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>

.container li{
  margin-top:20px;
  cursor: pointer;

 }

.container .nav li:hover{

color: #548CA8;
font-size: 24px;


}
.container .recid i:hover{
cursor:pointer;

}
.container .table2 td{
   border:1px solid #e9e2e2;


}
.container .table2{
   width:800px;
   height:700px;
   margin-left:35px;
   margin-top : 30px;
   border-collapse: collapse;
}


.comments td{
border : 1px solid #e9e2e2;
}

.container .comments input:hover{
cursor:pointer;


}

.commentwrite td{
border : 1px solid #e9e2e2;
}

</style>
</head>
<body>

   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
   <!--  -->
    <%@ include file="/inc/header.jsp"%>
       
    
    <section class="container" style="width:1050px; height:auto; margin-bottom:40px;">
      
         
         <h1 class="page-header" style="margin-left:30px; color : #548CA8;">${dto.category}</h1>
         
         <div style="display:flex;">
            <div class="siderbar" style="display: block;  color: #f8f8f8; height:100%; width: 150px;  z-index: 1000; font-size:20px; position: static;"  >
            <ul class="nav" style="width:140px;">               
               <li id="allall" onclick="location.href='/webproject/main/member/community/list.do';">All</li>
               <li id="livestory" onclick="location.href='/webproject/main/member/community/livestory.do';">사는 얘기</li>
               <li id="itevent" onclick="location.href='/webproject/main/member/community/itevent.do';">IT 행사</li>
               <li id= "review" onclick="location.href='/webproject/main/member/community/review.do';">기술서적 리뷰</li>
               <li id= "license" onclick="location.href='/webproject/main/member/community/license.do';">자격증 정보</li>
               <li  onclick="location.href='/webproject/main/member/community/chart.do';">카테고리 차트</li>
               
            </ul>
         
            
            </div>
            
            <table class="table2" style="width:100%; height:100%;">
            <tr style="background-color: #f3eded;">
               <td colspan="3" style="height:40px;">
                  <span style ="margin-left:20px;  font-size:18px; color:#548CA8;" >${dto.nickname}</span>
                  <span style="float:right; margin-right:20px;">
                  <span style = "margin-left:580px; font-size:14px;"><i class="bi bi-chat-text-fill"></i> ${dto.commentcount}</i></span>
                  <span style = "font-size:15px; margin-left:5px;"><i class="bi bi-eye-fill"></i> ${dto.readcount}</i></span>
                  </span>
               </td>
               
            </tr>
            
            <tr style="background-color: #f3eded;">
               <td colspan="3" style="border-top:hidden;">
                   <div style ="margin-left:20px;">${dto.regdate}</div>
               </td>
               
            </tr>
            
            
            <tr class="hover">
               <td style="height:60px; width: 700px;" ><span style="margin-left:25px; font-size:20px;">${dto.title}</span></td>
               <td colspan="3" rowspan="2" style="text-align:center;'">
               
               <!-- 추천 -->
               <div class="recid">
                  
                  <c:if test="${not empty id}">
                  
                  <c:set var="recYes" value="empty" />
                  <c:forEach items="${rlist}" var="dto">
                     <c:if test="${memberSeq == dto.memberseq}">
                        <c:if test="${dto.recommend == 'y'}">
                           <c:set var="recYes" value="rec" />  <!--  추천누른사람 -->
                        </c:if>
                        <c:if test="${dto.recommend == 'n'}">
                           <c:set var="recYes" value="dec" />    <!-- 비추천 누른사람 -->
                        </c:if>
                     </c:if>
                  </c:forEach>
                  
                  <c:if test="${recYes eq 'rec'}">
                     <div style="font-size:40px; margin-top:30px;" >
                           <i class="bi bi-chevron-up" title="추천" id="up" style="color: red;"></i>
                           </div>
                        <div style="font-size:37px;">
                           
                           
                           ${(dto.recommendcount - dto.decommendcount)}
                           
      
                           </div>
                        
                           <div style="font-size:40px;">
                           <i class="bi bi-chevron-down" title="비추천" style="cursor:auto;" ></i>
                           </div>
                           <br>
                  
                  </c:if>
                  
                  <c:if test="${recYes eq 'dec'}">
                           <div style="font-size:40px; margin-top:30px;" >
                           
                           <i class="bi bi-chevron-up" title="추천" style="cursor:auto;"></i>
                           </div>
            
                           <div style="font-size:37px; ">
                           
                           ${(dto.recommendcount - dto.decommendcount)}
                              
                           </div>

                           <div style="font-size:40px;">
                           <i class="bi bi-chevron-down" title="비추천" id="down" style="color:red;"></i>
                           </div>
                           <br>
                     </c:if>
                     
                     
                     <c:if test="${recYes eq 'empty'}">
                           <div style="font-size:40px; margin-top:30px;" >
                           <i class="bi bi-chevron-up" title="추천"  onclick="location.href='/webproject/main/member/community/recommend.do?memberseq=${memberSeq}&seq=${dto.seq}&check=emptyrec';"></i>
                           </div>
            
                           <div style="font-size:37px;">
                           
                           ${(dto.recommendcount-dto.decommendcount)}
                           
                           </div>
                           
                        
                           <div style="font-size:40px;">
                           <i class="bi bi-chevron-down" title="비추천"  onclick="location.href='/webproject/main/member/community/recommend.do?memberseq=${memberSeq}&seq=${dto.seq}&check=emptydec';"></i>
                           </div>
                           <br>
                     
                     </c:if>
                  
                  </c:if>
             
               </div>   
               
               
                  <c:if test="${empty id}">
                     <div style="font-size:40px; margin-top:30px;" >
                           <i class="bi bi-chevron-up" title="추천"  ></i>
                           </div>
            
                           <div style="font-size:37px;">
                           ${(dto.recommendcount - dto.decommendcount)}
                           </div>
                           
                        
                           <div style="font-size:40px;">
                           <i class="bi bi-chevron-down" title="비추천"></i>
                           </div>
                           <br>
                  
                  
                  
                  
                  </c:if>
                  
                  
                  
               <div class="recid">
                  <c:if test="${not empty id}">
                     <c:set var="bookYes" value="n" />
                     <c:forEach items="${slist}" var="dto">
                        <c:if test="${memberSeq == dto.memberseq}">
                        <c:set var="bookYes" value="y" />
                        </c:if>
                     </c:forEach>
                     <c:if test="${bookYes eq 'y'}">
                     <span style="font-size:40px;" class="scrap" id="scrap">
                        <i class="bi bi-bookmark-check-fill" title="스크랩취소"></i>
                     </span>
                     </c:if>
                     <c:if test="${bookYes eq 'n'}">
                     <span  style="font-size:40px;" class="scrap" id="noscrap">
                        <i class="bi bi-bookmark" title="스크랩"></i>
                     </span>
                     </c:if>
                  </c:if>
               </div>   
               
                  <c:if test="${empty id}">
                     <div style="font-size:40px;">
                        <i class="bi bi-bookmark"></i>
                     </div>
                  </c:if>                  
                  
         
               
               
               <div style="background-color:#548CA8; border-radius:10px; width:50px; height:20px; margin-left:48px; color:white; margin-bottom:30px;">
               ${dto.scrapcount}</div>
         
            
               </td>
            </tr>
            
            <tr>
               <td><div style="margin:30px; font-size:15px; white-space:pre-line;">${dto.content}</div></td>
   
            </tr>
               
            
            <tr>
               <td colspan="3" style="height:40px; background-color: #f3eded;"><span style="margin-left:20px; font-size:17px; ">댓글<span style="font-size:15px;">(${dto.commentcount})</span></span></td>
            </tr>
            
            <tr>
               
            </tr>
      
            
            </table>
               
            </div>
            
            
         <table style="margin-left:175px; border-collapse:collapse; text-align:center; width:845px;">
         
         <c:forEach items="${clist}" var="cdto">
         
            <%-- <c:if test="${clist.size() == 0 } ">
                  <tr>   
                        <td style="margin-left:15px">댓글이 없습니다.</td>
                  </tr>
               </c:if> --%>
            
            
            
            <tr class="comments" style="height:50px;">
            <td style=" width:200px;"><span style ="margin-left:20px;  font-size:15px; color:#548CA8; margin-right:20px;">${cdto.nickname}</span>
               <div style="color: #ddd5d5">${cdto.regdate}</div>
               </td>
               <td style= text-align:left;"><div style="margin-left:10px;">${cdto.content}</div>

                  
               <c:if test="${not empty id}"> 
                     <c:if test="${cdto.memberseq == memberSeq}"> 
                     
               <div style="font-size:11px; float:right;">
            <%--    <input type="button" value="수정" style="background-color: #476072; color:white; width:40px; height:25px; "
                     onclick="location.href='/webproject/main/member/community/commentedit.do?seq=${cdto.commentseq}&pseq=${dto.seq}';"> --%>
               <input type="button" value="삭제" style="background-color: #334257; color:white; width:40px; height:25px; "
                     onclick="location.href='/webproject/main/member/community/commentdelete.do?seq=${cdto.commentseq}&pseq=${dto.seq}';">
                     
               </div>
               
                  </c:if>       
               </c:if> 
                  
               </td>
               
            
                     
               
            </tr>
            
         
         </c:forEach>
         
         
      
                  
                  
         </table>
            
            <form method="POST" action="/webproject/main/member/community/commentadd.do">
            <c:if test="${not empty id}"> 
            <table style=" margin-left:175px; width:845px;">
               <tr class="comments" style="height:50px;">
                  <td style="border-right:hidden; color:#548CA8; width:200px; text-align:center; font-size:17px;">${nickname}</td>
                  <td><input type="text" name="content" id="content" class="form-control" required placeholder="댓글을 작성하세요."></td>
                  <td style="border-left:hidden; width:90px;"><input type="submit" value="댓글쓰기" style="margin-left:10px; color:white; background-color: #548CA8; " class="btn btn-default"></td>
               </tr>
               
            </table>
                  
            </c:if> 
               
            <c:if test="${empty id}">    
            <table style=" margin-left:175px; width:845px;">
            <tr>
               <td style="border:1px solid #e9e2e2; height:40px;"> <span style="margin-left:100px; font-size:16px;"><a href="/webproject/main/login/login.do">로그인</a>을 하시면 댓글을 등록할 수 있습니다.</span></td>
               
               </tr>
            
            </table>
            
            </c:if>
            
            <input type="hidden" name="pseq" value="${dto.seq}">
            
            </form>
         
         
         
               <c:if test="${not empty id}">
                  <c:if test="${dto.memberseq == memberSeq}">
                  
                  <input type="button" value="글수정" class="btn" style="width:70px; height:30px; background-color: #334257;  margin-left:870px; margin-top:20px;  color:white; " 
                  onclick="location.href='/webproject/main/member/community/edit.do?seq=${dto.seq}';">
               
                  
                  <input type="button" value="글삭제" class="btn" style="width:70px; height:30px; background-color: #334257; margin-top:20px; float:right; color:white;"
                     onclick="location.href='/webproject/main/member/community/delete.do?seq=${dto.seq}';">
                  
                  </c:if>
               </c:if>
                  
                  
         <input type="button" value="돌아가기" class="btn" style="width:80px; height:30px; background-color: #334257; margin-top:30px; float:right; color:white;"
                     onclick="location.href='/webproject/main/member/community/list.do';">
                  
            
      
      
     </section >
     <%@ include file="/inc/footer.jsp"%>
      <%@ include file="/inc/init.jsp"%>
   <script>

   $('#allall').click(function(){
      
      location.href ="/webproject/main/member/community/list.do";
      
   });
 $('#livestory').click(function(){
      
      location.href ="/webproject/main/member/community/livestory.do";
      
   });
   
     $('#up').click(function(){
        
        var result = confirm("추천을 취소하시겠습니까?");

        if(result){

           location.href="/webproject/main/member/community/recommend.do?memberseq=${memberSeq}&seq=${dto.seq}&check=reczoro"
         
              alert("추천 취소되었습니다.");
        }else {

          

        }
     });
     
     $('#down').click(function(){
        var result = confirm("추천을 취소하시겠습니까?");

        if(result){

           location.href="/webproject/main/member/community/recommend.do?memberseq=${memberSeq}&seq=${dto.seq}&check=reczoro"
         
              alert("비추천 취소되었습니다.");
        }else {


        }
     });
     
     
  
     
     $('#noscrap').click(function(){
        var result = confirm("글을 스크랩하시겠습니까?");

        if(result){

           location.href="/webproject/main/member/community/scrap.do?memberseq=${memberSeq}&seq=${dto.seq}&check=y"
         
              alert("스크랩되었습니다.");
        }else {


        }
     });
     
     
     $('#scrap').click(function(){
        var result = confirm("스크랩을 취소하시겠습니까?");

        if(result){

           location.href="/webproject/main/member/community/scrap.do?memberseq=${memberSeq}&seq=${dto.seq}&check=n"
         
              alert("스크랩이 취소되었습니다.");
        }else {


        }
     });
     
     
     
   </script>
</body>
</html>

