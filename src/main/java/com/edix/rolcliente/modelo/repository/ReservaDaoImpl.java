package com.edix.rolcliente.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.rolcliente.modelo.beans.Cliente;
import com.edix.rolcliente.modelo.beans.Evento;
import com.edix.rolcliente.modelo.beans.Reserva;

@Repository
public class ReservaDaoImpl implements IntReservaDao {

	private List<Reserva> listadoReservas;

	public ReservaDaoImpl() {
		listadoReservas = new ArrayList<>();

	}

	@Override
	public int nuevaReserva(Reserva reserva) {
		if (!listadoReservas.contains(reserva)) {
			listadoReservas.add(reserva);
			return 1;
		}
		return 0;
	}

	@Override
	public List<Reserva> verReservas(Cliente cliente, Evento evento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int comprobarIdReserva() {
		int autoId = 0;
		if(listadoReservas.size()==0) {
			autoId =  1;
		}else {
			autoId =  listadoReservas.get(listadoReservas.size()-1).getIdReserva() + 1;
		}
		return autoId;
	}

}
