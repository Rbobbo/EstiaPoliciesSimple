<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Include jquery -->

<!-- -------- -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Polizze effettuate</title>
</head>
<body>
<h2>Lista Polizze</h2>
<input class="ui-button ui-widget ui-corner-all" type="button" id="reloadButton" value="Aggiorna" style="float: right;"><br><br><br>

<table id="list-policies" class="table table-condensed table-hover table-striped" width="90%" align="center"  >
    <thead class="ui-widget-header">
        <tr>
            <th data-column-id="city">Citt&#224; </th>
            <th data-column-id="pasengernumber">Numero passeggeri</th>
            <th data-column-id="datestart" >Data inizio</th>
            <th data-column-id="datefinish" >Data fine</th>
            <th data-column-id="link" data-formatter="link" data-sortable="false">Link</th>
        </tr>
	</thead>
	<tbody  class="ui-widget-content">
        <c:forEach items="${listPoliciesAttribute}" var="policyTemp" >
        	<tr>
	        	<td> <c:out value="${policyTemp.city}"></c:out> </td>
	        	<td> <c:out value="${policyTemp.pasengernumber}"></c:out> </td>
	        	<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${policyTemp.datestart}" /> </td>
	        	<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${policyTemp.datefinish}" /> </td>
	        	<td> link </td>
	        </tr>
        </c:forEach>
    </tbody>
    
    
</table>
<br>
</body>

<script>

$( "#reloadButton" ).click(function() {
	$("#listPoliciesDiv").load("listPolicies");
});


</script>


</html>