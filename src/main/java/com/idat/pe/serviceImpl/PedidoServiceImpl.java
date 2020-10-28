package com.idat.pe.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Pedido;
import com.idat.pe.repository.IPedidoRepository;
import com.idat.pe.service.IPedidoService;

@Service
@Transactional
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired
	IPedidoRepository dao;

	@Override
	public List<Pedido> findAll() {
		return (List<Pedido>) dao.findAll();
	}

	@Override
	public Pedido findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Pedido save(Pedido model) {
		return dao.save(model);
	}

	@Override
	public Pedido update(Pedido model) {
		return dao.save(model);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public boolean exists(Integer id) {
		return dao.existsById(id);
	}

}
