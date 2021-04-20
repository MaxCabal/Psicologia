package com.max.psicologia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
	
	@GetMapping({"/"})
	public String index(Model model) {
//		model.addAttribute("cambiarContrasena",new CambiarContrasenaDto());
		return "index";
	}

	@PostMapping({"/login"})
	public String login() {
		return "usuarios";
	}
}
