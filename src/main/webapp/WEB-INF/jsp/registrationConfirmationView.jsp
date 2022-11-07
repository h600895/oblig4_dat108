<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Påmeldingsbekreftelse</title>
	<link rel="stylesheet" href="css/simple.css">
</head>

<body>
	<p>Påmeldingen er mottatt for
		<c:out value="${person.firstName} ${person.lastName}"/><br/>
		<c:out value="${person.phone}"/><br/>
		<c:out value="${person.gender}"/><br/><p/>
	
	<form action="attendeeList" method="post">
	  <fieldset>
	  		<p><input type="submit" value="Gå til deltagerlisten"/></p>
	  </fieldset>
	</form>
</body>

</html>