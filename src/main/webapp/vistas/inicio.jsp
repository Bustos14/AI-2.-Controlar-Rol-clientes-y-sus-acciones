<%@page import="com.edix.rolcliente.modelo.beans.Tipo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.edix.rolcliente.modelo.beans.Evento"%>
<%@page import="com.edix.rolcliente.modelo.repository.EventoDaoImpl"%>
<%@page import="com.edix.rolcliente.modelo.repository.IntEventoDao"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Un titulillo para ver que funciona</title>
</head>
<body>
	<table border = "2">
		<tr>
			<td><strong><button style="center;"><a href ="">Tipos</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Eventos</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Usuarios</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Eventos/tipo</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Login</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Registro</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Salir</a></button></strong></td>
			
		</tr>
	</table>
	<%List<Evento> lista = (List<Evento>)request.getAttribute("eventos"); %>
		<h1>${mensaje}</h1>
		<button style="center;"><a href ="/cliente/todos">Todos</a></button>
		<button style="center;"><a href ="/cliente/activos">Activos</a></button>
		<button style="center;"><a href ="/cliente/destacados">Destacados</a></button>
		<button style="center;"><a href ="/cliente/cerrarSesion">Cerrar sesión</a></button>
		<br>
		<br>
	<table>
	<th>Id</th> <th> Nombre </th> <th> Precio </th><th>Fecha de inicio</th> <th>Detalle</th>
			<% for(Evento ele: lista){ %>
	<tr style= "text-align: center;" >
	<td><%= ele.getIdEvento() %></td>
	<td><%= ele.getNombre() %></td>
	<td><%= ele.getPrecioDec()%></td>
	<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
	<td><%= df.format( ele.getFechaInicio()) %></td>
	<td><a href ="/cliente/detalle/<%=ele.getIdEvento()%>">Detalle</a></td>
	</tr>
	<%} %>
	</table>
	<h2><strong>Cliente actual:  ${miCliente.getNombre()}</strong></h2>
</body>
</html>