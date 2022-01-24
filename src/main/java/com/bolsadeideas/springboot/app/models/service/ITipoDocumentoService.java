package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.TipoDocumento;


public interface ITipoDocumentoService {
	
	public List<TipoDocumento> findAll();
		
	public TipoDocumento findById(Long id);
	
}
