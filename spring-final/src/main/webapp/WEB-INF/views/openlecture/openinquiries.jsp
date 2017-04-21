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

<script type="text/javascript">

	$(function(){
		
	//테이블 조회	
	$("#search-button").on("click", function(){
		
			event.preventDefault();
			
			var SearchTable = $("#fixed-header-drawer-exp").val();
			
			$.ajax({
				type:"GET",
				url:"searchtable/"+SearchTable,
				dataType:"json",
				success: function(data){
					
					var $tbody = $("#professorlist").empty();	
					
					for(i=0; i<data.length; i++){
						
							var subjectNo =data[i].subjectNo;
							var	subjectCode = data[i].subjectCode;
							var	subjectName = data[i].subjectName;
							var	subjectPassd = data[i].subjectPassd;
							var subjectId = data[i].subjectId;
							var register = data[i].register;
							
							if(register == null){
								
								var html = "<tr>"
								html += "<td style=width:10%><input type='radio' name='subjectradio' value='"+subjectNo+'-'+subjectId+"'/></td>"
								html += "<td style=width:15%>"+subjectCode+"</td>";
								html += "<td style=width:15%>"+subjectNo+"</td>";
								html += "<td style=width:30%>"+subjectName+"</td>";
								html += "<td style=width:15%>"+subjectPassd+"</td>";
								html += "<td style=width:15%><button disabled value='"+register+"' id='openlecture-"+subjectNo+"' type='button' class='btn btn-default btn-xs'data-toggle='modal' data-target='.bs-example-modal-lg'><i class='glyphicon glyphicon-list-alt'></i></button></td>";
								html += "</tr>";
								
								$tbody.append(html);
								
							}else{
								
								var html = "<tr>"
								html += "<td style=width:10%><input type='radio' name='subjectradio' value='"+subjectNo+"'/></td>"
								html += "<td style=width:15%>"+subjectCode+"</td>";
								html += "<td style=width:15%>"+subjectNo+"</td>";
								html += "<td style=width:30%>"+subjectName+"</td>";
								html += "<td style=width:15%>"+subjectPassd+"</td>";
								html += "<td style=width:15%><button value='"+register+"' id='openlecture-"+subjectNo+"' type='button' class='btn btn-default btn-xs'data-toggle='modal' data-target='.bs-example-modal-lg'><i class='glyphicon glyphicon-list-alt'></i></button></td>";
								html += "</tr>";
								
								$tbody.append(html);
								
							}	
						
						}
					
					//모달 강의 평가 
						$("button[id^='openlecture']").on("click", function(event){
						
						var SubjectNo = $(this).attr('id').replace('openlecture-','');
						
						
						$.ajax({
							type:"GET",
							url:"subjectNo/"+SubjectNo,
							dataType:"json",
							success: function(data){
								
								var $div = $("#modaldata").empty();
								if (data.length) {
									var html='<div class="container">';
									html+='<h3>강의 계획서</h3>';
									html+='<table style="width: 870px;">';
									html+='<tr>';
									html+='<td>';
									html+='<p>&nbsp;◎ 본조사는 중앙 HTA 대학교 재학생을 대상으로 한 교육만족도 증진을 위한 만족도 조사로 익명으로 실시되오니 솔직하고 정확하게 작성 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;해 주시기 바랍니다.&nbsp; </p>';
									html+='<p>&nbsp;◎ 여러분이 응답하여 주신 각각의 자료는 보다 나은 교육서비스 체제 구축을 위한 발전방안을 마련하는 기초자료로 적극 반영될 것입니다.</p>';
									html+='</td>';
									html+='</tr>';
									html+='</table>';
									html+='<table class="table table-default" style="width: 870px;">';
									html+='<tr>';
									html+='<td colspan="7">';
									html+='<p>&nbsp;&nbsp;■ 다음은 교육과정(전공, 교양)에 대한 질문입니다. 해당란에 체크표 해주십시오.&nbsp;&nbsp;</p>';
									html+='</td>';
									html+='</tr>';
									html+='<tr>';
									html+='<td align="center" style="size: 1">구분</td>';
									html+='<td style="width:40%" align="center" style="size: 1">조사 항목</td>';
									html+='<td style="width:10%" align="center">';
									html+='<p align="center" style="size: 1">매우그렇다</p>';
									html+='</td>';
									html+='<td style="width:10%" align="center" style="size: 2">';
									html+='<p align="center" style="size: 1">대체로 그렇다</p>';
									html+='</td>';
									html+='<td style="width:10%" align="center" style="size: 2">';
									html+='<p align="center" style="size: 1">그저 그렇다</p>';
									html+='</td>';
									html+='<td style="width:10%" align="center" style="size: 2">';
									html+='<p align="center" style="size: 1">대체로 아니다</p>';
									html+='</td>';
									html+='<td style="width:10%" align="center" style="size: 2">';
									html+='<p align="center" style="size: 1">전혀아니다</p>';
									html+='</td>';
									html+='</tr>';
									
									for(i=0; i<data.length; i++){
										
									html+='<tr id="">';
									html+='<td style="width:10%" align="center" style="size: 1">'+(i+1)+'</td>';
									html+='<td style="width:40%" align="center" style="size: 1">'+data[i].contents+'</td>';
									html+='<td style="width:10%" align="center" style="size: 1">';
									html+='<input type="radio" checked="checked" name="appraise" style="size: 1"/>';
									html+='</td>';
									html+='<td style="width:10%" align="center" style="size: 1">';
									html+='<input type="radio" name="appraise" style="size: 1"/>';
									html+='</td>';
									html+='<td style="width:10%" align="center" style="size: 1">';
									html+='<input type="radio" name="appraise" style="size: 1"/>';
									html+='</td>';
									html+='<td style="width:10%" align="center" style="size: 1">';
									html+='<input type="radio" name="appraise" style="size: 1"/>';
									html+='</td>';
									html+='<td style="width:10%" align="center" style="size: 1">';
									html+='<input type="radio" name="appraise" style="size: 1"/>';
									html+='</td>';
									html+='</tr>';
									}
									html+='</table>';
									html+='</div>';
									

									$div.append(html);
								}else {
									
								}
								
													
											
							}
						})						
					});
					
				}
			});
			
			
		//삭제 ajax
		$("#subjectdelete").on("click", function(){
			
			var text = $(":checked").val().split("-")
			var deleteNo = text[0];
			var deleteId = text[1];
			
			console.log(deleteNo);
			console.log(deleteId);
			
			$.ajax({
				type:"DELETE",
				url:"deletesubject/"+deleteNo+"/"+deleteId,
				dataType:"json",
				success: function(data){
				
								var $tbody = $("#professorlist").empty();	
						
							
								for(i=0; i<data.length; i++){
							
								var subjectNo =data[i].subjectNo;
								var	subjectCode = data[i].subjectCode;
								var	subjectName = data[i].subjectName;
								var	subjectPassd = data[i].subjectPassd;
								var register = data[i].register;
								
							
								var html = "<tr>"
								html += "<td style=width:10%><input type='radio' name='subjectradio' value='"+subjectNo+"'/></td>"
								html += "<td style=width:15%>"+subjectCode+"</td>";
								html += "<td style=width:15%>"+subjectNo+"</td>";
								html += "<td style=width:30%>"+subjectName+"</td>";
								html += "<td style=width:15%>"+subjectPassd+"</td>";
								html += "<td style=width:15%><button disabled value='"+register+"' id='openlecture-"+subjectNo+"' type='button' class='btn btn-default btn-xs'data-toggle='modal' data-target='.bs-example-modal-lg'><i class='glyphicon glyphicon-list-alt'></i></button></td>";
								html += "</tr>";
								
								$tbody.append(html);
								
						}
							
					}
			});
		});
		});	
	});

