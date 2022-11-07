<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registrering</title>
	<link rel="stylesheet" href="css/simple.css">
</head>
<body>
<h1>Påmelding</h1>
	<p>${redirectMessage}</p>
	<form action="registration" method="post">
		<fieldset>
			<table>
				<tr>
					<td>Fornavn:</td>
					<td><input type="text" name="firstName"
						   required pattern="[A-ZÆØÅ]{1}[a-zA-ZæøåÆØÅ -]{2,20}"
						   placeholder="Ditt fornavn"
						   title="Fornavn må starte med en STOR bokstav, så små">
						</td>
				<tr>
					<td>Etternavn:</td>
					<td><input type="text" name="lastName"
							   required pattern="[A-ZÆØÅ]{1}[a-zA-ZæøåÆØÅ -]{2,20}"
							   placeholder="Ditt etternavn"
							   title="Etternavn må starte med en STOR bokstav, så små">
					</td>
				</tr>
				<tr>
					<td>Mobil (8 siffer):</td>
					<td><input type="text" name="phone"
					required pattern="[0-9]{8}"
							   placeholder="Telefonnummer"
							   title="Telefonnummeret må ha åtte tall"
						></td>
				</tr>
				<tr>
					<td>Passord:</td>
					<td><input type="password" name="pword"/></td>
				</tr>
				<tr>
					<td>Passord repetert: </td>
					<td><input type="password" name="pwordRep"/></td>
				</tr>
				<tr>
					<td>Kjønn: </td>
					<td><input type="radio" id="mann" name="gender" value="M"/>
						<label for="mann">Mann</label>
						<input type="radio" id="kvinne" name="gender" value="K"/>
						<label for="kvinne">Kvinne</label></td>
				</tr>
				<tr><td colspan="2"><input type="submit" value="Meld meg på"/></td></tr>



			</table>
		
			<!--Fornavn: <input type="text" name="firstName"/><br>
			Etternanv: <input type="text" name="lastName"/><br>
			Mobil (8 siffer): <input type="text" name="phone"/><br>
			Passord: <input type="text" name="pword"/><br>
			Passord repetert: <input type="text" name="pwordRep"/><br>

			Kjønn: <input type="radio" id="mann" name="gender" value="mann"/>
			<label for="mann">Mann</label>
			<input type="radio" id="kvinne" name="gender" value="kvinne"/>
			<label for="kvinne">Kvinne</label><br>

			<input type="submit" value="Logg inn"/><br>-->
			
		</fieldset>
	</form>
</body>
</html>

