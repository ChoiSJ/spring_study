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
<script type="text/javascript">
$(function() {
	$("#add-list").click(function(event) {
		event.preventDefault();
		
		$(this).attr("data-dismiss", "modal").click();
	});
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarsubject.jsp" %>
<div class="container" style="margin-left: 250px; padding-top: 25px;">
	<form method="post" action="adminsendprocess" enctype="multipart/form-data">
		<div class="row" style="margin-bottom: 15px;">
			<div class="col-sm-12">
				<div class="btn-group">
					<a href="adminsendemail" class="btn btn-info">메일발송</a>
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
								<input type="radio" name="receiver" value="stu"> 학생&nbsp;
								<input type="radio" name="receiver" value="pro"> 교수
							</td>
						</tr>
						<tr class="form-inline">
							<td>받는사람</td>
							<td>
								<input type="text" name="address" class="form-control">
								<button type="button" class="btn btn-xs btn-default" data-toggle="modal" data-target="#searchModal">사용자 검색</button>
								
								<!-- 검색 modal -->
								<div id="searchModal" class="modal fade" role="dialog">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header text-center">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<div class="form-inline input-group">
													<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
													<input type="text" name="word" class="form-control">
													<div class="input-group-btn">
														<button class="btn btn-success">검색</button>
													</div>
												</div>
											</div>
											<div class="modal-body">
												<div class="row well">
													<div class="col-sm-5 well">
													
													</div>
													<div class="col-sm-5 col-sm-offset-2 well">
													
													</div>
												</div>
											</div>
											<div class="modal-footer text-right">
												<button type="submit" class="btn btn-info" id="add-list">추가</button>
												<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>제목</td>
							<td>
								<input type="text" class="form-control" name="title">
							</td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<textarea rows="10" class="form-control" name="contents"></textarea>
							</td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td>
								<input type="file" class="form-control" name="file">
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