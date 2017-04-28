<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	if($("#isSame").val() == "false") {
		alert("접근 권한이 없습니다.");
	}
})
</script>
<style type="text/css">
	th { text-align: center !important;
		vertical-align: middle !important;}
	td { text-align: center !important;
		vertical-align: middle !important;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
<div class="container" style="margin-left: 250px; padding-top:25px; ">
<input type="hidden" id="isSame" value="${param.isSamePerson}" />
	<div class="row text-right">
         	과제 게시판
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 수강 과목</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <div class="row">
		<div style="padding-top: 20px;" class="text-center form-group">
			<form method="post" action="enrollMain" >
				<select class="w3-select w3-border" style="width: 8%; height: 37px;">
					<option value="gradeAll">전체</option>
					<option value="grade1">제목</option>
					<option value="grade2">2 학년</option>
					<option value="grade3">3 학년</option>
					<option value="grade4">4 학년</option>
				</select>
				<input type="text" name="searchInput" style="width: 30%; height: 37px;"/>
				<button type="submit" class="btn btn-default" >검색</button>	
			</form>
		</div>
      </div>
      <hr />
      <div class="row">
	     <table class="table table-bordered">
	     	<colgroup>
	     		<col width="10%" />
	     		<col width="*" />
	     		<col width="20%" />
	     		<col width="10%" />
	     		<col width="20%" />
	     		<col width="10%" />
	     	</colgroup>
	     	<thead>
	     		<tr>
	     			<th>번호</th>
	     			<th>제목</th>
	     			<th>작성자</th>
	     			<th>파일 첨부</th>
	     			<th>등록일</th>
	     		</tr>
	     	</thead>
	     	<tbody>
	     		<!-- 교수 -->
	     		<c:if test="${!empty profReportList}">
		     		<c:forEach var="profReport" items="${profReportList}">
			     		<tr>
			     			<td><font color="red">과제</font></td>		
			     			<td><a href="showProfReport?pno=${profReport.no}&eno=${param.eno}">${profReport.title }</a></td>
			     			<td>${profReport.professor.name } 교수</td>
			     			<td></td>
			     			<td>과제 등록일</td>
			     		</tr>
		     		</c:forEach>
	     		</c:if>
	     		<!-- 학생 -->
	     		<c:if test="${!empty stuReportList }">
	     			<c:forEach var="stuReport" items="${stuReportList }">
			     		<tr>
			     			<td>${stuReport.no}</td>
			     			<td>
			     				<a href="showStuReport?cno=${stuReport.no}&eno=${stuReport.enroll.no}">${stuReport.title}</a>
			     			</td>
			     			<td>${stuReport.student.name}</td>
			     			<td>
			     				<c:choose>
			     					<c:when test="${stuReport.filename ne null}">
			     						<span class="glyphicon glyphicon-save-file" aria-hidden="true"></span>
			     					</c:when>
			     					<c:otherwise>
			     					</c:otherwise>
			     				</c:choose>
			     			</td>
			     			<td><fmt:formatDate value="${stuReport.enrollDate}" pattern="YYYY-MM-dd HH:mm"/> </td>
			     		</tr>	     				
	     			</c:forEach>
	     		</c:if>
	     	</tbody>
	     </table> 
	</div>
</div>
</body>
</html>