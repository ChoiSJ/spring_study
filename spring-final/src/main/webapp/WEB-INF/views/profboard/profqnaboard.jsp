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
<title></title>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px;">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > 신입학 조회 
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> Q&amp;A 게시판</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;"></div>
		<div class="row well">
			<form class="form-inline">
				<label style="width: 200px;">검색</label>
				<select name="searchType" class="form-control input-sm">
					<option value="title" ${search.searchType eq 'title' ? 'selected=selected' : '' }>제목</option>
					<option value="name" ${search.searchType eq 'name' ? 'selected=selected' : '' }>이름</option>
					<option value="contents" ${search.searchType eq 'contents' ? 'selected=selected' : '' }>내용</option>
				</select>
				<input value="${param.keyword }" style="width: 400px;" type="text" name="keyword" class="form-control input-sm" />
				<a id="search-btn" href="javascript:;" type="submit" class="btn btn-primary btn-sm">검색</a>
			</form>
		</div>
		<div class="row text-center">
			<table class="table table-striped">
			<colgroup>
				<col width="5%">
				<col width="15%">
				<col width="*">
				<col width="5%">
				<col width="10%">
				<col width="5%">
			</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>과목명</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>