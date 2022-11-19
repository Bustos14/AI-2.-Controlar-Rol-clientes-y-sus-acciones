package com.edix.rolcliente.modelo.beans;

import java.io.Serializable;

public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int idReserva;
	Evento evento;
	Cliente cliente;
	double precioVenta;
	String observaciones;
	int cantidad;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Reserva(int idReserva, Evento evento, Cliente cliente, double precioVenta, String observaciones,
			int cantidad) {
		super();
		this.idReserva = idReserva;
		this.evento = evento;
		this.cliente = cliente;
		this.precioVenta = precioVenta;
		this.observaciones = observaciones;
		this.cantidad = cantidad;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
