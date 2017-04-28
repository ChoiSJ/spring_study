<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/profnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
<div class="container">
	<h1>강의조회</h1>
		<hr class="one">
		<table class="table table-condensed">
				<colgroup>
					<col width="25%">
					<col width="60%">
					<col width="15%">
				</colgroup>
			<thead>
				<tr>
					<th>학생</th>
					<th>과제 제목</th>
					<th>확인</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${pcont}" varStatus="status">
					<tr>
						<td>${item.student.name }</td>
						<td>${item.title }</td>
						<td><a href="/jhta/prof/report/reporttodetail?no=${item.no }"><button class="btn btn-default">확인</button></a></td>
					</tr>
				</c:forEach>					
			</tbody>
		</table>
		<div class="pull-right">
			<a href="/jhta/prof/report/reportinfo" class="btn btn-warning">뒤로</a>
		</div>
	</div>
</body>
</html>