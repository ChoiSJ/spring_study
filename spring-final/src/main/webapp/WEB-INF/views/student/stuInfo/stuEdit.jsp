<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
   <<div class="container" style="margin-left: 250px; padding-top:25px; ">
    <div class="row text-right">
         홈
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 비밀번호 변경</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <div class="row">
		<div style="padding-top: 2px; text-align: center;  border:1px solid gray;">
			<h4><strong>비밀번호 확인</strong></h4><br />
			<p style="font-size : 15px;">
				<span style="color:#008bcc;">비밀번호를 입력하여 주세요.</span> <br />
			</p> <br />
			<p>
				<span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>
				비밀번호 <input type="password" id="board-Pwd" name="boardPwd"/>	
			</p>
			<div style="padding-top: 2px; text-align: center;">
				<p>
				<button type="submit" class="btn btn-info">확인</button>
				</p>
			</div>
		</div>
      </div>
   </div>
</body>
</html>