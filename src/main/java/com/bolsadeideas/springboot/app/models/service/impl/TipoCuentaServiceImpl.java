package com.bolsadeideas.springboot.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.ITipoCuentaDao;
import com.bolsadeideas.springboot.app.models.entity.TipoCuenta;
import com.bolsadeideas.springboot.app.models.service.ITipoCuentaService;

@Service
public class TipoCuentaServiceImpl implements ITipoCuentaService{
	
	@Autowired
	private ITipoCuentaDao tipoCuentaDao;
	
	@Override
	@Transactional(readOnly = true)	
	public List<TipoCuenta> findAll() {
		
		return (List<TipoCuenta>) this.tipoCuentaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)	
	public TipoCuenta findById(Long id) {
		
		return this.tipoCuentaDao.findById(id).orElse(null);
	}

	

}
