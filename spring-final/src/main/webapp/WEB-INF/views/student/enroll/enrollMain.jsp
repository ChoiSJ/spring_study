<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style type="text/css">
	th { text-align: center !important;
		vertical-align: middle !important;}
</style>
<script type="text/javascript">
$(function() {
	
	$("#select-dept").change(function() {
		var dept = $(this).val();
		
		if(dept=="") {
			$("#select-major").empty();
			return false;
		}
		
		$.ajax({
			url: "enrollSubjectSearch?dept=" + dept,
			dataType: "json",
			type: "POST",
			success: function(data) {
				$("#select-major").empty();
				
				for (var i=0; i<data.length; i++) {
					$("#select-major").append("<option value="+data[i].code+">"+data[i].name+"</option>");
				}
			}
		});
	});
 // access=deny 처리 하기
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
   <div class="container" style="margin-left: 250px; padding-top:25px; ">
    <div class="row text-right">
         	홈
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 수강신청</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <div class="row">
		<div style="padding-top: 20px;" class="text-center form-group">
			<form method="post" action="enrollMain" >
				<select class="w3-select w3-border" name="option1" style="width: 8%; height: 37px;">
					<option value="gradeAll">전체</option>
					<option value="grade1">1 학년</option>
					<option value="grade2">2 학년</option>
					<option value="grade3">3 학년</option>
					<option value="grade4">4 학년</option>
				</select>
				<select class="w3-select w3-border" name="dept" id="select-dept" style="width: 16%; height: 37px;">
					<option value="">학부</option>
					<c:forEach items="${deptList }" var="dept">
						<option value="${dept.code }">${dept.name }</option>
					</c:forEach>
				</select>
				<select class="w3-select w3-border" name="select-major" id="select-major" style="width: 16%; height: 37px;">
					<option value="siteAll">전공</option>
				</select>
				<input type="text" name="searchInput" style="width: 30%; height: 37px;"/>
				<button type="submit" class="" style="background-color: gray; height:30px; width:70px;">검색</button>	
			</form>
		</div>
      </div>
      <hr />
      <div class="row">
      	신청 목록
      	<!-- <form action="enrollSend" method="POST"> -->
	      	<table class="table table-bordered">
	      		<colgroup>
	      			<col width="10%" />
	      			<col width="8%" />
	      			<col width="8%" />
	      			<col width="*" />
	      			<col width="8%" />
	      			<col width="10%" />
	      			<col width="10%" />
	      			<col width="5%" />
	      			<col width="10%" />
	      			<col width="8%" />
	      		</colgroup>
	      		<thead>
	      			<tr>
	      				<th>번호</th>
	      				<th>이수구분</th>
	      				<th>학년</th>
	      				<th>과목명</th>
	      				<th>담당교수</th>
	      				<th>강의요일</th>
	      				<th>강의시간</th>
	      				<th>학점</th>
	      				<th>신청인원</th>
	      				<th>신청</th>
	      			</tr>
	      		</thead>
	      		<tbody>
	      			<c:forEach var="enroll" items="${subList}" >
	      				<tr>
	      					<th>${enroll.siteCode.name}</th>
	      					<th>${enroll.passed.passedName }</th>
	      					<th>${enroll.grade }</th>	<!-- 학년 -->
	      					<th>${enroll.subjectName }</th>	<!-- 과목명 -->
	      					<th>${enroll.professor.name }</th>	<!-- 담당교수 -->
	      					<%-- ${enroll.subject.professor } --%>
	      					<th>${enroll.enroll.enrollNum }</th>	<!-- 강의 요일-->
	      					<th>${enroll.enroll.enrollTime }</th>	<!-- 강의 시간 -->
	      					<th>${enroll.score }</th>	<!-- 학점 -->
	      					<th>
	      						<c:choose>
	      							<c:when test="${enroll.enroll.enrollNum eq enroll.limitStu}">
	      								<strong><font color="red">마감</font></strong>
	      							</c:when>
	      							<c:otherwise>
					      				${enroll.enroll.enrollNum } / ${enroll.limitStu}	<!-- 신청 인원 -->
	      							</c:otherwise>
	      						</c:choose>	  
	      					</th>    					
	      					<th>
	      						<c:choose>
	      							<c:when test="${regisubList == null }">
	      								<a href="enrollSend?enrollNo=${enroll.enroll.no }" class="btn btn-default">신청</a>	
	      							</c:when>
	      							<c:otherwise>
	      								<c:forEach var="regisub" items="${regisubList }">
	      									<c:choose>
		      									<c:when test="${regisub.subject.siteCode.code eq enroll.siteCode.code}">
												<strong><font color="blue">신청 완료</font></strong>
												</c:when>
												<c:when test="${enroll.enroll.enrollNum eq enroll.limitStu}">
													<strong><font color="red">마감</font></strong>
												</c:when>
												<c:otherwise>
													<a href="enrollSend?enrollNo=${enroll.enroll.no }" class="btn btn-default">신청</a>							
												</c:otherwise>
											</c:choose>
		      							</c:forEach>
	      							</c:otherwise>
	      						</c:choose>														
	      					</th>
	      				</tr>
	      			</c:forEach>
	      		</tbody>
	      	</table>
	     <!-- </form> -->
	      </div>
	      <div>
	      <hr />
	      <div class="row">
	      <!-- <form action="enrollCancle" method="POST"> -->
	      	신청 현황
	      	<table class="table table-bordered">
	      		<colgroup>
	      			<col width="10%" />
	      			<col width="8%" />
	      			<col width="8%" />
	      			<col width="*" />
	      			<col width="8%" />
	      			<col width="10%" />
	      			<col width="10%" />
	      			<col width="5%" />
	      			<col width="6%" />
	      			<col width="10%" />
	      			<col width="8%" />
	      		</colgroup>
	      		<thead>
	      			<tr>
	      				<th>번호</th>
	      				<th>이수구분</th>
	      				<th>학년</th>
	      				<th>과목명</th>
	      				<th>담당교수</th>
	      				<th>강의시간</th>
	      				<th>강의요일</th>
	      				<th>학점</th>
	      				<th>신청인원</th>
	      				<th>취소</th>
	      			</tr>
	      		</thead>
	      		<tbody id="enrolled">
	      			<c:forEach var="regisub" items="${regisubList }">
	      				<tr>
	      					<th>${regisub.subject.siteCode.code}</th>
	      					<th>${regisub.subject.passed.passedName }</th>
	      					<th>${regisub.subject.grade }</th>	<!-- 학년 -->
	      					<th>${regisub.subject.subjectName }</th>	<!-- 과목명 -->
	      					<th>${regisub.subject.professor.name }</th>	<!-- 담당교수 -->
	      					<%-- ${enroll.subject.professor } --%>
	      					<th>${regisub.enroll.enrollTime }</th>	<!-- 강의 시간 -->
	      					<th>${regisub.enroll.enrollDay }</th>	<!-- 강의 요일-->
	      					<th>${regisub.subject.score }</th>	<!-- 학점 -->
							<th>
	      						<c:choose>
	      							<c:when test="${regisub.enroll.enrollNum eq regisub.subject.limitStu}">
	      								<strong><font color="red">마감</font></strong>
	      							</c:when>
	      							<c:otherwise>
					      				${regisub.enroll.enrollNum } / ${regisub.subject.limitStu}	<!-- 신청 인원 -->
	      							</c:otherwise>
	      						</c:choose>	  
	      					</th>
	      					<th>
	      						<a href="enrollCancle?cancleNo=${regisub.enroll.no }" class="btn btn-default">취소</a>
	      					</th>
	      				</tr>
	      			</c:forEach>
	      		</tbody>
	      	</table>
	    <!-- </form> -->
      	<div class="row text-center">
      		신청 학점 / 최대 신청학점
      	</div>
      </div>
    </div>
   </div>
</body>
</html>