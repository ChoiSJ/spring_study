<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	$("#submit-button").click(function(event) {
		$disabled = $(":input.form-control").attr("disabled");
		
		if ($disabled) {
			event.preventDefault();
			$("#submit-button").attr("form", "book-update")
				.removeClass("btn-default").addClass("btn-success");
			$(":input.form-control").attr("disabled", false);
			//$("#reset-button").attr("form", "book-update");
		} else {
			$("#submit-button").submit();
		}
	});
})
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="panel panel-success">
				<div class="panel-heading text-center">
					<h4>책 상세정보</h4>
				</div>
				<div class="panel-body">
					<form id="book-update" method="post" action="updatebook.hta">
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="title" class="form-control" value="${book.title }" disabled="disabled">
						</div>
						<div class="form-group">
							<label>저자</label>
							<input type="text" name="author" class="form-control" value="${book.author }" disabled="disabled"/>
						</div>
						<div class="form-group">
							<label>출판사</label>
							<input type="text" name="publisher" class="form-control" value="${book.publisher }" disabled="disabled"/>
						</div>
						<div class="form-group">
							<label>가격</label>
							<input type="number" name="price" class="form-control" value="${book.price }" disabled="disabled"/>
						</div>
						<div class="form-group">
							<label>설명</label>
							<textarea rows="5" name="description" class="form-control" disabled="disabled">${book.description }</textarea>
						</div>
						<div class="form-group">
							<label>발매일</label>
							<input type="date" name="regdate" class="form-control" disabled="disabled" 
							value='<fmt:formatDate pattern="yyyy-MM-dd" value="${book.regdate }"/>'/>
						</div>
						<input type="hidden" name="no" value="${book.no }">
					</form>
				</div>
				<div class="panel-footer text-right">
					<button id="submit-button" class="btn btn-default">수정</button>
					<button id="reset-button" class="btn btn-info" type="reset">초기화</button>
					<button class="btn btn-default" onclick="history.back()">리스트</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>