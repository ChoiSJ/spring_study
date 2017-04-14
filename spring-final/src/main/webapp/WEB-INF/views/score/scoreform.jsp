<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarscore.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top: 25px;">
	<h3>성적 수정</h3>
	<hr style="border:solid 0.5px #2C7BB5;">
		<div class="row">
			<form:form class="form-group" action="scoreform.do" method="post" modelAttribute="scoreupdate">
				<form:input path="no" cssClass="form-control" value="${score.no }" type="hidden"/>
				<div class="form-group">
					<label>학점</label>
					<form:input path="credit" cssClass="form-control" value="${score.credit }"/>
				</div>
				
				<div class="form-group">
					<label>등급</label>
					<form:input path="grade" cssClass="form-control" value="${score.grade }"/>
				</div>	
				
				<div class="form-group">
					<label>과제</label>
					<form:input path="reportScore" cssClass="form-control" value="${score.reportScore }"/>
				</div>
				
				<div class="form-group">
					<label>출석</label>
					<form:input path="attScore" cssClass="form-control" value="${score.attScore }"/>
				</div>	
				
				<div class="form-group">
					<label>중간</label>
					<form:input path="midtermScore" cssClass="form-control" value="${score.midtermScore }"/>
				</div>	
				
				<div class="form-group">
					<label>기말</label>
					<form:input path="endtermScore" cssClass="form-control" value="${score.endtermScore }"/>
				</div>
				<div class="text-right">
					<button type="submit" class="btn btn-defalut">등록</button>
					<a href="scorelist.do" class="btn btn-defalut">취소</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>