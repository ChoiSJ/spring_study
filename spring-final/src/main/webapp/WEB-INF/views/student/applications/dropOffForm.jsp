<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style type="text/css">
	.show { display: none !important;}
</style>
<script type="text/javascript">
$(function() {	
	
	$("select[name='chageReason']").click(function() {
		var reason = $("select[name='chageReason'] :selected").val();
		$("#change-Reason").val(reason);
	});

	// 신청 제약
	$('form').submit(function() {
		if($('#select-Semester :selected').val() == "") {
			alert("휴학 학기를 선택해주세요");
			$("#select-Semester").focus();
			return false;
		}
		if($("#checkbox-leave:checked").val()) {	
			if($("#leave-Code").val() == $("select[name='chageReason'] :selected").val()) {
				alert("변경 사항은 기존의 사항과 달라야 합니다.");
				$("select[name='chageReason']").focus();
				return false;
			}
		}
		if(($("#leave-Pass").val() == 'false') && ($("#checkbox-leaveHidden").val() == 'false')) {
			alert("미승인 신청내역이 존재합니다.");
			return false;
		}
	});	
	
	// 휴학 일자 자동 입력
	var today = new Date();
	var month = today.getMonth()+1;
	var day = today.getDate();
	var output = today.getFullYear() + '년 ' +
	    (month<10 ? '0' : '') + month + '월 ' +
	    (day<10 ? '0' : '') + day + '일';
	$("#input-today").text(output);
	
	function choCheck(data){
		if(data =='') {	return "";}		
		if(data == '2') {
			if(5<12-month) {var modiDay = today.getFullYear() + 1;
				return modiDay + '년 07월 01일';
			} else {var modiDay = today.getFullYear() + 1;
				return modiDay + '년 01월 01일';
			}
		} 
	}
	
	// 현재 이수 학기 반환하기
	var nowSemester = $("#now-Semester").attr('class');
	function checkNowSemeter(date) {
		if(month<7) {
			if(nowSemester == '1' ) {$("#now-Semester").text('0'); return;
			} else {$("#now-Semester").text('1'); return;}
			if (nowSemester == '2') {$("#now-Semester").text('2'); return;
			} else {$("#now-Semester").text('3'); return;}
			if (nowSemester == '3') {$("#now-Semester").text('4'); return;
			} else {$("#now-Semester").text('5'); return;}
			if (nowSemester == '4') {$("#now-Semester").text('6'); return;
			} else {$("#now-Semester").text('7'); return;
			}return;
		} else {
			if(nowSemester == '1' ) {$("#now-Semester").text('1'); return;
			} else {$("#now-Semester").text('2'); return;}
			if (nowSemester == '2') {$("#now-Semester").text('3'); return;
			} else {$("#now-Semester").text('4'); return;}
			if (nowSemester == '3') {$("#now-Semester").text('5'); return;
			} else {$("#now-Semester").text('6'); return;}
			if (nowSemester == '4') {$("#now-Semester").text('7'); return;
			} else {$("#now-Semester").text('8'); return;
			} return;
		}
	}
	checkNowSemeter();
	
	
	$("#select-Semester").click(function() {
		var outDay = choCheck($(this).val());
		$("#change-BackYear").text(outDay);
		// 복학 예정일을 milliseconds로 넘겨준다.		
		var selectedYear = outDay.substring(0, 4);
		var selectedMonth = outDay.substring(6, 8);
		var selectedDay = outDay.substring(10, 12);
		var selectedDate = new Date(selectedYear +'-'+selectedMonth+'-'+selectedDay);
		var selectInDate = selectedDate.getTime();
		$("#reinDate").val(selectInDate);
	});
	
	$("#change-Enroll").click(function(event) {
		event.preventDefault();
		
		$('form').submit();
	});
	
	$("#checkbox-leave").click(function() {
		if($("#checkbox-leave:checked").val()) {
			$("#checkbox-leaveHidden").val('true');
			$("#change-Leave").css("display", "");
			$("#leave-Enroll").text("변경");
			return;
		} else {
			$("#change-Leave").css("display", "none");
			$("#checkbox-leaveHidden").val('false');
			$("#leave-Enroll").text("신청");
			return;
		}
	});
	$('#drop-Enroll').click(function (event) {
		event.preventDefault();
		if($('[name=reason]').val().trim() == ''){
			alert('자퇴 사유를 작성하여주세요.');
			return false;
		}		
		$('#formActionRoot').submit();
		return;
	})
})
</script>
<style type="text/css">
	th { text-align: center !important;
			vertical-align: middle !important;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
   <div class="container" style="margin-left: 250px; padding-top:25px; ">
    <div class="row text-right">
         홈
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 자퇴 신청</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <div class="row">
      	<div class="col-xs-2">
      		<img src="../resources/images/student/PeoPleDefault.png" alt="person" style="width: 100px; height: 100px;"/>
      	</div>
      	<div class="col-xs-10">
      		<p>나의 정보</p>
        	<table class="table table-bordered">
	        	<colgroup>
	        		<col width="20%" />
	        		<col width="30%" />
	        		<col width="20%" />
	        		<col width="30%" />
	        	</colgroup>
	           	<thead>
	        		<tr>
	        			<th>구분</th>
	        			<td colspan="3" id="register">
	        				<c:out value="${student.cName }" />
	        			</td>
	        		</tr>
	        		<tr>
	        			<th>이름</th>
	        			<td><c:out value="${student.name }" /></td>
	        			<th>아이디</th>
	        			<td><c:out value="${student.id }"/></td>
	        		</tr>
	        		<tr>
	        			<th>주민등록번호</th>
	        			<td><c:out value="${student.ssn }"/></td>
	        			<th>성별</th>
	        			<td>
	        				<c:choose>
	        					<c:when test="${student.gender eq 'M' }">남성</c:when>
	        					<c:when test="${student.gender eq 'F' }">여성</c:when>
	        					<c:otherwise>Other</c:otherwise>
	        				</c:choose>	        			
	        		</tr>
	        		<tr>
	        			<th>전공</th>
	        			<td><c:out value="${student.tName}"/></td>
	        			<th>학년</th>
	        			<td><c:out value="${student.grade }"/></td>
	        		</tr>
	        		<tr>
	        			<th>지도교수</th>
	        			<td><c:out value="${student.professor }"/></td>
	        			<th>입학 년도</th>
	        			<td>
	        				<fmt:formatDate value="${student.enterDate }" pattern="yyyy-MM-dd"/>
	        			</td>
	        		</tr>
	        		<tr>
	        			<th>보호자 성함</th>
	        			<td><c:out value="${student.parentName }"/></td>
	        			<th>보호자 연락처</th>
	        			<td><c:out value="${student.parentPhone }"/></td>
	        		</tr>
	        	</thead>
	        </table>
        </div>
      </div>  
      <div class="row" style="padding: 20px;">
      	<h4>자퇴 신청</h4>
      	<form action="dropoff" method="POST" id="formActionRoot">
	   		<table class="table table-bordered">
	   			<colgroup>
	   				<col width="12%" />
	   				<col width="17%" />
	   				<col width="17%" />
	   				<col width="15%" />
	   				<col width="14%" />
	   				<col width="*" />
	   			</colgroup>
	   			<thead>
	   				<tr>
	   					<th>자퇴 구분</th>
	   					<td>
						    <input type="radio" name="register" value="OU1000" checked="checked"/>자퇴  &nbsp;
	   					</td>
	   					<th>자퇴 신청 일자</th>
	   					<th id="input-today"></th>
	   				</tr>
	   				<tr>
	   					<th>자퇴 사유</th>
	   					<td colspan="3">
	   						<textarea rows="6"name="reason" style="width:100%; resize: none;"></textarea>
	   					</td>
	   				</tr>
	   			</thead>
	   		</table>
	   		<div class="form-group text-center">
			   	<button type="submit" class="btn btn-default" id="drop-Enroll">신청</button>		
	   			<a class="btn btn-default" href="home">취소</a>
	   		</div>
   		</form>
      </div>      
   </div>
</body>
</html>