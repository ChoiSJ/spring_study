<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px;">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > 신입학 조회 
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> 자유 게시판 등록</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;"></div>
		<div class="row">
			<form:form action="addfreeboard" commandName="boardForm">
				<div class="form-group">
					<label>제목</label>
					<form:input path="title" cssClass="form-control"/>
					<form:errors path="title" cssClass="text-danger"/>
				</div>
				<div class="form-group">
					<label>내용</label>
					<form:textarea cols="20" path="contents" cssClass="form-control"/>
					<form:errors path="contents" cssClass="text-danger"/>
				</div>
				<div class="text-right">
					<button type="submit" class="btn btn-default btn-sm">등록</button>
				</div>
			</form:form>
		</div>
	</div>
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>