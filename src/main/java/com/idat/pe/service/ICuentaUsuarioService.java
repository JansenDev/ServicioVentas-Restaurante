package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.CuentaUsuario;

public interface ICuentaUsuarioService {

	List<CuentaUsuario> findAll();

	CuentaUsuario findById(Integer id);

	CuentaUsuario save(CuentaUsuario model);

	CuentaUsuario update(CuentaUsuario model);

	void delete(Integer id);

	boolean exists(Integer id);
}
