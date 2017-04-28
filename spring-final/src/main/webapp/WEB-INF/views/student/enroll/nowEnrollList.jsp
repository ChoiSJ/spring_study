<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
         	홈 > 수강 과목
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 수강 과목</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
         <div class="row" style="margin: 10px;">
	      <!-- <form action="enrollCancle" method="POST"> -->
	      	<table class="table table-bordered">
	      		<colgroup>
	      			<col width="13%" />
	      			<col width="*" />
	      			<col width="11%" />
	      			<col width="5%" />
	      			<col width="10%" />
	      			<col width="10%" />
	      			<col width="10%" />
	      			<col width="10%" />
	      			<col width="6%" />
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
	      				<th>재수강 여부</th>
	      				<th>학점</th>
	      				<th>강의 계획서</th>
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
	      					<th>X</th>	<!-- 재수강 여부 -->
	      					<th>${regisub.subject.score }</th>	<!-- 학점 -->
	      					<th><a href="" class="btn btn-default">출 력</a></th>
	      				</tr>
	      			</c:forEach>
	      		</tbody>
	      	</table>
	    <!-- </form> -->
      	<div class="row text-center" style="padding: 20px;">
      		<hr />
      		<p><font size="4;">현재 신청 학점 <span id="applyScore">${applyScore}</span> / 최대 신청 학점 <span id="maxOneScore">${student.maxOneScore}</span></font></p>
      	</div>
      </div>
    </div>
</body>
</html>