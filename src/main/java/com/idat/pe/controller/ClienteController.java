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

import com.idat.pe.model.Cliente;
import com.idat.pe.service.IClienteService;
import com.idat.pe.utils.Messages_Utils;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	IClienteService dao;
	Messages_Utils plantilla = new Messages_Utils();
	String mensaje = "";

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(dao.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id) {

		Cliente clienteEncontrado = dao.findById(id);
		mensaje = plantilla.getNotFound();

		if (clienteEncontrado.getId_cliente() == null && clienteEncontrado.getId_cliente() != 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		return new ResponseEntity<Cliente>(clienteEncontrado, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {

		String mensaje = plantilla.getParamInvalid();

		if (cliente.getNombre() == null || cliente.getDni() == null || cliente.getApellido() == null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}

		return new ResponseEntity<Cliente>(dao.save(cliente), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
		
		int id = cliente.getId_cliente();

		if (cliente.getId_cliente() == null || id < 0) {
			mensaje = plantilla.getParamInvalid(); 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}

		if (!dao.exists(id)) {
			mensaje = plantilla.getNotExists(id); 
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}

		return new ResponseEntity<Cliente>( dao.save(cliente), HttpStatus.OK );
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {

		String mensaje = plantilla.getSuccessDelete(id);

		try {
			mensaje = plantilla.getSuccessDelete();
			dao.delete(id);
			return new ResponseEntity<Object>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(plantilla.getErrorDelete(), HttpStatus.CONFLICT);
		}

	}

}
