<%@page import="com.afd.member.space.SpaceMainDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page import="com.afd.member.space.SpaceReservationDTO"%>
<%@page import="com.afd.member.space.SpaceDAO"%>
<%@page import="com.afd.member.space.SpaceImageDTO"%>
<%@page import="com.afd.member.space.SpaceClickInfoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.afd.member.space.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
     
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" type="text/css"  href="counter.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>

</title>

<%@ include file="/inc/asset.jsp"%>

<style type="text/css">
/* 기본스타일  */	
	table{ background-color: #F2F2F2;}
	
	tr{height: 60px;}
	td{width: 100px; text-align: right; font-size: 15pt; font-family: D2coding;}
/* 타이틀 스타일 */
	th#title {font-size: 20pt; font-weight: bold; color: #FFBF00; font-family: D2coding; }

/* 요일 스타일 */
	td.sunday{ text-align: center; font-weight: bold; color: red; font-family: D2coding; }
	td.saturday{ text-align: center; font-weight: bold; color: blue; font-family: D2coding; }
	td.etcday{ text-align: center; font-weight: bold; color: black; font-family: D2coding; }

/* 날짜 스타일 */
	td.sun{ text-align: right; font-size: 15pt; color: red; font-family: D2coding; vertical-align: top;}
	td.sat{ text-align: right; font-size: 15pt; color: blue; font-family: D2coding; vertical-align: top;}
	td.etc{ text-align: right; font-size: 15pt; color: black; font-family: D2coding; vertical-align: top;}
	
	td.redbefore{ text-align: right; font-size: 12pt; color: red; font-family: D2coding; vertical-align: top;}
	td.before{ text-align: right; font-size: 12pt; color: gray; font-family: D2coding; vertical-align: top;}
	
	.reservation-div { width:500px; overflow:auto; margin: 0 auto;  }
	.reservation-table { white-space:nowrap; border-collapse:collapse;}
	.reservation-td { width:80px; height: 60px; border: 1px solid black; }
	.reservation-text { width:80px; height: 60px; text-align: left; padding-top: 30px; margin-left: -5px; background-color: white; }
	.td { background-color: white; }
	.header1 {margin-top: 100px;}
	
	.clicked {
        color: gold;
      }
	
	.qty .count {
    color: #000;
    display: inline-block;
    vertical-align: top;
    font-size: 25px;
    font-weight: 700;
    line-height: 30px;
    padding: 0 2px
    ;min-width: 35px;
    text-align: center;
}
.qty .plus {
    cursor: pointer;
    display: inline-block;
    vertical-align: top;
    color: white;
    width: 30px;
    height: 30px;
    font: 30px/1 Arial,sans-serif;
    text-align: center;
    border-radius: 50%;
    }
.qty .minus {
    cursor: pointer;
    display: inline-block;
    vertical-align: top;
    color: white;
    width: 30px;
    height: 30px;
    font: 30px/1 Arial,sans-serif;
    text-align: center;
    border-radius: 50%;
    background-clip: padding-box;
}
#butt {
    text-align: center;
}
.minus:hover{
    background-color: #717fe0 !important;
}
.plus:hover{
    background-color: #717fe0 !important;
}
/*Prevent text selection*/
span{
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}
#counter{  
    border: 0;
    width: 5%;
}
nput::-webkit-outer-spin-button,
#counter::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
input:disabled{
    background-color:white;
}

#totalpay {
	font-size: 40px; 
	text-align: center;
	margin-left: 500px;
}
	
</style>
</head>
<body>

<%@ include file="/inc/header.jsp" %>
	
	<div class="container">
      
		<h1 class="page-header">예약하기</h1>	
		<%
