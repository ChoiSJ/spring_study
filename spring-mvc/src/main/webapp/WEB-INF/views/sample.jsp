<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Sample Page</title>
</head>
<body>
	<h1>Sample Page</h1>
	
	<ul>
		<li><a href="list.do?pno=3">22</a></li>
	</ul>
	
	<form:form method="get" action="add.do" modelAttribute="scoreForm">
		<form:errors path="*"></form:errors><br>
		번호:<form:input type="number" path="no"/><br>
		이름:<form:input type="text" path="name"/><br> 
		국어:<form:input type="number" path="kor"/><br>
		영여:<form:input type="number" path="eng"/><br>
		수학:<form:input type="number" path="math"/><br>
		물리:<form:input type="number" path="phy"/><br>
		화학:<form:input type="number" path="che"/><br>
		생물:<form:input type="number" path="bio"/><br>
		음악:<form:input type="number" path="mus"/><br>
		<button type="submit">등록</button>
	</form:form>
</body>
</html>