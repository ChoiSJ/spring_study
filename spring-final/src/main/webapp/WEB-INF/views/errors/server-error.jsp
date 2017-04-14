<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>error page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
	<div class="jumbotron">
		<h1>서버 에러</h1>
		<div class="alert alert-danger">
			<strong>에러 메세지</strong> <%=exception.getMessage() %>
			<p>
			<%
				for (StackTraceElement el : exception.getStackTrace()) {
			%>
				<p><%=el.toString() %></p>
			<%
			}
			%>
			</p>
		</div>
		<p class="text-right">
			<a href="testmain" class="btn btn-default btn-lg">HOME</a>
			
		</p>
	</div>
</div>	
</body>
