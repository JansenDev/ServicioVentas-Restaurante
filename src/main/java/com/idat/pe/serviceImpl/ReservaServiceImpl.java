package com.idat.pe.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Reserva;
import com.idat.pe.repository.IReservaRepository;
import com.idat.pe.service.IReservaService;

@Service
@Transactional
public class ReservaServiceImpl implements IReservaService{
	
	@Autowired
	IReservaRepository dao;

	@Override
	public List<Reserva> findAll() {
		return (List<Reserva>) dao.findAll();
	}

	@Override
	public Reserva findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Reserva save(Reserva model) {
		return dao.save(model);
	}

	@Override
	public Reserva update(Reserva model) {
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
