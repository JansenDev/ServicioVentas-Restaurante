package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idat.pe.model.Reserva;
import com.idat.pe.service.IReservaService;
import com.idat.pe.utils.Messages_Utils;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	IReservaService dao;
	Messages_Utils plantilla;
	String mensaje = "";
	
	@GetMapping
	public ResponseEntity<List<Reserva>> findAll(){
		return new ResponseEntity<List<Reserva>>(dao.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Reserva> findById(@PathVariable("id") Integer id){
		
		if(!dao.exists(id)) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.OK, mensaje);
		}
		
		Reserva reservaEncontrada = dao.findById(id);
		return new ResponseEntity<Reserva>(reservaEncontrada , HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Reserva> save(@RequestBody Reserva reserva){
		
		if(reserva.getEstado() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.OK, mensaje);
		}
		
		Reserva reservaCreada = dao.save(reserva);
		return new ResponseEntity<Reserva>(reservaCreada, HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<Reserva> update(@RequestBody Reserva reserva)
	{
		
		if(!dao.exists(reserva.getId_reseva())) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		
		Reserva reservaActualizada = dao.update(reserva);
		return new ResponseEntity<Reserva>(reservaActualizada , HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete (@PathVariable("id") Integer id){
		
		try {
			dao.delete(id);
			mensaje = plantilla.getSuccessDelete();
			return new ResponseEntity<Object>(mensaje, HttpStatus.OK );
		} catch (Exception e) {
			mensaje = plantilla.getErrorDelete();
			return new ResponseEntity<Object>(mensaje, HttpStatus.CONFLICT );
		}
		
	}
	
}
