<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp"%>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b45f8a2df1911e3150bc76d38f8e4d13"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	
<script src="/webproject/asset/js/highcharts.js"></script>

<style>
	.jobpost-view {
		width: 68%;
		display: float;
		float: left;
		maring-bottom: 10px;
	}
	
	.company-img img {
		width: 100%;
		border: 1px solid #ccc;
	}
	
	.company-content .postName {
		margin-top: 30px;
		font-size: 20px;
		color: #333;
		margin-bottom: 5px;
	}
	
	.company-content .companyName {
		font-size: 14px;
		color: #333;
	}
	
	.company-content .companyName .location {
		font-size: 14px;
		color: #bbb;
	}
	
	.company-content .bottomBox {
		margin-left: 7px;
		font-size: 14px;
		color: #777;
	}
	
	.company-content .content {
		margin-top: 50px;
		margin-left: 3px;
		line-height: 1.5em;
		font-size: 14px;
		color: #666;
	}
	
	.company-content .bottomBox {
		border-top: 1px solid #ccc;
		margin-top: 50px;
		padding-top: 10px;
	}
	
	.company-content .location-api {
		margin: 0px;
		padding: 0px;
		width: 100%;
		height: 330px;
		margin-bottom: 50px;
	}
	
	.company-content .location-api #map {
		width: 100%;
		height: 100%;
	}
	
	.bottomBox .date-box {
		margin: 10px;
		margin-bottom: 20px;
	}
	
	.bottomBox .date-box .date {
		margin-right: 15px;
	}
	
	.bottomBox .date-box .date-bar{
		margin-right: 5px;
		margin-left: 5px;
	}
	
	.bottomBox .date-box .dday{
		color: tomato;
		margin-left: 5px;
		font-size: 18px;
		font-weight: bold;
	}
	
	.bottomBox .address-box {
		margin: 10px;
		margin-bottom: 20px;
	}
	
	.bottomBox .address-box .address {
		margin-right: 15px;
	}
	
	.job-post-right {
		margin-top: 50px;
		display: float;
		float: right;
		border: 1px solid #ccc;
		border-radius: 5px;
		width: 28%;
		height: auto;
		padding: 5px;
		text-align: center;
	}
	
	.job-post-right button {
		border: 1px solid #548CA8;
		width: 260px;
		height: 45px;
		border-radius: 30px;
	}
	
	.job-post-right #scrapbtn {
		background-color: white;
		color: #548CA8;
		margin-bottom: 10px;
		text-align: center;
		vertical-align: middle;
	}
	
	
	.job-post-right #scrapbtn input[type="checkbox"] {
		display: none;
	}
	
	.job-post-right #scrapbtn #bookmark {
		font-size: 15px;
		margin-right: 15px;
	}
	
	.job-post-right .seeker {
		background-color: #548CA8;
		color: white;
	}

	.chart{
		border-radius: 10px;
		width: 100%;
		margin: 0px auto;
		padding: 20px;
	}
	
/*  	.highcharts-figure, .highcharts-data-table table {
	    min-width: 320px; 
	    max-width: 500px;
		margin: 1em auto;
	}  */
	
	.highcharts-figure #container {
	    height: auto;
	}
	
	.highcharts-data-table table {
		font-family: Verdana, sans-serif;
		border-collapse: collapse;
		border: 1px solid #EBEBEB;
		margin: 10px auto;
		text-align: center;
		width: 100%;
	}
	.highcharts-data-table caption {
	    padding: 1em 0;
	    font-size: 1.2em;
	    color: #555;
	}
	.highcharts-data-table th {
		font-weight: 600;
	    padding: 0.5em;
	}
	.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
	    padding: 0.5em;
	}
	.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
	    background: #f8f8f8;
	}
	.highcharts-data-table tr:hover {
	    background: #f1f7ff;
	}
	
	.job-post-right .title{
		font-size: 27px;
		color: #555;
	}
	
	.job-post-right .total{
		font-size: 20px;
		color: #555;
	}
	
	.job-post-right .total span{
		font-size: 28px;
		color: cornflowerblue;
	}
	
	#scrapbtn {
		margin-top: 20px;
	}
		
</style>

