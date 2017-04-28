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
			var score = $(this).val();
			if(score=="") {
				$("#score_box2").empty();
				return false;
			}
			
			$.ajax({
				url: "scoreSearch.do?score="+score,
				dataType: "json",
				type: "POST",
				success: function(data) {
					$("#score_box2").empty();
					$("#score_box2").append('<option value="siteall">전공</option>');
					for (var i=0; i<data.length; i++) {						
						$("#score_box2").append("<option value="+data[i].code+">"+data[i].name+"</option>");
						console.log(data[i].code);
					}
				}
			});
		});
		
		$("#att_box1").change(function() {
			var score = $(this).val();
			
			if(score=="") {
				$("#att_box2").empty();
				return false;
			}
			
			$.ajax({
				url: "scoreSearch.do?score="+score,
				dataType: "json",
				type: "POST",
				success: function(data) {
					$("#att_box2").empty();
					
					for (var i=0; i<data.length; i++) {
						$("#att_box2").append("<option value="+data[i].code+">"+data[i].name+"</option>");
					}
				}
			});
		});
				
		$("#score_search_btn").click(function() {
			var code1 = $("#score_box1").val();
			var code2 = $("#score_box2").val();
			var stucode = $("#score_box3").val();
				$.ajax({
					url: "scoreSearchInfo?code="+code1+"&codes="+code2+"&stucode="+stucode,
					dataType: "json",
					type: "POST",
					success: function(data) {
					$("#score_td_box").empty();
						
					for (var i=0; i<data.length; i++) {
						$("#score_td_box").append('<tr style="text-align: left;" id=tr_'+data[i].no+'></tr>');
						$("#tr_"+data[i].no).append('<td>'+data[i].no+'</td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].student.name+'</td>');
						$("#tr_"+data[i].no).append('<td><a href="scoreInfo.do?stuno='+data[i].student.no+'">'+data[i].student.id+'</a></td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].subject.selectNo.semeSelect+'</td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].subject.subjectName+'</td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].subject.passed.passedName+'</td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].score.credit+'</td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].score.grade+'</td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].score.reportScore+'</td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].score.attScore+'</td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].score.midtermScore+'</td>');
						$("#tr_"+data[i].no).append('<td>'+data[i].score.endtermScore+'</td>');			
						$("#tr_"+data[i].no).append('<td><a href="scoreform.do?sno='+data[i].score.no+'" class="btn btn-primary btn-xs">수정</a></td>');
					}
				}
			});	
		});
	});
</script>
<style>

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/collegeregister/sidebar-hakjuk.jsp" %>
	<!-- 성적/과제/출결 현황 리스트 -->
	<div class="container" style="margin-left: 250px; padding-top: 25px;">
		<div class="row text-right">
			홈 > 성적관리 > 성적조회 >  
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> 성적 관리</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div class="panel panel-heading">		                            	   
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#score" aria-controls="score" role="tab" data-toggle="tab" aria-expanded="true">성적</a></li>
			</ul>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="score">
					<div class="row">
						<table class="table table-condensed">
							<tbody>
								<tr>
									<td bgcolor="#dceef3"
										style="color: #333; width: 10%; vertical-align: middle; height: 30px;"><strong>조회</strong></td>
									<td bgcolor="#f0fcff"><select class="form-control"
										id="score_box1">
											<option value="all">전체</option>
											<c:forEach var="sitemaplist" items="${sitemaplist }">
												<option value="${sitemaplist.code }">${sitemaplist.name }</option>
											</c:forEach>
									</select></td>
									<td bgcolor="#f0fcff"><select class="form-control"
										id="score_box2">
											<option value="siteall">전공</option>
									</select></td>
									<td bgcolor="#f0fcff"><input class="form-control"
										type="text" placeholder="학번을 입력하세요" id="score_box3" /></td>
									<td bgcolor="#f0fcff">
										<button class="btn btn-primary" type="button"
											id="score_search_btn">조회하기</button>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="panel panel-body" id="score_table">
						<div style="overflow:scroll; width:1100px; height:300px;">
							<table class="table table-hover">
								<colgroup>
									<col style="width: 5%">
									<col style="width: 5%">
									<col style="width: 7%">
									<col style="width: 5%">
									<col style="width: 10%">
									<col style="width: 6%">
									<col style="width: 5%">
									<col style="width: 5%">
									<col style="width: 6%">
									<col style="width: 5%">
									<col style="width: 5%">
									<col style="width: 5%">
									<col style="width: 5%">

								</colgroup>
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
											<td><a href="scoreInfo.do?stuno=${regilist.student.no }">${regilist.student.id}</a></td>
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
			</div>
		</div>
	</div>
</div>
</body>
</html>