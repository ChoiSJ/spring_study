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
	<form method="post" action="" class="form-inline">
	<div class="row">
		<div class="col-sm-12">
			<h4>학생별 수강신청관리</h4><hr>
			<table class="table table-bordered">
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				<tbody>
					<tr>
						<td><label>학기검색</label></td>
						<td>
							<select class="form-control" name="">
								<option value="#">학과</option>
								<option value="">일어일문</option>
								<option value="">중어중문</option>
								<option value="">컴퓨터공학</option>
								<option value="">물리</option>
							</select>
							<select class="form-control" name="">
								<option value="">전체학기</option>
								<option value="">2017-2</option>
								<option value="">2017-1</option>
								<option value="">2016-2</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label>개별검색</label></td>
						<td>
							<input type="radio" name=""> 이름
							<input type="radio" name=""> 학번
							<input type="text" name="">
							<button type="submit" class="btn btn-sm btn-success">조회하기</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div><br>
	<div class="row">
		<div class="col-sm-12">
			<p><strong>검색 0건</strong></p>
			<table class="table table-bordered">
				<colgroup>
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="*">
					<col width="10%">
					<col width="5%">
					<col width="5%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead class="table-active">
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>소속</th>
						<th>교과목명</th>
						<th>년도/학기</th>
						<th>분반</th>
						<th>학점</th>
						<th>이수구분</th>
						<th>신청일</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>20062222</td>
						<td>홍진호</td>
						<td>컴퓨터공학</td>
						<td>Java의 이해</td>
						<td>2017/1</td>
						<td>1</td>
						<td>3</td>
						<td>전공필수</td>
						<td>2017-2-22</td>
						<td class="text-center">
							<a href="" class="btn btn-xs btn-default">삭제</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row text-center">
		<div class="col-sm-12">
			<ul class="pagination">
				<li><a href=""><span aria-hidden="true">&laquo;</span></a></li>
				<li><a href="">1</a></li>
				<li><a href="">2</a></li>
				<li><a href="">3</a></li>
				<li><a href="">4</a></li>
				<li><a href="">5</a></li>
				<li><a href=""><span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</div>
	</div>
	</form>
</div>
</body>
</html>