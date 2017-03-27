<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>새 일정 등록하기</h1>
     
	<div class="row well">
		<form:form method="post" action="addtodo.do" modelAttribute="todoForm" enctype="multipart/form-data">
			<div class="form-group">
           		<label>제목</label>
           		<form:input path="title" cssClass="form-control"/>
				<form:errors path="title" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>날짜</label>
  				<form:input type="date" path="eventDate" cssClass="form-control"/>
				<form:errors path="eventDate" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>내용</label>
				<form:textarea path="description" cssClass="form-control"/>
				<form:errors path="description" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>약도</label>
				<form:input path="uploadFile" type="file" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label>첨부파일</label>
				<form:input path="attachFile" type="file" cssClass="form-control"/>
			</div>
			<div class="form-group text-right">
				<button type="submit" class="btn btn-primary">등록</button>
  				<a href="home.do" class="btn btn-warning">취소</a>
			</div>
		</form:form>
	</div>
</div>   
</body>
</html>