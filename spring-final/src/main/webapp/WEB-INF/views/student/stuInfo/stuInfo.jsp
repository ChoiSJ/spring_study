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
         <h4><span class="glyphicon glyphicon-th-list"></span> 정보 조회</h4>
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
	        				<c:out value="${student.register }" />
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
	        			<td><c:out value="${tName}"/></td>
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
      
      <div class="row">
      	<p>연락처 정보</p>
     	<form:form action="stuInfo" method="POST" modelAttribute="studentForm">
      		<table class="table table-bordered">
      			<colgroup>
      				<col width="10%" />
      				<col width="15%" />
      				<col width="*" />
      			</colgroup>
      			<thead></thead>
      			<tbody>
      				<tr>
      					<th rowspan="2">개인</th>
      					<th>휴대폰</th>
      					<td><form:input type="text" path="phone" value="${student.phone }"/>
      						<button type="submit" class="btn btn-default">수정</button>
      						<form:errors path="phone" cssClass="text-danger"/>
      					</td>
      				</tr>
      				<tr>
      					<th>이메일</th>
      					<td><form:input type="text" path="email" value="${student.email }" />
      						<button type="submit" class="btn btn-default">수정</button>
      						<form:errors path="email" cssClass="text-danger"/>
      					</td>
      				</tr>
      				<tr>
      					<th rowspan="6">자택</th>
      					<th rowspan="3">주소</th>
      					<td><form:input type="text" path="addr1"/>
      						<a href="" class="btn btn-default">우편번호 검색</a>
      					</td>
      				</tr>
      				<tr>
      					<td>
      						<input type="text" />
      					</td>
      				</tr>
      				<tr>
      					<td><form:input type="text" path="addr2" value="${student.addr2 }"/>
      						<button class="btn btn-default">수정</button>
      					</td>
      				</tr>
      				<tr>
      					<th>보호자 성함</th>
      					<td><c:out value="${student.parentName }"/></td>
      				</tr>
      				<tr>
      					<th>보호자 연락처</th>
      					<td><form:input type="text" path="parentPhone" value="${student.parentPhone }"/>
      						<button type="submit" class="btn btn-default">수정</button>
      						<form:errors path="parentPhone" cssClass="text-danger"/>
      					</td>
     				</tr>
     					<form:input cssClass="hidden" path="pwd" value="${student.pwd}"/>
      			</tbody>
      		</table>
      	</form:form>
      </div>      
   </div>
</body>
</html>