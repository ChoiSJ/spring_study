<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
	.ceth { text-align: center !important;
		vertical-align: middle !important;}
	.cetr { text-align: center !important;
		vertical-align: middle !important;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/profnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
<div class="container" style="margin-left: 250px; padding-top:25px; ">
<div class="row text-right">
    Professor Report
    </div>
    <div class="row">
       <h4><span class="glyphicon glyphicon-th-list"></span>Professor Report</h4>
       <hr style="border:solid 0.5px #2C7BB5;">
    </div>
      
    <div class="row">
	    <form>
			<table class="table table-bordered">
				<colgroup>
					<col width="10%" />
					<col width="25%" />
					<col width="10%" />
					<col width="*" />
				</colgroup>
				<thead>
					<tr>
						<th class="ceth">과목</th>
						<th>${profReport.report.subject.subjectName}</th>
						<th class="ceth">교수</th>
						<th>${profReport.report.professor.name }</th>
					</tr>
					<tr>
						<th class="ceth">요일</th>
						<th>${profReport.enroll.enrollDay }</th>
						<th class="ceth">시간</th>
						<th>${profReport.enroll.enrollTime }</th>
					</tr>
					<tr>
						<th class="ceth">과제 마감일</th>
						<th colspan="3"><span id="proend"><fmt:formatDate value="${profReport.report.proend }" pattern="YYYY-MM-dd 23:55"/></span>
						</th>
					</tr>
					<tr>
						<th class="ceth">과제</th>
						<td colspan="3" style="height: 50px;">${profReport.title}</td>
					</tr>
					<tr>
						<th class="ceth">내용</th>
						<td colspan="3" style="height: 300px;">${profReport.content}</td>						
					</tr>
					<tr>
						<th class="ceth">첨부파일</th>
						<td colspan="3">
							<c:choose>
								<c:when test="${profReport.filename ne null}">
									<a href="/jhta/prof/report/fileDownload?no=${profReport.no}">${profReport.filename }</a><br />
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
				</thead>	
			</table>
		</form>
			<div class="form-group text-center">      
	      		<a href="/jhta/prof/scoreform.do?sno=${port.score.no }&psco=${port.subject.score}"><button class="btn btn-default">성적 입력</button></a>
	      		<a href="/jhta/prof/report/reportinfo" class="btn btn-default">뒤로</a>
	      	</div>
	</div>
</div>
</body>
</html>