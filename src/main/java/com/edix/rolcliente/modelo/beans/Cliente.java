package com.edix.rolcliente.modelo.beans;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;


	int idUsuario;
	String username;
	String password;
	String email;
	String nombre;
	String direccion;
	Boolean enabled;
	Date fechaRegistro;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idUsuario, String username, String password, String email, String nombre, String direccion,
			Boolean enabled, Date fechaRegistro) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nombre = nombre;
		this.direccion = direccion;
		this.enabled = enabled;
		this.fechaRegistro = fechaRegistro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
