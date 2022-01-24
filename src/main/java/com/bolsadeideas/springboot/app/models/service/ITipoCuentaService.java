package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.TipoCuenta;


public interface ITipoCuentaService {
	
	public List<TipoCuenta> findAll();
		
	public TipoCuenta findById(Long id);
	
}
