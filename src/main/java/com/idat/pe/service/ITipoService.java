package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Tipo;

public interface ITipoService {
	List<Tipo> findAll();

	Tipo findById(Integer id);

	Tipo save(Tipo model);

	Tipo update(Tipo model);

	void delete(Integer id);

	boolean exists(Integer id);
}
