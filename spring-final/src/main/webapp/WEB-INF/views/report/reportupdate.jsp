<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(function(){
		$("#content1").text($("#content2").text());
		$("#prost").val($("#prost1").text());
		$("#proend").val($("#proend1").text());
		
		console.log($("#prost").val());
	})
		

</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/profnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
	<div class="container">
		<h1>과제수정하기</h1>
		<hr class="one">
		<div class="row well">
			<form:form method="post" action="/jhta/prof/report/reportupdate?no=${pre.no }" modelAttribute="reportform">
				<div class="form-group">
					<form:input type="hidden" cssClass="form-control" path="enrollno"/>			
				</div>
				<div class="form-group" id="profno1">
					<form:input type="hidden" cssClass="form-control" path="profno" value="${pre.professor.no }"/>
				</div>
				<div class="form-group">
					<label>과제 제목</label>
					<form:input cssClass="form-control" path="title" value="${pre.title }" />
				</div>
				<div class="form-group">
					<label>과제 내용</label>
					<span id="content2" style="display:none;">${pre.content }</span>
					<form:textarea path="content" rows="5" cssClass="form-control" id="content1"/>
				</div>
				<div class="form-group">
					<label>과제물 제출시작날짜</label>
					<span id="prost1" style="display:none;"><fmt:formatDate value='${pre.prost}' pattern='yyyy-MM-dd'/></span>	
					<form:input id="prost" path="prost" type="date" cssClass="form-control"/>
					<form:errors path="prost" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과제물 제출종료날짜</label>
					<span id="proend1" style="display:none;"><fmt:formatDate value='${pre.proend}' pattern='yyyy-MM-dd'/></span>	
					<form:input id="proend" path="proend" type="date" cssClass="form-control"/>
					<form:errors path="proend" cssClass="text-danger"></form:errors>
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