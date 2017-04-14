<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarsubject.jsp" %>
<div class="container" style="margin-left: 250px; padding-top: 25px;">
	<form method="post" action="">
		<div class="row" style="margin-bottom: 15px;">
			<div class="col-sm-12">
				<div class="btn-group">
					<a href="adminsendemailbox" class="btn btn-info">받은쪽지</a>
					<a href="adminrecievemailbox" class="btn btn-info">보낸쪽지</a>
					<a href="adminsendemail" class="btn btn-info">쪽지쓰기</a>
				</div>			
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-bordered">
					<colgroup>
						<col width="10%">
						<col width="*">
					</colgroup>		
					<tbody>
						<tr>
							<td>수신대상</td>
							<td>
								<input type="radio" name=""> 학생&nbsp;
								<input type="radio" name=""> 교수
							</td>
						</tr>
						<tr class="form-inline">
							<td>받는사람</td>
							<td>
								<input type="text" name="" class="form-control">
								<button class="btn btn-xs btn-default">사용자 검색</button>
							</td>
						</tr>
						<tr>
							<td>제목</td>
							<td>
								<input type="text" class="form-control">
							</td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<textarea rows="10" class="form-control"></textarea>
							</td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td>
								<input type="file" class="form-control">
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 text-center">
				<button type="submit" class="btn btn-default">발송</button>
				<button type="button" class="btn btn-default" onclick="history.back()">취소</button>
			</div>
		</div>
	</form>
</div>
</html>