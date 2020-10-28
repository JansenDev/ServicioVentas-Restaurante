package com.idat.pe.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.NumeroSillas;
import com.idat.pe.repository.INumeroSillasRepository;
import com.idat.pe.service.INumeroSillasService;

@Service
@Transactional
public class NumeroSillasServiceImpl implements INumeroSillasService{
	
	@Autowired
	INumeroSillasRepository dao;

	@Override
	public List<NumeroSillas> findAll() {
		return (List<NumeroSillas>) dao.findAll();
	}

	@Override
	public NumeroSillas findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public NumeroSillas save(NumeroSillas model) {
		return dao.save(model);
	}

	@Override
	public NumeroSillas update(NumeroSillas model) {
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
