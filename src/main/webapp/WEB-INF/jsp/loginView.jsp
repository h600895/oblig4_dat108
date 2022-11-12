<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Logg inn</title>
	<link rel="stylesheet" href="css/simple.css">

</head>
<body>

<h1>Logg inn</h1>

<p style="color:red">${redirectMessage}</p>


<form action="login" method="post">
	<fieldset>

		<label for="phone">Telefon-nummer:</label><br>
		<input type="text" name="phone" id="phone" required pattern="[0-9]{8}" placeholder="Brukenavn"/><br>
		<label for="pword">Passord:</label><br>
		<input type="password" name="pword" id="pword" class="weakPassword" required pattern="^(?=.*[a-zæøå!@#$%^&*_=+-])(?=.*[A-ZÆØÅ])(?=.*[0-9]).{8,}$" placeholder="Passord"/><br>
		<input type="submit" value="Logg inn"/><br>

	</fieldset>
</form>
<script src="javascript/login.js"></script>
</body>
</html>

