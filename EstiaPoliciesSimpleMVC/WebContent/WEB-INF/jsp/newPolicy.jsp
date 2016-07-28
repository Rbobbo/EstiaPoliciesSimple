<html>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
<title>Inserisci una nuova polizza</title>
</head>
<body>
<h2>Inserisci una nuova polizza</h2><br>
<hr>
<form id="newPolicyForm" action="<c:url value='/home/addPolicy' />" method="POST" novalidate="novalidate" >
	<div id="head">
		<label class="head" id="codeHead" ></label>
	</div>
	<br>
	<table>
		<tr>
			<td><label class="profileLabel" >Città : </label></td>
			<td><input name="city" id="cityInputInputId" class="profileEditInput" ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Data inizio : </label></td>
			<td><input type="text" id="datestartInputId" name="datestart"  ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Data di fine : </label></td>
			<td><input type="text" id="datefinishInputId" name="datefinish" ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Numero passeggeri : </label></td>
			<td><input type="text" id="pasengernumberInputId" name="pasengernumber" size="5"></td>
		</tr>
	</table>
	<br>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input class="ui-button ui-widget ui-corner-all" id="buttonAddPolicy" type="submit" value="Aggiungi">
</form> 
</body>

<script>

	$( window ).load(function()
	{
		$("#datestartInputId").datepicker({ dateFormat: 'dd/MM/yyyy' })
		$("#datefinishInputId").datepicker({ dateFormat: 'dd/MM/yyyy' })
		$("#isAddPolicy").val("");

		$("#codeHead").text("${userLocal.logincode}");
		
		
		// When the browser is ready...
		$(function()
		{
			
			// Setup form validation on the #register-form element
			$("#newPolicyForm").validate({
			
				// Specify the validation rules
				rules: {
					cityInputInputId: "required",
					datestartInputId: "required"
				},
					
				errorClass: "error",
					
				submitHandler: function(form)
				{
					form.submit();
				},
				
				//azioni da intraprendere in caso di errore
				highlight: function(element, errorClass){
					alert("element"+element);
				$(element).parent("td").addClass(errorClass);
				},
				//e quando l'errore viene risolto
				unhighlight: function(element, errorClass){
				$(element).parent("td").removeClass(errorClass);
				}

			});
			
			//-------------------
			
			
			//-----------			
		});
   });
	$( document ).ready(function()
	{
		$("#newPolicyForm").on('submit', function(e)
			{
				var isvalidate=$("#newPolicyForm").valid();
				if(isvalidate)
				{
					e.preventDefault();
				}
				
			});
		
	});
	
</script>
</body>
</html>