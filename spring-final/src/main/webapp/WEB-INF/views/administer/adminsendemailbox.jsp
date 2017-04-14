<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarsubject.jsp" %>
<div class="container" style="margin-left: 250px; padding-top: 25px;">
	<form method="post" action="">
		<div class="row" style="margin-bottom: 15px;">
			<div class="col-sm-12">
				<div class="btn-group">
					<a href="adminsendemailbox" class="btn btn-info">받은쪽지</a>
					<a href="adminrecievemailbox" class="btn btn-info">보낸쪽지</a>
					<a href="adminsendemail" class="btn btn-info">쪽지쓰기</a>
				</div>			
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-bordered">
					<colgroup>
						<col width="70%">
						<col width="30%">
					</colgroup>
					<tbody>
						<tr>
							<td style="vertical-align: middle;">
								읽지 않은 쪽지가 0통이 있습니다. 전체 받은 쪽지 (0통)
							</td>
							<td class="text-right">
								<button class="btn btn-default">선택삭제</button>
								<button class="btn btn-default">전체삭제</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<p>받은쪽지</p>
				<table class="table table-bordered">
					<colgroup>
						<col width="5%">
						<col width="10%">
						<col width="*">
						<col width="15%">
						<col width="15%">
					</colgroup>
					<thead>
						<tr>
							<th>
								<input type="checkbox" name="">
							</th>
							<th>보낸사람</th>
							<th>제목</th>
							<th>첨부</th>
							<th>보낸날짜</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="checkbox" name="">
							</td>
							<td>임요환</td>
							<td>삼연벙 괜찮았음?</td>
							<td>sample.jsp</td>
							<td>2017-4-12</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row text-center">
			<div class="col-sm-12">
				<ul class="pagination">
					<li><a href="#"><span aria-hidden="true">&laquo;</span></a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#"><span aria-hidden="true">&raquo;</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
</html>