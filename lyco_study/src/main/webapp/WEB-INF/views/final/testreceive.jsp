<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">학사관리시스템</a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a href="#">사용자관리</a></li>
				<li><a href="#">수강관리</a></li>
				<li><a href="#">페이지관리</a></li>
			</ul>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-2">
			<ul class="nav">
				<li><a href="#">기초정보관리</a></li>
				<li><a href="#">사용자관리</a></li>
				<li><a href="#">교육과정관리</a></li>
				<li><a href="#">증명서관리</a></li>
				<li><a href="#">정보광장관리</a></li>
				<li><a href="#">홈페이지관리</a></li>
				<li><a href="#">커뮤니티관리</a></li>
				<li><a href="#">통계관리</a></li>
			</ul>
		</div>
		<div class="col-sm-10">
			<h4>쪽지관리</h4><hr>
			<div class="btn-group">
				<button type="button" class="btn btn-info" onclick="location.href='testreceive.hta'">받은쪽지</button>
				<button type="button" class="btn btn-info">보낸쪽지</button>
				<button type="button" class="btn btn-info" onclick="location.href='testwrite.hta'">쪽지쓰기</button>
			</div>
			<div class="well">
				<p>읽지 않은 쪽지가 0통이 있습니다. (전체 받은 쪽지 : 0 통)</p>
			</div>
			<table class="table table-bordered well">
				<colgroup>
					<col width="10%">
					<col width="20%">
					<col width="40%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" value=""></th>
						<th>보낸사람</th>
						<th>제목</th>
						<th>첨부</th>
						<th>보낸날짜</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>