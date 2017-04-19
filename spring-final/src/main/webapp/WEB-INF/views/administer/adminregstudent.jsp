<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
	$(".form-inline").submit(function() {
		if ($("#select-major").val() == 0 || !$(":radio:checked").length || !$(":text").text().trim()) {
			alert("검색 값을 입력하세요.");
			$(":text").focus();
			return false;
		}
	});
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarsubject.jsp" %>
<div class="container" style="margin-left: 250px; padding-top: 25px;">
	<form method="post" action="adminregstudent" class="form-inline">
	<div class="row">
		<div class="col-sm-12">
			<h4>학생별 수강신청관리</h4><hr>
			<table class="table table-bordered">
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				<tbody>
					<tr>
						<td><label>학기검색</label></td>
						<td>
							<select class="form-control" name="major" id="select-major">
								<option value="0">학과선택</option>
								<c:forEach items="${majorList }" var="major">
									<option value="${major.code }">${major.name }</option>
								</c:forEach>
							</select>
							<select class="form-control" name="semester">
								<option value="0">전체학기</option>
								<c:forEach items="${semesterList }" var="semester">
									<option value="${semester.no }">${semester.semeSelect }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td><label>개별검색</label></td>
						<td>
							<input type="radio" name="student" value="name"> 이름
							<input type="radio" name="student" value="stuNo"> 학번
							<input type="text" name="word">
							<button type="submit" class="btn btn-sm btn-success">조회하기</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div><br>
	<div class="row">
		<div class="col-sm-12">
			<p><strong>검색 ${not empty stuListCount ? stuListCount : 0 }건</strong></p>
			<table class="table table-bordered">
				<colgroup>
					<col width="10%">
					<col width="10%">
					<col width="15%">
					<col width="*">
					<col width="10%">
					<col width="5%">
					<col width="5%">
					<col width="10%">
				</colgroup>
				<thead class="table-active">
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>소속</th>
						<th>교과목명</th>
						<th>년도/학기</th>
						<th>분반</th>
						<th>학점</th>
						<th>이수구분</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${stuList }" var="stu">
					<tr>
						<td>${stu.ID }</td>
						<td>${stu.NAME }</td>
						<td>${stu.DIVISION }</td>
						<td>${stu.SUBJECTNAME }</td>
						<td>${stu.SEMESELECT }</td>
						<td>${stu.division.no }</td>
						<td>${stu.SUBGRADE }</td>
						<td>${stu.ISPASSED }</td>
						<td class="text-center">
							<a href="adminstudelete?dno=${stu.enroll.no }" class="btn btn-xs btn-default">삭제</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</form>
</div>
</body>
</html>