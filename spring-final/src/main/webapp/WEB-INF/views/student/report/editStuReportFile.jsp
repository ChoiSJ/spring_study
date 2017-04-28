<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		
	$("form").submit(function() {
		
		if(parseNowDate > endDate) {
			alert("과제 제출 기한이 지났습니다.");
			return false;
		}
		
		if(!$("#input-title").val()) {
			alert("제목을 입력하세요");
			$("#input-title").focus()
			return false;
		}
		
		if(!$("#input-content")) {
			alert("내용을 입력하세요");
			$("#input-content").focus();
			return false;
		}
		
	});
	
	$("#name-Sign").keyup(function(event) {
		if($("#name-Sign").val() == $("#student-name").val()) {
			$("#NameCheckSpan").empty();
			$("#NameCheckSpan").append("<font color='blue' id='Remessage'>자신의 이름과 같습니다.</font>");
			$("#submit-btn").removeAttr("disabled");
		} else {
			$("#NameCheckSpan").empty();
			$("#NameCheckSpan").append("<font color='red' id='Remessage'>이름을 입력하세요.</font>");
			$("#submit-btn").attr("disabled", "disabled");
		}
	});
	
	$("#input-content").text($("#content").text());
	
	$(".deleteFile").on("click", function() {
		var $a = $(this).parent();
		var filename = $(this).text();
		var cno = $("#input-Cno").val();	
		
		$.ajax({
			type:"POST",
			url:"deleteReportFile/"+ cno,
			dataType:"json",
			success:function() {
				
				$a.remove();
				$("#empty-Th").text("파일이 삭제되었습니다.");
			}
		});

		console.log($("#file").attr("path"));
	});
	
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
	      <form:form action="editReportFile" method="POST"  modelAttribute="preportContentForm" enctype="multipart/form-data">
		      <input type="hidden" name="eno" value="${preportContent.enroll.no}" />
		      <form:input type="hidden" path="no" value="${preportContent.no}" />
		      <input type="hidden" id="input-Cno" value="${preportContent.no}"/>
		      <div class="form-group text-right"> 
		      	<a href="deleteReprot?cno=${preportContent.no }&eno=${preportContent.enroll.no}" class="btn btn-default">삭제</a>
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
		      			<th><span id="proend"><fmt:formatDate value="${preportContent.report.proend }" pattern="YYYY-MM-dd 23:55"/></span></th>
		      		</tr>
		      		<tr>
		      			<th>과제</th>
		      			<th colspan="3">${preportContent.report.title}</th>
		      		</tr>
		      		<tr>
						<th>*제목</th>  			
		      			<td colspan="3">
		      				<form:input type="text" path="title" cssClass="form-control" id="input-title" value="${preportContent.title }" />
		      			</td>
		      		</tr>
		      		<tr>
		      			<th>*내용</th>
		      			<td colspan="3" style="height: 214px;">
		      				<span id="content" style="display:none;">${preportContent.content }</span>
		      				<form:textarea path="content" id="input-content" cols="30" rows="10" cssClass="form-control"></form:textarea>
		      			</td>
		      		</tr>
		      		<tr>
		      			<th>*서명</th>
		      			<td colspan="3"><input type="text" id="name-Sign"/>
		      				<span id="NameCheckSpan"><font color='red'>이름을 입력하세요.</font></span>
		      			</td>
		      		</tr>
		      		<tr>
		      			<th>파일첨부</th>
		      			<td colspan="3" id="empty-Th">
	      					<a class="btn btn-default btn-sm"><span class="deleteFile glyphicon glyphicon-remove" aria-hidden="true">${preportContent.filename }</span></a>
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
	      	<input type="hidden" value=${student.name } id="student-name" />
	      	<div class="form-group text-center">      
	      		<button type="submit" class="btn btn-default" id="submit-btn" disabled="disabled">제출</button>
	      		<a href="ReportHome?eno=${preportContent.enroll.no}" class="btn btn-default">취소</a>
	      	</div>
      	</form:form>
      </div>
</div>
</body>
</html>