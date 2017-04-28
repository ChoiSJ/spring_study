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
		window.open('data:application/vnd.ms-excel, Score_Info' + encodeURIComponent($('#modal_excel').html()), '_blank');
		e.preventDefault(); 
	});
});
</script>
<style type="text/css">
td{
	text-align: center;
}
th{
	text-align: center;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/collegeregister/sidebar-hakjuk.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top: 25px;">
	<div class="row text-right">
			홈 > 성적관리 > 성적조회 > 성적상세정보 >
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> 성적 상세정보</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		
		<!-- 모달 출력 영역 -->
		<div class="panel panel-heading">
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog-lg" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">성적표</h4>
			      </div>
			      <div class="modal-body" id="modal_excel">
					<label><strong>${stuinfo.name } 성적 정보</strong></label>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th bgcolor="#f0fcff">
									<label>전체 신청학점</label>
								</th>
								<th bgcolor="#f0fcff">
									<label>전체 이수학점</label>
								</th>
								<th bgcolor="#f0fcff">
									<label>전체 평점</label>
								</th>
								<th bgcolor="#f0fcff">
									<label>전체 백분율</label>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<p><strong id="t1"></strong></p>
								</td>
								<td>
									<p><strong id="t2"></strong></p>
								</td>
								<td>
									<p><strong id="t3"></strong></p>
								</td>
								<td>
									<p><strong id="t4"></strong></p>
								</td>
							</tr>
						</tbody>
					</table>
					<label>전체성적 리스트</label>
					<table class="table table-bordered">
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
							</tr>
						</thead>
						<tbody id="score_td_box-1">
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
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<label>학기별 리스트</label>
					<table class="table table-bordered">
						<thead>
							<tr bgcolor="#f0fcff">
								<th>학기</th>
								<th>신청학점</th>
								<th>이수학점</th>
								<th>평균점수</th>
								<th>백분율점수</th>
								<th>학사경고</th>
								<th>전.필</th>
								<th>전.선</th>
								<th>교.필</th>
								<th>교.선</th>
								<th>일.선</th>
								<th>구분</th>
								<th>학.기</th>
							</tr>
						</thead>
						<tbody id="score_td_box-2">
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
									<td>${savg.pass5 }</td>
									<td>${savg.pass6 }</td>
									<td>${savg.pass7 }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-success" data-dismiss="modal" id="scoreprint">엑셀</button>
			        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			      </div>
			    </div>
			  </div></div>

		</div>
		
		<!-- 성적 리스트 및 수정 -->
		<div class="panel panel-body" id="scoreDate">
			<label><strong>${stuinfo.name } 성적 정보</strong></label>
			<table class="table table-hover">
				<thead>
					<tr>
						<th bgcolor="#f0fcff">
							<label>전체 신청학점</label>
						</th>
						<th bgcolor="#f0fcff">
							<label>전체 이수학점</label>
						</th>
						<th bgcolor="#f0fcff">
							<label>전체 평점</label>
						</th>
						<th bgcolor="#f0fcff">
							<label>전체 백분율</label>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<p><strong id="t11"></strong></p>
						</td>
						<td>
							<p><strong id="t22"></strong></p>
						</td>
						<td>
							<p><strong id="t33"></strong></p>
						</td>
						<td>
							<p><strong id="t44"></strong></p>
						</td>
					</tr>
				</tbody>
			</table>
			<label>전체성적 리스트</label>
			<table class="table table-hover">
				<thead>
					<tr bgcolor="#f0fcff">
						<th>수강번호</th>
						<th>이름</th>
						<th>학번</th>
						<th>학기</th>
						<th>과목명</th>
						<th>이수구분</th>
						<th>이수학점</th>
						<th>등급</th>
						<th>과제</th>
						<th>출석</th>
						<th>중간</th>
						<th>기말</th>
						<th>수정</th>
					</tr>
				</thead>
				<tbody id="score_td_box-3">
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
			<label>학기별 리스트</label>
			<table class="table table-hover">
				<thead>
					<tr bgcolor="#f0fcff">
						<th>학기</th>
						<th>신청학점</th>
						<th>이수학점</th>
						<th>평균점수</th>
						<th>백분율점수</th>
						<th>학사경고</th>
						<th>전.필</th>
						<th>전.선</th>
						<th>교.필</th>
						<th>교.선</th>
						<th>일.선</th>
						<th>구분</th>
						<th>학.기</th>
					</tr>
				</thead>
				<tbody id="score_td_box-4">				
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
							<td>${savg.pass5 }</td>
							<td>${savg.pass6 }</td>
							<td>${savg.pass7 }</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		<div class="panel panel-footer">
			<div class="text-right">
				<a href="scorelist.do" class="btn btn-info">메인</a>
				<a href="attinfolist.do?stuno=${stuinfo.no }" class="btn btn-primary">출석</a>
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">엑셀</button>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function() {
	var $list_tbody = $("#score_td_box-4");
	
	var rowCount = $list_tbody.find("tr").length;
	
	var totalCredit1 = 0;
	$("#score_td_box-4 td:nth-child(13n+2)").each(function(index, item) {
		totalCredit1 += parseInt($(item).text());
	});
	var totalCredit2 = 0;
	$("#score_td_box-4 td:nth-child(13n+3)").each(function(index, item) {
		totalCredit2 += parseInt($(item).text());
	});
	var totalCredit3 = 0;
	$("#score_td_box-4 td:nth-child(13n+4)").each(function(index, item) {
		totalCredit3 += parseInt($(item).text());
	});
	var totalCredit4 = 0;
	$("#score_td_box-4 td:nth-child(13n+5)").each(function(index, item) {
		totalCredit4 += parseInt($(item).text());
	});
	
	var t1= totalCredit1;
	var t2= totalCredit2;
	var t3= (totalCredit3/rowCount).toFixed(2);
	var t4= (totalCredit4/rowCount).toFixed(2);
	$("#t1").text(t1);
	$("#t11").text(t1);
	$("#t2").text(t2);
	$("#t22").text(t2);
	$("#t3").text(t3);
	$("#t33").text(t3);
	$("#t4").text(t4);
	$("#t44").text(t4);
})
</script>
</html>