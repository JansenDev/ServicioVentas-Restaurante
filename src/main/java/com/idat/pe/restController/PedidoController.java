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

import com.idat.pe.model.Pedido;
import com.idat.pe.service.IPedidoService;
import com.idat.pe.utils.Messages_Utils;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	IPedidoService dao;
	Messages_Utils plantilla;
	String mensaje = "";
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		return new ResponseEntity<List<Pedido>>( dao.findAll(), HttpStatus.OK );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(Integer id){
		
		if(!dao.exists(id)) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		Pedido pedidoEncontrado = dao.findById(id);
		
		return new ResponseEntity<Pedido>(pedidoEncontrado,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
		
		if(pedido.getCod_pedido() == null || pedido.getEmpleado() == null ||
				pedido.getMonto_total() == null) {
			
			mensaje = plantilla.getParamInvalid();
			throw new ResponseStatusException(HttpStatus.CONFLICT, mensaje);
		}
		
		Pedido pedidoCreado = dao.save(pedido);
		return new ResponseEntity<Pedido>(pedidoCreado , HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<Pedido> update (@RequestBody Pedido pedido){
		
		if(!dao.exists(pedido.getId_pedido())) {
			mensaje = plantilla.getNotExists();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
		}
		
		Pedido pedidoActualizado = dao.update(pedido);
		return new ResponseEntity<Pedido>(pedidoActualizado , HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		
		try {
			dao.delete(id);
			mensaje = plantilla.getSuccessDelete();
			return new ResponseEntity<Object>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			mensaje = plantilla.getErrorDelete();
			return new ResponseEntity<Object>(mensaje,HttpStatus.CONFLICT);
		}
		
	}
	
	
}
