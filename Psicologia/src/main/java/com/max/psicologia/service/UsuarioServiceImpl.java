package com.max.psicologia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.max.psicologia.entity.Usuario;
import com.max.psicologia.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	private Environment env;

	@Override
	public Iterable<Usuario> getAllUsuarios() {
		return repository.findAll();
	}
	
	@Override
	public Usuario crear(Usuario usuario) throws Exception {
//		paciente.setFecNac(Utils.parseTimestamp(paciente.getFechaNacimiento()));
		if(usuario.getFecNac() == null) {
			throw new Exception(env.getProperty("typeMismatch.postForm.date"));
		} else {
			repository.save(usuario);
		}
		return usuario;
	}

	@Override
	public Usuario getUsuarioByRut(String rut) throws Exception {
		return repository.findById(rut).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}

	@Override
	public Iterable<Usuario> getByTipoUsuario(int idTipoUsuario) {
		return repository.findByTipo(idTipoUsuario);
	}

	@Override
	public Iterable<Usuario> getAllByTipo(int idTipoUsuario) {
		return repository.findByTipo(idTipoUsuario);
	}

}
