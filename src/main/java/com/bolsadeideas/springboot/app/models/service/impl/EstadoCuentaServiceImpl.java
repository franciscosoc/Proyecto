package com.bolsadeideas.springboot.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IEstadoCuentaDao;
import com.bolsadeideas.springboot.app.models.entity.EstadoCuenta;
import com.bolsadeideas.springboot.app.models.service.IEstadoCuentaService;

@Service
public class EstadoCuentaServiceImpl implements IEstadoCuentaService{
	
	@Autowired
	private IEstadoCuentaDao estadoCuentaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<EstadoCuenta> findAll() {
		
		return (List<EstadoCuenta>)this.estadoCuentaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)	
	public EstadoCuenta findById(Long id) {
		
		return this.estadoCuentaDao.findById(id).orElse(null);
	}

	

}
