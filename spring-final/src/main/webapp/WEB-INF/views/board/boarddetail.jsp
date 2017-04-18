<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<%@ include file="/WEB-INF/views/navi/adminSidebar.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px;">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > 신입학 조회 
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span>${board.title }</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div class="container">
			<div class="text-center">
				<div>
					${board.contents }
				</div>
				<c:if test="${!empty board.fileName }">
					<hr>
					<div>
						<img src="../resources/images/board/${board.fileName }">
					</div>
				</c:if>
			</div>
		</div>
		<div class="text-right">
			<a href="modified?bno=${board.no }" class="btn btn-danger btn-xs">수정</a>
			<a href="board" class="btn btn-default btn-xs">뒤로가기</a>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>