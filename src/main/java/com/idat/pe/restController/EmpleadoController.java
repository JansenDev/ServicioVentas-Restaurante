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

import com.idat.pe.model.Empleado;
import com.idat.pe.service.IEmpleadoService;
import com.idat.pe.utils.Messages_Utils;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	IEmpleadoService dao;
	Messages_Utils plantilla;
	String mensaje= "";
	
	@GetMapping
	public ResponseEntity<List<Empleado>> findAll(){
		return new ResponseEntity<List<Empleado>>(dao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> findById(@PathVariable("id") Integer id){
		
		if(!dao.exists(id)) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.CONFLICT,	mensaje);
		}
		
		Empleado empleadoEncontrado = dao.findById(id);
		
		if(empleadoEncontrado.getId_empleado() == null && empleadoEncontrado.getId_empleado() < 0) {
			
			mensaje = plantilla.getNotFound();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		return new ResponseEntity<Empleado>(empleadoEncontrado, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Empleado> save(@RequestBody Empleado empleado){
		
		if(empleado.getNombre() == null || empleado.getApellido() == null|| empleado.getTelefono() == null) {
			
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje );
		}
		
		Empleado empleadoCreado = dao.save(empleado);
		return new ResponseEntity<Empleado>(empleadoCreado ,HttpStatus.OK) ;
	}
	
	
	
	@PutMapping
	public ResponseEntity<Empleado> update(@RequestBody Empleado empleado){
		if(empleado.getNombre() == null || empleado.getApellido() == null||
			empleado.getTelefono() == null || empleado.getId_empleado() == null) {
			
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje );
		}
		
		if(!dao.exists(empleado.getId_empleado())){
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
			
		}
		
			Empleado empleadoaActualizado = dao.update(empleado);
		return new ResponseEntity<Empleado>(empleadoaActualizado ,HttpStatus.OK) ;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		
		mensaje = plantilla.getSuccessDelete();
		
		try {
			dao.delete(id);
			return new ResponseEntity<Object>(mensaje , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(plantilla.getErrorDelete(), HttpStatus.CONFLICT);
		}
		
	}
	
	
	
	
	
	
	
}
