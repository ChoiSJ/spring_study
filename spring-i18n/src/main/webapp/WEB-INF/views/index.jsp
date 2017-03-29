<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title><spring:message code="welcome.title"/></title>
</head>
<body>
	<spring:message code="input.helper" var="aa"/>
	
	<h1><spring:message code="welcome.message"/></h1>
	<p>${message }</p>

	<p>
		<a href="about.do"><spring:message code="link.about"/></a>
	</p>
	
	<form>
		<input type="text" name="kerword" placeholder="${aa }"><button>검색</button>
	</form>

	<p>
		Language: <a href="home.do?lang=ko">한국어</a> | <a href="home.do?lang=en">English</a> | <a href="home.do?lang=ja">日本語</a>
	</p>
</body>
</html>