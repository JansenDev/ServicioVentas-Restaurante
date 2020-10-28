package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Plato;

public interface IPlatoService {
	List<Plato> findAll();

	Plato findById(Integer id);

	Plato save(Plato model);

	Plato update(Plato model);

	void delete(Integer id);

	boolean exists(Integer id);
}
