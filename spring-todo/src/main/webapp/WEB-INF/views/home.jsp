<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="jumbotron">
		<h1>일정 관리 프로그램</h1>
		<p>회원 가입, 로그인, 일정 등록 및 수정 기능을 지원하는 프로그램입니다.</p>
		
		<c:choose>
			<c:when test="${empty LOGIN_USER }">
				<p class="text-right">
					<a href="register.do" class="btn btn-info">회원가입</a>
					<a href="login.do" class="btn btn-default">로그인</a>
				</p>
			</c:when>
			<c:otherwise>
				<p class="text-right">
					<a href="todo.do" class="btn btn-info">일정보기</a>
					<a href="addtodo.do" class="btn btn-default">일정등록</a>
					<a href="logout.do" class="btn btn-default">로그아웃</a>
				</p>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>