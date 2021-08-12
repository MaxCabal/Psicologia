package com.max.psicologia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.psicologia.entity.Fase;
import com.max.psicologia.repository.FaseRepository;

@Service
public class FaseServiceImpl implements FaseService {
	
	@Autowired
	FaseRepository faseRepository;

	@Override
	public void borrar(Integer id) throws Exception {
		Fase fase = faseRepository.findById(id).orElseThrow(() -> new Exception("FaseNotFound in deleteUser -"+this.getClass().getName()));
		faseRepository.delete(fase);
	}

	@Override
	public Iterable<Fase> findAll() {
		return faseRepository.findAll();
	}

	public void guardar(Fase fase) {
		faseRepository.save(fase);
	}

}
