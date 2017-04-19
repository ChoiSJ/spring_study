<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script type="text/javascript">
  	$(function () {
		$("#college").change(function (event) {
			var dept = $(this).find("option:selected").val();
			$.ajax({
				url: "searchmajor?dept=" + dept,
				dataType: "json",
				type: "POST",
				success: function(data) {
					$("#division").empty();
					for (var i=0; i<data.sitemapList.length; i++) {
						$("#division").append("<option value="+data.sitemapList[i].code+">"+data.sitemapList[i].name+"</option>");	
					}
				}
			});
		});
		
		$("#search-btn").click(function (event) {
			event.preventDefault();
			$("[name='register']").val($("#register").find("option:selected").val());
			if($("#division").find("option:selected").val() != 'not'){
				$("[name='division']").val($("#division").find("option:selected").val());	
			}else{
				$("[name='division']").val('');
			}
			$("[name='grade']").val($("#grade").find("option:selected").val());
			$("[name='sort']").val($("#sort").find("option:selected").val());
			$("[name='q']").val($("#q").val());
			console.log($("[name='register']").val());
			console.log($("[name='sort']").val());
			console.log($("[name='q']").val());
			console.log($("[name='grade']").val());
			$("#search-form").submit();
		});
	});
  </script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="sidebar-hakjuk.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px; ">
		<div class="row text-right">
			홈 > 학적관리 > 사용자 조회 > <strong>학생 정보 조회</strong> 
		</div>
		<div class="row" style="margin: 0px; padding: 0px;">
			<h4><span class="glyphicon glyphicon-list-alt"></span> 학생 정보 조회</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<form action="" method="">
						<div class="row">
							<div class="col-md-1">
								<p>구분 </p>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<select class="form-control" id="register">
										<option value="all">전체</option>	
										<option value="AD">재학</option>
										<option value="LV">휴학</option>
										<option value="DM">제적</option>
										<option value="OU">자퇴</option>
									</select>
								</div>
							</div>			
							<div class="col-md-1">
								<p>대학구분</p>
							</div>
							<div class="col-md-2">
								<select class="form-control" id="college">
									<option>전체</option>
									<c:forEach var="sitemap" items="${sitemapList }">
										<option value="${sitemap.code }">${sitemap.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-1">
								<p>학과구분</p>
							</div>
							<div class="col-md-2">
								<select class="form-control" id="division">
									<option value="not">대학을 선택하세요.</option>
								</select>
							</div>
							<div class="col-md-1">
								<p>학년구분</p>
							</div>
							<div class="col-md-2">
								<select class="form-control" id="grade">
									<option value="0">전체</option>	
									<option value="1">1학년</option>
									<option value="2">2학년</option>
									<option value="3">3학년</option>
									<option value="4">4학년</option>
								</select>
							</div>
						</div>
						<div class="row" style="margin: -10px;">
							<hr>
						</div>
						<div class="row">
							<div class="col-md-2">
								<select class="form-control" id="sort">
									<option value="U_STU_NAME">이름</option>	
									<option value="U_STU_ID">학번</option>
									<option value="U_STU_PHONE">전화번호</option>
								</select>
							</div>
							<div class="col-md-6">
								<input class="form-control" type="text" id="q" placeholder="전화번호로 검색시 '-'을 입력하세요."/>
							</div>
							<div class="col-md-1">
								<button type="submit" class="btn btn-sm btn-primary" id="search-btn"><span class="glyphicon glyphicon-search"></span> 검색</button>
							</div>
						</div>
					</form>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-6">
							<select class="">
								<option>10개 씩 보기</option>
								<option>25개 씩 보기</option>
								<option>50개 씩 보기</option>
							</select>	
						</div>
						<div class="col-md-6 text-right">
							<p>조회된 학생 수 : 5 명</p>
						</div>
					</div>
					<div class="row">
						<table class="table table-striped table-bordered table-hover" id="dataTables-example">
							<thead>
								<tr>
									<th>번호</th>
									<th>구분</th>
									<th>학번</th>
									<th>성명</th>
									<th>학과</th>
									<th>입학 일자</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty studList }">
									<tr class="text-center">
										<td colspan="6">조회된 학생이 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach var="stud" items="${studList }" varStatus="status">
									<tr onclick="location.href='studinfo?id=${stud.id}'" style="cursor: pointer;">
										<td>${status.count }</td>
										<td>${stud.register }</td>
										<td>${stud.id }</td>
										<td>${stud.name }</td>
										<td>${stud.division }</td>
										<td><fmt:formatDate value="${stud.enterDate }" pattern="yyyy-MM-dd"/></td>
									</tr>	
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form action="/jhta/admin/searchstud" method="post" id="search-form">
		<input type="hidden" name="register">
		<input type="hidden" name="division">
		<input type="hidden" name="grade">
		<input type="hidden" name="sort">
		<input type="hidden" name="q">
	</form>
</body>
</html>