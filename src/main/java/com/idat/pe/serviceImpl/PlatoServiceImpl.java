package com.idat.pe.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Plato;
import com.idat.pe.repository.IPlatoRepository;
import com.idat.pe.service.IPlatoService;

@Service
@Transactional
public class PlatoServiceImpl implements IPlatoService{
	
	@Autowired
	IPlatoRepository dao;

	@Override
	public List<Plato> findAll() {
		return (List<Plato>) dao.findAll();
	}

	@Override
	public Plato findById(Integer id) {
		return dao.findById(id).get() ;
	}

	@Override
	public Plato save(Plato model) {
		return dao.save(model);
	}

	@Override
	public Plato update(Plato model) {
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
