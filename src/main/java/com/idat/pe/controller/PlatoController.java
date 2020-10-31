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

import com.idat.pe.model.Plato;
import com.idat.pe.service.IPlatoService;
import com.idat.pe.utils.Messages_Utils;

@RestController
@RequestMapping("/plato")
public class PlatoController {

	@Autowired
	IPlatoService dao;
	Messages_Utils plantilla;
	String mensaje = "";
	
	@GetMapping
	public ResponseEntity<List<Plato>> findAll(){
		return new ResponseEntity<List<Plato>>(	dao.findAll(),HttpStatus.OK	);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Plato> findById(@PathVariable("id")Integer id){
		
		if(!dao.exists(id)) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		Plato platoEncontrado = dao.findById(id);
		return new ResponseEntity<Plato>(platoEncontrado, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Plato> save(@RequestBody Plato plato){
		
		if(plato.getNombre() == null || plato.getPrecio() == null || plato.getTipo() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		Plato platoCreado = dao.save(plato);
		return new ResponseEntity<Plato>(platoCreado , HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<Plato> update(@RequestBody Plato plato){
		
		if(!dao.exists(plato.getId_plato())) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}

		Plato platoActualizado = dao.update(plato);
		return new ResponseEntity<Plato>(platoActualizado , HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(Integer id){
		
		try {
			dao.delete(id);
			mensaje = plantilla.getSuccessDelete();
			return new ResponseEntity<Object>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			mensaje = plantilla.getErrorDelete();
			return new ResponseEntity<Object>(mensaje, HttpStatus.CONFLICT);
		}
	}
	
	
}
