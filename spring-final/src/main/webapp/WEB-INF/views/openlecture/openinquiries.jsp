<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<title>Insert title here</title>


<style>
.wrap_table {padding:30px 0px; position:relative; width:1172px;}
.wrap_table > div {overflow:auto; height:153px;}
.wrap_table table {width:1172px;}
.wrap_table table caption {height:0; overflow:hidden;}
.wrap_table table thead,
.wrap_table table tfoot {
    position:absolute;
    display:table;
    width:1172px;
    border-bottom:1px solid #ccc;
}
.wrap_table table thead {top:0;}
.wrap_table table tfoot {bottom:0;}
.wrap_table table th,
.wrap_table table td {
    text-align:center;
    border-right:1px solid #ccc;
    border-top:1px solid #ccc;
    border-left:1px solid #ccc;
    border-bottom:1px solid #ccc;
    vertical-align:middle;
}
.wrap_table table tr th:first-child,
.wrap_table table tr td:first-child {border-left:1px solid #ccc;}
.wrap_table table tbody tr:first-child td {border-top:0;}
</style>

<script type="text/javascript">

	$(function(){
		
		
	$("#search-button").on("click", function(){
		
			event.preventDefault();
			
			var SearchTable = $("#fixed-header-drawer-exp").val();
			
			$.ajax({
				type:"GET",
				url:"searchtable/"+SearchTable,
				dataType:"json",
				success: function(data){
					
					for(i=0; i<data.length; i++){
						
						var subjectNo =data[i].subjectNo;
						var	subjectCode = data[i].subjectCode;
						var	subjectPassd = data[i].subjectPassd;
						var	subjectPorfessor = data[i].subjectPorfessor;
						var	subjectProfeesorId = data[i].subjectProfeesorId;
					
						var $tbody = $("#professorlist").empty();	
						
						var html = "<tr>";
						html += "<td>"+subjectCode+"</td>";
						html += "<td>"+subjectNo+"</td>";
						html += "<td>"+subjectPorfessor+"</td>";
						html += "<td>"+subjectPassd+"</td>";
						html += "</tr>"
						
						$tbody.append(html);
	
					}	
				}
			});
		});	
	});

</script>

</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarsubject.jsp" %>
	<div class="container">
					<h1>강의 평가 조회</h1>
					<hr />
				  	  <div class="row">
				  		<h3>과목 조회</h3>
						<div class="row">
				      		<div class="mdl-layout__header-row">
						      <div id="search-option" class="mdl-layout-spacer"></div>
						      <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable mdl-textfield--floating-label mdl-textfield--align-right">
						        <label class="mdl-button mdl-js-button mdl-button--icon" for="fixed-header-drawer-exp">
						          <i class="material-icons">search</i>
						        </label>
						        <div id="search-text" class="mdl-textfield__expandable-holder">
						          <input class="mdl-textfield__input" type="text" id="fixed-header-drawer-exp" placeholder="아이디 입력">
						        </div>
						      </div>
						   		  <button class="mdl-button mdl-js-button" id="search-button"><i class="material-icons">check</i></button>
						    </div>		
				      	</div>
			      	  </div>
				  		<hr />
				  			<div class="wrap_table">
							    <div align="center">
							        <table>
							            <thead>
							                <tr>
							                    <th style="width: 25%">과목 코드</th>
							                    <th style="width: 25%">과목 번호</th>
							                    <th style="width: 25%">과목 이름</th>
							                    <th style="width: 25%">전공 옵션</th>
							                </tr>
							            </thead>
							            <tbody id="professorlist">
							                 <tr>
							                    <td style="width: 25%"></td>
							                    <td style="width: 25%"></td>
							                    <td style="width: 25%"></td>
							                    <td style="width: 25%"></td>
							                </tr>
							            </tbody>
							            <tfoot></tfoot>
							        </table>
							    </div>
							</div>
				  		</div>
			  		</div>
</body>
</html>