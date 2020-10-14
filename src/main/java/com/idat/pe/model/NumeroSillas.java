package com.idat.pe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sillas")
public class NumeroSillas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_sillas;
	
	private Integer cantidad;
	
	@OneToMany(mappedBy = "num_sillas", cascade = CascadeType.ALL)
	private List<Mesa> mesas;
	

	public NumeroSillas() {}
	public NumeroSillas(Integer id_sillas, Integer cantidad) {
		super();
		this.id_sillas = id_sillas;
		this.cantidad = cantidad;
	}
	public Integer getId_sillas() {
		return id_sillas;
	}
	public void setId_sillas(Integer id_sillas) {
		this.id_sillas = id_sillas;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
