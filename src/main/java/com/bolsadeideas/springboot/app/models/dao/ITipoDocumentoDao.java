package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.app.models.entity.TipoDocumento;

@Repository
public interface ITipoDocumentoDao extends CrudRepository<TipoDocumento, Long>{

}
