package com.max.psicologia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.max.psicologia.entity.TipoUsuario;

public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, Integer> {

	public Optional<TipoUsuario> findByIdTipoUsuario(int tipo);
	
}
