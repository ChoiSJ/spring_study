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
	$("#receiver-box").on("click", "span", function() {
		var spanNo = $(this).attr("id").replace("name-", "");
		
		$("input:hidden[name='address']").each(function(index, item) {
			var hiddenNo = $(this).attr("id").replace("email-", "");
			
			if (spanNo == hiddenNo) {
				$("span[id='name-"+spanNo+"']").remove();
				$("input:hidden[id='email-"+hiddenNo+"']").remove();
			}
		})
	}).css("cursor", "pointer");
	
	// 추가를 눌렀을 때 받는사람에 메일어드레스를 추가하는 코드
	$("#add-list").click(function(event) {
		event.preventDefault();
		var id = $("tr[class='active'] td:eq(0)").text();
		var name = $("tr[class='active'] td:eq(1)").text();
		var address = $("tr[class='active'] td:eq(3)").text();
		
		// 같은 사람을 두 번 등록하는 것을 체크하는 코드
		$("span[class='badge']").each(function(index, item) {
			var spanNo = $(item).attr("id").replace("name-", "");	
		
			if (id == spanNo) {
				alert("이미 추가되어 있는 유저입니다.");
				id = false;
				address = false;
				return false;
			}
		});
		
		if (name && address) {
			$("#receiver-box").append("<span class='badge' id='name-"+id+"'>"+name+"</span> ");
			$("#mail-form").append("<input type='hidden' name='address' value='"+address+"' id='email-"+id+"'>");
		}
		
		$(".modal-body tbody").empty();
		$("#search-word").val("");
		
		$(this).attr("data-dismiss", "modal");
	});
	
	$("#search-list").click(function(event) {
		event.preventDefault();
		
		checkedRadio = $(":radio:checked").val();
		searchWord = $("#search-word").val();
		
		// 학생, 교수 분류와 이름을 검색했을 때 검색결과를 표시하는 ajax 코드
		$.get("adminAddressSearch", {checkedRadio: checkedRadio, searchWord: searchWord}, function(data) {
			$(".modal-body tbody").empty();
			
			for (var i=0; i<data.length; i++) {
				var tr = "<tr id='search-row-"+i+"'><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].phone+"</td><td>"+data[i].email+"</td></tr>";
				$(".modal-body tbody").append(tr);
			}
		}, "json");
	});
	
	// 검색된 행을 클릭했을 때 활성화 시키는 코드
	$(".modal-body tbody").on("click", "tr", function() {
		if ($(this).attr("class")) {
			$(this).removeClass("active");
		} else {
			$(this).addClass("active").siblings().removeClass("active");
		}
	})
	
	// 모달을 닫을 때 입력 데이터를 없애는 코드
	$("#close-modal").click(function() {
		$(".modal-body tbody").empty();
		$("#search-word").val("");
	});
	
	$("#send-button").click(function() {
		if (!$("#receiver-box").text().trim()) {
			alert("메일 주소를 추가해주세요.");
			return false;
		}
	});
})
</script>
<style>
input:-webkit-autofill {
	-webkit-box-shadow: 0 0 0 1000px white inset;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarsubject.jsp" %>
<div class="container" style="margin-left: 250px; padding-top: 25px;">
	<form id="mail-form" method="post" action="adminsendprocess" enctype="multipart/form-data">
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
								<label class="radio-inline"><input type="radio" name="receiver" value="stu" checked> 학생&nbsp;</label>
								<label class="radio-inline"><input type="radio" name="receiver" value="pro"> 교수</label>
							</td>
						</tr>
						<tr class="form-inline">
							<td>받는사람</td>
							<td>
								<span id="receiver-box"></span>
								<button type="button" class="btn btn-xs btn-default" data-toggle="modal" data-target="#searchModal">사용자 검색</button>
								
								<!-- 검색 modal -->
								<div id="searchModal" class="modal fade" role="dialog">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header text-center">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<div class="form-inline input-group">
													<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
													<input type="text" name="word" class="form-control" id="search-word">
													<div class="input-group-btn">
														<button type="button" class="btn btn-success" id="search-list">검색</button>
													</div>
												</div>
											</div>
											<div class="modal-body">
												<table class="table table-bordered">
													<colgroup>
														<col width="20%">
														<col width="20%">
														<col width="30%">
														<col width="30%">
													</colgroup>
													<thead>
														<tr>
															<th>학번</th>
															<th>이름</th>
															<th>전화번호</th>
															<th>메일주소</th>
														</tr>
													</thead>
													<tbody>
													
													</tbody>
												</table>
											</div>
											<div class="modal-footer text-right">
												<button class="btn btn-info" id="add-list">추가</button>
												<button type="button" class="btn btn-default" data-dismiss="modal" id="close-modal">닫기</button>
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
				<button type="submit" class="btn btn-default" id="send-button">발송</button>
				<button type="button" class="btn btn-default" onclick="history.back()">취소</button>
			</div>
		</div>
	</form>
</div>
</html>