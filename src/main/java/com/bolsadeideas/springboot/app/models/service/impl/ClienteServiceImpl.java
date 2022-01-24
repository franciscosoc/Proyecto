package com.bolsadeideas.springboot.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.ICuentaDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Cuenta;
import com.bolsadeideas.springboot.app.models.service.IClienteService;


@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
		
	@Autowired
	private ICuentaDao cuentaDao;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {

		return clienteDao.findById(id).orElse(null);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		
		return clienteDao.findAll(pageable);
	}

	
	@Override
	@Transactional
	public void saveCuenta(Cuenta cuenta) {

		cuentaDao.save(cuenta);
		
	}

	
	@Override
	@Transactional(readOnly=true)
	public Cuenta findCuentaById(Long id) {

		return cuentaDao.findById(id).orElse(null);

	}

	@Override
	@Transactional
	public void deleteCuenta(Long id) {
		
		cuentaDao.deleteById(id);

		
		
		
	}

}
