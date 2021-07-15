package com.max.psicologia.service;

import com.max.psicologia.entity.Usuario;

public interface UsuarioService {
	
	Iterable<Usuario> getAllUsuarios();
	
	Iterable<Usuario> getAllByTipo(int idTipoUsuario);
	
	Iterable<Usuario> getByTipoUsuario(int idTipoUsuario);
	
	Usuario crear(Usuario usuario) throws Exception;
	
	Usuario getUsuarioByRut(String rut) throws Exception;


}
