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
	$("#score_box1").change(function() {
		var subname = $(this).val();
		console.log(subname);
		
		$.ajax({
			url: "subSearch.do?sub="+subname,
			dataType: "json",
			type: "POST",
			success: function(data) {
				$("#score_td_box").empty();
				for (var i=0; i<data.length; i++) {
					$("#score_td_box").append('<tr style="text-align: left;" id=tr_'+data[i].no+'></tr>');
					$("#tr_"+data[i].no).append('<td>'+data[i].no+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].student.name+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].student.id+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].subject.selectNo.semeSelect+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].subject.subjectName+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].subject.passed.passedName+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].score.credit+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].score.grade+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].score.reportScore+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].score.attScore+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].score.midtermScore+'</td>');
					$("#tr_"+data[i].no).append('<td>'+data[i].score.endtermScore+'</td>');			
					$("#tr_"+data[i].no).append('<td><a href="scoreform.do?sno='+data[i].score.no+'&psco='+data[i].subject.score+'" class="btn btn-primary btn-xs">수정</a></td>');
				}
			}
		});
	});
});
</script>
</head>
<body>
<body>
	<%@ include file="/WEB-INF/views/navi/adminnavi.jsp"%>
	<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp"%>
	<!-- 성적/과제/출결 현황 리스트 -->
	<div class="container" style="margin-left: 250px; padding-top: 25px;">
		<div class="row text-right">홈 > 성적관리 > 성적조회 ></div>
		<div class="row">
			<h4>
				<span class="glyphicon glyphicon-th-list"></span> 성적 관리
			</h4>
			<hr style="border: solid 0.5px #2C7BB5;">
		</div>

		<div class="row">
			<div class="panel panel-body" id="score_table">
				<table class="table table-condensed">
					<tbody>
						<tr>
							<td bgcolor="#dceef3"style="color: #333; width: 10%; vertical-align: middle; height: 30px;">
								<strong>조회</strong>
							</td>
							<td bgcolor="#f0fcff">
								<select id="score_box1">
									<option value="all">전체</option>
									<c:forEach var="sublist" items="${sublist }">
										<option value="${sublist.subjectName }">${sublist.subjectName }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
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
								<td><a href="scoreform.do?sno=${regilist.score.no }&psco=${regilist.subject.score}" class="btn btn-primary btn-xs">수정</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</body>
</html>