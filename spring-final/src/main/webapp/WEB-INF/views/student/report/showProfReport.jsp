<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
	var nowDate = new Date();
	var parseNowDate = Date.parse(nowDate);
	var endDate = Date.parse($("#proend").text())
	
	if(parseNowDate <= endDate) {
		$("#submit-btn").removeAttr("disabled", "disabled");
	}

	$("form").submit(function() {	
		if(parseNowDate > endDate) {
			alert("과제 제출 기한이 지났습니다.");
			return false;
		}
	});
	
	
})
</script>
<style type="text/css">
	.ceth { text-align: center !important;
		vertical-align: middle !important;}
	.cetr { text-align: center !important;
		vertical-align: middle !important;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
<div class="container" style="margin-left: 250px; padding-top:25px; ">
<div class="row text-right">
    Professor Report
    </div>
    <div class="row">
       <h4><span class="glyphicon glyphicon-th-list"></span>Professor Report</h4>
       <hr style="border:solid 0.5px #2C7BB5;">
    </div>
      
    <div class="row">
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
					<th>${profReport.enroll.subject.subjectName}</th>
					<th class="ceth">교수</th>
					<th>${profReport.professor.name }</th>
				</tr>
				<tr>
					<th class="ceth">요일</th>
					<th>${profReport.enroll.enrollDay }</th>
					<th class="ceth">시간</th>
					<th>${profReport.enroll.enrollTime }</th>
				</tr>
				<tr>
					<th class="ceth">과제 마감일</th>
					<th colspan="3"><span id="proend"><fmt:formatDate value="${profReport.proend }" pattern="YYYY-MM-dd 23:55"/></span>
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
							<c:when test="${profReport.upfile ne null}">
								<a href="#">${profReport.upfile}</a>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</thead>	
		</table>
		<div class="form-group text-center">      
      		<a href="stuReportAfter?rno=${profReport.no}&eno=${param.eno}" type="submit" class="btn btn-default" id="submit-btn" disabled="disabled">과제 등록</a>
      		<a href="ReportHome?eno=${param.eno}" class="btn btn-default">뒤로가기</a>
      	</div>
	</div>
</div>
</body>
</html>