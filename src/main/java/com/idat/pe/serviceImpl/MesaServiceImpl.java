package com.idat.pe.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Mesa;
import com.idat.pe.repository.IMesaRepository;
import com.idat.pe.service.IMesaService;

@Service
@Transactional
public class MesaServiceImpl implements IMesaService{
	
	@Autowired
	IMesaRepository dao;

	@Override
	public List<Mesa> findAll() {
		return (List<Mesa>) dao.findAll();
	}

	@Override
	public Mesa findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Mesa save(Mesa model) {
		return dao.save(model);
	}

	@Override
	public Mesa update(Mesa model) {
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
