package com.idat.pe.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.CuentaUsuario;
import com.idat.pe.repository.ICuentaUsuarioRepository;
import com.idat.pe.service.ICuentaUsuarioService;

@Service
@Transactional
public class CuentaUsuarioServiceImpl implements ICuentaUsuarioService {
	
	@Autowired
	ICuentaUsuarioRepository dao;
	

	@Override
	public List<CuentaUsuario> findAll() {
		return (List<CuentaUsuario>) dao.findAll();
	}

	@Override
	public CuentaUsuario findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public CuentaUsuario save(CuentaUsuario model) {
		return dao.save(model);
	}

	@Override
	public CuentaUsuario update(CuentaUsuario model) {
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
