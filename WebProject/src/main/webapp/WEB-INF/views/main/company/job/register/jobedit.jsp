<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>
   
   .register-box{
	border: 1px solid #476072;
   	width: 70%;
   	margin: 80px auto;
   	height: auto;
   	background-color: #FAFBFC;
	
   }
   
   .register-box .register-content .title{
    border-bottom: 1px solid #ccc;
   	padding: 20px;
   	font-size: 25px;
   	font-weight: bold;
   	color: #548CA8;
   }
   
   .register-tbl{
   	margin-top: 5px;
   	width: 100%;
	font-size: 18px;
	padding: 10px;
   }
   
   .register-tbl tr th{
	   	width: 130px;
	   	padding: 12px;
	   	padding-left: 30px;
   }
   
    .register-tbl tr td{
    	padding: 12px;
    }
   
   .register-tbl td input {
   	border: 1px solid #ccc;
   	width: 320px;
   	height: 50px;
   	padding: 5px;
   }
   .register-tbl td select {
   	border: 1px solid #ccc;
   	width: 230px;
   	height: 50px;
   	padding: 5px;
   }
   
   .register-tbl .date input{
   	width: 170px;
   	font-size: 16px;
   }
   
   .register-tbl .date span{
   	margin: 5px;
   }
   
   .register-tbl #address input{
   	width: 150px;
   	text-align: right;
   }
   
   #detail-address #search{
   	width: 60px;
   	height: 48px;
   	font-size: 13px;
   	border: 0px;
   }
   
   .postContent {
    border: 1px solid #ccc;
   	width: 500px;
   	height: 400px;
   	font-size: 20px;
   	padding: 5px;
   	}
   	
   	.register-tbl .attachedFile{
   		width: 250px;
   	}
   	
   	.register-tbl #map-box input{
   		width: 140px;
   		font-size:16px;
   	}
   
   .coltd{
   	text-align: center;
   }
   
   .register-tbl .editBtn{
   	background-color: #548CA8;
   	color: white;
   	width: 150px;   	
   }
   
   
</style>

