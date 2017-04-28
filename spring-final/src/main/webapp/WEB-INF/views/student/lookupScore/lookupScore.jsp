<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta http-equiv="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" />
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
      
<style type="text/css">
	th { text-align: center !important;
		vertical-align: middle !important;}
</style>
<script type="text/javascript">
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
         <h4><span class="glyphicon glyphicon-th-list"></span> 과목 성적 정보</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      
      <div class="row">
      
      	<!-- 탭 매뉴 리스트 -->
      	<ul class="nav nav-tabs">
      		<li role="presentation" class="active"><a href='#help' aria-controls="help" role="tab" data-toggle="tab" aria-expanded="true">정보</a></li>
      		<c:forEach var="semelist" items="${semelist }">
      			<li role="presentation"><a href='#${semelist }' aria-controls="${semelist }" role="tab" data-toggle="tab" aria-expanded="true">${semelist }학기</a></li>
      		</c:forEach>
      		
      	</ul>
      	     	
      	<!-- 탭 내용  -->
      	<div class="tab-content">
      		<div role="tabpanel" class="tab-pane active" id="help">
      			<h3> 해당학기를 선택해서 과목정보를 확인하세요 </h3>
      		</div>
      		<c:forEach var="semelists" items="${semelist }">
	      		<div role="tabpanel" class="tab-pane" id="${semelists }">
	      			<p></p>
	      			<table class="table table-bordered">
			      		<colgroup>
			      			<col width="10%" />
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
			      				<th>번호</th>
			      				<th>이수구분</th>
			      				<th>학기</th>
			      				<th>학년</th>
			      				<th>과목명</th>
			      				<th>담당교수</th>
			      				<th>학점</th>
			      				<th>성적</th>
			      				<th>강의평가</th>
			      			</tr>
			      		</thead>
			      		<tbody>
			      			<c:forEach var="regilistab" items="${regilist }">
			      				<c:if test="${regilistab.subject.selectNo.semeSelect eq semelists}">
			      					<tr>
				      					<td align="center">${regilistab.no}</td>
										<td align="center">${regilistab.subject.passed.passedName}</td>
										<td align="center">${regilistab.subject.selectNo.semeSelect}</td>
										<td align="center">${regilistab.subject.grade}</td>
										<td align="center">${regilistab.subject.subjectName}</td>
										<td align="center">${regilistab.subject.professor.name}</td>
										<c:choose>
												<c:when test="${regilistab.score.test eq 'N'}">
													<td align="center" colspan="2">미평가</td>
													<td align="center"><a href="../lecturerating.do?scoreNo=${regilistab.score.no }&subjectNo=${regilistab.subject.no}"><i class="material-icons" style="color: black">rate_review</i></a></td>
											
												</c:when>
												<c:otherwise>
													<td align="center">${regilistab.score.credit}</td>
													<td align="center">${regilistab.score.grade}</td>
													<td align="center"><i class="material-icons">done</i></td>
												</c:otherwise>		
										</c:choose>
		      						</tr>
			      				</c:if>
			      			</c:forEach>
			      		</tbody>
		      		</table>
	      		</div>
      		</c:forEach>
      	</div>
      </div>
      <hr />
      
   </div>
</body>
</html>