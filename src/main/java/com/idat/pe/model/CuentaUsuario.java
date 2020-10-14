package com.idat.pe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class CuentaUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	
	@Column(nullable =  false, length = 5)
	private String cod_empleado;
	
	@Column(nullable =  false)
	private String nombre;
	
	@Column(nullable =  false)
	private String contrasena;

	
	
	public CuentaUsuario() {}
	public CuentaUsuario(Integer id_usuario, String cod_empleado, String nombre, String contrasena) {
		super();
		this.id_usuario = id_usuario;
		this.cod_empleado = cod_empleado;
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCod_empleado() {
		return cod_empleado;
	}

	public void setCod_empleado(String cod_empleado) {
		this.cod_empleado = cod_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	

}
