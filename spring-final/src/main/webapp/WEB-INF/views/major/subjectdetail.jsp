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
<script type="text/javascript">
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarmajor.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px; ">
    	<div class="row text-right">
			홈
    	</div>
    	<div class="row">
    		<h4><span class="glyphicon glyphicon-th-list"></span> 과목상세</h4>
        	<hr style="border:solid 0.5px #2C7BB5;">
    	</div>
    	
    	<div class="panel panel-default panel-body">
    		<div class="row well">
    			<form action="" method="post" name="subjectbyno">
    				<input type="hidden" name="no" value="${subjectbyno.no }">
    				<table class="table table-condensed">
    					<tr>
         					<td><label>과목명</label></td>
         					<td><input type="text" name="subjectName" value="${subjectbyno.subjectName }"></td>
         					<td><label>정원</label></td>
         					<td><input type="number" name="limitStu" value="${subjectbyno.limitStu }">
         				</tr>
         				<tr>
         					<td><label>이수구분</label></td>
         					<td>
         						<h1>${subjectbyno.passed.code }</h1>
         						<select name="passed.code">
         							<option value="ns" ${subjectbyno.passed.code eq 'ns' ? 'selected:selected' : ''}>구분없음</option>
         							<option value="me" ${subjectbyno.passed.code eq 'me' ? 'selected:selected' : ''}>전공필수</option>
         							<option value="ms" ${subjectbyno.passed.code eq 'ms' ? 'selected:selected' : ''}>전공선택</option>
         							<option value="ce" ${subjectbyno.passed.code eq 'ce' ? 'selected:selected' : ''}>교양필수</option>
         							<option value="cs" ${subjectbyno.passed.code eq 'cs' ? 'selected:selected' : ''}>교양선택</option>
         							<option value="gs" ${subjectbyno.passed.code eq 'gs' ? 'selected:selected' : ''}>일반선택</option>
         							<option value="db" ${subjectbyno.passed.code eq 'db' ? 'selected:selected' : ''}>학부기초</option>
         						</select>
         					</td>
         					<td><label>대상학년</label></td>
         					<td>
         						<select name="grade">
         							<option value="0">전체</option>
         							<option value="1">1학년</option>
         							<option value="2">2학년</option>
         							<option value="3">3학년</option>
         							<option value="4">4학년</option>
         						</select>
         					</td>
         				</tr>
         				<tr>
         					<td><label>교수명</label></td>
         					<td>
         						<select name="professor.id" id="select-prof">
         							<option>교수선택</option>
         							
         						</select>
         					</td>
         					<td><label>학점</label></td>
         					<td>
         						<select name="score">
         							<option>학점선택</option>
         							<option value="1">1</option>
         							<option value="2">2</option>
         							<option value="3">3</option>
         						</select>
         					</td>
         				</tr>
    				</table>
    			</form>
    		</div>
    	</div>
    </div>

</body>
<script type="text/javascript">

</script>
</html>