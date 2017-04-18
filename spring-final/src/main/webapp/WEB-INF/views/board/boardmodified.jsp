<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#textarea').text($('#contents').val());
	});
</script>
<title></title>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/adminSidebar.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px;">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > 신입학 조회 
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span>공지사항 수정</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;"></div>
		<div class="row">
			<form:form action="modified?bno=${board.no }" enctype="multipart/form-data" commandName="boardForm">
				<div class="form-group">
					<label>제목</label>
					<form:input value="${board.title }" path="title" cssClass="form-control"/>
					<form:errors path="title" cssClass="text-danger"/>
				</div>
				<div class="form-group">
					<label>내용</label>
					<form:textarea id="textarea" path="contents" cssClass="form-control"/>
					<form:errors path="contents" cssClass="text-danger"/>
				</div>
				<div class="form-inline">
					<input style="width: 1120px;" type="file" class="form-control" name="attachFile">
					<button type="submit" class="btn btn-default btn-sm">등록</button>
				</div>
			</form:form>
		</div>
	</div>
	<input type="hidden" id="contents" value="${board.contents }" >
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>