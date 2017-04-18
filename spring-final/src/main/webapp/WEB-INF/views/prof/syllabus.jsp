<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<style>
	hr.one{
   width : 100%;
   border: thin solid #1c86ee;
   color: #1c86ee;
}
</style>
<title>강의계획서</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
	<div class="container">
	<h1>강의계획서</h1>
		<hr class="one">
		<table class="table table-condensed">
			<tbody>
				<colgroup>
					<col width="25%">
					<col width="75%">
				</colgroup>
						<tr>
							<th>과목명</th>
							<td>${syno.subname }</td>
						</tr>
						<tr>
							<th>평가기준</th>
							<td><span class="btn btn-primary btn-xs">중간</span> 중간점수 : ${syno.midtrum }% <span class="btn btn-warning btn-xs">기말</span> 기말점수 : ${syno.final1 }% 
							<span class="btn btn-info btn-xs">출석</span> 출석점수 : ${syno.atlen }% <span class="btn btn-danger btn-xs">과제</span> 과제점수 : ${syno.project }%</td>
						</tr>
						<tr>
							<th>성적분포</th>
							<td>${syno.distri }</td>
						</tr>
						<tr>
							<th>과목개요</th>
							<td>${syno.outline }</td>
						</tr>
						<tr>
							<th>강의목표</th>
							<td>${syno.goals }</td>
						</tr>
						<tr>
							<th>강의방법</th>
							<td>${syno.method }</td>
						</tr>
						<tr>
							<th>담당 교수</th>
							<td>${syno.name }</td>
						</tr>
						<tr>
							<th>이메일 주소</th>
							<td>${syno.email }</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${syno.phone }</td>
						</tr>
						<tr>
							<th>주교재</th>
							<td>${syno.book }</td>
						</tr>
						<tr>
							<th>중간고사기간</th>
							<td><fmt:formatDate value="${syno.midst }"/> ~ <fmt:formatDate value="${syno.midend }"/></td>
						</tr>
						<tr>
							<th>기말고사기간</th>
							<td><fmt:formatDate value="${syno.finalst }"/> ~ <fmt:formatDate value="${syno.finalend }"/></td>
						</tr>
						<tr>
							<th>과제물제출기간</th>
							<td><fmt:formatDate value="${syno.prost }"/> ~ <fmt:formatDate value="${syno.proend }"/></td>
						</tr>
						<tr>
							<th>과제물</th>
							<td>${syno.procontent }</td>
						</tr>
						<tr>
							<th>1주차</th>
							<td>${syno.week1 }</td>
						</tr>
						<tr>
							<th>2주차</th>
							<td>${syno.week2 }</td>
						</tr>
						<tr>
							<th>3주차</th>
							<td>${syno.week3 }</td>
						</tr>
						<tr>
							<th>4주차</th>
							<td>${syno.week4 }</td>
						</tr>
						<tr>
							<th>5주차</th>
							<td>${syno.week5 }</td>
						</tr>
						<tr>
							<th>6주차</th>
							<td>${syno.week6 }</td>
						</tr>
						<tr>
							<th>7주차</th>
							<td>${syno.week7 }</td>
						</tr>
						<tr>
							<th>8주차</th>
							<td>${syno.week8 }</td>
						</tr>
						<tr>
							<th>9주차</th>
							<td>${syno.week9 }</td>
						</tr>
						<tr>
							<th>10주차</th>
							<td>${syno.week10 }</td>
						</tr>
						<tr>
							<th>11주차</th>
							<td>${syno.week11 }</td>
						</tr>
						<tr>
							<th>12주차</th>
							<td>${syno.week12 }</td>
						</tr>
						<tr>
							<th>13주차</th>
							<td>${syno.week13 }</td>
						</tr>
						<tr>
							<th>14주차</th>
							<td>${syno.week14 }</td>
						</tr>
						<tr>
							<th>15주차</th>
							<td>${syno.week15 }</td>
						</tr>
			</tbody>
		</table>
		<div class="pull-right">
			<a href="/jhta/prof/syllupdate?no=${syno.no }" class="btn btn-primary">수정</a>
			<a href="/jhta/prof/syllinfo" class="btn btn-warning">뒤로</a>
		</div>
	</div>
</body>
</html>