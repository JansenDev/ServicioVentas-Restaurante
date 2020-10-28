package com.idat.pe.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pedido;
	
	private String cod_pedido;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_pedido;
	
	@JoinColumn(name = "empleado",referencedColumnName = "id_empleado")
	@ManyToOne
	private Empleado empleado;
	
	@JoinColumn(name = "cliente",referencedColumnName = "id_cliente")
	@ManyToOne
	private Cliente cliente;
	
	@JoinColumn(name = "mesa",referencedColumnName = "id_mesa")
	@ManyToOne
	private Mesa mesa;
	
	
	@JoinTable(name = "detalle_pedido",
			joinColumns = {@JoinColumn(name = "pedido",referencedColumnName = "id_pedido")},
			inverseJoinColumns = {@JoinColumn(name = "plato", referencedColumnName = "id_plato")})
	@ManyToMany
	private List<Plato> platos;
	
	private Float monto_total;

	public Pedido() {}
	public Pedido(Integer id_pedido, String cod_pedido, Date fecha_pedido, Empleado empleado, Cliente cliente,
			Mesa mesa, List<Plato> platos, Float monto_total) {
		super();
		this.id_pedido = id_pedido;
		this.cod_pedido = cod_pedido;
		this.fecha_pedido = fecha_pedido;
		this.empleado = empleado;
		this.cliente = cliente;
		this.mesa = mesa;
		this.platos = platos;
		this.monto_total = monto_total;
	}
	public Integer getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}
	public String getCod_pedido() {
		return cod_pedido;
	}
	public void setCod_pedido(String cod_pedido) {
		this.cod_pedido = cod_pedido;
	}
	public Date getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public List<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
	public Float getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(Float monto_total) {
		this.monto_total = monto_total;
	}
	
	

}
