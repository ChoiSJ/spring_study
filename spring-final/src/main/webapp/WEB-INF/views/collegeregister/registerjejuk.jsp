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
$(function () {
	$("#search-btn").click(function () {
		
	});
});
</script>


</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/collegeregister/sidebar-hakjuk.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px; ">
    	<div class="row text-right">
			홈 > 학적관리 > 제적관리 > <strong>제적처리</strong>
    	</div>
    	<div class="row">
    	<h4><span class="glyphicon glyphicon-th-list"></span> 제적처리</h4>
        <hr style="border:solid 0.5px #2C7BB5;">
    	</div>
    </div>
    
    <div class="row">
      	<div class="col-xs-2">
      		<img src="../resources/images/student/PeoPleDefault.png" alt="person" style="width: 130px; height: 140px;"/>
      	</div>
      	<div class="col-xs-10">
      		<p>학생 정보</p>
        	
        	<form action="insurejejuk" name="">
        		<input type="hidden" name="student.no" value="${student.no }">
	        	<table class="table table-bordered">
		        	<colgroup>
		        		<col width="20%" />
		        		<col width="30%" />
		        		<col width="20%" />
		        		<col width="30%" />
		        	</colgroup>
		           	<thead>
		        		<tr>
		        			<th>학적</th>
		        			<td colspan="3">
		        				<c:out value="${student.register }" />
		        			</td>
		        		</tr>
		        		<tr>
		        			<th>이름</th>
		        			<td><c:out value="${student.name }" /></td>
		        			<th>학번</th>
		        			<td><c:out value="${student.id }"/></td>
		        		</tr>
		        		<tr>
		        			<th>전공</th>
		        			<td><c:out value="${student.division}"/></td>
		        			<th>학년</th>
		        			<td><c:out value="${student.grade }"/></td>
		        		</tr>
		        		<tr>
		        			<th>제적사유</th>
		        			<td>
		        				<select required="required" name="reason">
		        					<option>선택해주세요</option>
		        					<option value="미등록제적">미등록제적</option>
		        					<option value="미복학제적">미복학제적</option>
		        					<option value="이중학적제적">이중학적제적</option>
		        					<option value="징계제적">징계제적</option>
		        					<option value="재학연한초과제적">재학연한초과제적</option>
		        					<option value="학사경고초과제적">학사경고초과제적</option>
		        				</select>
		        			</td>
		        			<th>제적처리</th>
		        			<td><button type="submit">제적처리</button></td>
		        		</tr>
		        		
		        	</thead>
		        </table>
	        </form>
        </div>
      </div>  

</body>
</html>