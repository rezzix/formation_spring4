<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<c:if test="${not empty msg}"><h3>${msg}</h3></c:if>

<h2>Clients</h2>
<c:if test="${not empty customers}">
	<table>
		<thead><tr><th>Nom</th><th>Prénom</th></tr></thead>
		<tbody>
		<c:forEach var="customer" items="${customers}">
			<tr>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>

<hr/>
<a href="<c:url value="/customer/create" />" >Creation</a>

</body>
