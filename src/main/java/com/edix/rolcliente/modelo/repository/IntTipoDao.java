package com.edix.rolcliente.modelo.repository;

import java.util.List;

import com.edix.rolcliente.modelo.beans.Tipo;

public interface IntTipoDao {

	Tipo buscarTipoId(int idTipo);
	List<Tipo> buscarTodos();
}
