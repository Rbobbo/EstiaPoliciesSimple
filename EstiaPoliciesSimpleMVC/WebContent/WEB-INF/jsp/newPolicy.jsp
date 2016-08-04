<html>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head>
<title>Inserisci una nuova polizza</title>
</head>
<body>
<h2>Inserisci una nuova polizza</h2><br>

<form id="newPolicyForm" action="<c:url value='/home/addPolicy' />" method="POST" >
	<div id="headNewPolicy">
		<label class="head" id="codeHeadNewPolicyId" ></label>
	</div> <br>
	<table>
		<tr>
			<td><label class="profileLabel" >Città : </label></td>
			<td><input name="city" id="cityInputInputId" class="profileEditInput" placeholder="Roma, Venezia, Boogna..." ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Data inizio : </label></td>
			<td><input type="text" id="datestartInputId" name="datestart" placeholder="gg/MM/aaaa"  ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Data di fine : </label></td>
			<td><input type="text" id="datefinishInputId" name="datefinish" placeholder="gg/MM/aaaa" ></td>
		</tr>
		<tr>
			<td><label class="profileLabel" >Numero passeggeri : </label></td>
			<td><input type="text" id="pasengernumberInputId" name="pasengernumber" maxlength="5" size="5"></td>
		</tr>
	</table>
	<br>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input class="ui-button ui-widget ui-corner-all" id="buttonAddPolicy" type="submit" value="Aggiungi">
</form> 
</body>

<script>

	$( document ).ready(function()
	{	
		/* Validation */
	    $('#newPolicyForm').validate(
		{ // initialize the plugin
			 rules: {
	        	city: {
	                required: true
	            },
				datestart: {
	                required: true,
	                dateCustomIta: true
	            },
				datefinish: {
	                required: true,
	                dateCustomIta: true
	            },
				pasengernumber: {
	                required: true
	            }
	        },
			
			messages: 
			{
				city: 
				{
					required: " Campo obbligatorio"
				},
				datestart: 
				{
					required: " Campo obbligatorio",
					date: "Formato data non valido"
				},
				datefinish: 
				{
					required: " Campo obbligatorio",
					date: "Formato data non valido"
				},
				pasengernumber: 
				{
					required: " Campo obbligatorio"
				}
				
			},
			
			submitHandler: function(form) {
				form.submit();
			}
	       
	    });
		// Custom date for validation
		$.validator.addMethod(
			"dateCustomIta",
			function ( value, element ) {
				var bits = value.match( /([0-9]+)/gi ), str;
				if ( ! bits )
					return this.optional(element) || false;
				str = bits[ 1 ] + '/' + bits[ 0 ] + '/' + bits[ 2 ];
				return this.optional(element) || !/Invalid|NaN/.test(new Date( str ));
			}
		);
		
		/* Set datepicker */
		$("#datestartInputId").datepicker({ dateFormat: 'dd/mm/yy' });
		$("#datefinishInputId").datepicker({ dateFormat: 'dd/mm/yy' });
		$("#isAddPolicy").val("");
		/* Head info */
		$("#codeHeadNewPolicyId").text("${userLocal.logincode}");
		/* Handling validation on submit */
		$("#newPolicyForm").on('submit', function(e)
		{
			var isvalidate=$("#newPolicyForm").valid();
			if(!isvalidate)
			{
				e.preventDefault();
			}
		});
	
    });
		
</script>
</body>
</html>