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
$(function () {
	$("#scoreprint").click(function (e) {
		var scoreno = $(this).val();
		var stuname = $("#stuname").val();
		alert(stuname);
		window.open('data:application/vnd.ms-excel,'+stuname+'_Score_Info' + encodeURIComponent($('#scoreDate').html()), '_blank');
		e.preventDefault(); 
	});
});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarscore.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top: 25px;" id="scoreDate">
	<div class="row text-right">
			홈 > 성적관리 > 성적상세정보 >  
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> 성적 상세정보</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div class="panel panel-heading">
			
		</div>
		<div class="panel panel-body">
			<label><strong>${stuinfo.name } 성적 정보</strong></label>
			<table class="table table-condensed">
				<thead>
					<tr>
						<th bgcolor="#f0fcff">
							<label>전체 평점 평균</label>
						</th>
						<th bgcolor="#f0fcff">
							<label>전체 백분율</label>
						</th>
						<th bgcolor="#f0fcff">
							<label>전체 신청학점</label>
						</th>
						<th bgcolor="#f0fcff">
							<label>전체 취득학점</label>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<p><strong>${savgtotal.credit3 }</strong></p>
						</td>
						<td>
							<p><strong>${savgtotal.credit4 }</strong></p>
						</td>
						<td>
							<p><strong>${savgtotal.credit1 }</strong></p>
						</td>
						<td>
							<p><strong>${savgtotal.credit2 }</strong></p>
						</td>
					</tr>
				</tbody>
			</table>
			<label>전체성적 리스트</label>
			<table class="table table-condensed">
				<thead>
					<tr bgcolor="#f0fcff">
						<th>수강번호</th>
						<th>이름</th>
						<th>학번</th>
						<th>학기</th>
						<th>과목명</th>
						<th>이수구분</th>
						<th>학점</th>
						<th>등급</th>
						<th>과제</th>
						<th>출석</th>
						<th>중간</th>
						<th>기말</th>
						<th>수정</th>
					</tr>
				</thead>
				<tbody id="score_td_box">
					<c:forEach var="regilist" items="${regilist }">
						<tr style="text-align: left;">
							<td>${regilist.no}</td>
							<td>${regilist.student.name}</td>
							<td>${regilist.student.id}</td>
							<td>${regilist.subject.selectNo.semeSelect}</td>
							<td>${regilist.subject.subjectName}</td>
							<td>${regilist.subject.passed.passedName}</td>
							<td>${regilist.score.credit}</td>
							<td>${regilist.score.grade}</td>
							<td>${regilist.score.reportScore}</td>
							<td>${regilist.score.attScore}</td>
							<td>${regilist.score.midtermScore}</td>
							<td>${regilist.score.endtermScore}</td>
							<td><a href="scoreform.do?sno=${regilist.score.no }"class="btn btn-primary btn-xs">수정</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<label>학기별 리스트</label>
			<table class="table table-condensed">
				<thead>
					<tr bgcolor="#f0fcff">
						<th>학기</th>
						<th>신청학점</th>
						<th>취득학점</th>
						<th>평균점수</th>
						<th>백분율점수</th>
						<th>학사경고</th>
						<th>전필</th>
						<th>전선</th>
						<th>교필</th>
						<th>교선</th>
					</tr>
				</thead>
				<tbody id="score_td_box">
					<c:forEach var="savg" items="${savg }">
						<tr style="text-align: left;">
							<td>${savg.semename }</td>
							<td>${savg.credit1 }</td>
							<td>${savg.credit2 }</td>
							<td>${savg.credit3 }</td>
							<td>${savg.credit4 }</td>
							<c:choose>
								<c:when test="${savg.grade gt 2}">
									<td>Y</td>
								</c:when>
								<c:otherwise>
									<td>N</td>
								</c:otherwise>
							</c:choose>
							<td>${savg.pass1 }</td>
							<td>${savg.pass2 }</td>
							<td>${savg.pass3 }</td>
							<td>${savg.pass4 }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="panel panel-footer">
			<div class="text-right">
				<a href="scorelist.do" class="btn btn-info">메인</a>
				<button class="btn btn-success" type="button" id="scoreprint">엑셀</button>
			</div>
		</div>
	</div>
</body>
</html>