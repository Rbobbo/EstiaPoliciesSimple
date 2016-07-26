<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Include jquery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<!-- -------- -->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Modifica profilo</h2><br>
<hr>
<form action='<c:url value="/home/editProfile" />' id="editProfileForm"  method="POST" >
	<div id="head">
		<label class="head" id="codeHead" ></label>
	</div>
	<br>
	<table>
		<tr>
			<td><label class="profileLabel" >Nome : </label></td>
			<td><input name="name" class="profileEditInput" value="${userLocal.name}" ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Cognome : </label></td>
			<td><input name="surname" class="profileEditInput" value="${userLocal.surname}" ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Indirizzo : </label></td>
			<td><input name="address" class="profileEditInput" value="${userLocal.address}" ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Codice Fiscale : </label></td>
			<td><input name="taxcode" class="profileEditInput" value="${userLocal.taxcode}" > </td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
	<br>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input class="ui-button ui-widget ui-corner-all" type="submit" value="Salva le Modifiche">
</form> 

<!-- Dialog -->
<div id="dialogAddPolicy" class="confirmDialog" title="Basic dialog" >
  <p id="dialogText" >Polizza aggiunta correttamente</p>
</div>
 
</body>
<script>

$( function() {
    $( ".confirmDialog" ).dialog({
      autoOpen: false
    });
 	var isOpenAddPolicyConfir = "${successAddPolicy}";
    if(isOpenAddPolicyConfir == "true")
	{
		 /* $("#head").append('<c:set var="successAddPolicy" target="session" value="false"  ></c:set>');
		isOpenAddPolicyConfir = "${successAddPolicy}"; */
		$("#dialogText").text(" Polizza aggiunta correttamente");
		$( "#dialogAddPolicy" ).dialog( "open" );
   	}
    
  });

	$("#codeHead").text("${userLocal.logincode}");
	
	$( function()
	{
		$( ".widget input[type=submit], .widget a, .widget button" ).button();
	});
</script>
</html>



