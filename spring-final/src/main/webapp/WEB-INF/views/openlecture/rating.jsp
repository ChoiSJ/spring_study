<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="viewport"
	content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="resources/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<script type="text/javascript"
	src="resources/jquery/jquery-3.2.0.min.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<title>open lecture</title>
</head>
<body>
	<div class="container">
		<div class="row" style="height: 10px"></div>
		<div class="row">
			<div class="col-sm-3">
				<h2>&nbsp;&nbsp;강의 평가</h2>
			</div>
			<div class="col-sm-5"></div>
			<div class="col-sm-4">
				<img src="/jhta/resources/logo/login-logo4.png" width="350px"
					height="100px" />
			</div>
		</div>
		<div class="row" style="height: 30px"></div>
		<div class="row">
			<table
				class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--4dp"
				style="width: 100%;">
				<tr>
					<td>
						<p align="left">◎ 본조사는 중앙 HTA 대학교 재학생을 대상으로 한 교육만족도 증진을 위한 만족도
							조사로 익명으로 실시되오니 솔직하고 정확하게 작성해 주시기 바랍니다.</p>
						<p align="left">&nbsp;&nbsp;&nbsp;&nbsp;여러분이 응답하여 주신 각각의 자료는
							보다 나은 교육서비스 체제 구축을 위한 발전방안을 마련하는 기초자료로 적극 반영될 것입니다.</p>
						<p align="left">◎ 본 조사의 평가척도는 5점으로 구성되어 있으며, (1)은 전혀아니다 (5)는
							매우 그렇다를 의미하며, 번호가 클수록 만족도가 높은것을 의미합니다.</p>
					</td>
				</tr>
			</table>
			<br />
		</div>
		<form action="ratingInsert.do" id="scoreRating">
			<div class="row">
				<div class="row" style="height: 30px"></div>
				<table
					class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--4dp"
					style="width: 100%;">
					<thead>
						<tr hidden="hidden">
							<th hidden="hidden"></th>
							<th hidden="hidden"></th>
							<th hidden="hidden"></th>
							<th hidden="hidden"></th>
							<th hidden="hidden"></th>
							<th hidden="hidden"></th>
							<th hidden="hidden"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="7">
								<p>&nbsp;&nbsp;■ 다음은 교육과정(전공, 교양)에 대한 질문입니다. 해당란에 체크표
									해주십시오.&nbsp;&nbsp;</p>
							</td>
						</tr>
						<tr>
							<td style="width: 12%" align="center"><p align="center">구분</p></td>
							<td style="width: 30%"><p align="center">조사 항목</p></td>
							<td style="width: 12%">
								<p>매우그렇다</p>
								<p>(5)</p>
							</td>
							<td style="width: 12%">
								<p>대체로 그렇다</p>
								<p>(4)</p>
							</td>
							<td style="width: 12%">
								<p>그저 그렇다</p>
								<p>(3)</p>
							</td>
							<td style="width: 12%">
								<p>대체로 아니다</p>
								<p>(2)</p>
							</td>
							<td style="width: 12%">
								<p>전혀아니다</p>
								<p>(1)</p>
							</td>
						</tr>
						<!-- varStatus="status 숫자하나씩 올리는 코딩  ${status.count }-->
						<c:forEach var="detailsheet" items="${detailsheet }"
							varStatus="status">
							<tr id="">
								<td style="width: 12%"><p align="center">${status.count }</p></td>
								<td style="width: 30%"><p>${detailsheet.contents }</p></td>
								<td style="width: 12%"><input type="radio"
									checked="checked" name="appraise-${status.count }" value="5" /></td>
								<td style="width: 12%"><input type="radio"
									name="appraise-${status.count }" value="4" /></td>
								<td style="width: 12%"><input type="radio"
									name="appraise-${status.count }" value="3" /></td>
								<td style="width: 12%"><input type="radio"
									name="appraise-${status.count }" value="2" /></td>
								<td style="width: 12%"><input type="radio"
									name="appraise-${status.count }" value="1" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="row" style="height: 20px"></div>
			<div class="row">
				<div class="col-sm-10">
					<input name="scoreNo" type="hidden" value="${param.scoreNo }">
				</div>
				<div class="col-sm-2">

					<button class="mdl-button mdl-js-button mdl-button--primary"
						type="submit">등록</button>
					<a class="mdl-button mdl-js-button mdl-button--accent"
						href="scoreerror.do">취소</a>
				</div>
			</div>
		</form>
		<div class="row" style="height: 30px"></div>
	</div>
</body>
</html>