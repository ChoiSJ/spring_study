<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title></title>
<script type="text/javascript">
	$(function(){
		$('select[name="selectBoard"]').change(function(){
			var type = $(this).val();
			
			$.ajax({
				type:"post",
				url:'homeboard.json',
				data:{boardType:type},
				dataType:'json',
				success : function(data){
					$(data).each(function(index, item){
						
					});
				}
			});
			
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
			<h4><span class="glyphicon glyphicon-th-list"></span> 홈페이지 게시판 관리</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div style="margin-top: 20px;"></div>
		<div class="row well">
			<div class="form-inline">
				<label style="margin-right: 50px;">관리할 게시판 선택</label>
				<select class="form-control" name="selectBoard">
					<option value="N">공지사항</option>
					<option value="M">1:1 문의</option>
					<option value="Q">Q&amp;A</option>
				</select>
			</div>
		</div>
		<div class="row">
			<form class="form-inline">
				<select style="margin-right: 30px;" class="form-control input-sm" name="boardCount">
					<option value="5">5개 보기</option>
					<option value="10">10개 보기</option>
					<option value="30">30개 보기</option>
					<option value="50">50개 보기</option>
				</select>
				<label>총 게시물 <span id="totalCount">0</span>개, 검색 <span id="searchCount">0</span>개</label>
				<div class="pull-right">
					<select class="form-control input-sm" name="searchOption">
						<option value="title">제목</option>
						<option value="contents">내용</option>
						<option value="name">이름</option>
						<option value="id">아이디</option>
					</select>
					<input type="text" class="form-control input-sm" name="keyword">
					<button type="submit" class="btn btn-default btn-sm">검색</button>
				</div>
			</form>
		</div>
		<div class="row">
			<table class="table">
				<colgroup>
					<col width="5%">
					<col width="*">
					<col width="10%">
					<col width="5%">
				</colgroup>
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="allCheck">
						</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			<a href="javascript:;" class="btn btn-default btn-sm">선택삭제</a>
		</div>
	</div>
	
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>