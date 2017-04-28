<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
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
						$("#professor").append("<option value="+data.profList[i].id+">"+data.profList[i].name+" ("+data.profList[i].id+")"+"</option>");		
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
						$("#professor").append("<option value="+data[i].id+">"+data[i].name+" ("+data[i].id+")"+"</option>");		
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
			홈 > 학적관리 > 사용자 관리 > <strong>학생 조회</strong> 
		</div>
		<div class="row" style="margin: 0px; padding: 0px;">
			<h4><span class="glyphicon glyphicon-list-alt"></span> 학생 정보 수정</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
		</div>
		<div class="row">
			<div class="panel panel-default">
				<div class="panel panel-body" style="margin: 10px; ">
					<form action="updatestud" method="post">
						<div class="row">
							<div class="col-xs-2">
								<img src="/jhta/resources/images/student/PeoPleDefault.png" alt="person" style="width: 150px; height: 180px;" />
							</div>
							<div class="col-xs-10">
								<input type="hidden" name="id" value="${student.id }">
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
											<td><input type="text" name="name" class="form-control" value="${student.name }"/></td>
											<th>학적 상태 : </th>
											<td>
												${student.register }
											</td>
										</tr>
										<tr>
											<th>주민등록번호 : </th>
											<td>
												<input type="text" name="ssn" class="form-control" placeholder="'-'을 입력하세요." value="${student.ssn }">
											</td>
											<th>성별 구분: </th>
											<td>
												<c:choose>
						        					<c:when test="${student.gender eq 'M' }">남성</c:when>
						        					<c:when test="${student.gender eq 'F' }">여성</c:when>
	        									</c:choose>	    
											</td>
										</tr>
										<tr>
											<th>대학 구분 : </th>
											<td>
												<select class="form-control" id="college">
													<c:forEach var = "sitemap" items="${sitemapList }" >
														<c:choose>
															<c:when test="${sitemap.code eq studSitemap.preCode }">
																<option value="${sitemap.code }" selected="selected">${sitemap.name }</option>
															</c:when>
															<c:otherwise>
																<option value="${sitemap.code }">${sitemap.name }</option>	
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</td>
											<th>학과 구분: </th>
											<td>
												<select class="form-control" name="division" id="major">
													<c:if test="${not empty majors}">
														<c:forEach var="major" items="${majors }">
															<c:choose>
																<c:when test="${major.code eq studSitemap.code }">
																	<option value="${major.code }" selected="selected">${major.name }</option>
																</c:when>
																<c:otherwise>
																	<option value="${major.code }">${major.name }</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</c:if>
												</select>
											</td>
										</tr>
										<tr>
											<th>학년</th>
											<td>
												<select class="form-control" name="grade">
													<option ${student.grade eq 1 ? 'selected=selected' : ''}>1</option>
													<option ${student.grade eq 2 ? 'selected=selected' : ''}>2</option>
													<option ${student.grade eq 3 ? 'selected=selected' : ''}>3</option>
													<option ${student.grade eq 4 ? 'selected=selected' : ''}>4</option>
												</select>
											</td>
											<th>지도 교수 : </th>
											<td>
												<select class="form-control" name="professor" id="professor">
													<c:if test="${not empty professors }">
														<c:forEach var="professor" items="${professors }">
															<option value="${professor.id }" ${professor.id eq student.professor ? 'selected=selected' : '' }>${professor.name } (${professor.id })</option> 
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
										<td><input type="text" name="phone" class="form-control" placeholder="'-'을 입력하세요." value="${student.phone }"/></td>
										<th>이메일</th>
										<td>
											<div class=row>
												<div class="col-xs-4">
													<input type="text" name="studemail" class="form-control" value="${fn:split(student.email,'@')[0]  }" />
												</div>
												<div class="col-xs-1">
													<p>@</p>
												</div>
												<div class="col-xs-4">
													<input type="text" name="studemailaddr" class="form-control" value="${fn:split(student.email,'@')[1]  }" />
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
													<input type="text" name="addr1" class="form-control" value="${student.addr1 }"/> 
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="3"><input type="text" name="addr2" class="form-control" value="${student.addr2 }" /></td>
									</tr>
									<tr>
										<th>보호자 성함</th>
										<td><input type="text" name="parentName" class="form-control" value="${student.parentName }"/> </td>
										<th>보호자 연락처</th>
										<td><input type="text" name="parentPhone" class="form-control" placeholder="'-'를 사용하여 입력하세요." value="${student.parentPhone }" /> </td>
									</tr>
								</tbody>
							</table>
							<div class="text-right">
								<button class="btn btn-primary btn-sm" type="submit"><span class="glyphicon glyphicon-pencil"></span> 수정</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>