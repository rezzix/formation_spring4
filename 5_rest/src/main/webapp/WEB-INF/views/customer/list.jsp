<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

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

</body>