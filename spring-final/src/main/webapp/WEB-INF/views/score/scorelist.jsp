<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#att_Btn").click(function() {
			$('#attDataBox').empty();
			$('#attDataBox').append('<label>홍길동 디지털코드 출석정보</label><div class="progress"><div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;" id="attDataBar">60%</div></div>');			
		});
	});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarscore.jsp" %>
	<!-- 성적/과제/출결 현황 리스트 -->
	<div class="container" style="margin-left: 250px; padding-top: 25px;">
		<div class="panel panel-heading">
		<h3>성적관리</h3>
		<hr style="border:solid 0.5px #2C7BB5;">		                            	   

		<form class="form-group" method="post" action="">
			<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#score" aria-controls="score" role="tab" data-toggle="tab" aria-expanded="true">성적</a></li>
					<li role="presentation"><a href="#attendance" aria-controls="attendance" role="tab" data-toggle="tab" aria-expanded="false">출결</a></li>
					<li role="presentation"><a href="#report" aria-controls="report" role="tab" data-toggle="tab" aria-expanded="false">과제현황</a></li>
			</ul>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="score">
					<table class="table table-condensed">
						<tbody>
							<tr>
								<td bgcolor="#dceef3" style="color: #333; width: 10%; vertical-align: middle; height: 30px;"><strong>조회</strong></td>
								<td bgcolor="#f0fcff">
									과정구분: 
									<select>
										<option value="">재학생</option>
										<option value="">계절학기</option>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									이름:
									<input type="text"/>
								</td>
								<td bgcolor="#f0fcff">
									학기:
									<select>
										<c:forEach var="semesterlist" items="${semesterlist }">
											<option value="${semesterlist.no }">${semesterlist.semeSelect }</option>
										</c:forEach>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									<button class="btn btn-default btn-xs" type="submit">조회하기</button>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="panel panel-body">
						<table class="table table-condensed">
							<thead>
								<tr bgcolor="#f0fcff">
									<th>수강번호</th>
									<th>이름</th>
									<th>학번</th>
									<th>학기</th>
									<th>과목명</th>
									<th>학점</th>
									<th>등급</th>
									<th>과제</th>
									<th>출석</th>
									<th>중간</th>
									<th>기말</th>
									<th>수정</th>
								</tr>
							</thead>
							<tbody>
								<tr style="text-align: left;">
								<c:forEach var="scorelist2" items="${scorelist2 }">
									<td>${scorelist2.no}</td>
									<td>${scorelist2.student.name}</td>
									<td>${scorelist2.student.id}</td>
									<td>${scorelist2.subject.selectNo.semeSelect}</td>
									<td>${scorelist2.subject.subjectName}</td>
									<td>${scorelist2.score.credit}</td>
									<td>${scorelist2.score.grade}</td>
									<td>${scorelist2.score.reportScore}</td>
									<td>${scorelist2.score.attScore}</td>
									<td>${scorelist2.score.midtermScore}</td>
									<td>${scorelist2.score.endtermScore}</td>
									<td><a href="scoreform.do?sno=${scorelist2.score.no }" class="btn btn-default btn-xs">수정</a></td>
								</c:forEach>
								</tr>
							</tbody>
						</table>
					</div>
				</div>	
				
				<div role="tabpanel" class="tab-pane" id="attendance">
					<table class="table table-condensed">
						<tbody>
							<tr>
								<td bgcolor="#dceef3" style="color: #333; width: 10%; vertical-align: middle; height: 30px;"><strong>조회</strong></td>
								<td bgcolor="#f0fcff">
									학기선택:
									<select>
										<c:forEach var="semesterlist" items="${semesterlist }">
											<option value="${semesterlist.no }">${semesterlist.semeSelect }</option>
										</c:forEach>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									과목선택:
									<select>
										<option value="">디지털코드</option>
										<option value="">회로이론</option>
										<option value="">공업수학</option>
										<option value="">C언어 프로그래밍</option>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									<button class="btn btn-default btn-xs" type="submit">조회하기</button>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="panel panel-body">
						<div id="attDataBox"></div>
						<table class="table table-condensed">
							<thead>
								<tr bgcolor="#f0fcff">
									<th>성적번호</th>
									<th>학번</th>
									<th>이름</th>
									<th>학년</th>
									<th>교과목명</th>
									<th>출석일수</th>
									<th>선택</th>
								</tr>
							</thead>
							<tbody>
								<tr style="text-align: left;">
									<td>0</td>
									<td>0</td>
									<td>0</td>
									<td>0</td>
									<td>0</td>
									<td>0</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				
				<div role="tabpanel" class="tab-pane" id="report">
					<table class="table table-condensed">
						<tbody>
							<tr>
								<td bgcolor="#dceef3" style="color: #333; width: 10%; vertical-align: middle; height: 30px;"><strong>조회</strong></td>
								<td bgcolor="#f0fcff">
									과정구분: 
									<select>
										<option>재학생</option>
										<option>계절학기</option>
										<option>재학생</option>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									학기선택:
									<select>
										<c:forEach var="semesterlist" items="${semesterlist }">
											<option value="${semesterlist.no }">${semesterlist.semeSelect }</option>
										</c:forEach>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									과목선택:
									<select>
										<option value="">디지털코드</option>
										<option value="">회로이론</option>
										<option value="">공업수학</option>
										<option value="">C언어 프로그래밍</option>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									<button class="btn btn-sm-default" type="submit">조회하기</button>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="panel panel-body">
						<table class="table table-condensed">
							<thead>
								<tr bgcolor="#f0fcff">
									<th>학번</th>
									<th>학기</th>
									<th>교과목명</th>
									<th>제출기한</th>
									<th>제출일</th>
									<th>과제명</th>
									<th>점수</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>testid</td>
									<td>2015년 1학년 1학기</td>
									<td>디지털회로</td>
									<td>2015.07.21</td>
									<td>2015.07.16</td>
									<td>코드별 정리</td>
									<td>7 / 10</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
		</div>
	</div>
</body>
</html>