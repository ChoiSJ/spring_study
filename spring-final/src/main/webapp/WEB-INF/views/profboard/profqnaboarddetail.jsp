<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h4><span class="glyphicon glyphicon-th-list"></span>${board.title }</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div class="container">
			<div class="text-center">
				<div>
					${board.contentsForHTML }
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
			<a href="profqnaboard" class="btn btn-default btn-xs">뒤로가기</a>
		</div>
		<hr>
		<div class="row">
				<c:if test="${empty reviewList }">
					<div class="text-center">
						<div class="alert alert-info">댓글이 존재하지 않습니다.</div>
					</div>
				</c:if>
				<c:if test="${!empty reviewList }">
					<c:if test="${param.err eq 'deny' }">
						<div class="text-center">
							<h3 class="text-danger">본인이 작성한 댓글만 삭제할수 있습니다.</h3>
						</div>
					</c:if>
					<c:forEach var="review" items="${reviewList }">
						<div class="well">
							<div class="">
								<strong>${review.writer }</strong>
								<span class="pull-right"><fmt:formatDate value="${review.regdate }"/></span>
							</div>
							<hr>
							<p>${review.contentsForBr }</p>
							<div class="text-right">
								<a href="deleteprofqnaboardreview?rno=${review.no }" class="btn btn-danger btn-xs">삭제</a>
							</div>
						</div>
						<hr>
					</c:forEach>
				</c:if>
			</div>
			<div class="row well">
				<c:if test="${param.err eq 'invalid' }">
					<div class="text-center">
						<h3 class="text-danger">댓글을 작성해 주세요.</h3>
					</div>
				</c:if>
				<form action="profqnaaddreview?bno=${board.no }" method="post">
					<textarea name="reviewContents" rows="7" class="form-control"></textarea>
					<div class="text-right" style="margin-top: 20px;">
						<button type="submit" class="btn btn-primary">등록</button>
					</div>
				</form>
			</div>
	</div>
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>