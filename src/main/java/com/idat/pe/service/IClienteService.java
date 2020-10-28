package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Cliente;

public interface IClienteService {

	List<Cliente> findAll();
	
	Cliente findById(Integer id);
	
	Cliente save(Cliente model);
	
	Cliente update(Cliente model);
	
	void delete(Integer id);
	
	boolean exists(Integer id);
	
}
