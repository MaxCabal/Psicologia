package com.max.psicologia.service;

import javax.validation.Valid;

import com.max.psicologia.entity.Fase;

public interface FaseService {

	void borrar(Integer id) throws Exception;
	
	Iterable<Fase> findAll();

	void guardar(@Valid Fase fase);
}
