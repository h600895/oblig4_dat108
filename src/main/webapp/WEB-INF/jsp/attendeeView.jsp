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
		<c:forEach var="item" items="${appendees}"><tr>
			<td>${item.gender}</td>
			<td>${item.firstName}</td>
			<td>${item.phone}</td>
		</tr></c:forEach>
	</table><br>

	<form action="webshop" method="post">
	  <fieldset><legend>Handle</legend>
	       <input type="checkbox" name="vare" value="bukse" />Bukse<br/>
	       <input type="checkbox" name="vare" value="genser" />Genser<br/>
	    <p><input type="submit" value="Legg i handlekurv" /></p>
	  </fieldset>
	</form>

	<form action="logout" method="post">
	  <fieldset>
	  		<p><input type="submit" value="Logg ut" /></p>
	  </fieldset>
	</form>
</body>

</html>