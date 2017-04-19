<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<h4><span class="glyphicon glyphicon-th-list"></span> 학과 게시판</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;"></div>
		<div class="row text-center">
			<table class="table table-striped">
				<colgroup>
					<col width="5%">
					<col width="5%">
					<col width="*%">
					<col width="5%">
					<col width="10%">
					<col width="5%">
				</colgroup>
				<thead>
					<tr>
						<td>
							<input type="checkbox" id="allCheck">
						</td>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>날짜</td>
						<td>조회수</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardList }">
					<tr>
						<td>
							<input type="checkbox" id="deleteCheck-${board.no }">
						</td>
						<td>${board.no }</td>
						<td><a href="detail?bno=${board.no }">${board.title }</a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.regdate }"/> </td>
						<td>${board.countView }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center">
				<%@ include file="/WEB-INF/views/board/nav.jsp" %>
			</div>
		</div>
		<div class="text-right">
			<a href="profboardform" class="btn btn-primary btn-sm">글 작성하기</a>
		</div>
	</div>
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>