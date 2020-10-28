package com.idat.pe.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Cliente;
import com.idat.pe.repository.IClienteRepository;
import com.idat.pe.service.IClienteService;

@Service
@Transactional
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	IClienteRepository dao;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) dao.findAll();
	}

	@Override
	public Cliente findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Cliente save(Cliente model) {
		return dao.save(model);
	}

	@Override
	public Cliente update(Cliente model) {
	
		return dao.save(model);
	}

	@Override
	public void delete(Integer id) {
		 dao.deleteById(id);;
	}

	@Override
	public boolean exists(Integer id) {
		return dao.existsById(id);
	}
	

}
