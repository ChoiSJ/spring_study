<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
	<%@ include file="/WEB-INF/views/navi/adminSidebar.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px;">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > 신입학 조회 
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> 전체 공지사항 관리</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;"></div>
		<div class="row well">
			<form class="form-inline">
				<label style="width: 200px;">검색</label>
				<select name="searchType" class="form-control input-sm">
					<option value="title">제목</option>
					<option value="name">이름</option>
					<option value="contents">내용</option>
					<option value="id">아이디</option>
				</select>
				<input style="width: 400px;" type="text" name="keyword" class="form-control input-sm" />
				<button type="submit" class="btn btn-default btn-sm">검색</button>
			</form>
		</div>
		<div class="row">
			<div class="form-inline">
				<select name="searchCount" class="form-control input-sm">
					<option value="5">5개씩 보기</option>
					<option value="10">10개씩 보기</option>
					<option value="30">30개씩 보기</option>
					<option value="50">50개씩 보기</option>
				</select>
				<a href="javascript:;" class="btn btn-default btn-sm">선택삭제</a>
				<a href="boardform" class="btn btn-default btn-sm pull-right">공지사항 작성</a>
			</div>
		</div>
		<div class="row">
			<table class="table">
				<colgroup>
					<col width="5%">
					<col width="*">
					<col width="10%">
					<col width="10%">
					<col width="5%">
				</colgroup>
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="allCheck">
						</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<input type="checkbox">
						</td>
						<td>
							제목 테스트입니다.
						</td>
						<td>
							어드민
						</td>
						<td>
							2017-04-13
						</td>
						<td>
							0
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>