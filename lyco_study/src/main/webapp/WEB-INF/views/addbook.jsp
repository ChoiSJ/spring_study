<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	.row { margin-top: 50px; }
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2 well">
			<form:form method="post" action="addbook.hta" commandName="book">
				<div class="form-group">
					<form:label path="title">제목</form:label>
					<form:input path="title" cssClass="form-control"></form:input>
				</div>
				<div class="form-group">
					<form:label path="author">저자</form:label>
					<form:input path="author" cssClass="form-control"></form:input>
				</div>
				<div class="form-group">
					<form:label path="publisher">출판사</form:label>
					<form:input path="publisher" cssClass="form-control"></form:input>
				</div>
				<div class="form-group">
					<form:label path="price">가격</form:label>
					<form:input path="price" cssClass="form-control"></form:input>
				</div>
				<div class="form-group">
					<form:label path="description">설명</form:label>
					<form:textarea rows="5" path="description" cssClass="form-control"></form:textarea>
				</div>
				<div class="form-group text-right">
					<form:button Class="btn btn-info">등록</form:button>
					<a href="index.hta" class="btn btn-default">취소</a>
				</div>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>