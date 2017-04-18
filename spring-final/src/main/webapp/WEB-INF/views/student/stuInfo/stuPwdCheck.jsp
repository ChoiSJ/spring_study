<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	if($("input #pwdConfirm")) {
		if($("#pwdConfirm").val() == ("false")){
			alert("비밀번호가 올바르지 않습니다.");
			$("#board-Pwd").focus();
			console.log($("#pwdConfirm").val())
		}
		if($("#pwdConfirm").val() == ("true")) {
			alert("비밀번호가 변경되었습니다.");
			console.log($("#pwdConfirm").val())
		}
	}
		
	$("#RepwdCheck").keyup(function(event) {
		if($("#Repwd").val() == $("#RepwdCheck").val()) {
			$("#RepwdCheckSpan").empty();
			$("#RepwdCheckSpan").append("<font color='blue' id='Remessage'>새 비밀번호와 일치합니다.</font>");
			$("#submit-btn").removeAttr("disabled");
		} else {
			$("#RepwdCheckSpan").empty();
			$("#RepwdCheckSpan").append("<font color='red' id='Remessage'>새 비밀번호와 일치하지 않습니다.</font>");
			$("#submit-btn").attr("disabled", "disabled");
		}
	});
	
	$("form").submit(function() {
		if($("#Repwd").val() != $("#RepwdCheck").val()) {
			alert("새 비밀번호가 일치하지 않습니다.");
			return false;
		}
		return true;
	});
	
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
   <div class="container" style="margin-left: 250px; padding-top:25px; ">
   <input type="hidden" value="${confirm }" id="pwdConfirm"/>
    <div class="row text-right">
         홈
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> 비밀번호 변경</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <div class="row">
		<div style="padding-top: 2px; text-align: center;  border:1px solid gray;">
			<form action="stuPwdCheck" method="POST">
				<h2 style="padding-top: 30px;"><strong>비밀번호 변경</strong></h2><br />
				<hr />
				<p style="font-size : 15px;">
					<strong style="font-size: large; padding-bottom: 5px;">회원님의 소중한 개인정보를 안전하게 보호하기 위해</strong><br />
					<span style="color:#008bcc;">
					기존의 비밀번호를 입력해주세요.</span> <br />
				</p>
				<hr />
				<div class="text-left">
					<p>
						<label for="stuPwd" style="padding-left: 30px; padding-right: 28px;">현재 비밀번호</label> 
						<input type="password" id="stuPwd" name="stuPwd"/>	
					</p>
					<p>
						<label for="Repwd" style="padding-left: 30px; padding-right: 42px;">새 비밀번호</label>
						<input type="password" id="Repwd" name="Repwd"/>	
					</p>
					<p>
						<label for="RepwdCheck" style="padding-left: 30px; padding-right: 10px;">새 비밀번호 확인</label>
						<input type="password" id="RepwdCheck"/> <span id="RepwdCheckSpan"></span>
					</p>
				</div>
				<div style="padding-top: 2px; text-align:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      center;">
					<p>
						<button id="submit-btn" type="submit" class="btn btn-info" disabled="disabled">확인</button>
						<a href="home" class="btn btn-danger">취소</a>
					</p>
				</div>
			</form>
		</div>
      </div>
   </div>
</body>
</html>