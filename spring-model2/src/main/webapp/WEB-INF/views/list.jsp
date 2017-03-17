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
<div class="container">
	<h1>도서 전체 목록</h1>
	<table class="table table-condensed table-striped">
		<colgroup>
			<col width="20%">
			<col width="*">
			<col width="20%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${bookList} }">
			<tr>
				<td>${book.id }</td>
				<td>${book.title} }</td>
				<td>${book.author }</td>
				<td>${book.publisher }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div class="row text-right">
		<a href="searchform.hta" class="btn btn-primary btn-sm">책 찾기</a>
		<a href="addform.hta" class="btn btn-primary btn-sm">책 등록</a>
	</div>
</div>
</body>
</html>