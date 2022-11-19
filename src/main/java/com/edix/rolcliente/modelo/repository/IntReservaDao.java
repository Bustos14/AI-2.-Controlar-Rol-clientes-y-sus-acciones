package com.edix.rolcliente.modelo.repository;

import java.util.List;

import com.edix.rolcliente.modelo.beans.Cliente;
import com.edix.rolcliente.modelo.beans.Evento;
import com.edix.rolcliente.modelo.beans.Reserva;

public interface IntReservaDao {
	
	int nuevaReserva(Reserva reserva);
	List <Reserva> verReservas(Cliente cliente, Evento evento);
	int comprobarIdReserva();
}
