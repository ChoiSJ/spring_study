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
	$(function(){
		$("#profno1").hide();
		if($("#reportPass").val()) {
			alert("동일한 과목의 과제가 존재합니다.");
		}
	})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/profnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
<input type="text" value="${param.reportPass }" id="reportPass"/>
	<div class="container">
		<h1>새 과제등록하기</h1>
		<hr class="one">
		<div class="row well">
			<form:form method="post" action="/jhta/prof/report/reportform" modelAttribute="reportform" enctype="multipart/form-data">
				<div class="form-group">
					<label>강의 선택</label>
					<form:select path="enrollno" cssClass="form-control" selected="">
						<c:forEach var="enroll" items="${pList }" varStatus="status">
							<form:option id="enroll-${status.count }" value="${enroll.enroll.no }">${enroll.subject.subjectName }</form:option>							
						</c:forEach>
					</form:select>			
				</div>
				<div class="form-group" id="profno1">
					<form:input type="hidden" cssClass="form-control" path="profno" value="${prof.no }"/>
				</div>
				<div class="form-group">
					<label>과제 제목</label>
					<form:input cssClass="form-control" path="title" />
				</div>
				<div class="form-group">
					<label>과제 내용</label>
					<form:textarea path="content" rows="5" cssClass="form-control" value=""/>
				</div>
				<div class="form-group">
					<label>과제제출 시작일</label>
					<form:input type="date" path="prost" cssClass="form-control" value=""/>
				</div>
				<div class="form-group">
					<label>과제제출 종료일</label>
					<form:input type="date" path="proend" cssClass="form-control" value=""/>
				</div>
				<div class="form-group">
					<label>과제제출 종료일</label>
					<form:input type="file" path="file" cssClass="form-control" value=""/>
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