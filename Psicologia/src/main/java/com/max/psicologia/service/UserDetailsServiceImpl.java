package com.max.psicologia.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.max.psicologia.entity.Profesional;
import com.max.psicologia.entity.Rol;
import com.max.psicologia.repository.ProfesionalRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	ProfesionalRepository profesionalRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Profesional profesional = (Profesional) profesionalRepository.findByNombreUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no valido"));
		
		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
		
		for(Rol rol : profesional.getRols()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getRol());
			grantList.add(grantedAuthority);
		}
		
		UserDetails userDetails = (UserDetails)new User(profesional.getNombre(), profesional.getContrasena(), grantList);
		
		return userDetails;
	}

}
