<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
					<form action="" method="get" id="semi-form">
						<div class="row">
							<div class="col-md-1">
								<p>구분 </p>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<select class="form-control">
										<option value="">전체</option>	
										<option value="">재학</option>
										<option value="">휴학</option>
										<option value="">복학</option>
										<option value="">제적</option>
									</select>
								</div>
							</div>
							<div class="col-md-1">
								<p>대학구분</p>
							</div>
							<div class="col-md-2">
								<select class="form-control">
									<option value="">공과 대학</option>	
									<option value="">자연 대학</option>
									<option value="">사회 대학</option>
									<option value="">상경 대학</option>
									<option value="">인문 대학</option>
								</select>
							</div>
							<div class="col-md-1">
								<p>학과구분</p>
							</div>
							<div class="col-md-2">
								<select class="form-control">
									<option value="">전체</option>	
									<option value="">전자공학과</option>
									<option value="">정보통신공학과</option>
									<option value="">컴퓨터공학과</option>
									<option value="">일본어학과</option>
									<option value="">영문학과</option>
									<option value="">사회복지학과</option>
								</select>
							</div>
							<div class="col-md-1">
								<p>학년구분</p>
							</div>
							<div class="col-md-2">
								<select class="form-control">
									<option value="">전체</option>	
									<option value="">1학년</option>
									<option value="">2학년</option>
									<option value="">3학년</option>
									<option value="">4학년</option>
								</select>
							</div>
						</div>
						<div class="row" style="margin: -10px;">
							<hr>
						</div>
						<div class="row">
							<div class="col-md-2">
								<select class="form-control">
									<option value="">이름</option>	
									<option value="">학번</option>
									<option value="">전화번호</option>
								</select>
							</div>
							<div class="col-md-6">
								<input class="form-control" type="text" name="q" placeholder="전화번호로 검색시 '-'을 생략하여 입력하세요."/>
							</div>
							<div class="col-md-1">
								<button type="submit" class="btn btn-sm btn-primary"><span class="glyphicon glyphicon-search"></span> 검색</button>
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
								<tr onclick="location.href='studinfo?id=1'" style="cursor: pointer;">
									<td>1</td>
									<td>신입학</td>
									<td>11100210</td>
									<td>김철수</td>
									<td>정보통신공학과</td>
									<td>2017-03-02</td>
									
								</tr>
								<tr onclick="location.href='studinfo?id=2'" style="cursor: pointer;">
									<td>2</td>
									<td>신입학</td>
									<td>11100220</td>
									<td>이영희</td>
									<td>전자공학과</td>
									<td>2017-03-02</td>
								</tr>
								<tr onclick="location.href='studinfo?id=3'" style="cursor: pointer;">
									<td>3</td>
									<td>신입학</td>
									<td>11100230</td>
									<td>안철수</td>
									<td>간호학과</td>
									<td>2017-03-02</td>
								</tr>
								<tr>
									<td>4</td>
									<td>신입학</td>
									<td>11100240</td>
									<td>김유신</td>
									<td>전쟁학과</td>
									<td>2017-03-02</td>
								</tr>
								<tr>
									<td>5</td>
									<td>신입학</td>
									<td>11100250</td>
									<td>이순신</td>
									<td>해양생물학과</td>
									<td>2017-03-02</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>