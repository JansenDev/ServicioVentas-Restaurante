package com.idat.pe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Plato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_plato;
	
	private String nombre;
	
	private Float precio;
	
	@JoinColumn(name = "tipo",referencedColumnName = "id_tipo")
	@ManyToOne(optional = false)
	private Tipo tipo;

	
	@ManyToMany(mappedBy = "platos", cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
	public Plato() {}
	public Plato(Integer id_plato, String nombre, Float precio, Tipo tipo) {
		super();
		this.id_plato = id_plato;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public Integer getId_plato() {
		return id_plato;
	}
	public void setId_plato(Integer id_plato) {
		this.id_plato = id_plato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	

}
