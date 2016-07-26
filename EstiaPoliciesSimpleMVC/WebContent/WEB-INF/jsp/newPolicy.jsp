<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci una nuova polizza</title>
</head>
<body>
<h2>Inserisci una nuova polizza</h2><br>
<hr>
<form action="<c:url value='/home/addPolicy' />"  method="POST" >
	<div id="head">
		<label class="head" id="codeHead" ></label>
	</div>
	<br>
	<table>
		<tr>
			<td><label class="profileLabel" >Città : </label></td>
			<td><input name="city" class="profileEditInput" ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Data inizio : </label></td>
			<td><input type="text" id="datestart" name="datestart"  ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Data di fine : </label></td>
			<td><input type="text" id="datefinish" name="datefinish" ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Numero passeggeri : </label></td>
			<td><input type="text" id="pasengernumber" name="pasengernumber" size="5"></td>
		</tr>
	</table>
	<br>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input class="ui-button ui-widget ui-corner-all" id="buttonAddPolicy" type="submit" value="Aggiungi">
</form> 
</body>
<script>
$(document).ready(function() {
    $( "#datestart" ).datepicker({ dateFormat: 'dd/MM/yyyy' })
    $( "#datefinish" ).datepicker({ dateFormat: 'dd/MM/yyyy' })
 	$("#isAddPolicy").val("");

});
  
	$("#codeHead").text("${userLocal.logincode}");
	
</script>
</body>
</html>