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
<style>
	.row { margin-top: 50px; }
</style>
<script type="text/javascript">
$(function() {
	var $searchBar = $("#search-bar");
	$searchBar.hide();
	
	$("#search-button").click(function(event) {
		event.preventDefault();
		$searchBar.toggle();
	});
})
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3 text-center well">
			<h3>책 등록 프로그램</h3>
			<a href="addbook.hta" class="btn btn-info">등록</a>
			<a href="" id="search-button" class="btn btn-danger">검색</a>
			<a href="listbook.hta" class="btn btn-success">리스트</a>
		</div>
		<div id="search-bar" class="col-sm-6 col-sm-offset-3 text-center well">
			<form method="post" action="search()">
				<div class="col-sm-4 form-group">
					<select name="search" class="form-control">
						<option value="title">제목</option>
						<option value="description">내용</option>
						<option value="title-description">제목+내용</option>
					</select>
				</div>
				<div class="col-sm-6 form-group">
					<input type="text" name="searchbook" class="form-control">
				</div>
				<div class="col-sm-2 form-group">
					<button id="searchbook-button" type="submit" class="btn btn-default">검색</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>