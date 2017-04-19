<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	$(function () {
  		
		$("#college").change(function (event) {
			var dept = $(this).find("option:selected").val();
			$.ajax({
				url: "searchmajor?dept=" + dept,
				dataType: "json",
				type: "POST",
				success: function(data) {
					$("#major").empty();
					$("#professor").empty();

					for (var i=0; i<data.sitemapList.length; i++) {
						$("#major").append("<option value="+data.sitemapList[i].code+">"+data.sitemapList[i].name+"</option>");	
					}
					for (var i=0; i<data.profList.length; i++) {
						$("#professor").append("<option value="+data.profList[i].id+">"+data.profList[i].name+"</option>");	
					}
				}
			});
		});
		$("#major").change(function (event) {
			var dept = $(this).find("option:selected").val();
			$.ajax({
				url: "searchprof?code=" + dept,
				dataType: "json",
				type: "POST",
				success: function(data) {
					console.log(data);
					$("#professor").empty();
					for (var i=0; i<data.length; i++) {						
						$("#professor").append("<option value="+data[i].id+">"+data[i].name+"</option>");	
					}
				}
			});
		});
		$("#emailAddr").change(function (event) {
			if($(this).val() != 'edit'){
				$("[name='studemailaddr']").val($(this).val());
				$("[name='studemailaddr']").attr('readonly',true);
			}else{
				$("[name='studemailaddr']").attr('readonly',false);
				$("[name='studemailaddr']").val('');
			}
		});
	})
  </script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="sidebar-hakjuk.jsp" %>
	<div class="container" style="margin-left: 250px; padding-top:25px; ">
		<div class="row text-right">
			홈 > 학적관리 > 입학관리 > <strong>입학생 등록</strong> 
		</div>
		<div class="row" style="margin: 0px; padding: 0px;">
			<h4><span class="glyphicon glyphicon-list-alt"></span> 입학생 등록</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div class="row">
			<div class="panel panel-default">
				<div class="panel panel-body" style="margin: 10px; ">
					<form action="addstud" method="post">
						<div class="row">
							<div class="col-xs-2">
								<img src="/jhta/resources/images/student/PeoPleDefault.png" alt="person" style="width: 150px; height: 180px;" />
							</div>
							<div class="col-xs-10">
								<p>[기본 정보]</p>
								<table class="table table-bordered table-striped">
									<colgroup>
										<col width="20%" />
										<col width="30%" />
										<col width="20%" />
										<col width="30%" />
									</colgroup>
									<tbody>
										<tr>
											<th>학생 성명 : </th>
											<td><input type="text" name="name" class="form-control"/></td>
											<th>학적 상태 : </th>
											<td>
												<select class="form-control" name="register">
													<option value="AD1000">신입학</option>
													<option value="AD2000">재입학</option>
												</select>
											</td>
										</tr>
										<tr>
											<th>주민등록번호 : </th>
											<td>
												<input type="text" name="ssn" class="form-control" placeholder="'-'을 입력하세요.">
											</td>
											<th>성별 구분: </th>
											<td>
												<label>남 : </label><input type="radio" name="gender" value="M" checked="checked"/> / 
												<label>여 : </label><input type="radio" name="gender" value="F"/>
											</td>
										</tr>
										<tr>
											<th>대학 구분 : </th>
											<td>
												<select class="form-control" id="college">
													<c:forEach var = "sitemap" items="${sitemapList }" >
														<option value="${sitemap.code }">${sitemap.name }</option>
													</c:forEach>
												</select>
											</td>
											<th>학과 구분: </th>
											<td>
												<select class="form-control" name="division" id="major">
													<c:if test="${not empty majors}">
														<c:forEach var="major" items="${majors }">
															<option value="${major.code }">${major.name }</option> 
														</c:forEach>
													</c:if>
												</select>
											</td>
										</tr>
										<tr>
											<th>학년</th>
											<td>
												<select class="form-control" name="grade">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
												</select>
											</td>
											<th>지도 교수 : </th>
											<td>
												<select class="form-control" name="professor" id="professor">
													<c:if test="${not empty professors }">
														<c:forEach var="professor" items="${professors }">
															<option value="${professor.id }">${professor.name }</option> 
														</c:forEach>
													</c:if>
												</select>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<p>[추가 정보]</p>
							<table class="table table-bordered">
								<colgroup>
									<col width="10%" />
									<col width="10%" />
									<col width="*" />
								</colgroup>
								<tbody>
									<tr>
										<th>개인</th>
										<th>휴대폰</th>
										<td><input type="text" name="phone" class="form-control" placeholder="'-'을 입력하세요."/></td>
										<th>이메일</th>
										<td>
											<div class=row>
												<div class="col-xs-4">
													<input type="text" name="studemail" class="form-control" />
												</div>
												<div class="col-xs-1">
													<p>@</p>
												</div>
												<div class="col-xs-4">
													<input type="text" name="studemailaddr" class="form-control" />
												</div>
												<div class="col-xs-3">
													<select class="form-control" id="emailAddr">
														<option value="edit">직접입력</option>
														<option value="naver.com">naver.com</option>
														<option value="gmail.com">gmail.com</option>
														<option value="nate.com">nate.com</option>
														<option value="hanmail.net">hanmail.net</option>
														<option value="yahoo.co.kr">yahoo.co.kr</option>
													</select> 
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<th rowspan="4">자택</th>
										<th rowspan="2">주소</th>
										<td colspan="3">
											<div class="row">
												<div class="col-md-10">
													<input type="text" name="addr1" class="form-control" /> 
												</div>
												<div class="col-md-2">
													<a href="#" class="btn btn-success">우편번호 검색</a>
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="3"><input type="text" name="addr2" class="form-control" /></td>
									</tr>
									<tr>
										<th>보호자 성함</th>
										<td><input type="text" name="parentName" class="form-control" /> </td>
										<th>보호자 연락처</th>
										<td><input type="text" name="parentPhone" class="form-control" placeholder="'-' 없이 입력하세요."/> </td>
									</tr>
								</tbody>
							</table>
							<div class="text-right">
								<button class="btn btn-primary btn-sm" type="submit"><span class="glyphicon glyphicon-pencil"></span> 등록</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>