package com.max.psicologia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.max.psicologia.entity.Comuna;

@Repository
public interface ComunaRepository extends CrudRepository<Comuna, Integer>{
	
	@Query("from Comuna where id_region=:idRegion")
	public List<Comuna> findByIdRegion(@Param("idRegion") int idRegion);
}
