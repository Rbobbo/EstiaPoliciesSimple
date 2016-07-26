<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Include jquery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<!-- -------- -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>	
<body>
<h2>Login page</h2><br>

	<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method="POST">

			<table>
				<tr>
					<td>Utente:</td>
					<td><input type='text' name='username' value ="prova1atgmail.co"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' value="prova1" /></td>
				</tr>
				<tr>
					<td colspan='2'><br><input class="ui-button ui-widget ui-corner-all" type="submit" value="Login"></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<hr>
		<form name="register" id="reg" action="<c:url value='/login/register' />" method="POST">
			<h2>Oppure, <b>Registrati!</b></h2>
			<table>
				<tr>
					<td>Utente:</td>
					<td><input type='text' class="regForm" name='logincode' value =""></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' class="regForm" name='loginpassword' value="" /></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><input type='text' class="regForm" name='name' value="" /></td>
				</tr>
				<tr>
					<td>Cognome:</td>
					<td><input type='text' class="regForm" name='surname' value="" /></td>
				</tr>
				<tr>
					<td>Indirizzo:</td>
					<td><input type='text' class="regForm" name='address' value="" /></td>
				</tr>
				<tr>
					<td>Codice Fiscale:</td>
					<td><input type='text' class="regForm" name='taxcode' value="" /></td>
				</tr>
				<tr>
					<td colspan='2'><br>
						<input class="ui-button ui-widget ui-corner-all" type="submit" value="Registrati">
					</td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	<!-- Dialog -->
	<div id="dialogAddProfile" class="confirmDialog" style="display:none" title="Basic dialog" >
  		<p id="dialogText" >Utente correttamente registrato</p>
	</div>
</body>
<script language="Javascript">
	var isRegJavascript = "${isRegistered}";
	if(isRegJavascript != null && isRegJavascript != "")
	{
		clearFormRegister(isRegJavascript);
	}
	
	function clearFormRegister(isOkClear)
	{
		if(isOkClear == "true")
		{
			jQuery.each( $(".regForm"), function( i, input )
			{
				input.value = "";
			});
		}
	}
	
	/* handling dialog */
	$( function() {
	    $( ".confirmDialog" ).dialog({
	      autoOpen: false
	    });
	 	var isOpenRegisteredConfirm = "${isRegistered}";
	    if(isOpenRegisteredConfirm == "true")
		{
			$("#dialogText").text(" Utente ${utenteAggiunto} aggiunto correttamente");
			$( "#dialogAddProfile" ).dialog( "open" );
	   	}
	    
	  });
</script>
<c:set var="isRegistered" value="" />
</html>