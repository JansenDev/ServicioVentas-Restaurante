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

import com.idat.pe.model.Mesa;
import com.idat.pe.service.IMesaService;
import com.idat.pe.utils.Messages_Utils;

@RestController
@RequestMapping("/mesa")
public class MesaController {
	
	@Autowired
	IMesaService dao;
	Messages_Utils plantilla;
	String mensaje = "";
	
	@GetMapping
	public ResponseEntity<List<Mesa>> findAll(){
		return new ResponseEntity<List<Mesa>>(dao.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mesa> findById(@PathVariable("id") Integer id){
		
		if(!dao.exists(id)) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.OK, mensaje);
		}
		
		Mesa mesaEncontrada = dao.findById(id);
		
		if( mesaEncontrada.getId_mesa() == null ) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		return new ResponseEntity<Mesa>(mesaEncontrada, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Mesa> save(@RequestBody Mesa mesa)
	{
		
		if(mesa.getCod_mesa() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		Mesa nuevaMesa = dao.save(mesa);
		return new ResponseEntity<Mesa>(nuevaMesa, HttpStatus.OK) ;
	}
	
	@PutMapping
	public ResponseEntity<Mesa> update (@RequestBody Mesa mesa ){
		
		if(mesa.getId_mesa() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		if( !dao.exists( mesa.getId_mesa() )) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		Mesa mesaActualizada = dao.update(mesa);
		return new ResponseEntity<Mesa>(mesaActualizada, HttpStatus.OK  );
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(Integer id){
		
		try {
			mensaje = plantilla.getSuccessDelete();
			dao.delete(id);
			return new ResponseEntity<Object>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			mensaje = plantilla.getErrorDelete();
			return new ResponseEntity<Object>(mensaje, HttpStatus.OK);
		}	
		
	}
	
}
