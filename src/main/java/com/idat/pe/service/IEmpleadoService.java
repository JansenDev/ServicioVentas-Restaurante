package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Empleado;

public interface IEmpleadoService {
	List<Empleado> findAll();

	Empleado findById(Integer id);

	Empleado save(Empleado model);

	Empleado update(Empleado model);

	void delete(Integer id);

	boolean exists(Integer id);
}
