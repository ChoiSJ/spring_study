<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <link href="resources/fullcalendar/fullcalendar.min.css" rel="stylesheet" />
  <link href="resources/fullcalendar/fullcalendar.print.min.css" rel="stylesheet" media="print" />
  <script src="resources/fullcalendar/lib/moment.min.js"></script>
  <script src="resources/fullcalendar/lib/jquery.min.js"></script>
  <script src="resources/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,basicWeek,basicDay'
		},
		defaultDate: '2017-04-12',
		navLinks: true, // can click day/week names to navigate views
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		events: []
	});
	
});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/stunavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarstud.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px; ">
    <div class="row text-right">
         홈
      </div>
      <div class="row">
         <h4><span class="glyphicon glyphicon-th-list"></span> HOME</h4>
         <hr style="border:solid 0.5px #2C7BB5;">
      </div>
      <div class="row">
	      <div class="col-xs-6">
	      	<div class="panel panel-default">
		      	<div class="panel-heading">
					<strong>최근 공지사항</strong><span style="padding-left: 5px;"><a href="" class="btn-default btn-xs">more</a></span>
		        </div> 
		       	<div class="panel-body">
		
		        </div>
	      	</div>
	      	<div class="panel panel-default">
		      	<div class="panel-heading">
					<strong>Q&amp;A</strong><span style="padding-left: 5px;"><a href="" class="btn-default btn-xs">more</a></span>
		        </div> 
		       	<div class="panel-body">
		
		        </div>
	      	</div>
	      </div>
	      
	      <div class="col-xs-6">
	      	<div class="panel panel-default">
		      	<div class="panel-heading">
					<strong>일정</strong>
		        </div> 
		       	<div class="panel-body">
					<div id="calendar"></div>
		        </div>
      		</div>
	      	<div class="panel panel-default">
		      	<div class="panel-heading">
					<strong>추가</strong><span style="padding-left: 5px;"><a href="" class="btn-default btn-xs">more</a></span>
		        </div> 
		       	<div class="panel-body">
		
		        </div>
      		</div>
	      </div>
	      <div class="row">
	      	<div class="col-xs-1"></div>
	      	<div class="col-xs-10">
		      	<table class="table table-bordered">
		      		<colgroup>
		      			<col width="10%" />
		      			<col width="10%" />
		      			<col width="*" />
		      			<col width="10%" />
		      			<col width="10%" />
		      			<col width="10%" />
		      		</colgroup>
		      		<thead>
		      			<tr>
		      				<th>학기</th>
		      				<th>강좌구분</th>
		      				<th>교과목명</th>
		      				<th>교수</th>
		      				<th>조회</th>
		      			</tr>
		      		</thead>
		      		<tbody>
		      			<tr>
		      				<th></th>
		      				<th></th>
		      				<th></th>
		      				<th></th>
		      				<th></th>
		      			</tr>
		      		</tbody>
		      	</table>
	      	</div>
	      	<div class="col-xs-1"></div>
	      </div>
      </div>
   </div>
</body>
</html>