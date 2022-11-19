package com.edix.rolcliente.modelo.repository;

import java.util.List;

import com.edix.rolcliente.modelo.beans.Cliente;

public interface IntClienteDao {
	Cliente buscarUno(String username, String password);
}
