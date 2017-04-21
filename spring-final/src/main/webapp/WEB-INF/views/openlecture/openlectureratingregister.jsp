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
<title>openlecture register</title>
<script type="text/javascript">

	$(function(){
		
		//선택 조회하기
		$("#search-button").on("click", function(){
			
			event.preventDefault();
			
			var Search = $("#fixed-header-drawer-exp").val();
			
			console.log(Search);
			
			$.ajax({
				type:"GET",
				url:"search/"+Search,
				dataType:"json",
				success: function(data){
					
					var $tbody = $("#professorinformationtbody").empty();
					
					for(i=0; i<data.length; i++){
						
						var no = data[i].no;
						console.log(no);
						var professorName = data[i].name;
						console.log(professorName);
						var code = data[i].code;
						console.log(code);
						var subjectName = data[i].subjectName;
						console.log(subjectName);
						var subjectNo = data[i].subjectNo;
						console.log(subjectNo);
						var id = data[i].id;
						var register = data[i].register;
						
						//강의개설후 강의 평가한 과목은 y 아닌과목은 n으로 함
						if(register != 'y'){	
						var html = "<tr>";
						html += "<td><input type='radio' name='options' value='"+code+'-'+subjectNo+'-'+professorName+'-'+subjectName+'-'+id+'-'+register+"'></td>";
						html += "<td>"+code+"</td>";
						html += "<td>"+subjectNo+"</td>";
						html += "<td>"+professorName+"</td>";
						html += "<td>"+subjectName+"</td>";
						html += "</tr>"
					
						$tbody.append(html);	
						}

					}	
					
				}
				
			});	
		});
		
		//정보를 화면에 표시하기
		$("#add-infromation").on("click", function(){
			
			if($('[name="options"]').is(':checked')){
				
				var text = $('[name="options"]').filter(':checked').val().split("-");
				
				
				$("#code").attr("value",text[0]);
				$("#subjectNo").attr("value",text[1]);
				$("#professorName").attr("value",text[2]);
				$("#subjectName").attr("value",text[3]);
				$("#professorIdHidden").attr("value",text[4]);
				$("#professorSubject").attr("value",text[1]);
				$("#add-infromation").attr("data-dismiss","modal");
				
			} else{
				alert("하나를 선택해주세요.");
			};
		});	
		
		// 추가하기
		$("#add-text").on("click",function(){
			
			
			if($("#content .form-group").length < 7){
				
				var html = "<div class='form-group'>"
					html +="<div class='col-sm-1'></div>"
					html +="<div class='col-sm-1'>"
					html +="<label style='color: black'>조사항목 :</label>"
					html +="</div>"
					html +="<div class='col-sm-7'>"
					html +="<textarea name='contents' class='form-control'style='resize: none'></textarea>"
					html +="</div>"
					html +="<div class='col-sm-3'>";
					html +="<button class='mdl-button mdj-js-button mdl-button-fab mdl-button-mini-fab' style='color:black'><i class='material-icons md-48'>delete_forever</i></button>"
					html +="</div>";
					html +="</div>"
				
				$("#content").append(html);

			}else{
				alert("최대 생성 개수를 초과하였습니다.");
			}
		});
		
		// 미래에 일어날 버튼을 위한 처리
		$("#content").on("click", 'button',function() {
			
			$(this).parents('.form-group').remove();
			
		});
		
	});
