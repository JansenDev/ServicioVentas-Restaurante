package com.idat.pe.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Tipo;
import com.idat.pe.repository.ITipoRepository;
import com.idat.pe.service.ITipoService;

@Service
@Transactional
public class TipoServiceImpl implements ITipoService{

	@Autowired
	ITipoRepository dao;
	
	@Override
	public List<Tipo> findAll() {
		return (List<Tipo>) dao.findAll();
	}

	@Override
	public Tipo findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Tipo save(Tipo model) {
		return dao.save(model);
	}

	@Override
	public Tipo update(Tipo model) {
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
