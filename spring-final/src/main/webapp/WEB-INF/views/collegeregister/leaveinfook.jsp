<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
});
</script>
<style type="text/css">
	th { text-align: center !important;
			vertical-align: middle !important;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="sidebar-hakjuk.jsp" %>
   <div class="container" style="margin-left: 250px; padding-top:25px; ">
    	<div class="row text-right">
			홈 > 학적관리 > 휴학관리 > <strong>휴학 신청 목록</strong> 
		</div>
		<div class="row" style="margin: 0px; padding: 0px;">
			<h4><span class="glyphicon glyphicon-list-alt"></span> 휴학 신청 내역</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
      <div class="row">
      	<div class="col-xs-2">
      		<img src="../resources/images/student/PeoPleDefault.png" alt="person" style="width: 130px; height: 140px;"/>
      	</div>
      	<div class="col-xs-10">
      		<p>학생 정보</p>
        	<table class="table table-bordered">
	        	<colgroup>
	        		<col width="20%" />
	        		<col width="30%" />
	        		<col width="20%" />
	        		<col width="30%" />
	        	</colgroup>
	           	<thead>
	        		<tr>
	        			<th>학적</th>
	        			<td colspan="3">
	        				<c:out value="${student.register }" />
	        			</td>
	        		</tr>
	        		<tr>
	        			<th>이름</th>
	        			<td><c:out value="${student.name }" /></td>
	        			<th>학번</th>
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
	        			<td><c:out value="${student.division}"/></td>
	        			<th>학년</th>
	        			<td><c:out value="${student.grade }"/></td>
	        		</tr>
	        		<tr>
	        			<th>지도교수</th>
	        			<td><c:out value="${student.professor }"/></td>
	        			<th>입학 년도</th>
	        			<td>
	        				<fmt:formatDate value="${student.enterDate }" pattern="yyyy"/>년
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
      	<h4><strong>휴학(연장) 신청 내역</strong></h4>
      	<table class="table table-bordered">
			<thead>
				<tr>
					<th>학년도</th>
					<th>학기</th>
					<th>학과</th>
					<th>학년</th>
					<th>학번</th>
					<th>성명</th>
					<th>학적변동</th>
					<th>신청일자</th>
					<th>복학일자</th>
					<th>결재상태</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty leaveList}">
					<tr>
						<th colspan="13">신청 내역이 없습니다.</th>
					</tr>
				</c:if>
				<c:forEach var="leave" items="${leaveList}">
					<input type="hidden" value="${leave.enrollDate}" id="leaveEnrollDate" />
					<tr>
						<th>${leave.year }</th>
						<th>${leave.period }</th>
						<th>${student.division }</th>
						<th>${student.grade }</th>
						<th>${student.id }</th>
						<th>${student.name }</th>
						<th>${student.register }</th>
						<th>
							<fmt:formatDate value="${leave.enrollDate }" pattern="YYYY-MM-dd"/></th>
						<th>
							<fmt:formatDate value="${leave.reinDate }" pattern="YYYY-MM-dd"/></th>
						<th>
							<c:choose>
								<c:when test="${leave.pass eq 'false' }">
									<input type="hidden" id="leave-Pass" value="false" />
									<font color="red"><strong>미승인</strong></font>
								</c:when>
								<c:when test="${leave.pass eq 'ok' }">
									<input type="hidden" id="leave-Pass" value="false" />
									<font color="blue"><strong>승인</strong></font>
								</c:when>
								<c:otherwise>
									<font color="red"><strong>거절</strong></font>
								</c:otherwise>
							</c:choose>
						</th>	
					</tr>
				</c:forEach>
			</tbody>      	
      	</table>
      </div>
   </div>
</body>
</html>