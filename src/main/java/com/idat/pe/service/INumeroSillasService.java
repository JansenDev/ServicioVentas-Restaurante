package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.NumeroSillas;

public interface INumeroSillasService {
	List<NumeroSillas> findAll();

	NumeroSillas findById(Integer id);

	NumeroSillas save(NumeroSillas model);

	NumeroSillas update(NumeroSillas model);

	void delete(Integer id);

	boolean exists(Integer id);
}
