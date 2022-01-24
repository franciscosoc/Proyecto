package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Cuenta;


public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
    public void delete(Long id);
    
		
	public void saveCuenta(Cuenta cuenta);
	
		
	public Cuenta findCuentaById(Long id);
	
	public void deleteCuenta(Long id); 
	
	
	

	
}
