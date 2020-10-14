package com.idat.pe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Mesa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_mesa;
	
	private String cod_mesa;
	
	@JoinColumn(name= "num_sillas", referencedColumnName = "id_sillas")
	@ManyToOne(optional = false)
	private NumeroSillas num_sillas;
	
	@JoinColumn(name= "reserva", referencedColumnName = "id_reserva")
	@ManyToOne(optional = false)
	private Reserva reseva;

	@OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
	public Mesa() {}
	public Mesa(Integer id_mesa, String cod_mesa) {
		super();
		this.id_mesa = id_mesa;
		this.cod_mesa = cod_mesa;
	}
	public Integer getId_mesa() {
		return id_mesa;
	}
	public void setId_mesa(Integer id_mesa) {
		this.id_mesa = id_mesa;
	}
	public String getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(String cod_mesa) {
		this.cod_mesa = cod_mesa;
	}

	

}
