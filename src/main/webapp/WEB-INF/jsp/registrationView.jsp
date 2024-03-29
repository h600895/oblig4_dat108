<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registrering</title>
	<link rel="stylesheet" href="css/simple.css">
</head>
<body>
<h1>Påmelding</h1>
	<p style="color:red">${redirectMessage}</p>
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
							   placeholder="Mobilnummer"
							   title="Mobilnummeret må ha åtte tall"
						></td>
				</tr>
				<tr>
					<td>Passord:</td>
					<td><input id="pword" class="weakPassword" type="password" name="pword"
							   required pattern=^(?=.*[a-zæøå!@#$%^&*_=+-])(?=.*[A-ZÆØÅ])(?=.*[0-9]).{8,}$
						placeholder="Lag et sikkert passord"
							   title="Passordet må minst ha åtte tegn, en stor bokstav og et tegn"
					></td>
				</tr>
				<tr>
					<td>Passord repetert: </td>
					<td><input class="pwordRepInvalid" id="pwordRep" type="password" name="pwordRep"
					placeholder="Repeter passordet ditt"
							   title="Passordet må være likt"
					></td>
				</tr>
				<tr>
					<td>Kjønn: </td>
					<td><input type="radio" id="mann" name="gender" value="M" checked="checked"/>
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
	<script src="javascript/main.js"></script>
</body>
</html>

