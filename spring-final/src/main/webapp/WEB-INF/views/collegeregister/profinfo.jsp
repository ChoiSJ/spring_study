<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<img src="resources/images/photo.jpg" alt="person"
					style="width: 130px; height: 140px;" />
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
							<td colspan="3">학부생</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>학습자</td>
							<th>아이디</th>
							<td>1234</td>
						</tr>
						<tr>
							<th>주민등록번호</th>
							<td>1234-5678</td>
							<th>성별</th>
							<td>남/여</td>
						</tr>
						<tr>
							<th>전공</th>
							<td>경영</td>
							<th>학년</th>
							<td>1</td>
						</tr>
						<tr>
							<th>기타1</th>
							<td>1</td>
							<th>기타2</th>
							<td>1</td>
						</tr>
					</thead>
				</table>
			</div>
		</div>

		<div class="row">
			<p>연락처 정보</p>
			<table class="table table-bordered">
				<colgroup>
					<col width="10%" />
					<col width="10%" />
					<col width="*" />
				</colgroup>
				<thead></thead>
				<tbody>
					<tr>
						<th rowspan="2">개인</th>
						<th>휴대폰</th>
						<td><input type="text" /> <a href="" class="btn btn-default">수정</a>
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" /> <a href="" class="btn btn-default">수정</a>
						</td>
					</tr>
					<tr>
						<th rowspan="6">자택</th>
						<th rowspan="3">주소</th>
						<td><input type="text" /> <a href="" class="btn btn-default">우편번호
								검색</a></td>
					</tr>
					<tr>
						<td><input type="text" /></td>
					</tr>
					<tr>
						<td><input type="text" /> <a href="" class="btn btn-default">수정</a>
						</td>
					</tr>
					<tr>
						<th>전화</th>
						<td><input type="text" /> <a href="" class="btn btn-default">수정</a>
						</td>
					</tr>
					<tr>
						<th>보호자 성함</th>
						<td>홍길동</td>
					</tr>
					<tr>
						<th>보호자 연락처</th>
						<td><input type="text" /> <a href="" class="btn btn-default">수정</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>