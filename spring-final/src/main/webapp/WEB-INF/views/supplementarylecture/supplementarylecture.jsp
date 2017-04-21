<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="viewport" content="width=device-width, initial-scale=1">
<!-- 부트스트랩 설정 경로 지정  href에 부트스트랩이 저장되어있는 경로를 적는다.-->
<link type="text/css" rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="resources/material/material.min.css">
<script src="resources/material/material.min.js"></script>
<script type="text/javascript" src="resources/jquery/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
<title>supplementarylecture</title>
<style>
.wrap_table {padding:30px 0; position:relative; width:100%;}
.wrap_table > div {overflow:auto; height:153px;}
.wrap_table table {width:100%;}
.wrap_table table caption {height:0; overflow:hidden;}
.wrap_table table thead,
.wrap_table table tfoot {
    position:absolute;
    display:table;
    width:100%;
    border-bottom:1px solid #ccc;
}
.wrap_table table thead {top:0;}
.wrap_table table tfoot {bottom:0;}
.wrap_table table th,
.wrap_table table td {
    text-align:center;
    border-right:1px solid #ccc;
    border-top:1px solid #ccc;
    height:30px;
    vertical-align:middle;
}
.wrap_table table tr th:first-child,
.wrap_table table tr td:first-child {border-left:1px solid #ccc;}
.wrap_table table tbody tr:first-child td {border-top:0;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarsubject.jsp" %>
	<div class="container">
		<h1>휴강 관리</h1>
		<hr />
			<form action="">
				<div class="2"></div>
				<div class="col-sm-4">
				<select name="" id="">
					<option value="">자연대</option>
					<option value="">인문대</option>
					<option value="">사회대</option>
					<option value="">공학대</option>
				</select>
				</div>
				<div class="col-sm-4">
				<select name="" id="">
					<option value="">물리학과</option>
					<option value="">수학학과</option>
					<option value="">국어국문학과</option>
					<option value="">매미학과</option>
				</select>
				</div>
				<div class="2"></div>
				<button>검색</button>
			</form>
		<div class="wrap_table">
		    <div align="center">
		        <table>
		        	<caption></caption>
		            <thead>
		                <tr>
		                	<th style="width: 10"></th>
		                    <th style="width: 15%">과목 코드</th>
		                    <th style="width: 15%">전공 옵션</th>
		                    <th style="width: 15%">담당 교수</th>
		                    <th style="width: 30%">과목 이름</th>
		                    <th style="width: 15%">휴강 신청</th>
		                </tr>
		            </thead>		            
		            <tbody id="professorlist"></tbody>
		            <tfoot>
		            <tr>
		            	<td>
		            	</td>
		            </tr>
		            </tfoot>
		        </table>
		    </div>
		</div>
	</div>
</body>
</html>