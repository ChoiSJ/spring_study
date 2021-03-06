<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>로그인</title>
<script type="text/javascript">
	$(function () {
		$('[name="userId"]').focus();
		
		$('#login-btn').click(function (event) {
			event.preventDefault();
			if($('[name="userId"]').val().trim() == ''){
				alert("학번 또는 교번을 입력하세요.");
				$('[name="userId"]').focus();
				return;
			}
			if($("[name='userPwd']").val().trim() == ''){
				alert("비밀번호를 입력하세요.");
				$('[name="userPwd"]').focus();
				return;
			}
			$('#login-form').submit();
		})
		$('[type="radio"]').change(function (event) {
			if($(this).val() == 'stud'){
				$('[name="userId"]').attr('placeholder','학번을 입력하세요.');
			}else{
				$('[name="userId"]').attr('placeholder','교번을 입력하세요.');
			}			
		});
		
		$("#emailSend-btn").click(function() {
			if($("#emailSend").val() == "") {
				alert("이메일을 입력해주세요.");
				$("#emailSend").focus();
				return false;
			} 			
		});
		
		$("#pwdSend-btn").click(function() {
			if($("#pwdSend").val() == "") {
				alert("학번을 입력해주세요.");
				$("#pwdSend").focus();
				return false;
			}			
			if($("#pwdEmailSend").val() == "") {
				alert("이메일을 입력해주세요.");
				$("#pwdEmailSend").focus();
				return false;
			}
		});
	});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="container" style="margin-top: 7%;">
			<form class="form-group" action="login" method="post" id="login-form">
				<div class="col-md-7 col-md-offset-2">
					<div class="panel panel-default">
						<div class="panel-heading">
							<img style="width: 200px;" alt="logo" src="resources/logo/login-logo4.png">
						</div>
						<div class="panel-body">
							<div class="col-md-5">
								<img src = "resources/logo/login-logo5.png"  alt="logo" style="width: 210px; text-align: center; padding-top: 20px;">
							</div>
							<div class="form-group col-md-7">
								<div class="form-group row">
									<div class="col-md-4">학부생 <input type="radio" name="loginType" checked="checked" value="stud"/></div>
									<div class="col-md-4">교수 <input type="radio" name="loginType" value="prof" /></div>
								</div>
								<div class="form-group row">
									<input class="form-control" name="userId" type="text" placeholder="학번을 입력하세요">
								</div>
								<div class="form-group row">
									<input class="form-control" name="userPwd" type="password" placeholder="비밀번호를 입력하세요">
								</div>
								<div class="row">
									<c:if test="${ param.err eq 'fail'  }">
										<p class="alert alert-danger"><c:out value="아이디 혹은 비밀번호가 올바르지 않습니다."/></p>
									</c:if>
									<c:if test="${ param.err eq 'deny'  }">
										<p class="alert alert-danger"><c:out value="로그인 후에 서비스 이용이 가능합니다."/></p>
									</c:if>
									<c:if test="${ param.message eq 'logout'  }">
										<p class="alert alert-info"><c:out value="로그아웃 되었습니다."/></p>
									</c:if>
								</div>
								<div class="form-group row">
									<button class="btn btn-primary btn-block" type="submit" id="login-btn">로그인</button>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-md-6" style="padding-left: 30px; padding-right: 30px;">
									<a href="" data-toggle="modal" data-target="#id-modal" style="text-decoration: none;">학번을 잊어버리셨나요?</a> 
								</div>
								<div class="col-md-6" style="padding-left: 30px; padding-right: 30px;">
									<a href="" data-toggle="modal" data-target="#pwd-modal" style="text-decoration: none;">비밀번호를 잊어버리셨나요?</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="modal fade" id="id-modal" role="dialog">
		<form action="sendId" method="post">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">가입시 입력한 이메일 주소를 입력해주세요</h4>
					</div>
					<div class="modal-body">
						<input name="email" id="emailSend" placeholder="이메일 주소" type="email" style="width: 100%;">
					</div>
					<div class="modal-footer">
						<button type="submit" id="emailSend-btn" class="btn btn-default">확인</button>
						<button class="btn btn-default"  type="button" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="modal fade" id="pwd-modal" role="dialog">
		<form action="sendPwd" method="post">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">학번과 이메일을 입력해주세요</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<input name="id" id="pwdSend" class="form-control" placeholder="학번" type="number" style="width: 100%;">				
						</div>
						<div class="form-group">
							<input name="email" id="pwdEmailSend" class="form-control" placeholder="이메일" type="email" style="width: 100%;">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" id="pwdSend-btn" class="btn btn-default">확인</button>
						<button class="btn btn-default"  type="button" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
