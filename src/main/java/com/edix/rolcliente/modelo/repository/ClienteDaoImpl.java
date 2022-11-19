package com.edix.rolcliente.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.rolcliente.modelo.beans.Cliente;
@Repository
public class ClienteDaoImpl implements IntClienteDao {

	private List<Cliente> listadoClientes;
	
	public  ClienteDaoImpl() {
		listadoClientes = new ArrayList<Cliente>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		listadoClientes.add(new Cliente(1, "admin", "root", "admin@mail.com", "Alvaro", "Calle del admin", true, new Date()));
		listadoClientes.add(new Cliente(2, "Alvaro", "123", "Admin@mail.com", "Alvaro Bustos", "Calle de Alvaro", true, new Date()));
		listadoClientes.add(new Cliente(3, "Ana", "123", "ana@mail.com", "Ana Maria", "Calle de Ana", true, new Date()));
		
	}
	
	@Override
	public Cliente buscarUno(String username, String password) {
		Cliente aux = new Cliente();
		for(Cliente c : listadoClientes) {
			if(c.getUsername().equals(username)&& c.getPassword().equals(password)) {
				return c;
			}
		}
	return null;
	}
}
