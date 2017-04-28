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
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/collegeregister/sidebar-hakjuk.jsp" %>
	<div class="container"  style="margin-left: 250px; padding-top: 25px;">
		<div class="row text-right">
			홈 > 성적관리 > 성적조회 > 성적상세정보 > 출석정보
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span>${stuinfo.name } 출석정보</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
			<div class="panel panel-heading">
				(Y:출석, N:결석, R:지각)
				<table class="table text-center">
				<thead>
					<tr bgcolor="#f0fcff">
					    <th>수강번호</th>
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
						<th>수정</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="scorelist" items="${scorelist }">
					<tr>
					    <td>${scorelist.no }</td>
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
                        <td><a href="attform.do?attno=${scorelist.score.attendance.attNo }&stuno=${stuinfo.no }&scono=${scorelist.score.no}" class="btn btn-primary btn-xs">수정</a></td>
					</tr>
				</c:forEach>
				</tbody>	
				</table>
			</div>
			<div class="panel panel-footer">
				<div class="text-right">
					<a href="scoreInfo.do?stuno=${stuinfo.no }" class="btn btn-info">돌아가기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>