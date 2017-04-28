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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('roadAddress').value = fullRoadAddr;
                document.getElementById('jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
<style type="text/css">
	th { text-align: center !important;
			vertical-align: middle !important;}
</style>
</head>
<body>
<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
<img src="//i1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
</div>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
   <div class="container" style="margin-left: 250px; padding-top:25px; ">
    <div class="row text-right">
         홈 > 정보 조회
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 정보 조회</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <div class="row">      	
      	<div class="col-xs-2">
      		<img src="../resources/images/student/PeoPleDefault.png" alt="person" style="padding-left:10px; padding-right: 10px; padding-top: 30px; width: 150px; height: 200px;"/>
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
	        			<td><c:out value="${student.grade}"/></td>
	        		</tr>
	        		<tr>
	        			<th>지도교수</th>
	        			<td><c:out value="${student.professor }"/> 교수</td>
	        			<th>입학 년도</th>
	        			<td>
	        				<fmt:formatDate value="${student.enterDate }" pattern="yyyy년 MM월 dd일"/>
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
     		<form:input type="hidden" path="no" value="${student.no }" />
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
      					<th>*휴대폰</th>
      					<td><form:input type="text" path="phone" value="${student.phone }"/>
      						<button type="submit" class="btn btn-default">수정</button>
      						<form:errors path="phone" cssClass="text-danger"/>
      					</td>
      				</tr>
      				<tr>
      					<th>*이메일</th>
      					<td><form:input type="text" path="email" value="${student.email }" />
      						<button type="submit" class="btn btn-default">수정</button>
      						<form:errors path="email" cssClass="text-danger"/>
      					</td>
      				</tr>
      				<tr>
      					<th rowspan="6">자택</th>
      					<th rowspan="3">*도로명 주소</th>
      					<td>
      						<%-- <form:input type="text" path="zipCode" placeholder="도로명 주소" /> --%>
			      			<form:input style="width: 80px;" type="text" path="zipcode" id="postcode" placeholder="우편번호" value="${student.zipcode }" />
							<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
						</td>
					<tr>
						<td>
							<form:input style="width: 300px;" type="text" path="addr1" id="roadAddress" placeholder="도로명주소" value="${student.addr1 }" />
							<form:input style="width: 280px;" type="text" path="addr2" id="jibunAddress" placeholder="지번주소" value="${student.addr2 }"/>
							<span id="guide" style="color:#999"></span>
      					</td>
					</tr>
      				<tr>
      					<td><form:input style="width: 350px;" path="addr3" value="${student.addr3 }" placeholder="상세주소" type="text" />
      						<button class="btn btn-default">수정</button>
      					</td>
      				</tr>
      				<tr>
      					<th>보호자 성함</th>
      					<td><c:out value="${student.parentName }"/></td>
      				</tr>
      				<tr>
      					<th>*보호자 연락처</th>
      					<td><form:input type="text" path="parentPhone" value="${student.parentPhone }"/>
      						<button type="submit" class="btn btn-default">수정</button>
      						<form:errors path="parentPhone" cssClass="text-danger"/>
      					</td>
     				</tr>
      			</tbody>
      		</table>
      	</form:form>
      </div>      
   </div>
</body>
</html>