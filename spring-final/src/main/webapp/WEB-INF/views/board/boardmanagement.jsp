<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		<!-- ajax함수 -->
		var ajaxFunction = function(universityCode) {
			$.ajax({
				type:'post',
				url : 'boardmanagement',
				data : universityCode,
				dataType : 'json',
				success : function(data){
					$('#semester-select').empty();
					$('#lecture-select').empty();
					$.each(data.siteMapList, function(index, item){
						$('#semester-select').append("<option value="+item.code+">"+item.name+"</option>");
					});
					$.each(data.lectureList, function(index, item){
						$('#lecture-select').append("<option value="+item.no+">"+item.subjectName+"</option>");
					});
					if (!data.lectureList) {
						$('#lecture-select').append("<option>학과의 수업과정이 등록되어 있지 않습니다.</option>");
					}
				}
			});
		}  
		
		var universityCode = $('#term-select').val();
		ajaxFunction(universityCode);
		
		$('#term-select').change(function(){
			universityCode = $(this).val();
			ajaxFunction(universityCode);
		});
		
		$('#semester-select').change(function(){
		var subjectCode = $(this).val();
			$.ajax({
				type:'post',
				url: 'boardmanagement.json',
				data : subjectCode,
				dataType : 'json',
				success : function(data){
					$('#lecture-select').empty();
					$.each(data, function(index, item){
						$('#lecture-select').append("<option value="+item.no+">"+item.subjectName+"</option>");
					});
					if (!data.length) {
						$('#lecture-select').append("<option>학과의 수업과정이 등록되어 있지 않습니다.</option>");
					}
				}
			});
		});
		$('#search-btn').click(function(){
			$('#hidden-div').show();
			var lectureCode = $('#lecture-select').val();
			console.log(lectureCode);
			
			<!-- ajax통해 게시판 조회 -->
			
		});
		
		
	});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/adminSidebar.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px;">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > 신입학 조회 
		</div>
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span> 게시판 관리</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;">
		</div>
		<div class="row">
			<div class="col-sm-6">
				<table class="table">
					<tr>
						<th>대학선택</th>
						<td>
							<select id="term-select" class="form-control" style="width: 150px;">
								<c:forEach var="major" items="${majorList }">
									<option value="${major.code }">${major.name }</option>
								</c:forEach>
							</select>
						</td>
						<th>학과선택</th>
						<td>
							<select id="semester-select" class="form-control" style="width: 150px;">
								
							</select>
						</td>
						
					</tr>
					<tr>
						<th>강좌선택</th>
						<td colspan="3">
							<select id="lecture-select" class="form-control" style="width: 430px;">
								
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div class="col-sm-6">
				<div class="row" style="margin-top: 64px;">
					<button id="search-btn" class="btn btn-primary btn-sm">검색</button>
				</div>
			</div>
		</div>
		<div id="hidden-div" hidden="true">
			<div class="row well">
				<strong>사본_NIE를 활용한 글쓰기 과정 /자유게시판: <span id="freeBoardCount">0</span>건 /강의Q&amp;A: <span id="qnaBoardCount">0</span>건 </strong>
			</div>
			<div class="row">
				<ul class="nav nav-tabs" role="tablist" id="myTab">
					<li role="presentation" class="active"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">강의 Q&amp;A</a></li>
					<li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">강의 공지사항</a></li>
				</ul>
			</div>
			<div class="row">
				<div class="tab-content" style="margin-top: 15px;">
					<div role="tabpanel" class="tab-pane active" id="profile">
						<form class="form-inline">
							<select class="form-contro input-sm" name="searchCount">
								<option value="10">10개 보기</option>
								<option value="30">30개 보기</option>
								<option value="50">50개 보기</option>
							</select>
							<label> 총게시물 <span id="totalCount">0</span>개, 검색 <span id="searchCount">0</span>개</label>
							<div class="form-group pull-right">
								<select class="form-control input-sm" name="searchKeywordBox">
									<option value="title">제목</option>
									<option value="contents">내용</option>
									<option value="name">이름</option>
									<option value="id">아이디</option>
								</select>
								<input name="keyword" class="form-control input-sm" type="text">
								<a href="javascript:;" class="btn btn-primary btn-sm">검색</a>
							</div>
						</form>
						<hr>
						<table class="table">
							<colgroup>
								<col width="5%">
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox" id="allCheck"/></th>
									<th>제목</th>
									<th>작성자</th>
									<th>등록일</th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
						<button class="btn btn-danger btn-sm" id="delete-btn">선택삭제</button>
					</div>
					<div role="tabpanel" class="tab-pane" id="messages">
						<form class="form-inline">
							<select class="form-contro input-sm" name="searchCount">
								<option value="10">10개 보기</option>
								<option value="30">30개 보기</option>
								<option value="50">50개 보기</option>
							</select>
							<label> 총게시물 <span id="totalCount">0</span>개, 검색 <span id="searchCount">0</span>개</label>
							<div class="form-group pull-right">
								<select class="form-control input-sm" name="searchKeywordBox">
									<option value="title">제목</option>
									<option value="contents">내용</option>
									<option value="name">이름</option>
									<option value="id">아이디</option>
								</select>
								<input name="keyword" class="form-control input-sm" type="text">
								<a href="javascript:;" class="btn btn-primary btn-sm">검색</a>
							</div>
						</form>
						<hr>
						<table class="table">
							<colgroup>
								<col width="5%">
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox" id="allCheck"/></th>
									<th>제목</th>
									<th>작성자</th>
									<th>등록일</th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
						<button class="btn btn-danger btn-sm" id="delete-btn">선택삭제</button>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>