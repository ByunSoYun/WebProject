<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"  %>
<script src="/webproject/asset/js/highcharts.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<style>
   
   body { background: #eee;}

   .main-section{ background-color: #fff; padding: 20px; margin-bottom: 0;}
   
   .main-section .title td {border: 0; border-bottom: 1px solid #ddd; margin-bottom: 20px;}
    .main-section .title td:nth-child(1) { width: 300px; border-right: 1px solid #ddd; }
    .main-section .title td:nth-child(2) { width: 70px; }
    .main-section .title td:nth-child(3) { width: auto; text-align: left;}
    .main-section .title td:nth-child(4) { width: 200px; }
   
   .nickname { color: #548CA8;}
   
   .condition-section{ background-color: #fff; padding: 20px; width: 1050px; margin: 35px auto; margin-top:0; }
   
   .condition-section .condition-ment {
      display: flex;
        justify-content: center;
        background-color: #ddd;
        padding-top: 5px;
        padding-bottom: 5px;
        font-size: 20px;
        width: 1050px;
        margin-left: -20px;
     }
   
   .condition-section .condition-table {
      width: 800px;
      margin: auto;
      margin-bottom: 20px;
     }
     
   .condition-section .condition-table td {border: 0;}
    .condition-section .condition-table td:nth-child(1) { width: 150px; border-right: 1px solid #ddd}
    .condition-section .condition-table td:nth-child(2) { width: 300px; }
    .condition-section .condition-table td:nth-child(3) { width: 150px; border-right: 1px solid #ddd;}
    .condition-section .condition-table td:nth-child(4) { width: 200px; }
   .condition-section .main td {border: 0; text-align: left;}
   
   
   
   .main-section .main .content {white-space:pre-line;}
   
   .comment-section{ background-color: #fff; padding-bottom: 20px; width: 1050px; margin: 35px auto; margin-top:0; }
   
   .comment-section .comment-ment {
      display: flex;
        justify-content: center;
        background-color: #ddd;
        padding-top: 5px;
        padding-bottom: 5px;
        font-size: 20px;
        width: 1050px; 
      margin: 0;
     }
     
     .comment-section .comment-table td {border: 0;  text-align: center; }
    .comment-section .comment-table td:nth-child(1) { width: 150px; border-right: 1px solid #ddd; border-bottom: 1px solid #ddd;}
    .comment-section .comment-table td:nth-child(2) { width: auto; border-bottom: 1px solid #ddd; text-align: left; vertical-align: center;}
    .comment-section .comment-table td:nth-child(3) { width: 100px; border-bottom: 1px solid #ddd; text-align: middle;}
   
   
   .main-section .main td {border: 0; text-align: center}
   .main-section .main tr:nth-child(1) {border-bottom: 1px dashed #ccc; }
   .main-section .main td:nth-child(1) {text-align: left;}
   .main-section .main td:nth-child(2) { width: 170px; margin-bottom:3px;}
   .main td:nth-child(3) { width: 170px;}
   .main td:nth-child(4) { width: 170px;}
   
   .dto-content { margin-top: 20px;}
   
   .main .scrap {
      cursor: pointer;
      font-size: 20px;
   }
   
   .reclick {
      cursor: pointer;
   }
     
     .rec {
        font-size: 20px;
     }
     
     .btns-container {width: 1000px; display: inline-block; margin-top: 20px; }
     .red { color: tomato; font-size: 20px; display: inline-block;}
     .close-div { text-align: center;}
     
     
     .starR1{
       background: url('/webproject/asset/images/star.png') no-repeat -52px 0;
       background-size: auto 100%;
       width: 15px;
       height: 30px;
       float:left;
       text-indent: -9999px;
       cursor: pointer;
   }
   
   .starR2{
       background: url('/webproject/asset/images/star.png') no-repeat right 0;
       background-size: auto 100%;
       width: 15px;
       height: 30px;
       float:left;
       text-indent: -9999px;
       cursor: pointer;
   }
   
   .starR1.on{background-position:0 0;}
   .starR2.on{background-position:-15px 0;}
   
   
   .btns-container { text-align: right;};
   .btns-container .btn {display: inline-block; margin-left: 10px;}
   .btns-container div {display: inline-block; margin-left: 10px;}
   
   .red { color: tomato; font-size: 20px;}
   .blue { color: cornflowerblue;  font-size: 20px;}
   
   
   
   .apply-ment {
      display: flex;
        justify-content: center;
        background-color: #ddd;
        padding-top: 5px;
        padding-bottom: 5px;
        font-size: 20px;
        width: 1050px;
        margin-left: -20px;
        margin-top: 30px;
        margin-bottom: 20px;
     }
   
     #chart1 { height: 200px;}
   
</style>


</head>
<body>
   <%@ include file="/inc/header.jsp" %>
   <div class="container">
      <h1 class="page-header">정기모임/스터디</h1>
      <section class="main-section">
      
      <div>
         <table class="table title">
            <tr>
               <td class="nickname"><div>${dto.nickName} 님</div><div>${dto.regdate}</div></td>
               <td>평점 </td>
               <td>
                  <c:if test="${dto.score >= 1}">
                  <div class="starRev">
                       <span class="starR1">별1_왼쪽</span>
                       <span class="starR2">별1_오른쪽</span>
                       <span class="starR1">별2_왼쪽</span>
                       <span class="starR2">별2_오른쪽</span>
                       <span class="starR1">별3_왼쪽</span>
                       <span class="starR2">별3_오른쪽</span>
                       <span class="starR1">별4_왼쪽</span>
                       <span class="starR2">별4_오른쪽</span>
                       <span class="starR1">별5_왼쪽</span>
                       <span class="starR2">별5_오른쪽</span>
                  </div>
                  </c:if>
                  <c:if test="${dto.score == 0}">
                  <span>아직 평점이 없습니다.</span>
                  </c:if>
               </td>
               <td>
                  <i class="bi bi-hand-thumbs-up"></i> ${dto.recommendCount}
                  <i class="bi bi-hand-thumbs-down"></i> ${dto.decommendCount}
                  <i class="bi bi-eye"></i> ${dto.readCount}
               </td>
            </tr>
         
         </table>
         <table class="table main">
            <tr>
               <td><div class="rec">${dto.postTitle}</div></td>
               <td>
                  <c:if test="${not empty id}">
                     <c:set var="recYes" value="n" />
                     <c:forEach items="${slist}" var="dto">
                        <c:if test="${memberSeq == dto.scrapMemberSeq}">
                        <c:set var="recYes" value="y" />
                        </c:if>
                     </c:forEach>
                     <c:if test="${recYes eq 'y'}">
                     <span class="scrap" onclick="location.href='/webproject/main/member/study/scrapok.do?memberseq=${memberSeq}&seq=${dto.studyPostSeq}&check=n';">
                        <i class="bi bi-bookmark-check-fill"></i>스크랩취소하기
                     </span>
                     </c:if>
                     <c:if test="${recYes eq 'n'}">
                     <span class="scrap" onclick="location.href='/webproject/main/member/study/scrapok.do?memberseq=${memberSeq}&seq=${dto.studyPostSeq}&check=y';">
                        <i class="bi bi-bookmark"></i>스크랩하기
                     </span>
                     </c:if>
                  </c:if>
               </td>
                  <c:if test="${not empty id}">
                  <c:set var="recYes" value="empty" />
                  <c:forEach items="${rlist}" var="dto">
                     <c:if test="${memberSeq == dto.recommendMemberSeq}">
                        <c:if test="${dto.recommend == 'y'}">
                           <c:set var="recYes" value="rec" />
                        </c:if>
                        <c:if test="${dto.recommend == 'n'}">
                           <c:set var="recYes" value="dec" />
                        </c:if>
                     </c:if>
                  </c:forEach>
                  
                  <c:if test="${recYes eq 'rec'}">
                     <td class="rec done" >
                        <i class="bi bi-hand-thumbs-up-fill " ></i>추천완료
                     </td>
                     <td class="rec reclick" onclick="location.href='/webproject/main/member/study/recommendok.do?memberseq=${memberSeq}&seq=${dto.studyPostSeq}&check=dec';">
                        <i class="bi bi-hand-thumbs-down"></i>비추천하기
                     </td>
                  </c:if>
                  
                  <c:if test="${recYes eq 'dec'}">
                     <td class="rec reclick" onclick="location.href='/webproject/main/member/study/recommendok.do?memberseq=${memberSeq}&seq=${dto.studyPostSeq}&check=rec';">
                        <i class="bi bi-hand-thumbs-up"></i>추천하기
                     </td>
                     <td class="rec done" >
                        <i class="bi bi-hand-thumbs-down-fill"></i>비추천완료
                     </td>
                  </c:if>
                  
                  <c:if test="${recYes eq 'empty'}">
                     <td class="rec reclick" onclick="location.href='/webproject/main/member/study/recommendok.do?memberseq=${memberSeq}&seq=${dto.studyPostSeq}&check=emptyrec';">
                        <i class="bi bi-hand-thumbs-up"></i>추천하기
                     </td>
                     <td class="rec reclick" onclick="location.href='/webproject/main/member/study/recommendok.do?memberseq=${memberSeq}&seq=${dto.studyPostSeq}&check=emptydec';">
                        <i class="bi bi-hand-thumbs-down"></i>비추천하기
                     </td>
                  </c:if>
                  </c:if>
            </tr>
            <tr>
               <td class="content" colspan="3"><div class="dto-content">${dto.content}</div></td>
            </tr>
         </table>
         
      </div>
      </section>
      <section class="condition-section">
         <div class="condition-ment">모집요건</div>
         <table class="table condition-table">
            <tr>
               <td>구성원 나이대</td>
               <td>${dto.ageGroup}</td>
               <td>스터디 기간</td>
               <td>${dto.period}</td>
            </tr>
            <tr>
               <td>경력</td>
               <td>${dto.career}</td>
               <td>시작날짜</td>
               <td>${dto.startDate}</td>
            </tr>
            <tr>
               <td>학과</td>
               <td>${dto.major}</td>
               <td>종료날짜</td>
               <td>${dto.endDate}</td>
            </tr>
            <tr>
               <td>사용가능 언어</td>
               <td>${dto.language}</td>
               <td>용도</td>
               <td>${dto.purpose}</td>
            </tr>
            <tr>
               <td>지역</td>
               <td>${dto.city} ${dto.gu}</td>
               <td>관련직군</td>
               <td>${dto.jobGroup}</td>
            </tr>
            <tr>
               <td>모집 인원수</td>
               <td>${dto.memberCount} 인</td>
               <td></td>
               <td></td>
            </tr>
         </table>
         <c:if test="${dto.close == 'n'}">
         <div class="btns-container">
            <input type="button" value="돌아가기" class="btn btn-default back" >
            <c:if test="${not empty id}">
               <c:if test="${dto.memberSeq == memberSeq}">
                  <input type="button" value="수정하기" class="btn btn-primary"
                  onclick="location.href='/webproject/main/member/study/edit.do?seq=${dto.studyPostSeq}';">
                  <input type="button" value="삭제하기" class="btn btn-danger"
                  onclick="location.href='/webproject/main/member/study/delete.do?seq=${dto.studyPostSeq}';">
               </c:if>   
            </c:if>   
            <c:if test="${not empty id}">
               <c:if test="${dto.memberSeq != memberSeq}">
                  <c:set var="applyYes" value="o" />
                  <c:forEach items="${alist}" var="dto">
                     <c:if test="${memberSeq == dto.memberSeq}">
                     <c:set var="applyYes" value="${dto.seekerCheck}" />
                     </c:if>
                  </c:forEach>
                  <c:if test="${applyYes eq 'n'}">
                     <input type="button" value="지원취소하기" class="btn btn-danger" id="applydel"
                     onclick="location.href='/webproject/main/member/study/applydelete.do?seq=${dto.studyPostSeq}';">                     
                  </c:if>
                  <c:if test="${applyYes eq 'p'}">
                     <div><span class="blue">합격한 스터디로 지원이 불가합니다.</span></div>
                  </c:if>
                  <c:if test="${applyYes eq 'np'}">
                     <div><span class="red">불합격한 스터디로 지원이 불가합니다.</span></div>
                  </c:if>
                  <c:if test="${applyYes eq 'o'}">
                     <input type="button" value="지원하기" class="btn btn-primary"
                     onclick="location.href='/webproject/main/member/study/apply.do?seq=${dto.studyPostSeq}';">                                       
                  </c:if>
               </c:if>   
            </c:if>   
         </div>
         </c:if>
         <c:if test="${dto.close == 'y'}">
            <div class="close-div">
               <span class="red">종료된 공고입니다.</span>
            </div>
         </c:if>
         
         <div class="apply-ment">지원현황</div>
         <div class="chart" id="chart1"></div>
         
         <div class="apply-ment">위치</div>
		
		<div id="map" style="width: 100%; height: 400px;"></div>
            
      </section>
         
         
         
         
         
      <section class="comment-section">
         <div class="comment-ment">댓글</div>
         <table class="table comment-table">
         <!-- 댓글쓰기  -->
            <c:if test="${not empty id}">
               <form method="POST" action="/webproject/main/member/study/addcomment.do">
                  <tr>
                     <td class="nickname">${nickName}(나) 님</td>
                     <td><input type="text" name="content" id="content" class="form-control" required placeholder="댓글을 작성하세요."></td>
                     <td><input type="submit" value="댓글쓰기" class="btn btn-default"></td>
                  </tr>
                  <input type="hidden" name="memberSeq" value="${memberSeq}">
                  <input type="hidden" name="seq" value="${dto.studyPostSeq}">
               </form>
            </c:if>
            
            <!-- 댓글없을때   -->
            <c:if test="${clist.size() == 0 }">
            <tr>
               <td colspan="3" style='border: 0;'>댓글이 없습니다.</td>
            </tr>
            </c:if>
            <c:forEach items="${clist}" var="cdto">
            <tr>
               <td class="nickname">${cdto.nickName} 님</td>
               <td rowspan="2">
                  ${cdto.content}
                  <c:if test="${cdto.isnew < ( 2 / 24 )}">
                        <span class="label label-danger">new</span>
                        </c:if>
               </td>
               <td rowspan="2">
                  <!-- 댓글삭제  -->
                  <c:if test="${not empty id}">
                     <c:if test="${cdto.commentMemberSeq == memberSeq}">
                        <input type="button" value="삭제하기" class="btn btn-danger"
                        onclick="location.href='/webproject/main/member/study/commentdelete.do?seq=${cdto.commentSeq}&pseq=${dto.studyPostSeq}';">
                     </c:if>   
                  </c:if>
               </td>
            </tr>
            <tr>
               <td>${cdto.regdate}</td>
            </tr>
            </c:forEach>
         </table>
      </section>
   </div>
   <%@ include file="/inc/footer.jsp"%>
      <%@ include file="/inc/init.jsp"%>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c568aa74b3a9671ee3805242fef479b3"></script>   
   <script>
   

	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
   
    mapOption = { 
        center: new daum.maps.LatLng('${dto.latitude}', '${dto.longitude}'), // 지도의 중심좌표
        level: 3 
    };
	
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	var markerPosition  = new kakao.maps.LatLng('${dto.latitude}', '${dto.longitude}'); 
	
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	
	marker.setMap(map);
   
   
   
   
   
   
   
   
   
      $(".done").click(function () {
           alert('이미 완료했습니다.');
        });
      
      //별점 주기      
      window.onload = function(){
         for(let i=0; i< "${dto.score}"; i++){
              $('.starRev').children().eq(i).addClass("on");
            }
      }
      
      //돌아가기
      $(".back").click(function(){
         location.href="/webproject/main/member/study/list.do";
      })
      
      

      
      //경력 차트
      Highcharts.chart('chart1', {
          chart: {
              type: 'column'
          },
          title: {
              text: '지원자 경력'
          },
          subtitle: {
              text: ''
          },
          accessibility: {
              announceNewData: {
                  enabled: true
              }
          },
          xAxis: {
              type: 'category'
          },
          yAxis: {
              title: {
                  text: '지원사 수'
              }
      
          },
          legend: {
              enabled: false
          },
          plotOptions: {
              series: {
                  borderWidth: 0,
                  dataLabels: {
                      enabled: true,
                      format: '{point.y}명'
                  }
              }
          },
      
          tooltip: {
              headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
              pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}명</b> of total<br/>'
          },
      
          series: [
        	  {
                  name: "경력",
                  colorByPoint: true,
                  data: [
                      {
                          name: "신입",
                          y: ${cresult.career1},
                          drilldown: "신입"
                      },
                      {
                          name: "1년 미만",
                          y: ${cresult.career2},
                          drilldown: "1년 미만"
                      },
                      {
                          name: "1~3년",
                          y: ${cresult.career3},
                          drilldown: "1~3년"
                      },
                      {
                          name: "3~5년",
                          y: ${cresult.career4},
                          drilldown: "3~5년"
                      },
                      {
                          name: "5년 이상",
                          y: ${cresult.career5},
                          drilldown: "5년 이상"
                      }
                  ]
              }
          ],
          drilldown: {
              series: [
                 
              ]
          }
      });

              
      
      
      
      
      
   
   </script>
</body>
</html>










