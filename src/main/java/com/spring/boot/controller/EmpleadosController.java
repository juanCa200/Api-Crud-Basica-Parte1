package com.spring.boot.controller;

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

import com.spring.boot.entity.Empleados;
import com.spring.boot.service.EmpleadosServiceImpl;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

	@Autowired
	public EmpleadosServiceImpl servicio;

	@GetMapping
	public ResponseEntity<List<Empleados>> listar() {
		return new ResponseEntity<>(servicio.listar(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empleados> buscarPorId(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(servicio.buscarPorID(id), HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Empleados> guardar(@RequestBody Empleados empleados) {
		return new ResponseEntity<>(servicio.agregar(empleados),HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Empleados> actualizar(@RequestBody Empleados empleados, @PathVariable("id") Integer id) {
		Empleados empleado = servicio.buscarPorID(id);
		empleado.setNombre(empleados.getNombre());
		empleado.setApellido(empleados.getApellido());
		empleado.setCiudad(empleados.getCiudad());
		empleado.setEdad(empleados.getEdad());
		return new ResponseEntity<>(servicio.agregar(empleado),HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		servicio.Eliminar(id);
		return new ResponseEntity<>("empleado eliminado",HttpStatus.OK);
	}

}
