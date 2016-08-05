<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<!-- Include jquery -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<!-- -------- -->

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
	</head>	
	<!-- BODY -->
	<body>
		
		<div class="imgFront" id="imgFrontId">
		  <p> <img class="imgEstia" src="<c:url value="/resources/img/EstiaLogo.png" />" /> </p>
		</div>
		<h2>Login</h2><br>
		<form name='loginForm'
				action="<c:url value='/j_spring_security_check' />" method="POST">
	
				<table>
					<tr>
						<td>Utente:</td>
						<td><input type='text' id="usernameid" name='username' class="loginClass" value =""></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='password' class="loginClass" value="" /></td>
					</tr>
					<tr>
						<td colspan='2'><br><input class="ui-button ui-widget ui-corner-all" type="submit" value="Login"></td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		<br><br>
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
					<td><input type='text' class="regForm" maxlength="16" name='taxcode' value="" /></td>
				</tr>
				<tr>
					<td colspan='2'><br>
						<input class="ui-button ui-widget ui-corner-all" type="submit" value="Registrati">
					</td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		

		
		<!-- Dialog -->
		<div id="dialogAttentionDiv" class="confirmDialog" style="display:none" title="ATTENZIONE" >
	  		<p id="attentionDialogTextP" ></p>
		</div>
		<div id="dialogConfirmDiv" class="confirmDialog" style="display:none" title="Operazione eseguita" >
	  		<p id="confirmDialogTextP" ></p>
		</div>
	
	</body>
	
	<!-- SCRIPT -->
	<script language="Javascript">
	
		$( function()
		{
			$( ".imgFront" ).css( "opacity", 1 );
			$( ".imgFront" ).css( "float", "right" );
			$("#usernameid").focus();
		});
	  
	  
		$( ".loginClass" ).focus(function()
		{
			$( ".imgFront" ).fadeTo( "slow", 1 );
		});
		$( ".regForm" ).focus(function()
		{
			$( ".imgFront" ).fadeTo( "slow", 0.2 );
		});
	
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
		      autoOpen: false,
		      width: 450
		    });
		 	var isOpenRegisteredConfirm = "${isRegistered}";
		    if(isOpenRegisteredConfirm == "true")
			{
				$("#dialogConfirmDiv").dialog("open");
				$("#confirmDialogTextP").text("Utente ${utenteAggiunto} aggiunto correttamente");
		   	}
		    var errorToShow = "${error}";
		    if(errorToShow != "" )
		    {
				$("#dialogAttentionDiv").dialog("open");
		    	$("#attentionDialogTextP").html("Ci sono degli errori nel completamento del form di registrazione : <br> ${error}");
		    }
		    errorToShow = "${errorLogin}";
		    if(errorToShow != "" )
		    {
				$("#dialogAttentionDiv").dialog("open");
		    	$("#attentionDialogTextP").html("Utente o password errati");
		    }
		    
		  });
		
	</script>
	<c:set var="isRegistered" value="" />

</html>