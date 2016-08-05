<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Polizze effettuate</title>
	</head>
	
	<body>
	
		<h2>Lista Polizze</h2>
		<div id="head">
			<input class="ui-button ui-widget ui-corner-all" type="button" id="reloadButton" value="Aggiorna" style="float: right;"><br>
			<label class="head" id="codeHeadListId" ></label>
		</div><br>
		<table id="list-policies" class="table table-condensed table-hover table-striped" width="90%" align="center"  >
		    <thead class="ui-widget-header">
		        <tr>
		            <th data-column-id="city">Citt&#224; </th>
		            <th data-column-id="pasengernumber" align="center" >N&#176; Passeggeri</th>
		            <th data-column-id="datestart" align="center" >Data inizio</th>
		            <th data-column-id="datefinish" align="center" >Data fine</th>
		            <th data-column-id=link data-formatter="link" align="center" data-sortable="false">Pdf</th>
		        </tr>
			</thead>
			<tbody  class="ui-widget-content">
		        <c:forEach items="${listPoliciesAttribute}" var="policyTemp" >
		        	<tr>
			        	<td align="left" class="listPolicyTd" > <c:out value="${policyTemp.city}"></c:out> </td>
			        	<td align="center" class="listPolicyTd"> <c:out value="${policyTemp.pasengernumber}"></c:out> </td>
			        	<td align="left" class="listPolicyTd"> <fmt:formatDate pattern="dd/MM/yyyy" value="${policyTemp.datestart}" /> </td>
			        	<td align="left" class="listPolicyTd"> <fmt:formatDate pattern="dd/MM/yyyy" value="${policyTemp.datefinish}" /> </td>
			        	<td align="center" class="listPolicyTd"> <a  href="<c:url value='/home/generatePdf?policyId=${policyTemp.id}' />" > 
			        			<img class="imgDownloadPdf" alt="Download pdf" src="<c:url value="/resources/img/pdf.png" />" />
			        		</a> </td>
			        </tr>
		        </c:forEach>
		    </tbody>
		</table> <br>
		
	</body>
	
	<!-- Script -->
	<script>
		$("#codeHeadListId").text("${userLocal.logincode}");
	
		$( "#reloadButton" ).click(function() {
			$("#listPoliciesDiv").load("listPolicies");
		});
	
	</script>


</html>