</script>

</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarsubject.jsp" %>
	<div class="container">
								<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
								  <div class="modal-dialog modal-lg">
								    <div class="modal-content" id="modaldata">
								    </div>
								  </div>
								</div>
					<h1>강의 평가 조회</h1>
					<hr />
				  	  <div class="row">
				  		<h3>과목 조회</h3>
						<div class="row">
				      		<form action="">
					      		<div class="mdl-layout__header-row">
							      <div id="search-option" class="mdl-layout-spacer">
							      </div>
							      <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable mdl-textfield--floating-label mdl-textfield--align-right">
							        <label class="mdl-button mdl-js-button mdl-button--icon" for="fixed-header-drawer-exp">
							          <i class="material-icons">search</i>
							        </label>
							        <div id="search-text" class="mdl-textfield__expandable-holder">
							          <input class="mdl-textfield__input" type="text" id="fixed-header-drawer-exp" placeholder="아이디 입력">
							        </div>
							      </div>
							   		  <button class="mdl-button mdl-js-button" id="search-button" hidden="hidden"><i class="material-icons">check</i></button>
							    </div>		
				      		</form>
				      	</div>
			      	  </div>
				  		<hr />
				  			<div class="wrap_table">
							    <div align="center">
							        <table>
							        	<caption></caption>
							            <thead>
							                <tr>
							                	<th style="width: 10"></th>
							                    <th style="width: 15%">과목 코드</th>
							                    <th style="width: 15%">과목 번호</th>
							                    <th style="width: 30%">과목 이름</th>
							                    <th style="width: 15%">전공 옵션</th>
							                    <th style="width: 15%">강의 평가서</th>
							                </tr>
							            </thead>		            
							            <tbody id="professorlist"></tbody>
							            <tfoot>
							            <tr>
							            	<td>
							            		<button id="subjectdelete" type="submit" class='mdl-button mdj-js-button mdl-button-fab mdl-button-mini-fab pull-right' style='color:black'><i class='material-icons md-48'>delete_forever</i></button>
							            	</td>
							            </tr>
							            </tfoot>
							        </table>
							    </div>
							</div>
		<hr />
		<h3>교수 상세 정보</h3>	  		
	</div>
</body>
</html>