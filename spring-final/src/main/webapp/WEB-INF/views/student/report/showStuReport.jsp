<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
	var today = new Date();
	var month = today.getMonth()+1;
	var day = today.getDate();
	var output = today.getFullYear() + '년 ' +
	    (month<10 ? '0' : '') + month + '월 ' +
	    (day<10 ? '0' : '') + day + '일';
	$("#enroll-Today").text(output);
		
	var parseNowDate = Date.parse(today);
	var endDate = Date.parse($("#proend").text());
		
	if(parseNowDate >= endDate) {
		$("#submit-btn").css("display", "none");
	}
	
})
</script>
<style type="text/css">
	th { text-align: center !important;
		 vertical-align: middle !important;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
<div class="container" style="margin-left: 250px; padding-top:25px; ">
<div class="row text-right">
      Report
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span>Report</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      
      <div class="row">
	      <div class="form-group text-right">
	      	<c:choose>
	      		<c:when test="${stuReport.filename ne null}">
			      	<a href="editReportFile?cno=${stuReport.no}&eno=${stuReport.enroll.no}" class="btn btn-default" id="submit-btn">수정</a>	      		
	      		</c:when>
	      		<c:otherwise>
			      	<a href="editReport?cno=${stuReport.no}&eno=${stuReport.enroll.no}" class="btn btn-default" id="submit-btn">수정</a>	      			      		
	      		</c:otherwise>
	      	</c:choose> 
	      	<a href="deleteReprot?cno=${stuReport.no }&eno=${stuReport.enroll.no}" class="btn btn-default">삭제</a>
	      </div>
		      <table class="table table-bordered">
		      	<colgroup>
		      		<col width="15%" />
		      		<col width="35%" />
		      		<col width="15%" />
		      		<col width="35%" />	
		      	</colgroup>
		      	<thead>
		      		<tr>
		      			<th>이름</th>
		      			<th>${student.name }</th>
		      			<th>학과</th>
		      			<th>${student.tName }</th>
		      		</tr>
		      		<tr>
		      			<th>제출일</th>
		      			<th><span id="enroll-Today"></span></th>
		      			<th>마감일</th>
		      			<th><span id="proend"><fmt:formatDate value="${stuReport.report.proend }" pattern="YYYY-MM-dd 23:55"/></span></th>
		      		</tr>
		      		<tr>
		      			<th>과제</th>
		      			<th colspan="3">${stuReport.report.title}</th>
		      		</tr>
		      		<tr>
						<th>*제목</th>  			
		      			<td colspan="3">
		      				${stuReport.title }
		      			</td>
		      		</tr>
		      		<tr>
		      			<th>*내용</th>
		      			<td colspan="3" style="height: 214px;">
		      				${stuReport.content }
		      			</td>
		      		</tr>
		      		<tr>
		      			<th>파일첨부</th>
		      			<td colspan="3">
		      				<c:if test="${stuReport.filename ne null}">
		      					<a href="fileDownload.do?cno=${stuReport.no}">${stuReport.filename }</a><br />
		      				</c:if>      				
		      			</td>
		      		</tr>
		      		<tr>
		      			<th>비공개</th>
		      			<td colspan="3">
		      				<em>* 게시글은 담당 교수님과 자신만 볼 수 있습니다.</em>
		      			</td>
		      		</tr>
		      	</thead>
		      </table>
	      	<div class="form-group text-right">      
	      		<a href="ReportHome?eno=${stuReport.enroll.no}" class="btn btn-default">돌아가기</a>
	      	</div>
      </div>
</div>
</body>
</html>