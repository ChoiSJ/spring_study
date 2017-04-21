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
		/* function searchFormSet (pageNo){
			pageNo = pageNo || 1;
			$('#search-form :input[name="pageNo"]').val(pageNo);
			$(':input[name="searchType"]').val($('select[name="searchType"]').val());
			$(':input[name="display"]').val($('select[name="searchCount"]').val());
			
		}
		
		$("ul.pagination li > a").click(function(event) {
			event.preventDefault();
			var pageNo = $(this).attr("id").replace("navi-", "");
			searchFormSet(pageNo);
			$("#search-form").submit();
		}); */
		
		$("#att_Btn").click(function() {
			var attper = $("#att_Btn").val();
			alert(attper);
			$('#attDataBox').empty();
			$('#attDataBox').append('<label>홍길동 디지털코드 출석정보</label><div class="progress"><div class="progress-bar" role="progressbar" aria-valuenow="'+attper+'" aria-valuemin="0" aria-valuemax="15" style="width: '+attper+'%;" id="attDataBar">'+attper+'</div></div>');			
		});
		
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
		
		$("#rep_box1").change(function() {
			var score = $(this).val();
			
			if(score=="") {
				$("#rep_box2").empty();
				return false;
			}
			
			$.ajax({
				url: "scoreSearch.do?score="+score,
				dataType: "json",
				type: "POST",
				success: function(data) {
					$("#rep_box2").empty();
					
					for (var i=0; i<data.length; i++) {
						$("#rep_box2").append("<option value="+data[i].code+">"+data[i].name+"</option>");
					}
				}
			});
		});
		
		$("#score_search_btn").click(function() {
			var code1 = $("#score_box1").val();
			var code2 = $("#score_box2").val();
			var stucode = $("#score_box3").val();
			console.log(code1);
			console.log(code2);
			console.log(stucode);
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
						$("#tr_"+data[i].no).append('<td><a href="scoreInfo.do?stuno='+data[i].no+'>'+data[i].student.id+'</a></td>');
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
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarscore.jsp" %>
	<!-- 성적/과제/출결 현황 리스트 -->
	<div class="container" style="margin-left: 250px; padding-top: 25px;">
		<div class="row text-right">
			홈 > 성적관리 >  
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> 성적 관리</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div class="panel panel-heading">		                            	   
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#score" aria-controls="score" role="tab" data-toggle="tab" aria-expanded="true">성적</a></li>
				<!-- <li role="presentation"><a href="#attendance" aria-controls="attendance" role="tab" data-toggle="tab" aria-expanded="false">출결</a></li> -->
				<!-- <li role="presentation"><a href="#report" aria-controls="report" role="tab" data-toggle="tab" aria-expanded="false">과제현황</a></li> -->
			</ul>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="score">
					<table class="table table-condensed">
						<tbody>
							<tr>
								<td bgcolor="#dceef3" style="color: #333; width: 10%; vertical-align: middle; height: 30px;"><strong>조회</strong></td>
								<td bgcolor="#f0fcff">
									<select class="form-control" id="score_box1">
											<option value="all">전체</option>
										<c:forEach var="sitemaplist" items="${sitemaplist }">
											<option value="${sitemaplist.code }">${sitemaplist.name }</option>
										</c:forEach>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									<select class="form-control" id="score_box2">
										<option value="siteall">전공</option>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									<input class="form-control" type="text" placeholder="학번을 입력하세요" id="score_box3"/>
								</td>
								<td bgcolor="#f0fcff">
									<button class="btn btn-primary" type="button" id="score_search_btn">조회하기</button>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="panel panel-body" id="score_table">
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
									<td><a href="scoreform.do?sno=${regilist.score.no }" class="btn btn-primary btn-xs">수정</a></td>
								</tr>
								</c:forEach>	
							</tbody>
						</table>
						<div class="text-center">
							<%-- <%@include file="scorenav.jsp" %> --%>
						</div>
						<%-- <form id="search-form" action="scorelist.do" method="post">
							<input type="hidden" name="pageNo" value="1">
							<input type="hidden" name="searchType" value="${serch.searchType }">
							<input type="hidden" name="display"  value="${search.display }">
						</form> --%>
					</div>
				</div>	
				
				<%-- <div role="tabpanel" class="tab-pane" id="attendance">
					<table class="table table-condensed">
						<tbody>
							<tr>
								<td bgcolor="#dceef3" style="color: #333; width: 10%; vertical-align: middle; height: 30px;"><strong>조회</strong></td>
								<td bgcolor="#f0fcff">
									<select class="form-control" id="att_box1">
											<option value="">전체</option>
										<c:forEach var="sitemaplist" items="${sitemaplist }">
											<option value="${sitemaplist.code }">${sitemaplist.name }</option>
										</c:forEach>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									<select class="form-control" id="att_box2">
										<option value="siteAll">전공</option>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									<input class="form-control" type="text" placeholder="이름 또는 학번"/>
								</td>
								<td bgcolor="#f0fcff">
									<button class="btn btn-primary" type="submit">조회하기</button>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="panel panel-body">
						<div id="attDataBox"></div>
						<table class="table table-condensed">
							<thead>
								<tr bgcolor="#f0fcff">
									<th>수강번호</th>
									<th>학번</th>
									<th>이름</th>
									<th>학년</th>
									<th>교과목명</th>
									<th>출석일수</th>
									<th>선택</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="scorelist2" items="${scorelist2 }">
									<tr style="text-align: left;">
										<td>${scorelist2.no}</td>
										<td>${scorelist2.student.id}</td>
										<td>${scorelist2.student.name}</td>
										<td>${scorelist2.subject.grade}</td>
										<td>${scorelist2.subject.subjectName}</td>
										<td>${scorelist2.att.count}</td>
										<td><button type="button" class="btn btn-primary btn-xs" id="att_Btn" value="${scorelist2.att.count}">상세정보</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div> --%>
				
				<%-- <div role="tabpanel" class="tab-pane" id="report">
					<table class="table table-condensed">
						<tbody>
							<tbody>
							<tr>
								<td bgcolor="#dceef3" style="color: #333; width: 10%; vertical-align: middle; height: 30px;"><strong>조회</strong></td>
								<td bgcolor="#f0fcff">
									<select class="form-control" id="rep_box1">
											<option value="">전체</option>
										<c:forEach var="sitemaplist" items="${sitemaplist }">
											<option value="${sitemaplist.code }">${sitemaplist.name }</option>
										</c:forEach>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									<select class="form-control" id="rep_box2">
										<option value="siteAll">전공</option>
									</select>
								</td>
								<td bgcolor="#f0fcff">
									<input class="form-control" type="text" placeholder="이름 또는 학번"/>
								</td>
								<td bgcolor="#f0fcff">
									<button class="btn btn-primary" type="submit">조회하기</button>
								</td>
							</tr>
						</tbody>
						</tbody>
					</table>
					<div class="panel panel-body">
						<table class="table table-condensed">
							<thead>
								<tr bgcolor="#f0fcff">
									<th>수강번호</th>
									<th>학번</th>
									<th>이름</th>
									<th>학기</th>
									<th>교과목명</th>
									<th>제출기한</th>
									<th>제출일</th>
									<th>과제명</th>
									<th>점수</th>
									<th>수정</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="scorelist2" items="${scorelist2 }">
									<tr style="text-align: left;">
										<td>${scorelist2.no}</td>
										<td>${scorelist2.student.id}</td>
										<td>${scorelist2.student.name}</td>
										<td>${scorelist2.subject.selectNo.semeSelect}</td>
										<td>${scorelist2.subject.subjectName}</td>
										<td>${scorelist2.report.reportDeadline}</td>
										<td>${scorelist2.report.reportDate}</td>
										<td>${scorelist2.report.reportTitle}</td>
										<td>${scorelist2.report.reportScore}</td>
										<td><button type="button" class="btn btn-primary btn-xs" id="" value="">수정</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div> --%>
			</div>
		</div>
	</div>
</body>
</html>