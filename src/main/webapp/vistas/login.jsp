<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div id="container">
  		<h1>${mensaje}</h1>
        <form action="/cliente/login" method = "post">
		<input type = "text" name="username" placeholder="Nombre">
		<input type = "password" name="password" placeholder="Contraseña">
		<input type = "submit" value="Enviar">
        </form>       
    </div>  
</body>
</html>