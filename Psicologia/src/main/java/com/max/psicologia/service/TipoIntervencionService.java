package com.max.psicologia.service;

import com.max.psicologia.entity.TipoIntervencion;

public interface TipoIntervencionService {
	
	Iterable<TipoIntervencion> findAll();
	
	void save(TipoIntervencion tipoIntervencion);

	void delete(Integer id) throws Exception;
	
}