</head>
<body>
	<!-- jobview.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<div class="jobpost-view">

			<section class="company-img">
				<img src="http://localhost:8090/webproject/files/${dto.attachedFile}">
			</section>
			<section class="company-content">
				<div class="postName">${dto.postName}</div>
				<div class="companyName">${dto.name }
					<span class="location">${dto.city} ${dto.gu}</span>
				</div>

				<div class="content" style="white-space: pre-line;">${dto.postContent}</div>

				<div class="bottomBox">
					<div class="date-box">
						<span class="date">채용 날짜</span> 
						<span class="startdate">${dto.startDate}</span>
						<span class="date-bar">-</span>
						<span class="enddate">${dto.endDate}</span>
						<span class="dday">D-${map.diffDay }</span>
					</div>
					<div class="address-box">
						<span class="address">근무지역</span> <span class="city">${dto.city}</span>
						<span class="gu">${dto.gu}</span> <span class="dong">${dto.dong}</span>
						<span class="address">${dto.address }</span>
					</div>
					<div class="location-api">
						<div id="map"></div>
					</div>
				</div>
				
		
			</section>

		</div>
		<div class="job-post-right">
			<div class="title">지원현황</div>
			<div class="total">총 지원자 수 : <span>${totalnum}</span>명</div>
			
		    <c:choose>
		        <c:when test="${gresult.man eq 0 && gresult.woman eq 0 }">
		            <div style="color:tomato; font-size:15px; margin:8px;">아직 지원자가 없습니다.</div>
		        </c:when>         
		        <c:otherwise>
		           <figure class="highcharts-figure">
	    			<div id="container"></div>
					</figure>
					<figure class="highcharts-figure">
	    			<div id="container2"></div>
				</figure>
		         </c:otherwise>
		    </c:choose>
			
			<button type="button" id="scrapbtn">
				<i class="glyphicon glyphicon-bookmark" id="bookmark"></i> 
				<input type="checkbox" id="scrap" name="scrap"> 
				<label for="scrap" id="scrap-status" style="cursor: pointer;">스크랩하기</label>
			</button>
			<br>
			<button type="button" class="seeker" onclick="location.href='/webproject/main/member/job/jobenroll.do?jobPostSeq=${dto.jobPostSeq}';">지원하기</button>
		</div>
		


	</section>

	<%@ include file="/inc/footer.jsp"%>
	<%@ include file="/inc/init.jsp"%>
	<script>
		var container = document.getElementById('map'); // 지도 태그 선택
		
		var options = {
			center: new daum.maps.LatLng(${dto.latitude}, ${dto.longitude}), //지도의 중앙 좌표
			level: 3 //지도의 레벨(확대, 축소)
		};
		
		var marker = new daum.maps.Marker({
			position: new daum.maps.LatLng(${dto.latitude}, ${dto.longitude})
		});
		
		var map = new daum.maps.Map(container, options);
		marker.setMap(map);

	    window.onload = function () {
	        if(${isscrap.equals("y")}){
	     	   $('#scrap').prop('checked', true);
	     	   $('#scrap-status').text('스크랩 완료');
	        } else{
	     	   $('#scrap').prop('checked', false);
	     	   $('#scrap-status').text('스크랩 하기');
	        }
	    };  
      
      	$(document).ready(function() {
			$("#scrapbtn").click(function() {
			    if ($("#scrap").prop("checked")) {
			    	location.href = '/webproject/main/member/job/jobview.do?jobPostSeq=${dto.jobPostSeq}&scrap=y';
			    } else {
			    	location.href = '/webproject/main/member/job/jobview.do?jobPostSeq=${dto.jobPostSeq}&scrap=n';
			    }
		  	});
		});
      	
      	
      	Highcharts.chart('container', {
      	    chart: {
      	        plotBackgroundColor: null,
      	        plotBorderWidth: 0,
      	        plotShadow: false
      	    },
      	    title: {
      	        text: '성별 현황',
      	        align: 'center',
      	        verticalAlign: 'middle',
      	        y: 60
      	    },
      	    tooltip: {
      	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
      	    },
      	    accessibility: {
      	        point: {
      	            valueSuffix: '%'
      	        }
      	    },
      	    plotOptions: {
      	        pie: {
      	            dataLabels: {
      	                enabled: true,
      	                distance: -50,
      	                style: {
      	                    fontWeight: 'bold',
      	                    color: 'white'
      	                }
      	            },
      	            startAngle: -90,
      	            endAngle: 90,
      	            center: ['50%', '75%'],
      	            size: '110%'
      	        }
      	    },
      	    series: [{
      	        type: 'pie',
      	        name: '성별 현황',
      	        innerSize: '50%',
      	        data: [
      	            ['남자', ${gresult.man}],
      	            ['여자', ${gresult.woman}]
      	        ]
      	    }]
      	});
      	
      	
      	
     // Create the chart
      	Highcharts.chart('container2', {
      	    chart: {
      	        type: 'column'
      	    },
      	    title: {
      	        text: '경력별 현황'
      	    },
      	  /*   subtitle: {
      	        text: 'Click the columns to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'
      	    }, */
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
      	            text: '인원수(명)'
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
      	        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}명 </b><br/>'
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



