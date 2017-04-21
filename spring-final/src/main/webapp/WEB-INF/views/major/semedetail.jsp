<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/navi/adminnavi.jsp" %>
<%@ include file="/WEB-INF/views/navi/sidebarmajor.jsp" %>
   <div class="container" style="margin-left: 250px; padding-top:25px; ">
    <div class="row text-right">
         홈 > 학기관리 > <strong>학기상세/수정</strong>
    </div>
    <div class="row">
       <h4><span class="glyphicon glyphicon-th-list"></span> 학기수정</h4>
       <hr style="border:solid 0.5px #2C7BB5;">
    </div>
	<div class="row well">
		<div class="col-md-6">
			<form action="editseme" method="post" name="semeupdateform">
				<input type="hidden" name="no" value="${semeupdateform.no }">			
				<table class="table table-condensed">
			   		<colgroup>
			   			<col width="20%">
			   			<col width="32%">
			   			<col width="8%">
			   			<col width="32%">
			   			<col width="8%">
			   		</colgroup>
	      			
	      			
	      			<tr>
	      				<td>학기명</td>
	      				<td>
	      					<c:forTokens items="${semeupdateform.semeSelect }" delims="-"  begin="0" end="0" var="year" >
	      						<c:set value="${year }" var="selectyear"></c:set>
	      					</c:forTokens>
	      					<c:forTokens items="${semeupdateform.semeSelect }" delims="-"  begin="1" end="1" var="seme" >
	      						<c:set value="${seme }" var="selectseme"></c:set>
	      					</c:forTokens>
	      					<input name="selectyear" class="form-control"  style="text-align: right;" value="${selectyear }"/>
	      				</td>
	      				<td>년도</td>
	      				<td><input name="selectseme" class="form-control" value="${selectseme }" /></td>
	      				<td>학기</td>
	      			</tr>
	      			<tr>
	      				<td>학기기간</td>
	      				<td>
				      		<fmt:formatDate value="${semeupdateform.termStart }" pattern="yyyy-MM-dd" var="termStart"/>
	      					<input name="termStart" type="date" class="form-control" value="${termStart}"/>
	      				</td>
	      				<td style="text-align: center;"> ~ </td>
	      				<td>
				      		<fmt:formatDate value="${semeupdateform.termEnd }" pattern="yyyy-MM-dd" var="termEnd"/>
	      					<input name="termEnd" type="date" class="form-control" value="${termEnd}"/>
	      				</td>
	      				<td></td>
	      			</tr>
	      			<tr>
	      				<td>수강신청기간</td>
	      				<td>
	      					<fmt:formatDate value="${semeupdateform.enrollTermStart }" pattern="yyyy-MM-dd" var="enrollTermStart"/>
	      					<input name="enrollTermStart" type="date" class="form-control" value="${enrollTermStart}"/>
	      				</td>
	      				<td style="text-align: center;"> ~ </td>
	      				<td	 >
	      					<fmt:formatDate value="${semeupdateform.enrollTermEnd }" pattern="yyyy-MM-dd" var="enrollTermEnd"/>
	      					<input name="enrollTermEnd" type="date" class="form-control" value="${enrollTermEnd}"/>
	      				</td>
	      				<td></td>
	      			</tr>
	      			<tr>
	      				<td>수강정정기간</td>
	      				<td>
	      					<fmt:formatDate value="${semeupdateform.enrollEditTermStart }" pattern="yyyy-MM-dd" var="enrollEditTermStart"/>
	      					<input name="enrollEditTermStart" type="date" class="form-control" value="${enrollEditTermStart}"/>
	      				</td>
	      				<td style="text-align: center;"> ~ </td>
	      				<td	 >
	      					<fmt:formatDate value="${semeupdateform.enrollEditTermEnd }" pattern="yyyy-MM-dd" var="enrollEditTermEnd"/>
	      					<input name="enrollEditTermEnd" type="date" class="form-control" value="${enrollEditTermEnd}"/>
	      				</td>
	      				<td></td>
	      			</tr>
	      			<tr>
	      				<td>성적등록기간</td>
	      				<td>
	      					<fmt:formatDate value="${semeupdateform.applyTermStart }" pattern="yyyy-MM-dd" var="applyTermStart"/>
	      					<input name="applyTermStart" type="date" class="form-control" value="${applyTermStart}"/>
	      				</td>
	      				<td style="text-align: center;"> ~ </td>
	      				<td	 >
	      					<fmt:formatDate value="${semeupdateform.applyTermEnd }" pattern="yyyy-MM-dd" var="applyTermEnd"/>
	      					<input name="applyTermEnd" type="date" class="form-control" value="${applyTermEnd}"/>
	      				</td>
	      				<td></td>
	      			</tr>
	      			<tr>
	      				<td>강의평가기간</td>
	      				<td>
	      					<fmt:formatDate value="${semeupdateform.evalTermStart }" pattern="yyyy-MM-dd" var="evalTermStart"/>
	      					<input name="evalTermStart" type="date" class="form-control" value="${evalTermStart}"/>
	      				</td>
	      				<td style="text-align: center;"> ~ </td>
	      				<td	 >
	      					<fmt:formatDate value="${semeupdateform.evalTermEnd }" pattern="yyyy-MM-dd" var="evalTermEnd"/>
	      					<input name="evalTermEnd" type="date" class="form-control" value="${evalTermEnd}"/>
	      				</td>
	      				<td></td>
	      			</tr>
	      			<tr>
	      				<td>성적열람기간</td>
	      				<td>
	      					<fmt:formatDate value="${semeupdateform.gradeTermStart }" pattern="yyyy-MM-dd" var="gradeTermStart"/>
	      					<input name="gradeTermStart" type="date" class="form-control" value="${gradeTermStart}"/>
	      				</td>
	      				<td style="text-align: center;"> ~ </td>
	      				<td	 >
	      					<fmt:formatDate value="${semeupdateform.gradeTermEnd }" pattern="yyyy-MM-dd" var="gradeTermEnd"/>
	      					<input name="gradeTermEnd" type="date" class="form-control" value="${gradeTermEnd}"/>
	      				</td>
	      				<td></td>
	      			</tr>
	      			<tr>
	      				<td>성적이의기간</td>
	      				<td>
	      					<fmt:formatDate value="${semeupdateform.appealTermStart }" pattern="yyyy-MM-dd" var="appealTermStart"/>
	      					<input name="appealTermStart" type="date" class="form-control" value="${appealTermStart}"/>
	      				</td>
	      				<td style="text-align: center;"> ~ </td>
	      				<td	 >
	      					<fmt:formatDate value="${semeupdateform.appealTermEnd }" pattern="yyyy-MM-dd" var="appealTermEnd"/>
	      					<input name="appealTermEnd" type="date" class="form-control" value="${appealTermEnd}"/>
	      				</td>
	      				<td></td>
	      			</tr>
	      			<tr>
	      				<td>성적정정기간</td>
	      				<td>
	      					<fmt:formatDate value="${semeupdateform.gradeEditTermStart }" pattern="yyyy-MM-dd" var="gradeEditTermStart"/>
	      					<input name="gradeEditTermStart" type="date" class="form-control" value="${gradeEditTermStart}"/>
	      				</td>
	      				<td style="text-align: center;"> ~ </td>
	      				<td	 >
	      					<fmt:formatDate value="${semeupdateform.gradeEditTermEnd }" pattern="yyyy-MM-dd" var="gradeEditTermEnd"/>
	      					<input name="gradeEditTermEnd" type="date" class="form-control" value="${gradeEditTermEnd}"/>
	      				</td>
	      				<td></td>
	      			</tr>
	      			<tr>
	      				<td>수강기간</td>
	      				<td>
	      					<fmt:formatDate value="${semeupdateform.courseTermStart }" pattern="yyyy-MM-dd" var="courseTermStart"/>
	      					<input name="courseTermStart" type="date" class="form-control" value="${courseTermStart}"/>
	      				</td>
	      				<td style="text-align: center;"> ~ </td>
	      				<td	 >
	      					<fmt:formatDate value="${semeupdateform.courseTermEnd }" pattern="yyyy-MM-dd" var="courseTermEnd"/>
	      					<input name="courseTermEnd" type="date" class="form-control" value="${courseTermEnd}"/>
	      				</td>
	      				<td></td>
	      			</tr>
	      			<tr>
	      				<td colspan="5">
	      					<a href="semester" class="btn btn-default btn-sm pull-left">목록</a>
	      					<a href="semester" class="btn btn-default btn-sm pull-right">취소</a>
	      					<button type="submit" class="btn btn-primary btn-sm pull-right">수정</button>
	      				</td>
	      			</tr>
	    		</table>
			</form>
    	</div>
    </div>
      
      
   </div>
<%-- <%@ include file="/WEB-INF/views/footer/footer.jsp" %>--%>
</body>
</html>
      