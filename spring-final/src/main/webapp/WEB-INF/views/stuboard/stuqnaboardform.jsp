<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title></title>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px;">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > 신입학 조회
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> Q&amp;A 등록</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;"></div>
		<div class="row well">
			<form:form action="stuqnaboardform" commandName="boardForm">
				<select class="form-control" name="subjectSelect">
					<c:forEach var="sub" items="${subjectName }">
						<option value="${sub.subjectCode }">${sub.subjectName }</option>
					</c:forEach>
				</select>
				<div class="form-group">
					<label>제목</label>
					<form:input path="title" cssClass="form-control"/>
					<form:errors path="title" cssClass="text-danger"/>
				</div>
				<div class="form-group">
					<label>내용</label>
					<form:textarea path="contents" cssClass="form-control"/>
					<form:errors path="contents" cssClass="text-danger"/>
				</div>
				<div class="form-inline">
					<button type="submit" class="btn btn-default btn-sm">등록</button>
				</div>
			</form:form>
		</div>
	</div>
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>