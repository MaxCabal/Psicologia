package com.max.psicologia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.max.psicologia.dto.CambiarContrasenaDto;
import com.max.psicologia.service.UsuarioService;


@Controller
public class IndexController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping({"/","/login"})
	public String index(Model model) {
		model.addAttribute("cambiarContrasena",new CambiarContrasenaDto());
		return "index";
	}
	
	@GetMapping("/principal")
	public String index2(Model model) {
		return "principal";
	}
}
