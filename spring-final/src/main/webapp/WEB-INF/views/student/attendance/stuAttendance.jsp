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
         <h4><span class="glyphicon glyphicon-th-list"></span>출석 정보</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      
      <div class="row">
      
      	<!-- 탭 매뉴 리스트 -->
      	<ul class="nav nav-tabs">
      		<li role="presentation" class="active"><a href='#help' aria-controls="help" role="tab" data-toggle="tab" aria-expanded="true">전체</a></li>
      		<c:forEach var="semelist" items="${semelist }">
      			<li role="presentation"><a href='#${semelist }' aria-controls="${semelist }" role="tab" data-toggle="tab" aria-expanded="true">${semelist }학기</a></li>
      		</c:forEach>
      		
      	</ul>
      	     	
      	<!-- 탭 내용  -->
      	<div class="tab-content">
      		<div role="tabpanel" class="tab-pane active" id="help">
      			<p></p>
				(Y:출석, N:결석, R:지각)
				<table class="table text-center">
				<thead>
					<tr bgcolor="#f0fcff">
					    <th>수강번호</th>
					    <th>학기</th>
					    <th>과목</th>
					    <th>출석점수</th>
					    <th>1주</th>
						<th>2주</th>
						<th>3주</th>
						<th>4주</th>
						<th>5주</th>
						<th>6주</th>
						<th>7주</th>
						<th>8주</th>
						<th>9주</th>
						<th>10주</th>
						<th>11주</th>
						<th>12주</th>
						<th>13주</th>
						<th>14주</th>
						<th>15주</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="scorelist" items="${scorelist }">
					<tr>
					    <td>${scorelist.no }</td>
					    <td>${scorelist.subject.selectNo.semeSelect }</td>
					    <td>${scorelist.subject.subjectName }</td>
					    <td>${scorelist.score.attendance.attScore }</td>
						<td>${scorelist.score.attendance.week1 }</td>
						<td>${scorelist.score.attendance.week2 }</td>
						<td>${scorelist.score.attendance.week3 }</td>
                        <td>${scorelist.score.attendance.week4 }</td>
                        <td>${scorelist.score.attendance.week5 }</td>
                        <td>${scorelist.score.attendance.week6 }</td>
                        <td>${scorelist.score.attendance.week7 }</td>
                        <td>${scorelist.score.attendance.week8 }</td>
                        <td>${scorelist.score.attendance.week9 }</td>
						<td>${scorelist.score.attendance.week10 }</td>
						<td>${scorelist.score.attendance.week11 }</td>
                        <td>${scorelist.score.attendance.week12 }</td>
                        <td>${scorelist.score.attendance.week13 }</td>
                        <td>${scorelist.score.attendance.week14 }</td>
                        <td>${scorelist.score.attendance.week15 }</td>
					</tr>
				</c:forEach>
				</tbody>	
				</table>
      		</div>
      		<c:forEach var="semelists" items="${semelist }">
	      		<div role="tabpanel" class="tab-pane" id="${semelists }">
	      			<p></p>
					(Y:출석, N:결석, R:지각)
	      			<table class="table text-center">
						<thead>
							<tr bgcolor="#f0fcff">
							    <th>수강번호</th>
							    <th>학기</th>
							    <th>과목</th>
							    <th>출석점수</th>
							    <th>1주</th>
								<th>2주</th>
								<th>3주</th>
								<th>4주</th>
								<th>5주</th>
								<th>6주</th>
								<th>7주</th>
								<th>8주</th>
								<th>9주</th>
								<th>10주</th>
								<th>11주</th>
								<th>12주</th>
								<th>13주</th>
								<th>14주</th>
								<th>15주</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="scorelistse" items="${scorelist }">
								<c:if test="${scorelistse.subject.selectNo.semeSelect eq semelists}">
									<tr>
									    <td>${scorelistse.no }</td>
									    <td>${scorelistse.subject.selectNo.semeSelect }</td>
									    <td>${scorelistse.subject.subjectName }</td>
									    <td>${scorelistse.score.attendance.attScore }</td>
										<td>${scorelistse.score.attendance.week1 }</td>
										<td>${scorelistse.score.attendance.week2 }</td>
										<td>${scorelistse.score.attendance.week3 }</td>
				                        <td>${scorelistse.score.attendance.week4 }</td>
				                        <td>${scorelistse.score.attendance.week5 }</td>
				                        <td>${scorelistse.score.attendance.week6 }</td>
				                        <td>${scorelistse.score.attendance.week7 }</td>
				                        <td>${scorelistse.score.attendance.week8 }</td>
				                        <td>${scorelistse.score.attendance.week9 }</td>
										<td>${scorelistse.score.attendance.week10 }</td>
										<td>${scorelistse.score.attendance.week11 }</td>
				                        <td>${scorelistse.score.attendance.week12 }</td>
				                        <td>${scorelistse.score.attendance.week13 }</td>
				                        <td>${scorelistse.score.attendance.week14 }</td>
				                        <td>${scorelistse.score.attendance.week15 }</td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
				</table>
	      		</div>
      		</c:forEach>
      </div>
      <hr />
   </div>
   </div>
</body>
</html>