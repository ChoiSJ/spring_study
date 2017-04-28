<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/collegeregister/sidebar-hakjuk.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px; ">
    	<div class="row text-right">
			홈 > 학적관리 > <strong>제적학생목록</strong>
    	</div>
    	<div class="row">
    	<h4><span class="glyphicon glyphicon-th-list"></span> 제적학생목록</h4>
        <hr style="border:solid 0.5px #2C7BB5;">
    	</div>
    
    	<div class="panel panel-body">
    		<table class="table table-condensed">
    			<thead>
    				<tr>
    					<th>학번</th>
    					<th>이름</th>
    					<th>전공</th>
    					<th>학년</th>
    					<th>입학년도</th>
    					<th>연락처</th>
    					<th>학적상태</th>
    					<th>처리일</th>
    					<th>제적이유</th>
    				</tr>
    			</thead>
    			<tbody>
    			<c:forEach var="jejuk" items="${jejukList }">
    				<tr>
    					<td>${jejuk.id }</td>
    					<td>${jejuk.name }</td>
    					<td>${jejuk.division }</td>
    					<td>${jejuk.grade }</td>
    					<td>
    						<fmt:formatDate value="${jejuk.enterDate }" pattern="yyyy-MM-dd"/>
    					</td>
    					<td>${jejuk.phone }</td>
    					<td>${jejuk.register }</td>
    					<td>
    						<fmt:formatDate value="${jejuk.disDate }" pattern="yyyy-MM-dd"/>
    					</td>
    					<td>${jejuk.reason }</td>
    				</tr>
    			</c:forEach>
    			</tbody>
    		</table>
    	</div>
	</div>
</body>
</html>