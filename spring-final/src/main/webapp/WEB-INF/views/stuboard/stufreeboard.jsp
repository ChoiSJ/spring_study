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
<style type="text/css">
   th { 
   	  text-align: center !important;
      vertical-align: middle !important;
      }
   td{
   	  text-align: center !important;
      vertical-align: middle !important;
   }
</style>
<script type="text/javascript">
	$(function() {
		
		function searchFormSet (pageNo){
			pageNo = pageNo || 1;
			$('#search-form :input[name="pageNo"]').val(pageNo);
			$(':input[name="searchType"]').val($('select[name="searchType"]').val());
			$('#keyword').val($('.form-inline :input[name="keyword"]').val());
			$(':input[name="display"]').val($('select[name="searchCount"]').val());
			
		}
		$("ul.pagination li > a").click(function(event) {
			event.preventDefault();
			var pageNo = $(this).attr("id").replace("navi-", "");
			searchFormSet(pageNo);
			$("#search-form").submit();
		});
	});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px;">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > 신입학 조회 
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> 자유 게시판</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;"></div>
		<div class="row">
			<table class="table table-default">
				<colgroup>
					<col width="5%">
					<col width="*">
					<col width="5%">
					<col width="10%">
					<col width="5%">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardList }">
						<tr>
							<td>${board.no }</td>
							<td><a href="studboarddetail?bno=${board.no }">${board.title }</a></td>
							<td>${board.writer }</td>
							<td> <fmt:formatDate value="${board.regdate }"/> </td>
							<td>${board.countView }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center">
				<%@ include file="/WEB-INF/views/board/nav.jsp" %>
			</div>
			<div class="text-right">
				<a href="addfreeboard" class="btn btn-primary btn-sm">등록</a>
			</div>
		</div>
	</div>
	<form id="search-form" action="stufreeboard" method="post">
		<input type="hidden" name="pageNo" value="1">
		<input type="hidden" name="searchType"  value="${serch.searchType }">
		<input id="keyword" type="hidden" name="keyword" value="${search.keyword }" >
		<input type="hidden" name="display"  value="10">
	</form>
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>