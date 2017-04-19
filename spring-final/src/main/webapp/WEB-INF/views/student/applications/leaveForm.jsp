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
	
	// 휴학 일자 자동 입력
	var today = new Date();
	var month = today.getMonth()+1;
	var day = today.getDate();
	var output = today.getFullYear() + '년 ' +
	    (month<10 ? '0' : '') + month + '월 ' +
	    (day<10 ? '0' : '') + day + '일';
	$("#input-today").text(output);
	
	function choCheck(data){
		
		if(data == '2') {
			if(5<12-month) {
				var modiDay = today.getFullYear() + 1;
				return modiDay + '년 07월 01일';
			} else {
				var modiDay = today.getFullYear() + 1;
				return modiDay + '년 01월 01일';
			}
		} else {
			if(5<12-month) {
				var modiDay = today.getFullYear() + 2;	
				return modiDay + '년 07월 01일';
			} else {
				var modiDay = today.getFullYear() + 2;
				return modiDay + '년 01월 01일';
			}
		}

	}
	
	$("#select-Semester").click(function() {
		var outDay = choCheck($(this).val())
		$("#change-BackYear").text(outDay);
		/* inputChangeBackYear를 가진 input으로 값이 넘어감. */
		$("#inputChangeBackYear").val(outDay);
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
      
      <div class="row" style="padding: 20px;">
      	<h4>휴학(연장) 신청 내역</h4>
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
      	<h4>휴학 (연장)신청</h4>
      	<form action="">
	   		<table class="table table-bordered">
	   			<colgroup>
	   				<col width="12%" />
	   				<col width="17%" />
	   				<col width="17%" />
	   				<col width="12%" />
	   				<col width="17%" />
	   				<col width="*" />
	   			</colgroup>
	   			<thead>
	   				<tr>
	   					<th>휴학구분</th>
	   					<td colspan="3">
						    <input type="radio" name="option" value="radioStandard" checked="checked"/>일반휴학  &nbsp; 
						    <%-- 성별이 남성일 경우만  선택 가능 --%>
						    <input type="radio" name="option" value="radioArmy"/>군휴학
	   					</td>
	   					<th>휴학일자</th>
	   					<th id="input-today"></th>
	   				</tr>
	   				<tr>
	   					<th>현재 학생 정보</th>
	   					<td colspan="3">${tName}학과 ${student.grade }학년 / ${student.register } / 현재 이수학기:1</td>
	   					<th>잔여휴학 가능 학기</th>
	   					<th>4</th>
	   				</tr>
	   				<tr>
	   					<!-- 남성일경우만 변동 사유 표시 -->
	   					<th>변동 사유</th>
	   					<th colspan="5">
	   						<div class="form-group">
	   							<select name="" id="" class="form-control">
	   								<option value="standard">일반휴학</option>
	   								<c:if test="${student.gender eq 'M' }">
	   									<option value="army">군휴학</option>
	   								</c:if>
	   							</select>
	   						</div>
	   					</th>
	   				</tr>
	   				<tr>
	   					<th>성적취득여부</th>
	   					<th> 
	   						<label for="">해당없음
	   							<!-- 성적이 한개라도 취득 되어있으면 Check-->
	   							<input type="checkbox" />
	   							<!-- 성적이 취득되어있지 않으면 disabled-->
	   						</label> 
	   					</th>
	   						
	   					<th>휴학학기 수</th>
	   					<th>
	   						<div class="form-group">
	   							<select name="" id="select-Semester" class="form-control">
	   								<option value="2">2</option>
	   								<option value="4">4</option>
	   							</select>
	   						</div>
	   					</th>
	   					<th>복학학년도 학기</th>
	   					<th id="change-BackYear">
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