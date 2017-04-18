<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		$("#subclass").hide();
		$("#profclass").hide();
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
		
		$("#MidStartInput").val($("#MidStartid").text());
		$("#MidEndInput").val($("#MidEndid").text());
		
		$("#FinalStartInput").val($("#FinalStartid").text());
		$("#FinalEndInput").val($("#FinalEndid").text());
		
		$("#HomeworkStartInput").val($("#HomeworkStartid").text());
		$("#HomeworkEndInput").val($("#HomeworkEndid").text());
		$("#outline1").text($("#outline2").text());
		$("#goal1").text($("#goal2").text());
		$("#method1").text($("#content2").text());
		$("#content1").text($("#content2").text());
		$("#week1w").text($("#week1").text());
		$("#week-2w").text($("#week-2").text());
		$("#week-3w").text($("#week-3").text());
		$("#week-4w").text($("#week-4").text());
		$("#week-5w").text($("#week-5").text());
		$("#week-6w").text($("#week-6").text());
		$("#week-7w").text($("#week-7").text());
		$("#week-8w").text($("#week-8").text());
		$("#week-9w").text($("#week-9").text());
		$("#week-10w").text($("#week-10").text());
		$("#week-11w").text($("#week-11").text());
		$("#week-12w").text($("#week-12").text());
		$("#week-13w").text($("#week-13").text());
		$("#week-14w").text($("#week-14").text());
		$("#week-15w").text($("#week-15").text());

	})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarprof.jsp" %>
	<div class="container">
		<h1>강의계획서 수정</h1>
		<hr class="one">
		<div class="row well">
			<form:form method="post" action="/jhta/prof/syllupdate?no=${syno.no }" modelAttribute="syllabusform">
				<div class="form-group" id="subclass">
					<label>과목명</label>
					<form:select path="subno" cssClass="form-control" selected="${syno.subject.subjackName }">
						<c:forEach var="subject" items="${subList }" varStatus="status">
							<form:option id="subname-${status.count }" value="${subject.no }">${subject.subjectName }</form:option>							
						</c:forEach>
					</form:select>
					<form:input type="hidden" path="subname" id="subname1" value="${syno.subject.subjeckName }"/>
				</div>
				<div class="form-group">
					<label>중간점수퍼센트</label>
					<form:input path="midtrum" cssClass="form-control" value="${syno.midtrum }"></form:input>
					<form:errors path="midtrum" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>기말점수퍼센트</label>
					<form:input path="final1" cssClass="form-control" value="${syno.final1 }"/>
					<form:errors path="final1" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>출석점수퍼센트</label>
					<form:input path="atlen" cssClass="form-control" value="${syno.atlen }"/>
					<form:errors path="atlen" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과제점수퍼센트</label>
					<form:input path="project" cssClass="form-control" value="${syno.project }"/>
					<form:errors path="project" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>성적분포</label>
					<form:input path="distri" cssClass="form-control" value="${syno.distri }"/>
					<form:errors path="distri" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과목개요</label>
					<span id="outline2" style="display:none;">${syno.outline}</span>
					<form:textarea path="outline" cssClass="form-control" id="outline1"/>
					<form:errors path="outline" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>수업목표</label>
					<span id="goal2" style="display:none;">${syno.goals}</span>
					<form:textarea path="goals" cssClass="form-control" id="goal1"/>
					<form:errors path="goals" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>강의방법</label>
					<span id="method2" style="display:none;">${syno.method}</span>
					<form:textarea path="method" cssClass="form-control" id="method1"/>
					<form:errors path="method" cssClass="text-danger"></form:errors>
				</div>
				<h1 id="second">교수</h1>
				<div class="second">
				<div class="form-group" id="profclass">
					<label>담당 교수</label>
					<form:select path="id" cssClass="form-control" selected="${syno.professor.id }">
						<c:forEach var="professor" items="${proList }" varStatus="status">
							<form:option id="prof-${status.count }" value="${professor.id }">${professor.name }</form:option>	
						</c:forEach>
					</form:select>
					<form:input type="hidden" path="name" id="prof1" value="${syno.professor.id }"/>
				</div>
				<div class="form-group">
					<label>이메일주소</label>
					<form:input path="email" cssClass="form-control" value="${syno.email }"/>
					<form:errors path="email" cssClass="text-danger"></form:errors>
					
				</div>
				<div class="form-group">
					<label>전화번호</label>
					<form:input path="phone" cssClass="form-control" value="${syno.phone }"/>
					<form:errors path="phone" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>주교재</label>
					<form:input path="book" cssClass="form-control" value="${syno.book }"/>
					<form:errors path="book" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>중간고사시작날짜</label>
					<span id="MidStartid" style="display:none;"><fmt:formatDate value='${syno.midst}' pattern='yyyy-MM-dd'/></span>	
					<form:input id="MidStartInput" path="midst" type="date" cssClass="form-control"/>
					<form:errors path="midst" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>중간고사종료날짜</label>
					<span id="MidEndid" style="display:none;"><fmt:formatDate value='${syno.midend}' pattern='yyyy-MM-dd'/></span>	
					<form:input id="MidEndInput" path="midend" type="date" cssClass="form-control"/>
					<form:errors path="midend" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>기말고사시작날짜</label>
					<span id="FinalStartid" style="display:none;"><fmt:formatDate value='${syno.finalst}' pattern='yyyy-MM-dd'/></span>	
					<form:input id="FinalStartInput" path="finalst" type="date" cssClass="form-control"/>
					<form:errors path="finalst" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>기말고사종료날짜</label>
					<span id="FinalEndid" style="display:none;"><fmt:formatDate value='${syno.finalend}' pattern='yyyy-MM-dd'/></span>	
					<form:input id="FinalEndInput" path="finalend" type="date" cssClass="form-control"/>
					<form:errors path="finalend" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과제제출시작날짜</label>
					<span id="HomeworkStartid" style="display:none;"><fmt:formatDate value='${syno.prost}' pattern='yyyy-MM-dd'/></span>	
					<form:input id="HomeworkStartInput" path="prost" type="date" cssClass="form-control"/>
					<form:errors path="prost" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과제제출종료날짜</label>
					<span id="HomeworkEndid" style="display:none;"><fmt:formatDate value='${syno.proend}' pattern='yyyy-MM-dd'/></span>	
					<form:input id="HomeworkEndInput" path="proend" type="date" cssClass="form-control"/>
					<form:errors path="proend" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<label>과제물</label>
					<span id="content2" style="display:none;">${syno.procontent}</span>
					<form:textarea path="procontent" cssClass="form-control" id="content1"/>
				</div>
				</div>
				<h1 id="third">강의계획</h1>
				<div class="third">
				<div class="form-group">
					<label>1주차강의계획</label>
					<span id="week1" style="display:none;">${syno.week1}</span>
					<form:textarea path="week1" cssClass="form-control" id="week1w"/>
				</div>
				<div class="form-group">
					<label>2주차강의계획</label>
					<span id="week-2" style="display:none;">${syno.week2}</span>
					<form:textarea path="week2" cssClass="form-control" id="week-2w"/>
				</div>
				<div class="form-group">
					<label>3주차강의계획</label>
					<span id="week-3" style="display:none;">${syno.week3}</span>
					<form:textarea path="week3" cssClass="form-control" id="week-3w"/>
				</div>
				<div class="form-group">
					<label>4주차강의계획</label>
					<span id="week-4" style="display:none;">${syno.week4}</span>
					<form:textarea path="week4" cssClass="form-control" id="week-4w"/>
				</div>
				<div class="form-group">
					<label>5주차강의계획</label>
					<span id="week-5" style="display:none;">${syno.week5}</span>
					<form:textarea path="week5" cssClass="form-control" id="week-5w"/>
				</div>
				<div class="form-group">
					<label>6주차강의계획</label>
					<span id="week-6" style="display:none;">${syno.week6}</span>
					<form:textarea path="week6" cssClass="form-control" id="week-6w"/>
				</div>
				<div class="form-group">
					<label>7주차강의계획</label>
					<span id="week-7" style="display:none;">${syno.week7}</span>
					<form:textarea path="week7" cssClass="form-control" id="week-7w"/>
				</div>
				<div class="form-group">
					<label>8주차강의계획</label>
					<span id="week-8" style="display:none;">${syno.week8}</span>
					<form:textarea path="week8" cssClass="form-control" id="week-8w"/>
				</div>
				<div class="form-group">
					<label>9주차강의계획</label>
					<span id="week-9" style="display:none;">${syno.week9}</span>
					<form:textarea path="week9" cssClass="form-control" id="week-9w"/>
				</div>
				<div class="form-group">
					<label>10주차강의계획</label>
					<span id="week-10" style="display:none;">${syno.week10}</span>
					<form:textarea path="week10" cssClass="form-control" id="week-10w"/>
				</div>
				<div class="form-group">
					<label>11주차강의계획</label>
					<span id="week-11" style="display:none;">${syno.week11}</span>
					<form:textarea path="week11" cssClass="form-control" id="week-11w"/>
				</div>
				<div class="form-group">
					<label>12주차강의계획</label>
					<span id="week-12" style="display:none;">${syno.week12}</span>
					<form:textarea path="week12" cssClass="form-control" id="week-12w"/>
				</div>
				<div class="form-group">
					<label>13주차강의계획</label>
					<span id="week-13" style="display:none;">${syno.week13}</span>
					<form:textarea path="week13" cssClass="form-control" id="week-13w"/>
				</div>
				<div class="form-group">
					<label>14주차강의계획</label>
					<span id="week-14" style="display:none;">${syno.week14}</span>
					<form:textarea path="week14" cssClass="form-control" id="week-14w"/>
				</div>
				<div class="form-group">
					<label>15주차강의계획</label>
					<span id="week-15" style="display:none;">${syno.week15}</span>
					<form:textarea path="week15" cssClass="form-control" id="week-15w"/>
				</div>
				</div>
				
				<div class="form-group text-right">
					<button type="submit" class="btn btn-primary">수정</button>
					<a href="/jhta/prof/profinfo" class="btn btn-warning">취소</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>