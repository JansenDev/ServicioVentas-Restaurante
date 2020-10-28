package com.idat.pe.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Empleado;
import com.idat.pe.repository.IEmpleadoRepository;
import com.idat.pe.service.IEmpleadoService;

@Service
@Transactional
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	IEmpleadoRepository dao;
	
	
	@Override
	public List<Empleado> findAll() {
		return (List<Empleado>) dao.findAll();
	}

	@Override
	public Empleado findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Empleado save(Empleado model) {
		return dao.save(model);
	}

	@Override
	public Empleado update(Empleado model) {
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
