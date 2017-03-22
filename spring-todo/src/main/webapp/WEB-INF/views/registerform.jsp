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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>회원가입</h1>
	<div class="row well">
		<form:form method="post" action="register.do" commandName="userform">
			<div class="form-group">
				<form:label path="id">아이디</form:label>
				<form:input path="id" cssClass="form-control"/>
				<form:errors path="id" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="pwd">비밀번호</form:label>
				<form:password path="pwd" cssClass="form-control"/>
				<form:errors path="pwd" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="name">이름</form:label>
				<form:input path="name" cssClass="form-control"/>
				<form:errors path="name" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="phone">전화번호</form:label>
				<form:input path="phone" cssClass="form-control"/>
				<form:errors path="phone" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="email">이메일</form:label>
				<form:input path="email" cssClass="form-control"/>
				<form:errors path="email" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group text-right">
				<button type="submit" class="btn btn-primary">가입</button>
				<a href="home.do" class="btn btn-default">취소</a>
			</div>
		</form:form>
	</div>
</div>
</body>
</html>