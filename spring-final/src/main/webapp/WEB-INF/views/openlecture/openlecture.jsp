<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="viewport" content="width=device-width, initial-scale=1">
<!-- 부트스트랩 설정 경로 지정  href에 부트스트랩이 저장되어있는 경로를 적는다.-->
<link type="text/css" rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="resources/table/css/ingrid.css" type="text/css" media="screen" />
<script type="text/javascript" src="resources/jquery/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
<script>
	$(function(){
		
	});
</script>
<style>
 hr {
    border: none;
    border-top: 1px dotted black;
    color: #fff;
    background-color: #fff;
    height: 1px;
    width: 100%;
}
table,th,td,tr {
		border: 1px solid black;
}
</style>
<title>open lecture</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
	<div class="container">
		<h1>강의 평가</h1>
		<br />
		<table style="width: 100%; border:1px solid;">
			<tr>
				<td>
					<p>
					&nbsp;
					◎ 본조사는 중앙 HTA 대학교 재학생을 대상으로 한 교육만족도 증진을 위한 만족도 조사로 익명으로 실시되오니 솔직하고 정확하게 작성해 주시기 바랍니다.
					&nbsp; 
					</p>
					<p>
					&nbsp;
					&nbsp;
					&nbsp;
					&nbsp;
					여러분이 응답하여 주신 각각의 자료는 보다 나은 교육서비스 체제 구축을 위한 발전방안을 마련하는 기초자료로 적극 반영될 것입니다.
					</p>
					<p>
					&nbsp;
					◎ 본 조사의 평가척도는 5점으로 구성되어 있으며, (1)은 전혀아니다 (5)는 매우 그렇다를 의미하며, 번호가 클수록 만족도가 높은것을 의미합니다.
					&nbsp;
					</p>
				</td>
			</tr>			
		</table>
		<br />
		<table>
		</table>
		<hr />
		<table style="width: 100%; border:1px solid black;">
			<tr>
				<td colspan="7">
					<p>&nbsp;&nbsp;■ 다음은 교육과정(전공, 교양)에 대한 질문입니다. 해당란에 체크표 해주십시오.&nbsp;&nbsp;</p>
					
				</td>	
			</tr>
			<tr>
				<td align="center">구분</td>
				<td style="width:40%" align="center">조사 항목</td>
				<td style="width:10%" align="center">
				<p align="center">매우그렇다</p>
				<p align="center">(5)</p>
				</td>
				<td style="width:10%" align="center">
				<p align="center">대체로 그렇다</p>
				<p align="center">(4)</p>
				</td>
				<td style="width:10%" align="center">
				<p align="center">그저 그렇다</p>
				<p align="center">(3)</p>
				</td>
				<td style="width:10%" align="center">
				<p align="center">대체로 아니다</p>
				<p align="center">(2)</p>
				</td>
				<td style="width:10%" align="center">
				<p align="center">전혀아니다</p>
				<p align="center">(1)</p>
				</td>
			</tr>
			<tr id="">
				<td style="width:10%" align="center">1</td>
				<td style="width:40%" align="center"></td>
				<td style="width:10%" align="center">
				<input type="radio" checked="checked" name="appraise-1"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-1"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-1"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-1"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-1"/>
				</td>			
			</tr>
			<tr id="">
				<td style="width:10%" align="center">2</td>
				<td style="width:40%" align="center"></td>
				<td style="width:10%" align="center">
				<input type="radio" checked="checked" name="appraise-2"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-2"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-2"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-2"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-2"/>
				</td>
			</tr>
			<tr id="">
				<td style="width:10%" align="center">3</td>
				<td style="width:40%" align="center"></td>
				<td style="width:10%" align="center">
				<input type="radio" checked="checked" name="appraise-3"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-3"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-3"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-3"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-3"/>
				</td>
			</tr>
			<tr id="">
				<td style="width:10%" align="center">4</td>
				<td style="width:40%" align="center"></td>
				<td style="width:10%" align="center">
				<input type="radio" checked="checked" name="appraise-4"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-4"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-4"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-4"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-4"/>
				</td>
			</tr>
			<tr id="">
				<td style="width:10%" align="center">5</td>
				<td style="width:40%" align="center"></td>
				<td style="width:10%" align="center">
				<input type="radio" checked="checked" name="appraise-5"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-5"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-5"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-5"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-5"/>
				</td>
			</tr>
			<tr id="">
				<td style="width:10%" align="center">6</td>
				<td style="width:40%" align="center"></td>
				<td style="width:10%" align="center">
				<input type="radio" checked="checked" name="appraise-6"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-6"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-6"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-6"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-6"/>
				</td>
			</tr>
			<tr id="">
				<td style="width:10%" align="center">7</td>
				<td style="width:40%" align="center"></td>
				<td style="width:10%" align="center">
				<input type="radio" checked="checked" name="appraise-7"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-7"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-7"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-7"/>
				</td>
				<td style="width:10%" align="center">
				<input type="radio" name="appraise-7"/>
				</td>
			</tr>
			<tr>
				<td colspan="7">
					<textarea  class="form-control" id="" cols="30" rows="10"></textarea>
				</td>	
			</tr>
		</table>
	</div>
<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>