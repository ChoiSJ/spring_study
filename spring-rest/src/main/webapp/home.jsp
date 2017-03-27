<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#link-1").click(function() {
		event.preventDefault();
		
		$.ajax({
			type: "GET",		// 요청 방식
			url: "user/",		// 요청 URL
			dataType: "json",	// 응답 컨텐츠의 타입
			success: function(data) {
				var html = "<ul>";
				
				$.each(data, function(index, item) {
					html += "<li>"+item.name+" ("+item.id+")</li>";
				});
				
				html += "</ul>";
				$("#display-box").html(html);
			}
		});
	})
}) 
</script>
</head>
<body>
	<h1>사용자 관리</h1>
	
	<ul>
		<li><a href="#" id="link-1">사용자 전체 조회</a></li>
	</ul>
	
	<h2>사용자 리스트</h2>
	<div id="display-box">
	
	</div>
</body>
</html>