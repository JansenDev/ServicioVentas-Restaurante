package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Mesa;

public interface IMesaService {
	List<Mesa> findAll();

	Mesa findById(Integer id);

	Mesa save(Mesa model);

	Mesa update(Mesa model);

	void delete(Integer id);

	boolean exists(Integer id);
}
