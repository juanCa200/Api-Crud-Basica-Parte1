package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.entity.Empleados;
import com.spring.boot.repository.EmpleadosRepository;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

	@Autowired
	public EmpleadosRepository empleadosRepository;

	@Override
	public List<Empleados> listar() {
		return empleadosRepository.findAll();
	}

	@Override
	public Empleados agregar(Empleados empleados) {
		return empleadosRepository.save(empleados);
	}

	@Override
	public Empleados buscarPorID(Integer id) {
		return empleadosRepository.findById(id).get();
	}

	@Override
	public Empleados actualizar(Empleados empleados) {
		return empleadosRepository.save(empleados);
	}

	@Override
	public void Eliminar(Integer id) {
		empleadosRepository.deleteById(id);
	}

}
