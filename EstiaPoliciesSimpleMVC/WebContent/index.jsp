<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<!-- Include jquery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<!-- -------- -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<c:url value="/login" var="loginUrl" />
<body>
<form name='loginForm'
			action="${loginUrl}" method='GET'>

<h2>Benvenuto nel gestionale polizze di Estia s.r.l.</h2><br><br>
<input class="ui-button ui-widget ui-corner-all" type="submit" value="Entra">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
</form>


</body>
</html>