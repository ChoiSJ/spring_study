<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript">
	$(function(){
		
		function searchFormSet (pageNo){
			pageNo = pageNo || 1;
			$('#search-form :input[name="pageNo"]').val(pageNo);
			$(':input[name="searchType"]').val($('select[name="searchType"]').val());
			$('#keyword').val($('.form-inline :input[name="keyword"]').val());
			$(':input[name="display"]').val($('select[name="searchCount"]').val());
			$('input[name="searchBoardType"]').val($('select[name="searchBoardType"]').val());
			
		}
		
		$('#search-btn').click(function(event){
			event.preventDefault();
			searchFormSet();
			
			console.log($('#search-form :input[name="pageNo"]').val());
			console.log($(':input[name="searchType"]').val());
			console.log($('#keyword').val());
			console.log($(':input[name="display"]').val());
			console.log($('input[name="searchBoardType"]').val());
			
			$('#search-form').submit();
			
		});
		
		$('select[name="searchCount"]').change(function(){
			searchFormSet();
			$('#search-form').submit();
		});
		
		$("ul.pagination li > a").click(function(event) {
			event.preventDefault();
			var pageNo = $(this).attr("id").replace("navi-", "");
			searchFormSet(pageNo);
			$("#search-form").submit();
		});
		
		$('#allCheck').click(function(){
			if ($(this).is(":checked")){
				$(':input[id^="delete"]').prop('checked', 'checked');
			}else {
				$(':input[id^="delete"]').prop('checked', '');
			}
		});
		
		$('#delete-btn').click(function(){
			$(':input[id^="delete"]').each(function(){
				if ($(this).is(':checked')) {
					var $tr = $(this).parent().parent();
					var boardNo = $(this).attr('id').replace('deleteCheck-', '');
					$.ajax({
						type:"post",
						url: "homeboard/delete",
						data: {no:boardNo},
						dataType:'json',
						success : function(data){
							$tr.remove();
							window.location.replace("http://localhost/jhta/admin/homeboard");
						}
					});
				}
			});
		});
		
		$('select[name="searchBoardType"]').change(function(){
			var type = $(this).val();
			var $tbody = $('tbody');
 			var searchtype = $(':input[name="searchType"]').val();
			var keyword = $('#keyword').val();
			var display = $(':input[name="display"]').val();
			$('#search-form :input[name="pageNo"]').val(1);
			searchFormSet();
			$tbody.empty();
			
			$.ajax({
				type:"post",
				url:'homeboard.json',
				data:{BoardType:type,pageNo: 1,searchType: searchtype, searchKeyword : keyword, Display : display},
				dataType:'json',
				success : function(data){
					console.log(data);
					$(data.pagiNation).each(function(index, item){
						var htmlContent = "<tr>";
							htmlContent += "<td><input type='checkbox' id='deleteCheck-"+item.no+"'</td>";
							htmlContent += "<td>"+item.no+"</td>";
							htmlContent += "<td><a href='detail?bno="+item.no+"'>"+item.title+"</a></td>";
							htmlContent += "<td>"+item.writer+"</td>";
							htmlContent += "<td>"+item.regdate+"</td>";
							htmlContent += "<td>"+item.countView+"</td>";
							htmlContent += "</tr>";
						
						$tbody.append(htmlContent);
					});
				}
			});
			
		});
	});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/adminSidebar.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px;">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > 신입학 조회 
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> 홈페이지 게시판 관리</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;"></div>
		<div class="row">
			<div class="form-inline">
				<label style="margin-right: 50px;">관리할 게시판 선택</label>
				<select class="form-control" name="searchBoardType">
					<option value="N" ${search.searchBoardType eq 'N' ? 'selected=selected' : '' }>공지사항</option>
					<option value="M" ${search.searchBoardType eq 'M' ? 'selected=selected' : '' }>1:1 문의</option>
					<option value="Q" ${search.searchBoardType eq 'Q' ? 'selected=selected' : '' }>Q&amp;A</option>
				</select>
			</div>
		</div>
		<hr>
		<div class="row">
			<form class="form-inline">
				<select style="margin-right: 30px;" class="form-control input-sm" name="searchCount">
					<option value="5" ${search.display eq 5 ? 'selected=selected' : '' }>5개씩 보기</option>
					<option value="10" ${search.display eq 10 ? 'selected=selected' : '' }>10개씩 보기</option>
					<option value="30" ${search.display eq 30 ? 'selected=selected' : '' }>30개씩 보기</option>
					<option value="50" ${search.display eq 50 ? 'selected=selected' : '' }>50개씩 보기</option>
				</select>
				<div class="pull-right">
					<select name="searchType" class="form-control input-sm">
						<option value="title" ${search.searchType eq 'title' ? 'selected=selected' : '' }>제목</option>
						<option value="name" ${search.searchType eq 'name' ? 'selected=selected' : '' }>이름</option>
						<option value="contents" ${search.searchType eq 'contents' ? 'selected=selected' : '' }>내용</option>
					</select>
					<input type="text" class="form-control input-sm" name="keyword">
					<button id="search-btn" class="btn btn-primary btn-sm">검색</button>
				</div>
			</form>
		</div>
		<div class="row">
			<table class="table">
				<colgroup>
					<col width="5%">
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
				<%@include file="nav.jsp" %>
			</div>
			<a id="delete-btn" href="javascript:;" class="btn btn-danger btn-sm">선택삭제</a>
		</div>
	</div>
	<form id="search-form" action="homeboard" method="post">
		<input type="hidden" name="pageNo" value="1">
		<input type="hidden" name="searchType"  value="${serch.searchType }">
		<input id="keyword" type="hidden" name="keyword" value="${search.keyword }" >
		<input type="hidden" name="display"  value="${search.display }">
		<input type="hidden" name="searchBoardType" value="${search.searchBoardType }">
	</form>
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>