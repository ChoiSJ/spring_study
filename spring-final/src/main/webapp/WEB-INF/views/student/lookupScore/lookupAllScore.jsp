<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style type="text/css">
	th { text-align: center !important;
		vertical-align: middle !important;}
</style>
<script type="text/javascript">
$(function () {
	$("#scoreprint").click(function (e) {
		window.open('data:application/vnd.ms-excel, Score_Info' + encodeURIComponent($('#modal_excel').html()), '_blank');
		e.preventDefault(); 
	});
});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
   <div class="container" style="margin-left: 250px; padding-top:25px; ">
    <div class="row text-right">
         	홈
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 학기 성적 목록</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      
      <div class="row">
      	학기 성적 목록
      	<table class="table table-bordered">
      		<colgroup>
      			<col width="10%" />
      			<col width="10%" />
      			<col width="10%" />
      			<col width="*" />
      			<col width="10%" />
      			<col width="10%" />
      			<col width="10%" />
      		</colgroup>
      		<thead>
      			<tr>
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
      		<tbody id="searchBody">
      			<c:forEach var="savg" items="${savg }">
      			<c:choose>
      				<c:when test="${savg.testcount eq 0}">
      					<tr style="text-align: center;">
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
      				</c:when>
      				<c:otherwise>
      				<tr style="text-align: center;">
      					<td>${savg.semename }</td>
      					<td colspan="12"><strong>${savg.testcount }개의 강의 평가가 안되있습니다.</strong></td>
      				</tr>
      				</c:otherwise>
      			</c:choose>
				</c:forEach>
      		</tbody>
      	</table>
      	
      	전체 성적 목록
      	<table class="table table-bordered">
			<thead>
				<tr style="text-align: center;">
					<th>
						<label>전체 평점 평균</label>
					</th>
					<th>
						<label>전체 백분율</label>
					</th>
					<th>
						<label>전체 신청학점</label>
					</th>
					<th>
						<label>전체 이수학점</label>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr style="text-align: center;">
				<c:choose>
					<c:when test="${savgtotal.testcount eq 0 }">
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
					</c:when>
					<c:otherwise>
						<td colspan="4"><strong>총 ${savgtotal.testcount }개의 강의 평가 안되있습니다.</strong></td>
					</c:otherwise>
				</c:choose>
				</tr>
			</tbody>
		</table>
		<div class="text-right">
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">성적표</button>
		</div>
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
							<tr style="text-align: center;">
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
									<label>전체 이수학점</label>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr style="text-align: center;">
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
					<table class="table table-bordered">
						<thead>
							<tr bgcolor="#f0fcff" style="text-align: center;">
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
						<tbody id="score_td_box">
							<c:forEach var="regilist" items="${regilist }">
								<tr style="text-align: center;">
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
							<tr bgcolor="#f0fcff" style="text-align: center;">
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
						<tbody id="score_td_box">
							<c:forEach var="savg" items="${savg }">
								<tr style="text-align: center;">
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
   </div>
</body>
</html>