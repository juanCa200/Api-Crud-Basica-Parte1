package com.spring.boot.service;

import java.util.List;

import com.spring.boot.entity.Empleados;

public interface EmpleadosService {

	public List<Empleados>listar();
	public Empleados agregar(Empleados empleados);
	public Empleados buscarPorID(Integer id);
	public Empleados actualizar(Empleados empleados);
	public void Eliminar(Integer id);
	
}
