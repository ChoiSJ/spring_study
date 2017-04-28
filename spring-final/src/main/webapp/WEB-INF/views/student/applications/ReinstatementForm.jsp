<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
	$("form").submit(function(event) {
		if($('[name=selectLeave]:checked').val() == null) {
			alert("복학 하고자 하는 휴학을 선택하세요.");
			return false;
		}
		$('[name=leaveNo]').val($('[name=selectLeave]:checked').val());
		return true;
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
         홈
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 복학 신청</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <div class="row">
      	<div class="col-xs-2">
      		<img src="../resources/images/student/PeoPleDefault.png" alt="person" style="width: 100px; height: 100px;"/>
      	</div>
      	<div class="col-xs-10">
      		<p>나의 정보</p>
        	<table class="table table-bordered">
	        	<colgroup>
	        		<col width="20%" />
	        		<col width="30%" />
	        		<col width="20%" />
	        		<col width="30%" />
	        	</colgroup>
	           	<thead>
	        		<tr>
	        			<th>구분</th>
	        			<td colspan="3">
	        				<c:out value="${student.cName }" />
	        			</td>
	        		</tr>
	        		<tr>
	        			<th>이름</th>
	        			<td><c:out value="${student.name }" /></td>
	        			<th>아이디</th>
	        			<td><c:out value="${student.id }"/></td>
	        		</tr>
	        		<tr>
	        			<th>주민등록번호</th>
	        			<td><c:out value="${student.ssn }"/></td>
	        			<th>성별</th>
	        			<td>
	        				<c:choose>
	        					<c:when test="${student.gender eq 'M' }">남성</c:when>
	        					<c:when test="${student.gender eq 'F' }">여성</c:when>
	        					<c:otherwise>Other</c:otherwise>
	        				</c:choose>	        			
	        		</tr>
	        		<tr>
	        			<th>전공</th>
	        			<td><c:out value="${student.tName}"/></td>
	        			<th>학년</th>
	        			<td><c:out value="${student.grade }"/></td>
	        		</tr>
	        		<tr>
	        			<th>지도교수</th>
	        			<td><c:out value="${student.professor }"/></td>
	        			<th>입학 년도</th>
	        			<td>
	        				<fmt:formatDate value="${student.enterDate }" pattern="yyyy-MM-dd"/>
	        			</td>
	        		</tr>
	        		<tr>
	        			<th>보호자 성함</th>
	        			<td><c:out value="${student.parentName }"/></td>
	        			<th>보호자 연락처</th>
	        			<td><c:out value="${student.parentPhone }"/></td>
	        		</tr>
	        	</thead>
	        </table>
        </div>
      </div>  
      <div class="row" style="padding: 20px;">
      	<h4>휴학 신청 내역</h4>
      	<table class="table table-bordered">
			<thead>
				<tr>
					<th>선택</th>
					<th>학년도</th>
					<th>학기</th>
					<th>학과</th>
					<th>학년</th>
					<th>학번</th>
					<th>성명</th>
					<th>학적변동</th>
					<th>변동일자</th>
					<th>복학일자</th>
					<th>결재상태</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty leaveList}">
					<tr>
						<th colspan="13">신청 내역이 없습니다.</th>
					</tr>
				</c:if>
				<c:forEach var="leave" items="${leaveList}">
					<tr>
						<th>
							<input type="radio" name="selectLeave" value="${leave.no }"/>
						</th>
						<th>${leave.year }</th>
						<th>${leave.period }</th>
						<th>${student.tName }</th>
						<th>${student.grade }</th>
						<th>${student.id }</th>
						<th>${student.name }</th>
						<th>${student.cName }</th>
						<th>
							<fmt:formatDate value="${leave.enrollDate }" pattern="YYYY-MM-dd"/></th>

						<th>
							<fmt:formatDate value="${leave.reinDate }" pattern="YYYY-MM-dd"/></th>
						<th>
							<c:choose>
								<c:when test="${leave.pass eq 'false' }">
									<input type="hidden" id="leave-Pass" value="false" />
									<font color="red"><strong>미승인</strong></font>
								</c:when>
								<c:when test="${leave.pass eq 'not' }">
									<input type="hidden" id="leave-Pass" value="not" />
									<font color="red"><strong>거절</strong></font>
								</c:when>
								<c:otherwise>
									<font color="blue"><strong>승인</strong></font>
								</c:otherwise>
							</c:choose>
						</th>										
					</tr>
				</c:forEach>
			</tbody>      	
      	</table>
      </div>
      <div class="row">
      	<p style="color: red; padding-left: 20px;">▶ 복학 하고자 하는 휴학을 선택하세요.</p>
      	<form action="reinstate" method="post">
	   		<div class="form-group text-center">
	   			<input type="hidden" name="stuNo" value="${student.no }">
	   			<input type="hidden" name="leaveNo">
	   			<button class="btn btn-default" id="">신청</button>
	   			<a class="btn btn-default" href="" onclick="window.history.back();">취소</a>
	   			<input type="hidden" id="inputChangeBackYear" name="changeBackYear"/>
	   		</div>
   		</form>
      </div>      
   </div>
</body>
</html>