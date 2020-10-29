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
@RequestMapping("/usuario")
public class CuentaUsuarioController {

	@Autowired
	ICuentaUsuarioService dao;
	Messages_Utils plantilla = new Messages_Utils();
	String mensaje = "";

	@GetMapping
	public ResponseEntity<List<CuentaUsuario>> findAll() {
		return new ResponseEntity<List<CuentaUsuario>>(dao.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CuentaUsuario> findById(@PathVariable("id") Integer id) {

		CuentaUsuario CuentaEncontrada = dao.findById(id);
		mensaje = plantilla.getNotFound();

		if (CuentaEncontrada.getId_usuario() == null || CuentaEncontrada.getId_usuario() < 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, mensaje);
		}

		return new ResponseEntity<CuentaUsuario>(dao.findById(id), HttpStatus.OK);
	}

	public ResponseEntity<CuentaUsuario> save(CuentaUsuario cuentaUsuario) {

		boolean existeCuenta = dao.exists(	cuentaUsuario.getId_usuario());

		if (cuentaUsuario.getNombre() == null || cuentaUsuario.getContrasena() == null
				|| cuentaUsuario.getCod_empleado() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		if( existeCuenta	) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		CuentaUsuario usuarioCreado = dao.save(cuentaUsuario);
		return new ResponseEntity<CuentaUsuario>(usuarioCreado, HttpStatus.OK);

	}
	
	public ResponseEntity<CuentaUsuario> update(CuentaUsuario cuentaUsuario) {

		boolean existeCuenta = dao.exists(	cuentaUsuario.getId_usuario());

		if (cuentaUsuario.getNombre() == null || cuentaUsuario.getContrasena() == null
				|| cuentaUsuario.getCod_empleado() == null) {
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		if(  !existeCuenta	) {
			mensaje = plantilla.getNotExists( cuentaUsuario.getId_usuario() );
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		
		CuentaUsuario usuarioActualizado = dao.save(cuentaUsuario);
		return new ResponseEntity<CuentaUsuario>(usuarioActualizado, HttpStatus.OK);

	}
	
	
	public ResponseEntity<Object> delete(Integer id){
		
		try {
			dao.delete(id);
			mensaje = plantilla.getSuccessDelete(id);
			return new ResponseEntity<Object>(mensaje , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(plantilla.getErrorDelete(), HttpStatus.CONFLICT);
			
		}
		
		
		
		
	}
	

}
