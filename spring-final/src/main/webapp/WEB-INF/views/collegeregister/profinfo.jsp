<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
	<%@include file="sidebar-hakjuk.jsp"%>
	<div class="container" style="margin-left: 250px; padding-top: 25px;">
		<div class="row text-right">
			홈 > 학적관리 > 사용자 조회 > <strong>교수 정보 조회</strong>
		</div>
		<div class="row">
			<h4>
				<span class="glyphicon glyphicon-th-list"></span> 교수 상세 정보
			</h4>
			<hr style="border: solid 0.5px #2C7BB5;">
		</div>
		<div class="row">
			<div class="col-xs-2">
				<img src="/jhta/resources/images/student/PeoPleDefault.png" alt="person" style="width: 130px; height: 140px;" />
			</div>
			<div class="col-xs-10">
				<p>기본 정보</p>
				<table class="table table-bordered">
					<colgroup>
						<col width="20%" />
						<col width="30%" />
						<col width="20%" />
						<col width="30%" />
					</colgroup>
					<thead>
						<tr>
							<th>구분</th>
							<td>교수</td>
							<th>재직 상태</th>
							<td>${prof.register }</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>${prof.name }</td>
							<th>교번</th>
							<td>${prof.id }</td>
						</tr>
						<tr>
							<th>주민등록번호</th>
							<td>${prof.ssn }</td>
							<th>성별</th>
							<td>
								<c:if test="${prof.gender eq 'M' }">
									남
								</c:if>
								<c:if test="${prof.gender eq 'F' }">
									여
								</c:if>
							</td>
						</tr>
						<tr>
							<th>전공</th>
							<td>${prof.division }</td>
							<th>직위</th>
							<td>${prof.grade }</td>
						</tr>
					</thead>
				</table>
			</div>
		</div>

		<div class="row">
			<p>[추가 정보]</p>
			<table class="table table-bordered">
				<colgroup>
					<col width="10%" />
					<col width="10%" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>개인</th>
						<th>휴대폰</th>					
						<td>${prof.phone }</td>
						<th>이메일</th>
						<td>
							<div class=row>
								<div class="col-xs-4">
									${prof.email }
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<th rowspan="4">자택</th>
						<th rowspan="2">주소</th>
						<td colspan="3">
							<div class="row">
								<div class="col-md-10">
									${prof.addr } 
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3"></td>
					</tr>
				</tbody>
			</table>
			<div class="text-right">
				<a href="searchprof" class="btn btn-primary"><span class="glyphicon glyphicon-th-large"></span> 목록으로</a>
			</div>
		</div>			
	</div>
</body>
</html>