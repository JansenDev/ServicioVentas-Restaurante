package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idat.pe.model.CuentaUsuario;
import com.idat.pe.service.ICuentaUsuarioService;
import com.idat.pe.utils.Messages_Utils;

@RestController
@RequestMapping("/CuentaUsuario")
public class CuentaUsuarioController {

	@Autowired
	ICuentaUsuarioService dao;
	Messages_Utils plantilla = new Messages_Utils();
	String msg = "";

	@GetMapping
	public ResponseEntity<List<CuentaUsuario>> findAll() {
		return new ResponseEntity<List<CuentaUsuario>>(dao.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CuentaUsuario> findById(@PathVariable("id") int id) {

		CuentaUsuario CuentaEncontrada = dao.findById(id);
		msg = plantilla.getNotFound();

		if (CuentaEncontrada.getId_usuario() == null || CuentaEncontrada.getId_usuario() < 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
		}

		return new ResponseEntity<CuentaUsuario>(dao.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<CuentaUsuario> save(CuentaUsuario cuentaUsuario){
		
		CuentaUsuario usuarioCreado = dao.save(cuentaUsuario);
		
//		if() {
//			
//		}
		
		return new ResponseEntity<CuentaUsuario>(usuarioCreado,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
