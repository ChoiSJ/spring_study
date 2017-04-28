<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="viewport"
	content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="resources/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<script type="text/javascript"
	src="resources/jquery/jquery-3.2.0.min.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<style>
.demo-card-wide.mdl-card {
	width: 1200px;
}

.demo-card-wide>.mdl-card__title {
	color: #fff;
	height:300px;
	 background: url('/jhta/resources/logo/login-logo4.png') center / cover;
	 background-size: 100%;
}

.demo-card-wide>.mdl-card__menu {
	color: #fff;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="row" style="height: 200px"></div>
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-10">
			<div class="demo-card-wide mdl-card mdl-shadow--4dp">
				<div class="mdl-card__title">
					<h2 class="mdl-card__title-text">Welcome</h2>
				</div>
				<div class="mdl-card__supporting-text"><h2 align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아직 강의평가가 이루어지지 않은 강의입니다.</h2></div>
				<div class="mdl-card__actions mdl-card--border">
					<a
						class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect pull-right" href="scoreerror.do">
						되돌아가기 </a>
				</div>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>
</body>
</html>