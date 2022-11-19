package com.edix.rolcliente.modelo.repository;

import java.util.List;
import com.edix.rolcliente.modelo.beans.Evento;

public interface IntEventoDao {
	
	List<Evento> buscarActivos();
	List<Evento> buscarDestacados();
	List<Evento> buscarTodos();
	Evento buscarUno(int idEvento);
	int altaEvento(Evento evento);
	boolean eliminarEvento(Evento evento);
	int cancelarEvento (Evento evento);
}
