<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
	th { text-align: center !important;
		 vertical-align: middle !important;
			
		}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
<div class="container" style="margin-left: 250px; padding-top:25px; ">
<div class="row text-right">
      Report
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span>Report</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      
      <div class="row">
	      <table class="table table-bordered">
	      	<thead>
	      		<tr>
					<th>제목</th>  			
	      			<th>
	      				<input type="text" class="form-control"/>
	      			</th>
	      		</tr>
	      		<tr>
	      			<th>내용</th>
	      			<th>
	      				<textarea name="" id="" cols="30" rows="10" class="form-control"></textarea>
	      			</th>
	      		</tr>
	      	</thead>      
	      </table>
      </div>
</div>
</body>
</html>