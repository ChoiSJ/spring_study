<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
	hr.one{
   width : 100%;
   border: thin solid #1c86ee;
   color: #1c86ee;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(function(){
		$(".second").hide();
		$(".third").hide();
		$("#second").click(function(){
			$(this).next().slideToggle();
		})
		$("#third").click(function(){
			$(this).next().slideToggle();
		})
		$("[name='subno']").change(function () {
			$("#subname1").val($(this).find('option:selected').text());
			console.log($("#subname1").val());
		})
		$("[name='subno']").change(function () {
			$("#subname1").text($(this).find('option:selected').text());
			console.log($("#subname1").text());
		})
		$("[name='id']").change(function () {
			$("#prof1").val($(this).find('option:selected').text());
			console.log($("#prof1").val());
		})
		$("[name='id']").change(function () {
			$("#prof1").text($(this).find('option:selected').text());
			console.log($("#prof1").text());
		})
		$("#subname1").text($("[name='subno']").find('option:selected').text());
	
	})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
	<div class="container">
		<h1>새 강의계획서 등록하기</h1>
		<hr class="one">
		<div class="row well">
			<form:form method="post" action="/jhta/prof/syllform" modelAttribute="syllabusform">
				<div class="form-group">
					<label>과목명</label>
					<form:select path="subno" cssClass="form-control">
						<c:forEach var="subject" items="${subList }" varStatus="status">
							<form:option id="subname-${status.count }" value="${subject.no }">${subject.subjectName }</form:option>							
						</c:forEach>
					</form:select>
					<form:input type="hidden" path="subname" id="subname1" value=""/>
				</div>
				<div class="form-group">
					<label>중간점수퍼센트</label>
					<form:input path="midtrum" cssClass="form-control"/>
					<form:errors path="midtrum" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>기말점수퍼센트</label>
					<form:input path="final1" cssClass="form-control"/>
					<form:errors path="final1" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>출석점수퍼센트</label>
					<form:input path="atlen" cssClass="form-control"/>
					<form:errors path="atlen" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과제점수퍼센트</label>
					<form:input path="project" cssClass="form-control"/>
					<form:errors path="project" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>성적분포</label>
					<form:input path="distri" cssClass="form-control"/>
					<form:errors path="distri" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과목개요</label>
					<form:textarea path="outline" cssClass="form-control"/>
					<form:errors path="outline" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>수업목표</label>
					<form:textarea path="goals" cssClass="form-control"/>
					<form:errors path="goals" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>강의방법</label>
					<form:textarea path="method" cssClass="form-control"/>
					<form:errors path="method" cssClass="text-danger"></form:errors>
				</div>
				<h1 id="second">교수</h1>
				<div class="second">
				<div class="form-group">
					<label>담당 교수</label>
					<form:select path="id" cssClass="form-control">
						<c:forEach var="professor" items="${proList }" varStatus="status">
							<form:option id="prof-${status.count }" value="${professor.id }">${professor.name }</form:option>	
						</c:forEach>
					</form:select>
					<form:input type="hidden" path="name" id="prof1" value=""/>
				</div>
				<div class="form-group">
					<label>이메일주소</label>
					<form:input path="email" cssClass="form-control"/>
					<form:errors path="email" cssClass="text-danger"></form:errors>
					
				</div>
				<div class="form-group">
					<label>전화번호</label>
					<form:input path="phone" cssClass="form-control"/>
					<form:errors path="phone" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>주교재</label>
					<form:input path="book" cssClass="form-control"/>
					<form:errors path="book" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>중간고사시작날짜</label>
					<form:input path="midst" type="date" cssClass="form-control"/>
					<form:errors path="midst" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>중간고사종료날짜</label>
					<form:input path="midend" type="date" cssClass="form-control"/>
					<form:errors path="midend" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>기말고사시작날짜</label>
					<form:input path="finalst" type="date" cssClass="form-control"/>
					<form:errors path="finalst" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>기말고사종료날짜</label>
					<form:input path="finalend" type="date" cssClass="form-control"/>
					<form:errors path="finalend" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과제제출시작날짜</label>
					<form:input path="prost" type="date" cssClass="form-control"/>
					<form:errors path="prost" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과제제출종료날짜</label>
					<form:input path="proend" type="date" cssClass="form-control"/>
					<form:errors path="proend" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과제물</label>
					<form:textarea path="procontent" cssClass="form-control"/>
				</div>
				</div>
				<h1 id="third">강의계획</h1>
				<div class="third">
				<div class="form-group">
					<label>1주차강의계획</label>
					<form:textarea path="week1" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>2주차강의계획</label>
					<form:textarea path="week2" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>3주차강의계획</label>
					<form:textarea path="week3" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>4주차강의계획</label>
					<form:textarea path="week4" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>5주차강의계획</label>
					<form:textarea path="week5" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>6주차강의계획</label>
					<form:textarea path="week6" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>7주차강의계획</label>
					<form:textarea path="week7" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>8주차강의계획</label>
					<form:textarea path="week8" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>9주차강의계획</label>
					<form:textarea path="week9" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>10주차강의계획</label>
					<form:textarea path="week10" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>11주차강의계획</label>
					<form:textarea path="week11" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>12주차강의계획</label>
					<form:textarea path="week12" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>13주차강의계획</label>
					<form:textarea path="week13" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>14주차강의계획</label>
					<form:textarea path="week14" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label>15주차강의계획</label>
					<form:textarea path="week15" cssClass="form-control"/>
				</div>
				</div>
				
				<div class="form-group text-right">
					<button type="submit" class="btn btn-primary">등록</button>
					<a href="/jhta/profMain" class="btn btn-warning">취소</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>