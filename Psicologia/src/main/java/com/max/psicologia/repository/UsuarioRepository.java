package com.max.psicologia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.max.psicologia.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	@Query("from Usuario where id_tipo_usuario =:tipo")
	public List<Usuario> findByTipo(@Param("tipo") int tipo);
}
