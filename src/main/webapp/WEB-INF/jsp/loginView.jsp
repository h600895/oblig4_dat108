<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<h1>Logg inn</h1>


<form action="login" method="post">
	<fieldset>

		<label for="username">Brukernavn:</label><br>
		<input type="text" name="username" id="username" placeholder="12345678"/><br>
		<label for="pword">Passord:</label><br>
		<input type="password" name="pword" id="pword" placeholder="password"/><br>
		<input type="submit" value="Logg inn"/><br>

	</fieldset>
</form>
</body>
</html>

