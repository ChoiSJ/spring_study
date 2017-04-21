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
	
	$("form").submit(function() {
		if($("#textarea-description").empty()) {
			alert("신청사유는 필수입력입니다.");
			$("#textarea-description").focus();
			return false;
		}
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
         <h4><span class="glyphicon glyphicon-th-list"></span> 휴학 신청</h4>
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
	        				<c:out value="${cName }" />
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
      
      <div class="row" style="padding: 20px;">
      	<h4>재입학 신청</h4>
      	<table class="table table-bordered">
      		<colgroup>
      			<col width="" />
      			<col width="" />
      			<col width="" />
      			<col width="" />
      			<col width="" />
      			<col width="" />
      		</colgroup>
			<thead>
				<tr>
					<th>학년도</th>
					<th>학기</th>
					<th>학과</th>
					<th>학년</th>
					<th>학번</th>
					<th>성명</th>
					<th>학적변동</th>
					<th>변동일자</th>
					<th>결재상태</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th colspan="10">신청 내역이 없습니다.</th>
				</tr>
				<!-- forEach 반복문 -->
				<tr>
					
				</tr>
			</tbody>      	
      	</table>
      </div>
      
      <div class="row" style="padding: 20px;">
      	<h4>재입학 신청</h4>
      	<form action="">
	   		<table class="table table-bordered">
	   			<colgroup>
	   				<col width="16%" />
	   				<col width="17%" />
	   				<col width="17%" />
	   				<col width="16%" />
	   				<col width="17%" />
	   			</colgroup>
	   			<thead>
	   				<tr>
	   					<th>재입학 학년</th>
	   					<th>
	   						<div class="form-group">
	   							<select name="reGrade" id="select-reGrade" class="form-control">

		   								<option value="1">1</option>
		   								<option value="2">2</option>
		   								<option value="3">3</option>
		   								<option value="4">4</option>
	   							</select>
	   						</div>
	   					</th>
	   					<th>재입학 학기</th>
	   					<th>
	   						<div class="form-group">
	   							<select name="" id="" class="form-control">
	   								<option value="">1학기</option>
	   								<option value="">2학기</option>
	   							</select>
	   						</div>
	   					</th>
	   					<th>신청 결과</th>
	   					<th>
	   						<!-- 승인 전 / 후 -->
	   						승인 전
	   					</th>
	   				</tr>
	   				<tr>
	   					<th style="color: red;">신청사유*</th>
	   					<th colspan="5">
	   						<div class="form-group">
	   							<textarea name="" id="textarea-description" cols="30" rows="10" class="form-control" placeholder="필수 입력입니다."></textarea>
	   						</div>
	   					</th>
	   				</tr>
	   			</thead>
	   		</table>
	   		<div class="form-group text-center">
	   			<button class="btn btn-default">신청</button>
	   			<a class="btn btn-default" href="#">취소</a>
	   			<input type="hidden" id="inputChangeBackYear" name="changeBackYear"/>
	   		</div>
   		</form>
      </div>      
   </div>
</body>
</html>