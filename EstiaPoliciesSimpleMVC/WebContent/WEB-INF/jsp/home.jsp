<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Include jquery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<!-- -------- -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Summary</title>
</head>
<body>
<c:url value="j_spring_security_logout" var="logoutUrl" />

<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Profilo</a></li>
    <li><a href="#tabs-2">Nuova Polizza</a></li>
    <li><a href="#tabs-3">Lista Polizze effettuate</a></li>
  </ul>
  <div id="tabs-1">
  	<div id="profileDiv"></div>
  </div>
  <div id="tabs-2">
    <div id="newPolicyDiv"></div>
  </div>
  <div id="tabs-3">
    <div id="listPoliciesDiv"></div>
  </div>
</div>
<br>
<form action="${logoutUrl}" method=POST id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button onclick="javascript:formSubmit()" >Logout</button>
</form>

</body>

<script language="Javascript">
	
	$("#profileDiv").load("profile");
	$("#newPolicyDiv").load("newPolicy");
	$("#listPoliciesDiv").load("listPolicies");
	
	function formSubmit() {
		$("#logoutForm").submit();
	}
	
	$( function() {
	   $( "#tabs" ).tabs();
	 } );
	
</script>
	
</html>