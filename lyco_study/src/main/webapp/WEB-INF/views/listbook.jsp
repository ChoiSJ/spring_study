<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	.row { margin-top: 50px; }
</style>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<table class="table table-striped">
				<colgroup>
					<col width="40%">
					<col width="30%">
					<col width="30%">
				</colgroup>
				<thead>
					<tr>
						<th>제목</th>
						<th>저자</th>
						<th>발매일</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${bookLists }" var="book">
					<tr>
						<td><a href="detailbook.hta?no=${book.no }">${book.title }</a></td>
						<td>${book.author }</td>
						<td><fmt:formatDate value="${book.regdate }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="text-right">
				<a href="index.hta" class="btn btn-default text-right">메인</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>