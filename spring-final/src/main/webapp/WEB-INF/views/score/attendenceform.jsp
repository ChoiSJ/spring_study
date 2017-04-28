<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		var week = {};
		var attrep = 100;
		var atty = 0;
		var attr = 0;
		var attn = 0;
		var stuno = $("#sttno").val();
		$("#att_btn").click(function() {
			
			for(var i=1; i<16; i++){
				week['week'+i] = $(":input:radio[name=in_"+i+"]:checked").val();
				
				if(week['week'+i] == 'Y'){
					atty ++;
				}
				if(week['week'+i] == 'N'){
					attn ++;
				}
				if(week['week'+i] == 'R'){
					attr ++;
				}
			}
			attn += attr/3;
			attrep -= attn * 5;		
			if(attn >= 5){
				attrep = 0;
			}
			week["attScore"] = attrep;
			week["attNo"] = $("#attno").val();
			week["scoreNo"] = $("#sno").val();
			
			$.ajax({
				url:"attsavetest.do",
				method:"post",
				data: JSON.stringify(week),
				contentType:"application/json; charset=UTF-8",
				type:"json",
				success:function(){
					window.location.href="http://localhost:8051/jhta/admin/attinfolist.do?stuno="+stuno;
				}
			});
		});
	});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/collegeregister/sidebar-hakjuk.jsp" %>
	<div class="container"  style="margin-left: 250px; padding-top: 25px;">
		<div class="row text-right">
			홈 > 성적관리 > 성적조회 > 성적상세정보 > 출석정보
		</div>
		
		<div class="row">
			<h4><span class="glyphicon glyphicon-th-list"></span>${stuinfo.name } 출석정보</h4>
			<hr style="border:solid 0.5px #2C7BB5;">
			<div class="panel panel-heading">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>주</th>
							<th>출석체크</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach varStatus="status" begin="1" end="15">
						<tr>
							<td>${status.index } 주차</td>
							<td>
							<div class="radio" id="rbtn_${status.index }">
									<label class="radio-inline">
  										<input type="radio" name="in_${status.index }" id="inlineRadio1_${status.index }" value="Y" checked="checked"> 출석
									</label>
									<label class="radio-inline">
  										<input type="radio" name="in_${status.index }" id="inlineRadio2_${status.index }" value="N" > 결석
									</label>
									<label class="radio-inline">
  										<input type="radio" name="in_${status.index }" id="inlineRadio3_${status.index }" value="R" > 지각
									</label>
								</div>
							</td>
						</tr>
					</c:forEach>	
					</tbody>
				</table>
				<input type="hidden" id="attno" value="${atno }">
				<input type="hidden" id="sttno" value="${stno }">
				<input type="hidden" id="sno" value="${sno }">
			</div>
			<div class="panel panel-footer">
				<div class="text-right">
					<button type="button" class="btn btn-primary" id="att_btn">저장</button>
					<a href="attinfolist.do?stuno=${stno }" class="btn btn-info">뒤로가기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>