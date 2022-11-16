package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.entity.Empleados;
import com.spring.boot.service.EmpleadosServiceImpl;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

	@Autowired
	public EmpleadosServiceImpl servicio;

	@GetMapping
	public List<Empleados> listar() {
		return servicio.listar();
	}

	@GetMapping("/{id}")
	public Empleados buscarPorId(@PathVariable("id") Integer id) {
		return servicio.buscarPorID(id);
	}

	@PostMapping
	public Empleados guardar(@RequestBody Empleados empleados) {
		return servicio.agregar(empleados);
	}

	@PutMapping("/{id}")
	public Empleados Actualizar(@RequestBody Empleados empleados, @PathVariable("id") Integer id) {
		Empleados empleado = servicio.buscarPorID(id);
		empleado.setNombre(empleados.getNombre());
		empleado.setApellido(empleados.getApellido());
		empleado.setCiudad(empleados.getCiudad());
		empleado.setEdad(empleados.getEdad());
		return servicio.agregar(empleado);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		servicio.Eliminar(id);
	}

}
