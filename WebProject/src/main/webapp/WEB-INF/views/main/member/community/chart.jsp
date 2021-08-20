<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/inc/asset.jsp" %>
<script src="/webproject/asset/js/highcharts.js"></script>

<style>
	.chart {
		border: 1px solid #999;
		border-radius: 10px;
		width: 600px;
		margin: 40px auto;
		padding: 20px;
	}
	
</style>

</head>
<body>
	<!-- template.jsp > chart.jsp -->
	<%@ include file="/inc/header.jsp" %>
	
	<section class="main-section">
		
		<h1>카테고리별 차트</h1>
		
		<div class="chart" id="chart1"></div>
		<div class="chart" id="chart2"></div>
	<div><input type="button" onclick ="location.href='/webproject/main/member/community/list.do';" style="float:right; margin-right:100px;" value="돌아가기" class="btn btn-primary" >
		</div>
	</section>	

	
	<script>
		Highcharts.chart('chart1', {
		    chart: {
		        plotBackgroundColor: null,
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
		            valueSuffix: '개'
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
		    series: [
		    	{
		        name: '게시물수',
		        colorByPoint: true,
		        data: [
		        	
		        
		        <c:forEach items="${categorylist}" var="dto">
		        {
		            name: '${dto.name}',
		            y: ${dto.num}
		        },
		        </c:forEach>
		        
		        
		        ]
		    }]
		});		
		
		Highcharts.chart('chart2', {
		    chart: {
		        plotBackgroundColor: null,
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
		            valueSuffix: '개'
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
		    series: [
		    	{
		        name: '게시물수',
		        colorByPoint: true,
		        data: [
		        	
		        
		        <c:forEach items="${categorycommentlist}" var="dto">
		        {
		            name: '${dto.name}',
		            y: ${dto.num}
		        },
		        </c:forEach>
		        
		        
		        ]
		    }]
		});		
		
		
	
		
		
	</script>
	
	<div style="margin-top:100px;"></div>
	   <%@ include file="/inc/footer.jsp"%>
	   <%@ include file="/inc/init.jsp"%>
</body>
</html>