package com.max.psicologia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.max.psicologia.entity.TipoIntervencion;
import com.max.psicologia.repository.TipoIntervencionRepository;

@Service
public class TipoIntervencionServiceImpl implements TipoIntervencionService {
	
	private static final Logger logger = LoggerFactory.getLogger(TipoIntervencionServiceImpl.class);

	@Autowired
	TipoIntervencionRepository tipoIntervencionRepository;

	@Override
	public Iterable<TipoIntervencion> findAll() {
		return tipoIntervencionRepository.findAll();
	}

	@Override
	public void save(TipoIntervencion tipoIntervencion) {
		tipoIntervencionRepository.save(tipoIntervencion);
	}

	@Override
	public void delete(Integer id) throws Exception{
		try {
			TipoIntervencion tipoIntervencion = tipoIntervencionRepository.findById(id).orElseThrow(() -> new Exception("FaseNotFound in deleteUser -"+this.getClass().getName()));
			tipoIntervencionRepository.delete(tipoIntervencion);
		} catch (Exception e) {
			logger.error(e.getMessage());
			if(e instanceof DataIntegrityViolationException) {
				throw new Exception("No se puede eliminar un tipo de intervencion asociado a una intervencion existente");
			}
			throw e;
		}
	}

}
