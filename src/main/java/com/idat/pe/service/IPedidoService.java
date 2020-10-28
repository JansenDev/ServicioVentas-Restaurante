package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Pedido;

public interface IPedidoService {
	List<Pedido> findAll();

	Pedido findById(Integer id);

	Pedido save(Pedido model);

	Pedido update(Pedido model);

	void delete(Integer id);

	boolean exists(Integer id);
}
