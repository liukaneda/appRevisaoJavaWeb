<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LOGAR NA APLICA��O</title>
	</head>
	<body>
		
		<form action="/appRevisaoJavaWeb/servletController" method="post">
			<label for="login">Login:</label>
			<input type="text" id="login" name="login" /> <br />
			<label for="senha">Senha:</label>
			<input type="text" id="senha" name="senha"> <br />
			<button type="submit">LOGAR:</button>
		</form>
		
		
	</body>
</html>