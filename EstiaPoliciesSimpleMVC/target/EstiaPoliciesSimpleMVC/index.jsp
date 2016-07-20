<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<c:url value="/login" var="loginUrl" />
<body>
<form name='loginForm'
			action="${loginUrl}" method='GET'>

Welcome page

<input name="submit" type="submit" value="submit" />

</form>


</body>
</html>