</script>
<style>
button.delete{
	border: 0;
	outline:0;
	background-color: white; 
}
button.add{
	border: 0;
	outline:0;
	background-color: white;
}
select.menu{
	 border: 0;
	 outline:0;
}	
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarsubject.jsp" %>
	<div class="container">
			<h1>강의 평가 등록</h1>
			<hr />
			<div class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
						<div class="row">
							<h3>&nbsp;&nbsp;상세 정보 등록</h3>
							<div class="col-sm-10"></div>
							<div class="col-sm-2">
								<!-- Button trigger modal -->
								<button id="modal-button" type="button" class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab" style="color:black" data-toggle="modal" data-target="#myModal"><i class="material-icons md-48">search</i></button>
								<!-- Modal -->
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
								  <div class="modal-dialog">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title" id="myModalLabel">상세 조회</h4>
								      </div>
								      <div class="modal-body">
								      	<div class="row">
								      		<div class="col-sm-12">
								      		<form action="">
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
											   		  <button id="search-button" hidden="hidden"><i class="material-icons">check</i></button>
											    </div>
								      		</form>
								      		</div>
										</div>
										<div class="row">
									      	<table class="mdl-data-table mdl-js-data-table table table-fixed" style="width: 100%;">
									      		<thead>
									      			<tr>
									      				<th></th>
									      				<th>코드 번호</th>
									      				<th>과목 번호</th>
									      				<th>교수 이름</th>
									      				<th>교수 과목</th>
									      			</tr>
									      		</thead>
									      		<tbody id="professorinformationtbody" >
									      			<c:forEach var="professorList" items="${openlecturelist }">
									      				<tr>
									      					<td>
																  <input type="radio" id="option-${professorList.no }" name="options" 
																  value="${professorList.code }-${professorList.subjectNo }-${professorList.name }-${professorList.subjectName }">
															</td>
									      					<td id="code-${professorList.code }">${professorList.code }</td>
									      					<td id="subjectno-${professorList.subjectNo }">${professorList.subjectNo } </td>
									      					<td id="professorName-${professorList.name }">${professorList.name } </td>
								      						<td id="subjectname-${professorList.subjectName }">${professorList.subjectName } </td>
									      				</tr>
									      			</c:forEach>
									      		</tbody>
											</table>
										</div>	
								      </div>
								      <div class="modal-footer">
								        <button id="add-infromation" type="button" class="mdl-button mdl-js-button mdl-button--primary" data-dismiss="">추가</button>
								        <button type="button" class="mdl-button mdl-js-button mdl-button--accent" data-dismiss="modal">취소</button>
								      </div>
								    </div>
								  </div>
								</div>
							</div>
							<form class="form-horizontal">
								<div class="form-group">
										<div class="col-sm-2">
											<label class="pull-right" style="color:black">코드 번호 :</label>
										</div>
										<div class="col-sm-6">
											<input id="code" class="mdl-textfield__input" type="text" style="width: 100%" name="information" value="" disabled="disabled"/>
										</div>
										<div class="col-sm-4"></div>
								</div>
								<div class="form-group">
										<div class="col-sm-2">
											<label class="pull-right" style="color:black">과목 번호 : </label>
										</div>
										<div class="col-sm-6">
											<input id="subjectNo" class="mdl-textfield__input" type="text" style="width: 100%" name="information" value="" disabled="disabled"/>
										</div>
										<div class="col-sm-4"></div>
								</div>
								<div class="form-group">
										<div class="col-sm-2">
											<label class="pull-right" style="color:black">교수 이름 : </label>
										</div>
										<div class="col-sm-6">
											<input id="professorName" class="mdl-textfield__input" type="text" style="width: 100%" name="information" value="" disabled="disabled"/>
										</div>
										<div class="col-sm-4"></div>
								</div>
								<div class="form-group">
										<div class="col-sm-2">
											<label class="pull-right" style="color:black">교수 과목 : </label>
										</div>
										<div class="col-sm-6">
											<input id="subjectName" class="mdl-textfield__input" type="text" style="width: 100%" name="information" value="" disabled="disabled"/>
										</div>
										<div class="col-sm-4"></div>
								</div>				
							</form>
						</div>
						<hr class="one">
						<div class="row">
							<h3>&nbsp;&nbsp;조사 항목 등록</h3>
							
							<div class="col-sm-10"></div>
							<div class="col-sm-2">
								<form >
									<button id="add-text" type="button" class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab" style="color:black"><i class="material-icons md-48">note_add</i></button>
								</form>
							</div>
						</div>
						<div class="row">
							<form class="form-horizontal" action="investigating.do">
								<div class="col-sm-12" id="content">
									<div class="form-group">
										<div class="col-sm-1"></div>
										<div class="col-sm-1">
									    	<label style="color: black">조사항목 :</label>
										</div>
										<div class="col-sm-7">
									  		<textarea name="contents" class="form-control" style="resize: none"></textarea>
									  		
										</div>
										<div class="col-sm-3"></div>
									</div>
									<div class="form-group">
										<div class="col-sm-1"></div>
										<div class="col-sm-1">
									    	<label style="color: black">조사항목 :</label>
										</div>
										<div class="col-sm-7">
									  		<textarea name="contents" class="form-control" style="resize: none"></textarea>
										</div>
										<div class="col-sm-3"></div>
									</div>
									<div class="form-group">
										<div class="col-sm-1"></div>
										<div class="col-sm-1">
									    	<label style="color: black">조사항목 :</label>
										</div>
										<div class="col-sm-7">
									  		<textarea name="contents" class="form-control" style="resize: none" ></textarea>
										</div>
										<div class="col-sm-3"></div>
									</div>
								</div>
								<div class="col-sm-10">
									<input id="professorIdHidden" name="professorId" type="hidden" value="" />
									<input id="professorSubject" name="subjectNo" type="hidden" value="">
									<input id="professorreister" name="register"  type="hidden" value="y"/>
								</div>
								<div class="col-sm-2">
									<button id="infrosubmit" class="mdl-button mdl-js-button mdl-button--primary" type="submit">추가</button>
									<button class="mdl-button mdl-js-button mdl-button--accent">취소</button>
								</div>
							</form>			
						</div>
						
	  		</div>
	</div>
</body>
</html>