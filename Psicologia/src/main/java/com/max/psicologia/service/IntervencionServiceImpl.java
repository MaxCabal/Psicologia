package com.max.psicologia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.psicologia.entity.Intervencion;
import com.max.psicologia.repository.IntervencionRepository;

@Service
public class IntervencionServiceImpl implements IntervencionService {

	@Autowired
	IntervencionRepository intervencionRepository;

	@Override
	public Intervencion getById(int idIntervencion) {
		return intervencionRepository.findById(idIntervencion).get();
	}
	
}
