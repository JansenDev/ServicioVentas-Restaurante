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

import com.idat.pe.model.NumeroSillas;
import com.idat.pe.service.INumeroSillasService;
import com.idat.pe.utils.Messages_Utils;

@RestController
@RequestMapping("/sillas")
public class NumeroSillasController {

	@Autowired
	INumeroSillasService dao;
	Messages_Utils plantilla;
	String mensaje = "";
	
	@GetMapping
	public ResponseEntity<List<NumeroSillas>> findAll(){
		return new ResponseEntity<List<NumeroSillas>>(dao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NumeroSillas> findById(Integer id){
		
		if(!dao.exists(id)) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.OK, mensaje);
		}
		
		NumeroSillas numeroDeSillasEncontrada = dao.findById(id);
		
		if(numeroDeSillasEncontrada.getCantidad() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		return new ResponseEntity<NumeroSillas>(numeroDeSillasEncontrada, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<NumeroSillas> save(@RequestBody NumeroSillas sillas){
		
		if(sillas.getCantidad() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		
		NumeroSillas sillaCreada = dao.save(sillas);
		return new ResponseEntity<NumeroSillas>(sillaCreada , HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<NumeroSillas> update (@RequestBody NumeroSillas sillas){
		
		if(sillas.getId_sillas() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		
		if( !dao.exists(sillas.getId_sillas())	) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		NumeroSillas sillaActualizada = dao.update(sillas);
		return new ResponseEntity<NumeroSillas>(sillaActualizada, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		
		try {
			mensaje = plantilla.getSuccessDelete();
			dao.delete(id);
			return new ResponseEntity<Object>(mensaje,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(plantilla.getErrorDelete(),HttpStatus.OK);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
