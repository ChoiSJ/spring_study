<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Employee Search Page</title>
<link type="text/css" rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="resources/jquery/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
	function setSearchFormField(pageNo) {
		pageNo = pageNo || 1;
		$("#search-form :input[name='pageNo']").val(pageNo);
		
		var rows = $("select[name='rows']").val();
		$("#search-form :input[name='display']").val(rows);
		
		var opt = $("#origin-search-form select[name='opt']").val();
		$("#search-form :input[name='opt']").val(opt);
		
		var keyword = $("#origin-search-form :input[name='keyword']").val();
		$("#search-form :input[name='keyword']").val(keyword)
		
		var arr = $("button:has('.glyphicon')").filter(".btn-success").attr("id").split("-");
		$("#search-form :input[name='sort']").val(arr[0]);
		$("#search-form :input[name='orderby']").val(arr[1]);

	}
	
	$("select[name='rows']").change(function() {
		setSearchFormField();
		
		/*
		// 지금 선택된 보기 갯수를 hidden 필드에 설정
		var rows = $(this).val();
		$(":input[name='display']").val(rows);
		// 무조건 1페이지로 hidden 필드에 설정
		//$("input[name='pageNo']").val(1);
		*/
		
		$("#search-form").submit();
	});
	
	$("ul.pagination li > a").click(function(event) {
		event.preventDefault();
		
		var pageNo = $(this).attr("id").replace("navi-", "");
		setSearchFormField(pageNo);
		
		/*
		// 지금 선택한 페이지번호를 hidden 필드에 설정
		$("input[name='pageNo']").val(pageNo);
		// 지금 선택된 보기 갯수를 hidden 필드에 설정
		var rows = $("select[name='rows']").val();
		$(":input[name='display']").val(rows);
		*/
		
		$("#search-form").submit();
	});
	
	$("button:has('.glyphicon')").click(function() {
		$("button:has('.glyphicon')").removeClass("btn-success").addClass("btn-default");
		$(this).addClass("btn-success").removeClass("btn-default");
		
		setSearchFormField(1);
		$("#search-form").submit();
	});
})
</script>
</head>
<body>
<div class="container">
	<h1>사원 조회</h1>
	<div class="row pull-right">
		<select name="rows" class="form-control" style="width: 200px;">
			<option value="5" ${search.display eq 5 ? 'selected=selected' : '' }> 5개씩 보기</option>
			<option value="10" ${search.display eq 10 ? 'selected=selected' : '' }> 10개씩 보기</option>
			<option value="20" ${search.display eq 20 ? 'selected=selected' : '' }> 20개씩 보기</option>
			<option value="50" ${search.display eq 50 ? 'selected=selected' : '' }> 50개씩 보기</option>
		</select>
	</div>	
	<div class="row">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>
						사원번호 
						<button type=button class="btn btn-success btn-xs" id="employee_id-asc">
							<span class="glyphicon glyphicon-sort-by-order" aria-hidden="true"></span>
						</button>
						<button type=button class="btn btn-default btn-xs" id="employee_id-desc">
							<span class="glyphicon glyphicon-sort-by-order-alt" aria-hidden="true"></span>
						</button>
					</th>
					<th>
						이름 
						<button type=button class="btn btn-default btn-xs" id="first_name-asc">
							<span class="glyphicon glyphicon-sort-by-alphabet" aria-hidden="true"></span>
						</button>
						<button type=button class="btn btn-default btn-xs" id="first_name-desc">
							<span class="glyphicon glyphicon-sort-by-alphabet-alt" aria-hidden="true"></span>
						</button>
					</th>
					<th>부서명</th>
					<th>직종</th>
					<th>전화번호</th>
					<th>
						급여
						<button type=button class="btn btn-default btn-xs" id="salary-asc">
							<span class="glyphicon glyphicon-sort-by-order" aria-hidden="true"></span>
						</button>
						<button type=button class="btn btn-default btn-xs" id="salary-desc">
							<span class="glyphicon glyphicon-sort-by-order-alt" aria-hidden="true"></span>
						</button>
					</th>
					<th>커미션</th>
					<th>입사일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="emp" items="${employees }">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.name }</td>
					<td>${emp.dept }</td>
					<td>${emp.job }</td>
					<td>${emp.phone }</td>
					<td>${emp.salary }</td>
					<td>${emp.comm }</td>
					<td><fmt:formatDate value="${emp.hiredate }"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="row text-center">
		<c:set var="link" value="search.do"></c:set>
		<%@ include file="common/navi.jsp" %>
	</div>
	<div class="row text-center">
		<form id="origin-search-form" class="form-inline">
			<div class="form-group">
				<label class="sr-only"></label>
				<select name="opt" class="form-control">
					<option value="dept" ${search.opt eq 'dept' ? 'selected=selected' : '' }>부서번호</option>
					<option value="job" ${search.opt eq 'job' ? 'selected=selected' : '' }>직종</option>
					<option value="name" ${search.opt eq 'name' ? 'selected=selected' : '' }>사원명</option>
					<option value="salary" ${search.opt eq 'salary' ? 'selected=selected' : '' }>급여</option>
				</select>
			</div>
			<div class="form-group">
				<label class="sr-only">검색어</label>
				<input type="text" name="keyword" class="form-control" value="${search.keyword }">
			</div>
			<button type="submit" class="btn btn-info">검색</button>
		</form>
	</div>
	<form id="search-form" action="search.do">
		<input type="hidden" name="pageNo" value="1">
		<input type="hidden" name="opt" value="">
		<input type="hidden" name="keyword" value="">
		<input type="hidden" name="display" value="10">
		<input type="hidden" name="sort" value="employee_id">
		<input type="hidden" name="orderby" value="asc">
	</form>
</div>
</body>
</html>