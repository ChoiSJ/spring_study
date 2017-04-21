<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
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
$(function() {
	$("#select-dept").change(function() {
		var dept = $(this).find("option:selected").val();
		if(dept == ""){
			$("#select-major").empty();
			$("#select-prof").empty();
			return false;
		}
		
		$.ajax({
			url: "addmajormenu?dept=" + dept,
			dataType: "json",
			type: "POST",
			success: function(data) {
				$("#select-major").empty();
				$("#select-prof").empty();
				
				for (var i=0; i<data.sitemapList.length; i++) {
					$("#select-major").append("<option value="+data.sitemapList[i].code+">"+data.sitemapList[i].name+"</option>");	
				}
				for (var i=0; i<data.profList.length; i++) {
					$("#select-prof").append("<option value="+data.profList[i].id+">"+data.profList[i].name+"</option>");	
				}
			}
		});
	});
	
	$("#select-major").change(function () {
		var code = $(this).find("option:selected").val();
		
		$.ajax({
			url: "addprofmenu?code=" + code,
			dataType: "json",
			type: "POST",
			success: function(data) {
				$("#select-prof").empty();
				
				for (var i=0; i<data.length; i++) {
					$("#select-prof").append("<option value="+data[i].id+">"+data[i].name+"</option>");	
				}
			}
		});
	});
});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarmajor.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px; ">
    	<div class="row text-right">
         	홈 > 과목관리 > <strong>과목등록</strong>
      	</div>
      	<div class="row">
         	<h4><span class="glyphicon glyphicon-th-list"></span> 과목등록</h4>
         	<hr style="border:solid 0.5px #2C7BB5;">
      	</div>
      	<div class="row">
         	<div class="panel panel-default panel-body">
         		<form action="addsubject"  method="post" name="subjectaddform">
         			<table class="table table-condensed">
         				<colgroup>
         					<col width="10%">
         					<col width="40%">
         					<col width="10%">
         					<col width="40%">
         				</colgroup>
         				<tr>
         					<td><label>학과선택</label></td>
         					<td colspan="3">
         						<label>대학선택</label>
	         					<select name="dept" id="select-dept">
	         						<option value="">대학</option>
	         						<c:forEach var="dept" items="${deptList }">
	         						<option value="${dept.code }">${dept.name }</option>	
	         						</c:forEach>
	         					</select>
	         					<label>전공</label>
	         					<select name="siteCode.code" id="select-major"></select>
	         					
         					</td>
         				</tr>
         				<tr>
         					<td><label>과목명</label></td>
         					<td><input type="text" name="subjectName"></td>
         					
         					
         				</tr>
         				<tr>
         					<td><label>학기선택</label></td>
         					<td>
         						<select name="selectNo.no">
         							<option>학기</option>
         							<c:forEach var="seme" items="${semeList}">
         							<option value="${seme.no }">${seme.semeSelect }</option>
         							</c:forEach>
         						</select>
         					</td>
         					<td><label>이수구분</label></td>
         					<td>
         						<select name="passed.code">
         							<option>이수구분</option>
         							<option value="ns">구분없음</option>
         							<option value="me">전공필수</option>
         							<option value="ms">전공선택</option>
         							<option value="ce">교양필수</option>
         							<option value="cs">교양선택</option>
         							<option value="gs">일반선택</option>
         							<option value="db">학부기초</option>
         						</select>
         					</td>
         					
         				</tr>
         				<tr>
         					<td><label>대상학년</label></td>
         					<td>
         						<select name="grade">
         							<option>학년선택</option>
         							<option value="0">전체</option>
         							<option value="1">1학년</option>
         							<option value="2">2학년</option>
         							<option value="3">3학년</option>
         							<option value="4">4학년</option>
         						</select>
         					</td>
         					<td><label>교수명</label></td>
         					<td>
         						<select name="professor.id" id="select-prof">
         							<option>교수선택</option>
         							
         						</select>
         					</td>
         					
         					
         				</tr>
         				<tr>
         					<td><label>학점</label></td>
         					<td>
         						<select name="score">
         							<option>학점선택</option>
         							<option value="1">1</option>
         							<option value="2">2</option>
         							<option value="3">3</option>
         						</select>
         					</td>
         					<td><label>정원</label></td>
         					<td>
         						<input type="number" name="limitStu">
         					</td>
         				</tr>
         				
         				
         			</table>
         			<div>
         				<button type="submit" class="btn btn-primary pull-right">등록</button>
         				<a href="subjectmain" class="btn btn-default pull-left">취소</a>
         			</div>
         		</form>
         	
         	</div>
		</div>
      
	</div>
</body>
</html>