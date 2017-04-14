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
         <h4><span class="glyphicon glyphicon-th-list"></span> 정보 수정</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <div class="row">
		<table class="table table-bordered" style="margin: auto;">
			
		</table>
		<div style="padding-top: 20px;" class="text-center form-group">
			<form action="">
			<input type="hidden" name="" value=""/>
			<input type="hidden" name="" value=""/>
				<select class="w3-select w3-border" name="option1" style="width: 8%; height: 37px;">
					<option value="gradeAll">전체</option>
					<option value="grade1">1 학년</option>
					<option value="grade2">2 학년</option>
					<option value="grade3">3 학년</option>
					<option value="grade4">4 학년</option>
				</select>
				<input type="text" name="searchInput" style="width: 30%; height: 37px;"/>
				<button type="submit" class="" style="background-color: gray; height:30px; width:70px;">검색</button>	
			</form>
		</div>
      </div>
      <hr />
      <div class="row">
      	신청 목록
      	<table class="table table-bordered">
      		<colgroup>
      			<col width="10%" />
      			<col width="10%" />
      			<col width="10%" />
      			<col width="*" />
      			<col width="10%" />
      			<col width="10%" />
      			<col width="10%" />
      		</colgroup>
      		<thead>
      			<tr>
      				<th>번호</th>
      				<th>이수구분</th>
      				<th>학년</th>
      				<th>과목명</th>
      				<th>담당교수</th>
      				<th>학점</th>
      				<th>성적</th>
      			</tr>
      		</thead>
      		<tbody id="searchBody"></tbody>
      	</table>
      </div>
      <div>
     	 <hr />
      	<div class="row">
      
      	</div>
      </div>
   </div>
</body>
</html>