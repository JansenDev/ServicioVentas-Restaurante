package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idat.pe.model.Empleado;
import com.idat.pe.service.IEmpleadoService;

@Controller
@RequestMapping
public class EmpleadoPageController {
	
	@Autowired
	IEmpleadoService dao;
	
	@GetMapping
	public String getIndex(Model model) {
		List<Empleado> empleados= dao.findAll();
		model.addAttribute("empleados",empleados);
		return "EmpleadoPage";
	}
	
	@GetMapping("/new")
	public String nuevoEmpleado(Model model) {
		model.addAttribute("empleado", new Empleado() );
		return "EmpleadoForm";
	}
	
	@PostMapping("/save")
	public String nuevoEmpleado(Empleado empleado) {
		dao.save(empleado);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String editarEmpleado(Model model,@PathVariable int id) {
		Empleado empleado = dao.findById(id);
		model.addAttribute("empleado", empleado);
		return "EmpleadoForm";
	}
	
	@GetMapping("eliminarEmpleado/{id}")
	public String eliminarEmpleado(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/";
	}

}
