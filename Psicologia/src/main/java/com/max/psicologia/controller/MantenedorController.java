package com.max.psicologia.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.max.psicologia.entity.Fase;

@Controller
public class MantenedorController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(MantenedorController.class);

	@GetMapping("/mantenedor")
	public String mantenedor(Model model) throws Exception{
		model.addAttribute("fase", new Fase());
		model.addAttribute("fases", faseRepository.findAll());
		model.addAttribute("tipoIntervenciones", tipoIntervencionRepository.findAll());
		model.addAttribute("idTipoUsuario", getTipoUsuarioSession().getIdTipoUsuario());
		model.addAttribute("faseTab","active");
		return "mantenedor/mantenedor";
	}
	
	@PostMapping("/crearFase")
	public String crearFase(Model model, @Valid @ModelAttribute("fase")Fase fase) throws Exception{
		faseRepository.save(fase);
		model.addAttribute("idTipoUsuario", getTipoUsuarioSession().getIdTipoUsuario());
		return "mantenedor/mantenedor";
	}
}