// 컴퓨터 시스템의 년, 월 받아오기
	Date date = new Date();
	int year = date.getYear() +1900;
	int month = date.getMonth() +1;
	int day = date.getDay() + 1;
	int rentalseq = Integer.parseInt(request.getParameter("rentalseq"));
	int limitperson = Integer.parseInt(request.getParameter("limit"));
	int hourpay = Integer.parseInt(request.getParameter("hourpay"));
	String clicked_id = request.getParameter("id");
	int starttime = 0;
	int endtime = 0;
	int personCount = 0;
	
	ArrayList<Integer> list1 = new ArrayList<Integer>();
	ArrayList<Integer> list2 = new ArrayList<Integer>();
	int index = 0;
	
	SpaceDAO dao = new SpaceDAO();
	SpaceReservationDTO insert_dto = new SpaceReservationDTO();
	
	try{
	//	오류사항 걸러주기	
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));
		day = Integer.parseInt(request.getParameter("day"));
		
		ArrayList<SpaceReservationDTO> list_dto = dao.reservationinfo(rentalseq, year, month, day);
		
		for (int i = 0; i<list_dto.size(); i++) {
			list1.add(list_dto.get(i).getStartdate());
			list2.add(list_dto.get(i).getEnddate() - list1.get(i));
		}
		
		for(int i=0; i<list1.size()-1; i++) {
			for(int j=1; j<list1.size(); j++) {
				if(list1.get(i) > list1.get(j)) {
					int temp = list1.get(i);
					list1.set(i, list1.get(j));
					list1.set(j, temp);
					temp = list2.get(i);
					list2.set(i, list2.get(j));
					list2.set(j, temp);
				}
			}
			
			starttime = list1.get(0);
			endtime = list1.get(list1.size()-1);
		}
		
		if(month>=13){
			year++;
			month =1;
		}else if(month <=0){
			year--;
			month =12;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>

<!-- 달력 만들기 -->
<table width ="700" align ="center" border ="1" cellpadding="5" cellspacing="0">
	<tr>
<!-- 이전달 버튼 만들기 -->
		<th>
		<%-- <a href ="?year=<%=year%>&month=<%month-1%>">이전 달</a> --%>
		<input type="button" value="이전 달" onclick="location.href='?year=<%=year%>&month=<%=month-1%>&rentalseq=<%=rentalseq%>&limit=<%=limitperson%>&hourpay=<%=hourpay%>'">
		</th>
		
<!-- 제목 만들기 -->
		<th id = "title" colspan = "5">
		<%=year%>년  <%=month%>월
		</th>
		
<!-- 다음달 버튼 만들기 -->
		<th>
		<%-- <a href ="?year=<%=year%>&month=<%month+1%>">다음 달</a> --%>
		<input type="button" value="다음 달" onclick="location.href='?year=<%=year%>&month=<%=month+1%>&rentalseq=<%=rentalseq%>&limit=<%=limitperson%>&hourpay=<%=hourpay%>'">
		
		</th>
	</tr>
<!-- 요일 표시칸 만들어주기(단, 토,일요일은 색을 다르게 하기위해 구분해주기) -->
	<tr>
		<td class = "sunday">일</td>
		<td class = "etcday">월</td>
		<td class = "etcday">화</td>
		<td class = "etcday">수</td>
		<td class = "etcday">목</td>
		<td class = "etcday">금</td>
		<td class = "saturday">토</td>
	</tr>
	
<!-- 날짜 집어 넣기 -->
	<tr>
	<%
//	1일의 요일을 계산한다(자주 쓰이기 때문에 변수로 선언해두기)
		int first = Calendar.weekDay(year, month, 1);
	
//	1일이 출력될 위치 전에 전달의 마지막 날짜들을 넣어주기위해 전 달날짜의 시작일을 계산한다.
		int start = 0 ;
		start = month ==1? Calendar.lastDay(year-1, 12)- first : Calendar.lastDay(year, month-1)- first;

//	1일이 출력될 위치를 맞추기 위해 1일의 요일만큼 반복하여 전달의날짜를 출력한다.
		for(int i= 1; i<= first; i++){
			if(i==1){
/* 일요일(빨간색)과 다른날들의 색을 구별주기  */
				out.println("<td class = 'redbefore'>"+(month ==1? 12 : month-1)+"/"+ ++start +"</td>");
			}else{
				out.println("<td class = 'before'>"+(month ==1? 12 : month-1)+"/"+ ++start +"</td>");
				
			}
		}

		/* 1일부터 달력을 출력한 달의 마지막 날짜까지 반복하며 날짜를 출력 */
		for(int i = 1; i <= Calendar.lastDay(year, month); i++){
			/* 요일별로 색깔 다르게 해주기위해 td에 class 태그걸어주기 */
			switch(Calendar.weekDay(year, month, i)){ 
				case 0 : 
					out.println("<td class='sun' id='cal"+i+"'>" + i +"</td>");
					break;
				case 6 :
					out.println("<td class='sat' id='cal"+i+"'>" + i +"</td>");
					break;
				default : 
					out.println("<td class='etc' id='cal"+i+"'>" + i +"</td>");
					break;
			}
			/* 출력한 날짜(i)가 토요일이고 그달의 마지막 날짜이면 줄을 바꿔주기 */
			if(Calendar.weekDay(year, month, i) == 6 && i != Calendar.lastDay(year, month)){
				out.println("</tr><tr>");			
			}
		}
		if(Calendar.weekDay(year, month, Calendar.lastDay(year, month)) !=6){
			for(int i = Calendar.weekDay(year, month, Calendar.lastDay(year, month))+1; i < 7; i++){
				out.println("<td></td>");	
			}
		}
		
	%>
	
	 
	</tr>
     </table>
    	<h1 class="header1"> 시간 예약하기</h1>
     </div><!--fin container  -->
     
      <div class="reservation-div">
			<table class = "reservation-table">
				<tr id="reservation-tr">
					<td><div class="reservation-text" ></div></td>
	  				<% for(int i=1; i<25; i++) { %>
	    			<td><div class="reservation-text" ><%=i %></div></td>
	    			<% } %>
	 			</tr>
	  
	  			<tr id="reservation-tr">
	  				<% for(int i=0; i<24; i++) { 
	    			try {
	    				if(index == list1.size()) {
	    					%>
	    					<td><div class="reservation-td" onclick="reservation(document.getElementById('<%=i %>').id);" id="<%=i %>" style='background-color: #f0f0f0;'>예약가능</div></td>
	    					<%
	    					continue;
	    				}
		    			if(list1.get(index) == i && list2.get(index) != 0) { 
		    				%> <td><div class="reservation-td" style="background-color:#c0c0c0" >예약불가</div></td> <%
		    				
		    				list1.set(index, list1.get(index)+1);
		    				list2.set(index, list2.get(index)-1);
		    				if(list2.get(index) == 0) {
		    					index += 1;
		    				}
		    			} else {
		    				%><td><div class="reservation-td" onclick="reservation(document.getElementById('<%=i %>').id);" id="<%=i %>" style='background-color: #f0f0f0;'>예약가능</div></td><%
		    			}
	  				} catch (Exception e) {
	  					e.printStackTrace();
	  				}
	  			}
	    			%>
	 			</tr>
			</table>
		</div>
		<div class="container" >
		
			<h1>예약일시</h1>
			<span id="reservationText"></span>
		
			<h1 class="header1">총인원수 (최대 <%=limitperson %>명)</h1>
			
			<div class="qty mt-5" id="butt">
	            <span class="minus bg-dark">-</span>
	            <input type="number" class="count" id="counter" name="qty" value="1">
	            <span class="plus bg-dark">+</span>
            </div>
            
            <h1>공간사용료</h1>
            <div><span id="totalpay"></span></div>
            
            <p style="float:right">
	            <form method="POST" action="addok.do">
				<input type="submit" class="btn btn-secondary" style=" width: 100px; height: 50px; float: right;" onclick="action_reservation();" value="예약하기"></button>
					
				<input type="hidden" name="memberseq" id="memberseq">
				<input type="hidden" name="rentalseq" id="rentalseq">
				<input type="hidden" name="purpose" id="purpose">
				<input type="hidden" name="year" id="year">
				<input type="hidden" name="month" id="month">
				<input type="hidden" name="day" id="day">
				<input type="hidden" name="request" id="request">
				<input type="hidden" name="startdate" id="startdate">
				<input type="hidden" name="enddate" id="enddate">
				<input type="hidden" name="personcount" id="personcount">
				<input type="hidden" name="totalpay2" id="totalpay2">
				</form>
            </p>
		</div>
			
     <%@ include file="/inc/footer.jsp" %>
     
   <script>
   /*$(this).rentalseq()  */

  		var time = 0;
   		var totalpay = 0;
   		var counter = document.getElementById("counter");
   		var span_totalpay = document.getElementById("totalpay");
   		var time_list = [];
   		
   		var html_memberseq = document.getElementById("memberseq");
   		var html_rentalseq = document.getElementById("rentalseq");
   		var purpose = document.getElementById("purpose");
   		var html_year = document.getElementById("year");
   		var html_month = document.getElementById("month");
   		var html_day = document.getElementById("day");
   		var html_request = document.getElementById("request");
   		var html_startdate = document.getElementById("startdate");
   		var html_enddate = document.getElementById("enddate");
   		var html_personcount = document.getElementById("personcount");
   		
   		var id = <%=clicked_id%>;
   		$(id).css('background', "yellow");

   		$('#memberseq').val("${memberSeq}");
   		$('#rentalseq').val(<%=rentalseq%>);
   		$('#purpose').val("면접");
   		$('#request').val("알아서 해줘");
   		$('#year').val(<%=year%>);
	   	$('#month').val(<%=month%>);
	   	$('#day').val(<%=day%>);
   		
	   	
	  
   				
   		
   	
	   	
   		$("td.sun").click(function(){
   			location.href="/webproject/main/member/space/booklist.do?memberSeq=${memberSeq}&rentalseq=" + <%=rentalseq %> + "&year=" + <%=year %> + "&month=" + <%=month %> 
   			+ "&day=" + $(this).text() + "&limit=" + <%=limitperson%> + "&hourpay=" + <%=hourpay%>+ "&id=" + $(this).attr('id');
   			y_m_d();
   		});
   		
   		$("td.sat").click(function(){
   			location.href="/webproject/main/member/space/booklist.do?memberSeq=${memberSeq}&rentalseq=" + <%=rentalseq %> + "&year=" + <%=year %> + "&month=" + <%=month %> 
   			+ "&day=" + $(this).text() + "&limit=" + <%=limitperson%> + "&hourpay=" + <%=hourpay%> + "&id=" + $(this).attr('id');
   			y_m_d();
  
   		});
   		
   		
   		$("td.etc").click(function(){
   			location.href="/webproject/main/member/space/booklist.do?memberSeq=${memberSeq}&rentalseq=" + <%=rentalseq %> + "&year=" + <%=year %> + "&month=" + <%=month %> 
   			+ "&day=" + $(this).text() + "&limit=" + <%=limitperson%> + "&hourpay=" + <%=hourpay%> + "&id=" + $(this).attr('id');
   			y_m_d();
   			
   		});
   		
   		
   		
   		function reservation(id1) {
   			var html = document.getElementById(id1);
   			var num_id = parseInt(id1);
   			

   			if(time_list. indexOf(num_id) != -1) {
   				time_list = time_list.filter((element) => element != num_id);
   			}
   			else { time_list.push(num_id); }
   			
   			time_list.sort();
   			
   			if(html.style.background == "red") {
   				html.style.background = "#f0f0f0";
   				time -= 1;
   			} else {
   				html.style.background = "red";
   				time += 1;
   			}
   			cal_pay();
   			change_reservationText();
   			
   		}
   		
   		function cal_pay() {
   			totalpay = counter.value * <%=hourpay%> * time;
   			$('#personcount').val(counter.value);
   			$('#totalpay2').val(totalpay);
   			span_totalpay.innerHTML = totalpay + "원";
   		}
   		
   		function change_reservationText() {
   			if(time_list.length != 0) {
   				document.getElementById("reservationText").innerHTML = <%=year%> + "년 " + <%=month%> + "월"
   							+ <%=day%> + "일" + time_list[0] + ":00 ~ " + (time_list[time_list.length-1]+1) + ":00";

   				$('#startdate').val(time_list[0]);
   				$('#enddate').val(time_list[time_list.length-1]+1);
   			} else {
   				document.getElementById("reservationText").innerHTML = "";
   			}
   		}
   		
   		
   		function action_reservation() {
   			var index_check = 0;
   			
   			if(time_list.length == 0) {
   				alert("시간을 선택해 주세요!");
   				return;
   			}
   			
	   		for (var i=time_list[0]; i<time_list[time_list.length-1]; i++) {
	   			if (time_list[index_check] != i) {
	   				alert("연속으로 예약해 주세요");
	   				return;
	   			} else {
	   				index_check += 1;
	   			}
	   		}
	   		
	   	 	 if (!confirm("예약 하시겠습니까? ")) {
	            alert("예약이 취소 되었습니다.");
	        } else {
	            alert("정상적으로 예약 되었습니다");
	        } 
	   	 	 
   		}//fin reservation
   		
   		function y_m_d() {
   			$('#year').val(<%=year%>);
   	   		$('#month').val(<%=month%>);
   	   		$('#day').val(<%=day%>);
   		}
   		
   		/* counter 버튼*/
   		$(document).ready(function(){
   			var html = document.getElementById("counter");
		    $('.count').prop('disabled', true);
   			$(document).on('click','.plus',function(){
				$('.count').val(parseInt($('.count').val()) + 1 );
				cal_pay();
    		});
        	$(document).on('click','.minus',function(){
    			$('.count').val(parseInt($('.count').val()) - 1 );
    				if ($('.count').val() == 0) {
						$('.count').val(1);
					}
    				cal_pay();
    	    	});
 		});
   		
	</script>
</body>
</html>



