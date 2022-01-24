package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.EstadoCuenta;


public interface IEstadoCuentaService {
		
	public List<EstadoCuenta> findAll();
	
	public EstadoCuenta findById(Long id);
	
}
