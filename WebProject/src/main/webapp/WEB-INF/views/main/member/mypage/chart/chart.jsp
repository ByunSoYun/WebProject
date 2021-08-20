<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>

<style>
.chart {
	border: 1px solid #999;
	border-radius: 10px;
	width: 600px;
	margin: 40px auto;
	padding: 20px;
	position: relative;
	top: -180px;
}

.qna {
	cursor: pointer;
}
</style>
</head>
<body>

	<%@ include file="/inc/header.jsp"%>

	<!--  -->
	<div class="container">
      
		<h1 class="page-header">내가 쓴 게시글 - 차트</h1>
		
		<div class="container2">
			<div class="a" style="width: 200px;">
				<div class="c" style="border-bottom: 0;">
					<div>커뮤니티</div>
					<div class="qna" onclick="location.href='/webproject/main/member/mypage/mycomment/qnalist.do'">Q&A</div>
					<div>스터디/정기모임 내역</div>
					<div>공간대여 내역</div>
				</div>
			</div>
		</div>
		
		<div id="boardChart" class="chart"></div>
		
		<div id="boardCommentChart" class="chart"></div>
      
   </div>
   
   <%@ include file="/inc/footer.jsp"%>
   <%@ include file="/inc/init.jsp"%>

   <script>
      
	   Highcharts.chart('boardChart', {
		    chart: {
		        plotBackgroundColor: '#F8F8FA',
		        plotBorderWidth: null,
		        plotShadow: false,
		        type: 'pie'
		    },
		    title: {
		        text: '카테고리별 게시물 수'
		    },
		    tooltip: {
		        pointFormat: '{series.name}: <b>{point.y}개</b>'
		    },
		    accessibility: {
		        point: {
		            valueSuffix: '%'
		        }
		    },
		    plotOptions: {
		        pie: {
		            allowPointSelect: true,
		            cursor: 'pointer',
		            dataLabels: {
		                enabled: true,
		                format: '<b>{point.name}</b>: {point.y}개'
		            }
		        }
		    },
		    series: [{
		        name: '게시물수',
		        colorByPoint: true,
		        data: [
		        
		        {
		            name: '커뮤니티',
		            y: ${boardCount.communityCount}
		        },
		        {
		            name: 'Q&A',
		            y: ${boardCount.qnaCount}
		        },
		        {
		            name: '스터디',
		            y: ${boardCount.studyCount}
		        },
		        
		       ]
		    }]
		});
	   
	   Highcharts.chart('boardCommentChart', {
		    chart: {
		        plotBackgroundColor: '#F8F8FA',
		        plotBorderWidth: null,
		        plotShadow: false,
		        type: 'pie'
		    },
		    title: {
		        text: '카테고리별 댓글 수'
		    },
		    tooltip: {
		        pointFormat: '{series.name}: <b>{point.y}개</b>'
		    },
		    accessibility: {
		        point: {
		            valueSuffix: '%'
		        }
		    },
		    plotOptions: {
		        pie: {
		            allowPointSelect: true,
		            cursor: 'pointer',
		            dataLabels: {
		                enabled: true,
		                format: '<b>{point.name}</b>: {point.y}개'
		            }
		        }
		    },
		    series: [{
		        name: '댓글수',
		        colorByPoint: true,
		        data: [
		        {
		            name: '커뮤니티',
		            y: ${commentCount.communityCommentCount}
		        },
		        {
		            name: 'Q&A',
		            y: ${commentCount.qnaCommentCount}
		        },
		        {
		            name: '스터디',
		            y: ${commentCount.studyCommentCount}
		        },
		        ]
		    }]
		});
   
   </script>
</body>
</html>



