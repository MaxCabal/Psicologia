package com.max.psicologia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.max.psicologia.entity.Profesional;

public interface ProfesionalRepository extends CrudRepository<Profesional, Integer> {
	
	public Optional<Profesional> findByNombre(String nombre);
	
	public Optional<Profesional> findByNombreUsuario(String nombreUsuario);

}
