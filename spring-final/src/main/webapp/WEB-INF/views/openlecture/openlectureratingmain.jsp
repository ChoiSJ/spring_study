<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="viewport"
	content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/navi/profnavi.jsp" %>
	<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top: 25px;">
		<div class="row text-right">홈 > 휴강 보강 관리</div>
		<div style="height: 80px"></div>
		<div class="row">
		<div class="col-sm-1"></div>
			<div class="col-sm-5" align="center">
				<a href="openratingregister.do" class="thumbnail"> <img
					src="/jhta/resources/images/lecture/lectureopen.png" width="100%"
					height="100%"> <label><font size="6px">등&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;록&nbsp;&nbsp;&nbsp;</font></label>
				</a>
			</div>
			<div class="col-sm-5" align="center">
				<a href="openLectureTableAll.do" class="thumbnail"> <img
					src="/jhta/resources/images/lecture/search2.png" alt="..."
					width="40%" height="50%"> <label><font size="6px">조&nbsp;&nbsp;회&nbsp;/&nbsp;삭&nbsp;&nbsp;제</font></label>
				</a>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
</body>
</html>