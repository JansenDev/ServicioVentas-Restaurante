package com.idat.pe.restController;

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

import com.idat.pe.model.Tipo;
import com.idat.pe.service.ITipoService;
import com.idat.pe.utils.Messages_Utils;

@RestController
@RequestMapping("/tipo")
public class TipoController {

	@Autowired
	ITipoService dao;
	Messages_Utils plantilla;
	String mensaje = "";
	
	@GetMapping
	public ResponseEntity<List<Tipo>> findAll(){
		
		return new ResponseEntity<List<Tipo>>(dao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tipo> findById(@PathVariable("id") Integer id){
		
		if(!dao.exists(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		
		Tipo tipoEncontrado = dao.findById(id) ;
		return new ResponseEntity<Tipo>(tipoEncontrado, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Tipo> save(@RequestBody Tipo tipo){
		
		if(tipo.getNombre() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		
		
		Tipo tipoCreado = dao.save(tipo);
		return new ResponseEntity<Tipo>(tipoCreado , HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<Tipo> update(@RequestBody Tipo tipo){
		
		if(!dao.exists(tipo.getId())) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		
		Tipo tipoActualizado = dao.update(tipo);
		return new ResponseEntity<Tipo>(tipoActualizado , HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete (@PathVariable("id") Integer id){
		
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
