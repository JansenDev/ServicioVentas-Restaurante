 package com.idat.pe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo;
	
	@Column(nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "tipo",cascade = CascadeType.ALL)
	private List<Plato> platos;
	
	public Tipo() {}

	public Tipo(Integer id_tipo, String nombre) {
		super();
		this.id_tipo = id_tipo;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id_tipo;
	}

	public void setId(Integer id) {
		this.id_tipo = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
