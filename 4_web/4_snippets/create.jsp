<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<h2>Ajout client</h2>

<spring:url value="/customer/save" var="saveActionUrl" />

<form:form method="post" modelAttribute="customer" action="${saveActionUrl}">
	<!-- bind to user.name-->

<table>
	<tbody>
		<tr>
			<td>Nom :</td>
			<td><form:input path="lastName" type="text" /></td>
		</tr>
		<tr>
			<td>Prenom :</td>
			<td><form:input path="firstName" type="text" /></td>
		</tr>
		<tr>
			<td></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
	</tbody>
</table>

</form:form>

</body>