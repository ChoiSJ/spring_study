<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.off {display: none;}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#extend-btn").click(function() {
		$(".extend-box").toggleClass("off");
	});
})
</script>
</head>
<body>
<div class="container">
	<h1>도서 검색 <button id="extend-btn" class="btn btn-default btn-sm">확장 검색</button></h1>
	<div class="row well">
		<form method="post" action="search.hta">
			<div class="form-group">
				<label>제목</label>
				<input type="text" class="form-control" name="title"/>
			</div>
			<div class="form-group off extend-box" >
				<label>저자</label>
				<input type="text" class="form-control" name="author"/>
			</div>
			<div class="form-group off extend-box">
				<label>출판사</label>
				<input type="text" class="form-control" name="publisher"/>
			</div>
			<div class="form-group">
				<button type="submit" id="search-btn" class="btn btn-default">검색</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>