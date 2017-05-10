<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#select-dept").change(function() {
		var dept = $(this).val();
		
		if(dept=="") {
			$("#select-major").empty();
			return false;
		}
		
		$.ajax({
			url: "enrollSubjectSearch?dept=" + dept,
			dataType: "json",
			type: "POST",
			success: function(data) {
				$("#select-major").empty();
				
				for (var i=0; i<data.length; i++) {
					$("#select-major").append("<option value="+data[i].code+">"+data[i].name+"</option>");
				}
			}
		});
	});
	
	// 깜빡이 이벤트
	setInterval(function(){
	    $(".blinkEle").toggle();
	  }, 1000);
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
         	홈 > 과제 관리
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 과제 관리</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <hr />
         <div class="row">
	      	<table class="table table-bordered">
	      		<colgroup>
	      			<col width="13%" />
	      			<col width="*" />
	      			<col width="11%" />
	      			<col width="5%" />
	      			<col width="10%" />
	      			<col width="10%" />
	      			<col width="10%" />
	      			<col width="6%" />
	      			<col width="10%" />
	      			<col width="10%" />
	      		</colgroup>
	      		<thead>
	      			<tr>
	      				<th>과목 코드</th>
	      				<th>과목명</th>
	      				<th>이수구분</th>
	      				<th>학년</th>
	      				<th>담당교수</th>
	      				<th>강의시간</th>
	      				<th>강의요일</th>
	      				<th>학점</th>
	      				<th>과제 확인</th>
	      				<th>제출 여부</th>
	      			</tr>
	      		</thead>
	      		<tbody id="enrolled">
	      			<c:forEach var="regisub" items="${regisubList }">
	      				<c:if test="${empty regisubList }">
	      					<tr>
	      						<th colspan="10">수강 신청 내역이 없습니다.</th>
	      					</tr>
	      				</c:if>
	      				<tr>
	      					<th>${regisub.subject.siteCode.code }-${regisub.subject.no }</th>
	      					<th>${regisub.subject.subjectName }</th>	<!-- 과목명 -->
	      					<th>${regisub.subject.passed.passedName }</th>
	      					<th>${regisub.subject.grade }</th>	<!-- 학년 -->
	      					<th>${regisub.subject.professor.name }</th>	<!-- 담당교수 -->
	      					<th>${regisub.enroll.enrollTime }</th>	<!-- 강의 시간 -->
	      					<th>${regisub.enroll.enrollDay }</th>	<!-- 강의 요일-->
	      					<th>${regisub.subject.score }</th>	<!-- 학점 -->
	      					<th>
	      						<c:choose>
	      							<c:when test="${regisub.isNewReport eq ('true') || regisub.show eq ('true')}">
			      						<a href="ReportHome?eno=${regisub.enroll.no}"><font color="red"><span class="blinkEle">New</span></font></a>
	      							</c:when>
	      							<c:otherwise>
	      								예정
	      							</c:otherwise>
	      						</c:choose>
	      					</th>
	      					<th>
	      						<c:choose>
	      							<c:when test="${regisub.show eq ('true') }">
	      								<font color="blue">제출</font>
	      							</c:when>
	      							<c:otherwise>
	      								<font color="red">미제출</font>
	      							</c:otherwise>
	      						</c:choose>
	      					</th>
	      				</tr>
	      			</c:forEach>
	      		</tbody>
	      	</table>
	      </div>
	    <div class="row text-center" style="padding: 20px;">
	      	<hr />
      		<p><font size="4;">현재  수강 학점 : <span id="applyScore">${applyScore}</span></font></p>
    	</div>
    </div>
</body>
</html>