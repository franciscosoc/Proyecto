package com.bolsadeideas.springboot.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.ITipoDocumentoDao;
import com.bolsadeideas.springboot.app.models.entity.TipoDocumento;
import com.bolsadeideas.springboot.app.models.service.ITipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService{
	
	@Autowired
	private ITipoDocumentoDao tipoDocumentoDao;
	
	@Override
	@Transactional(readOnly = true)	
	public List<TipoDocumento> findAll() {
		
		return (List<TipoDocumento>) this.tipoDocumentoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)	
	public TipoDocumento findById(Long id) {
		
		return this.tipoDocumentoDao.findById(id).orElse(null);
	}

	

}
