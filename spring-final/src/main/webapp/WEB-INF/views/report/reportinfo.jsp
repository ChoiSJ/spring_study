<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
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
				<col width="10%">
				<col width="35%">
				<col width="35%">
				<col width="10%">
				<col width="10%">				
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>과목명</th>
					<th>과제명</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${pList}" varStatus="status">
					<tr>
						<td>${status.count } </td>
						<td><a href="/jhta/prof/report/reportdetail?no=${item.enroll.no }">${item.subject.subjectName }</a></td>
						<td>${item.title }</td>
						<td><a href="/jhta/prof/report/reportupdate?no=${item.no }" class="btn btn-primary btn-xs">수정</a></td>
						<td><a href="/jhta/prof/report/delreport?no=${item.no }" class="btn btn-danger btn-xs">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="add text-right">
			<a href="/jhta/prof/report/reportform"><button class="btn btn-primary btn-xs">등록</button></a>
		</div>
	</div>
</body>
</html>