</head>
<body>
   <!-- jobedit.jsp -->
   <%@ include file="/inc/header1.jsp" %>
   
   <section class="main-section">
      
      <div class="register-box">
      	<div class="register-content">
      		<div class="title">${name} 공고 수정 </div>
      		
      		<form method="POST" action="/webproject/main/company/job/register/jobeditok.do" enctype="multipart/form-data">
      		<table class="register-tbl">
      			<tr>
      				<th>공고명</th>
      				<td>
      					<input type="text" name="postName"  required value="${dto.postName}">
      					<input type="hidden" name="jobPostSeq" value="${dto.jobPostSeq}">
      				</td>
      			</tr>
      			<tr>
      				<th>채용 날짜</th>
      				<td class="date">
      					<input type="date" id="startDate" name="startDate" required value="${dto.startDate}">
      					<span>-</span>
      					<input type="date" id="endDate" name="endDate" required value="${dto.endDate}">
      				</td>
      			</tr>
      			<tr>
      				<th>직군</th>
      				<td>
      					<select name="jobGroup" required id="jobGroup">
      						
      						<option value="서버 개발자">서버 개발자</option>
      						<option value="웹 개발자">웹 개발자</option>
      						<option value="프론트엔드 개발자">프론트엔드 개발자</option>
      						<option value="자바 개발자">자바 개발자</option>
      						<option value="안드로이드 개발자">안드로이드 개발자</option>
      						<option value="ios 개발자">ios 개발자</option>
      						<option value="데이터 엔지니어">데이터 엔지니어</option>
      						<option value="보안 엔지니어">보안 엔지니어</option>
      						<option value="웹 디자이너">웹 디자이너</option>
      					</select>
      				</td>
      			</tr>
      			<tr>
      				<th>경력</th>
      				<td>
      					<select name="career" id="career" required>
							<option value="신입·경력">신입·경력</option>
							<option value="신입">신입</option>
							<option value="1년이상">경력(1년이상)</option>
							<option value="3년이상">경력(3년이상)</option>
							<option value="5년이상">경력(5년이상)</option>
						</select>
      				</td>
      			</tr>
      			<tr>
      				<th>학력</th>
      				<td>
      					<select name="educationLevel" id="educationLevel" class="filtermargin" required>
							<option value="학력무관">학력무관</option>
							<option value="대졸">대학졸업</option>
							<option value="대졸(4년제)">대학졸업(4년제)</option>
						</select>
      				</td>
      			</tr>
      			<tr>
      				<th>근무형태</th>
      				<td>
      					<select name="jobType" id="jobType" required>
      						<option value="정규직, 계약직">정규직, 계약직</option>
      						<option value="정규직">정규직</option>
      						<option value="계약직">계약직</option>
      					</select>
      				</td>
      			</tr>
      			<tr>
      				<th>연봉</th>
      				<td>
      					<select name="salary" id="salary" required>
      						<option value="회사내규에 따름">회사내규에 따름</option>
      					</select>
      				</td>
      			</tr>
      			<tr>
      				<th>공고 내용</th>
      				<td>
      					<textarea name="postContent" class="postContent" required>${dto.postContent}</textarea>
      				</td>
      			</tr>
      			<tr>
      				<th>첨부 파일</th>
      				<td>
      					<input type="file" name = "attachedFile" class="attachedFile" required value="${dto.attachedFile }">
      				</td>
      			</tr>
      			
      			<tr>
      				<th>주소</th>
      				<td id="address">
      					<input type="text" name="city" required value="${dto.city}">
      					<input type="text" name="gu" required value="${dto.gu}">
      					<input type="text" name="dong" required value="${dto.dong}">
      				</td>
      			</tr>
      			<tr>
      				<th>상세 주소</th>
      				<td id="detail-address">
      					<input type="text" name="address" class="address" required value="${dto.address}">
      					<input type="button" value="검색" id="search" required>
      				</td>
      			</tr>
      			<tr>
      				<th>지도(좌표)</th>
      				<td id="map-box">
      					<div id="map" style="width:100%;height:350px; margin-bottom: 10px;"></div>
      					<input type="text" id="latitude" name="latitude" required value="${dto.latitude}">
						<input type="text" id="longitude" name="longitude" required value="${dto.longitude }">
      				</td>
      			</tr>
      			
      			<tr>
      				<td colspan="2" class="coltd">
						<input type="submit" value="수정" class="editBtn">
					</td>
      			</tr>
      			
      		</table>
      		
      		</form>
      	</div>
      </div>

      
      
   </section>   
   
   <%@ include file="/inc/footer.jsp"%>
   <%@ include file="/inc/init.jsp" %>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b45f8a2df1911e3150bc76d38f8e4d13&libraries=services"></script>
	
   <script>
   
	   
	   $('#jobGroup').val('${dto.jobGroup}').prop("selected",true);
	   $('#educationLevel').val('${dto.educationLevel}').prop("selected",true);
	   $('#career').val('${dto.career}').prop("selected",true);
	   $('#jobType').val('${dto.jobType}').prop("selected",true);
	  
	   
	   
		var infowindow = new kakao.maps.InfoWindow({zIndex:1});
	
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(${dto.latitude}, ${dto.longitude}), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
	
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
	   $('#search').click(function(){
	
	
			// 장소 검색 객체를 생성합니다
			var ps = new kakao.maps.services.Places(); 
	
			// 키워드로 장소를 검색합니다
			ps.keywordSearch($('.address').val(), placesSearchCB); 
	
			// 키워드 검색 완료 시 호출되는 콜백함수 입니다
			function placesSearchCB (data, status, pagination) {
			    if (status === kakao.maps.services.Status.OK) {
	
			        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
			        // LatLngBounds 객체에 좌표를 추가합니다
			        var bounds = new kakao.maps.LatLngBounds();
	
			        for (var i=0; i<data.length; i++) {
			            displayMarker(data[i]);    
			            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
			        }       
	
			        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
			        map.setBounds(bounds);
			    } 
			}
	
			// 지도에 마커를 표시하는 함수입니다
			function displayMarker(place) {
			    
			    // 마커를 생성하고 지도에 표시합니다
			    var marker = new kakao.maps.Marker({
			        map: map,
			        position: new kakao.maps.LatLng(place.y, place.x) 
			    });
			    
	
			    // 마커에 클릭이벤트를 등록합니다
			    kakao.maps.event.addListener(marker, 'click', function() {
			        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
			        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
			        infowindow.open(map, marker);
			        
			        $('#latitude').val(place.y);
			        $('#longitude').val(place.x);
			       
			    });
			}
					
		});
		
   </script>
</body>
</html>



