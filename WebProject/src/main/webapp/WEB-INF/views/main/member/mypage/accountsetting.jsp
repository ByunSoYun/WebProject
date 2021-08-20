<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

<%@ include file="/inc/asset.jsp"%>

<style>
#pw, #newPw, {
	width: 200px;
}

#nickname {
	width: 150px;
}

#name, #postnumber {
	width: 100px;
}

#postnumber {
	margin-right: 10px;
}

#firstRegistrationNumber, #secondRegistrationNumber, #tel1, #tel2, #tel3 {
	width: 100px;
}

#address {
	width: 450px;
}

.pw, .pw2, .nickname, .name, .registrationNumber, .fff, .tel, .ggg, .address, .hhh, .email, .iii {
	display: flex;
}

.fff span, .tel span {
	margin-left: 10px;
	margin-right: 10px;
}

.hhh {
	margin-bottom: 10px;
}

.aaaa {
	position: relative;
	border: 3px solid #EEE;
	width: 800px;
	left: 250px;
	top: -563px;
	padding: 15px;
}
</style>
</head>
<body>

	<%@ include file="/inc/header.jsp" %>

	<div class="container">
      
		<h1 class="page-header">마이페이지 - 계정설정</h1>
		
		<div class="a">
			<div class="b">
					<div><i class="bi bi-person-circle" style="font-size: 40px;"></i></div>
					<div>${list.name}</div>
					<div>${list.email}</div>
					<div>${list.tel}</div>
				<input type="button" value="프로필" name="profile" class="btn btn-primary" onclick="location.href='/webproject/main/member/mypage/myprofile.do';" />
			</div>
			<div class="c">
				<a href="/webproject/main/member/mypage/chart/chart.do"><div class="myComment">내가 쓴 게시글</div></a>
				<div>채용 공고</div>
				<div>공간대여 내역</div>
				<div>스터디 모임</div>
			</div>
			<div class="d">
				<div>스크랩 내역</div>
				<div>
					<span>커뮤니티</span>
					<span>${comScrapCount.comScrapCount}</span>
				</div>
				<div>
					<a href="/webproject/main/member/mypage/myscrap/qnalist.do"><span>Q&A</span></a>
					<span>${qnaScrapCount.qnaScrapCount}</span>
				</div>
				<div>
					<span>정기모임/스터디</span>
					<span>${studyScrapCount.studyScrapCount}</span>
				</div>
				<div>
					<span>채용공고</span>
					<span>${jobPostScrapCount.jobPostScrapCount}</span>
				</div>
				<div>
					<span>공간대여</span>
					<span>${spaceScrapCount.spaceScrapCount}</span>
				</div>
			</div>
			<div class="e">
				<a href="/webproject/main/member/mypage/accountsetting.do"><span>계정설정</span></a>
			</div>
		</div>
		
			<form action="/webproject/main/member/mypage/accountsettingedit.do" method="POST" name="join">
				<div class="aaaa">
					<div class="pw" style="margin-bottom: 15px; border-bottom: 2px solid #EEE; padding: 10px;">
						<div style="margin-right: 15px;">기존 비밀번호</div>
						<div>
							<input type="password" name="pw" id="pw" class="form form-control" />
						</div>
					</div>
					<div class="newPw" style="margin-bottom: 15px; border-bottom: 2px solid #EEE; padding: 10px; display: flex;">
						<div style="margin-right: 15px;">새 비밀번호</div>
						<div>
							<input type="password" name="newPw" id="newPw" class="form form-control" />
						</div>
					</div>
					<div class="nickname" style="margin-bottom: 15px; border-bottom: 2px solid #EEE; padding: 10px;">
						<div style="margin-right: 15px;">닉네임</div>
						<div>
							<input type="text" name="nickName" id="nickname" class="form form-control" value="${list.nickName}" />
						</div>
					</div>
					
					<div class="name" style="margin-bottom: 15px; border-bottom: 2px solid #EEE; padding: 10px;">
						<div style="margin-right: 15px;">이름</div>
						<div>
							<input type="text" name="name" id="name" class="form form-control" value="${list.name}" />
						</div>
					</div>
					
					<div class="registrationNumber" style="margin-bottom: 15px; border-bottom: 2px solid #EEE; padding: 10px;">
						<div style="margin-right: 15px;">주민번호</div>
						<div class="fff">
							<input type="text" name="firstRegistrationNumber" id="firstRegistrationNumber" class="form form-control" value="${fn:substring(list.registrationNumber, 0, 6)}" />
							 <span>-</span> 
							 <input type="password" name="secondRegistrationNumber" id="secondRegistrationNumber" class="form form-control" value="${fn:substring(list.registrationNumber, 7, 14)}" />
						</div>
					</div>
					
					<div class="tel" style="margin-bottom: 15px; border-bottom: 2px solid #EEE; padding: 10px;">
						<div style="margin-right: 15px;">전화번호</div>
						<div>
							<div class="ggg">
								<select name="tel1" id="tel1" class="form form-control">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
								</select>
								<span>-</span>
								<input type="number" name="tel2" id="tel2" class="form form-control" />
								<span>-</span>
								<input type="number" name="tel3" id="tel3" class="form form-control" />
							</div>
						</div>
					</div>
					
					<div class="address" style="margin-bottom: 15px; border-bottom: 2px solid #EEE; padding: 10px;">
						<div style="margin-right: 15px;">주소</div>
						<div>
							<div class="hhh">
								<span style="margin-right: 15px;">
									<input type="text" id="sample6_postcode" placeholder="우편번호" class="form form-control" name="postNumber">
								</span>
								<span><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="btn btn-primary"><br></span>
							</div>
							<input type="text" id="sample6_address" placeholder="주소" class="form form-control" style="width: 500px;" name="address1"><br>
							<div style="display: flex;">
								<input type="text" id="sample6_detailAddress" placeholder="상세주소" class="form form-control" style="width: 260px; margin-right: 15px;" name="address2">
								<input type="text" id="sample6_extraAddress" placeholder="참고항목" class="form form-control" style="width: 260px;" name="address3">
							</div>
						</div>
					</div>
					
					<div class="email" style="margin-bottom: 15px; border-bottom: 2px solid #EEE; padding: 10px;">
						<div style="margin-right: 15px;">이메일</div>
						<div class="iii">
							<input type="text" name="email" id="email" class="form form-control" />
							<span style="margin-left: 15px; margin-right: 15px;">@</span>
							<input type="text" name="domain" id="domain" class="form form-control" style="margin-right: 10px;" value="" disabled />
							<select name="selectDomain" id="selectDomain" class="form form-control" onchange="email_change(this.form)">
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="yahoo.co.kr">yahoo.co.kr</option>
								<option value="nate.com">nate.com</option>
								<option value="yahoo.co.kr">yahoo.co.kr</option>
								<option value="">직접 입력</option>
							</select>
						</div>
					</div>
					
					<div>
						<button type="submit" value="저장하기" class="btn btn-primary">저장하기</button>
						<button type="button" value="돌아가기" class="btn btn-default" onclick="history.back();">돌아가기</button>
					</div>
				</div>
			</form>
		
   </div>
   
   <%@ include file="/inc/footer.jsp" %>
   <%@ include file="/inc/init.jsp" %>
   
   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   
   <script>
      
   		$("#tel1").val("${fn:substring(list.tel, 0, 3)}")
   		$("#tel2").val("${fn:substring(list.tel, 4, 8)}")
   		$("#tel3").val("${fn:substring(list.tel, 9, 13)}")
   		$("#email").val("${fn:substring(list.email, 0, fn:indexOf(list.email, '@'))}")
   		$("#domain").val("${fn:substring(list.email, fn:indexOf(list.email, '@') + 1, fn:length(list.email))}")
   		$("#selectDomain").val("${fn:substring(list.email, fn:indexOf(list.email, '@') + 1, fn:length(list.email))}")
   		$("#sample6_postcode").val("${fn:substring(list.address, fn:length(list.address) - 5, fn:length(list.address))}")
   		$("#sample6_address").val("${fn:substring(list.address, 0, fn:indexOf(list.address, ','))}");
   		$("#sample6_detailAddress").val("${fn:substring(list.address, fn:indexOf(list.address, ',') + 2, fn:indexOf(list.address, '(') - 1)}");
   		$("#sample6_extraAddress").val("${fn:substring(list.address, fn:indexOf(list.address, '('), fn:indexOf(list.address, ')') + 1)}");
   		
   		
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
   		
   		function email_change(form) {
			
   			var value = form.selectDomain[form.selectDomain.selectedIndex].value;
   			
   			if (value != "") {
   				
   				form.domain.disabled = true;
   				form.domain.value = value;
   				
   			} else {
   				
   				form.domain.disabled = false;
   				
   			}
   			
   			form.domain.value = value;
   			form.domain.focus();
   			
   			return;
   			
		}
   		
   </script>
</body>
</html>



