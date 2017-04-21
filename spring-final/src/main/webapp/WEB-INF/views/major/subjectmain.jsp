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
<%@ include file="/WEB-INF/views/navi/sidebarmajor.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px; ">
    	<div class="row text-right">
			홈 > 과목관리 > <strong>과목검색</strong>
    	</div>
    	<div class="row">
    	<h4><span class="glyphicon glyphicon-th-list"></span> 과목검색</h4>
        <hr style="border:solid 0.5px #2C7BB5;">
    	</div>
      	
      	<div class="panel panel-default panel-body">
      		<form method="post" action="subjectmain" name="subjectsearchform" id="subject-search-form" class="form-inline">
      			<table class="table table-condensed">
      				<tr>
      					<td><label>검색옵션</label></td>
      					<td>
      						<select name="selectNo.no" >
      							<option value="">학기선택</option>
      							<c:forEach var="seme" items="${semeList }">  
      								<option value="${seme.no }">
      									<c:forTokens items="${seme.semeSelect }" delims="-" begin="0" end="0" var="a" >${a }</c:forTokens>년도  							
      									<c:forTokens items="${seme.semeSelect }" delims="-" begin="1" end="1" var="b" >${b }</c:forTokens>학기
      								</option>	
      							</c:forEach>
      						</select>
      					</td>
      				</tr>
      				<tr>
      					<td></td>
      					<td>
      						<div class="form-group">
	      						<select name="opt" class="form-controll" id="selectopt2">
	      							<option>세부항목</option>
	      							<option value="subjectname">과목명</option>
	      							<option value="profname">교수명</option>
	      						</select>
      						</div>
      						<div class="form-group">
      							<label>검색어</label>
      							<input type="text" name="keyword" value="${searchsubject.keyword }" required="required">
      						</div>
      						<button type="submit" class="btn btn-default" id="search-btn">검색</button>
      					</td>
      				</tr>
      			</table>
      		</form>
    	
    		<div class="row text-left pull-left">
    			<select name="rows" >
    				<option value="10" ${searchsubject eq 10? 'selected=selected' : '' }>10건씩 정렬</option>
    				<option value="50" ${searchsubject eq 50? 'selected=selected' : '' }>50건씩 정렬</option>
    				<option value="100" ${searchsubject eq 100? 'selected=selected' : '' }>100건씩 정렬</option>
    			</select>
    		</div>
      		<a href="addsubject" class="btn btn-primary btn-sm pull-right">교과등록</a>
      	
      	</div>
      	<div class="panel panel-body">
      		<table class="table table-condensed">
      			<thead>
      				<tr>
      					<th>년도학기</th>
      					<th>시행학과</th>
      					<th>과목명</th>
      					<th>교수명</th>
      					<th>분반수</th>
      					<th>이수구분</th>
      					<th>학점</th>
      					<th>학년</th>
      				</tr>
      			</thead>
      			<tbody>
      			<c:forEach var="subject" items="${resultList }">
      				<tr>
      					<td>${subject.selectNo.semeSelect }</td>
      					<td><a href="detailsubject?sno=${subject.no }">${subject.siteCode.name }</a></td>
      					<td>${subject.subjectName }</td>
      					<td>${subject.professor.name }</td>
      					<td>${subject.division }</td>
      					<td>${subject.passed.passedName }</td>
      					<td>${subject.score }</td>
      					<td>${subject.grade }</td>
      				</tr>
      			</c:forEach>	
      			</tbody>
      		</table>
      	</div>
    
    </div>
<%-- <%@ include file="/WEB-INF/views/footer/footer.jsp" %>--%>
</body>
</html>
      