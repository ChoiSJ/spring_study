<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarmajor.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px; ">
    	<div class="row text-right">
			홈
    	</div>
    	<div class="row">
    	<h4><span class="glyphicon glyphicon-th-list"></span> 과목검색</h4>
        <hr style="border:solid 0.5px #2C7BB5;">
    	</div>
    	<div class="row" style="margin-bottom: 20px">
      	<a href="addsubject" class="btn btn-primary btn-sm pull-right">교과등록</a>
      	</div>
    
    </div>
<%-- <%@ include file="/WEB-INF/views/footer/footer.jsp" %>--%>
</body>
</html>
      