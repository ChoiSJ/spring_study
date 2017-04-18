<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$("#sele").selected("#pass-0").val();
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
	<div class="container">
		<h1>새 강의등록하기</h1>
		<hr class="one">
		<div class="row well">
			<form:form method="post" action="/jhta/prof/addsubform" modelAttribute="subjackform">
				<div class="form-group">
					<label>과목명</label>
					<form:input cssClass="form-control" path="subjectName" />
				</div>
				<div class="form-group">
					<label>담당 교수</label>
					<form:input path="professor" cssClass="form-control" value="${prof.id }"/>
				</div>
				<div class="form-group">
					<label>학과코드</label>
					<form:input path="code" cssClass="form-control" value="${prof.code }"/>
					<form:errors path="code" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>학기 선택</label>
					<form:select path="selectNo" cssClass="form-control" selected="">
						<c:forEach var="semester" items="${semeList }" varStatus="status">
							<form:option id="semester-${status.count }" value="${semester.no }">${semester.semeSelect }</form:option>							
						</c:forEach>
					</form:select>			
				</div>
				<div class="form-group">
					<label>학년</label>
					<form:input path="grade" type="number" cssClass="form-control"/>
					<form:errors path="grade" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>이수구분</label>
					<form:select path="isPassed" id="sele" cssClass="form-control" selected="">
						<c:forEach var="pass" items="${passList }" varStatus="status">
							<form:option id="pass-${status.count }" value="${pass.code }">${pass.isPassedName }</form:option>							
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label>학점</label>
					<form:input path="score" type="number" cssClass="form-control"/>
					<form:errors path="score" cssClass="text-danger"></form:errors>
				</div>
				
				<div class="form-group text-right">
					<button type="submit" class="btn btn-primary">등록</button>
					<a href="/jhta/prof/main" class="btn btn-warning">취소</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>