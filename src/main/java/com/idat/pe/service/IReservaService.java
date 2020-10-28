package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Reserva;

public interface IReservaService {
	List<Reserva> findAll();

	Reserva findById(Integer id);

	Reserva save(Reserva model);

	Reserva update(Reserva model);

	void delete(Integer id);

	boolean exists(Integer id);
}
