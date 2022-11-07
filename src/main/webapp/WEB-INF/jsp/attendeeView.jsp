<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>DeltagerListe</title>
</head>

<body>
	<p>Du er innlogget som <c:out value="${person.phone} / ${person.firstName} ${person.lastName}"/><br>
	<table><tr>
			<th>Kjønn</th>
			<th>Navn</th>
			<th>Mobil</th>
		</tr>
		<c:forEach var="item" items="${attendees}">
			<c:choose>
				<c:when test="${item.phone==person.phone}">
				<tr style="background-color: green">
					<td>${item.gender}</td>
					<td>${item.firstName} ${item.lastName}</td>
					<td>${item.phone}</td>
				</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${item.gender}</td>
						<td>${item.firstName} ${item.lastName}</td>
						<td>${item.phone}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table><br>

	<form action="logout" method="post">
	  		<p><input type="submit" value="Logg ut" /></p>
	</form>
</body>

</html>