package com.idat.pe.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_reserva;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Temporal(TemporalType.TIME)
	private Date hora;
	
	private String estado;
	
	@OneToMany(mappedBy = "reseva", cascade = CascadeType.ALL)
	private List<Mesa> mesas;

	public Reserva() {}
	public Reserva(Integer id_reserva, Date fecha, Date hora, String estado) {
		super();
		this.id_reserva = id_reserva;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
	}
	public Integer getId_reseva() {
		return id_reserva;
	}
	public void setId_reseva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
