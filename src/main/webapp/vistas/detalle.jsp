<%@page import="com.edix.rolcliente.modelo.beans.Evento"%>
<%@page import="com.edix.rolcliente.modelo.beans.Reserva"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Formulario de reserva de eventos</h1>
<h2><strong>Cliente actual:  ${miCliente.getNombre()}</strong></h2>
	<% Evento ev = new Evento();
	ev = (Evento)request.getAttribute("eventoDetalle"); %>
	<ol style=" float: left">
	<li><p><strong>Nombre del evento:</strong> <%= ev.getNombre() %></p></li>
	<li><p><strong>Descripción:</strong> <%= ev.getDescripcion() %> </p></li>
	<li><p><strong>Duración:</strong> <%=ev.getDuracion()%> </p></li>
	<li><p><strong>Dirección:</strong> <%=ev.getDireccion() %></p></li>
	<li><p><strong>Aforo máximo:</strong> <%=ev.getAforoMax()%> </p></li>
	<li><p><strong>Asistentes mínimos:</strong> <%=ev.getAsistMin()%> </p></li>
	<li><p><strong>Precio:</strong> <%=ev.getPrecioDec() %></p></li>
	<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
	<li><p><strong>Fecha de inicio:</strong> <%= df.format( ev.getFechaInicio()) %></p></li>
	<li><p><strong>Tipo:</strong> <%= ev.getIdTipo().getNombre() %></p></li>
	</ol>

	<div style="float: left; margin-left: 64px;">
	<h1>Formulario de reserva</h1>
	<form action="/cliente/reserva/<%=ev.getIdEvento()%>" method = "post">
		<textarea name="observaciones" placeholder="Observaciones (Opcional)" style ="width:150px; height: 100px"></textarea>
		<br>
		<br>
		<input type = "number" name="precioUnitario" placeholder="Precio" style ="width:150px">
		<br>
		<br>
		<input type = "number" name="cantidad" placeholder="Cantidad (Máximo 10)" min = "1" max = "10" style ="width:150px">
		<br>
		<br>
		<input type = "submit" value="Reservar">
		
	</form>
	</div>
	
	
</body>
</html>