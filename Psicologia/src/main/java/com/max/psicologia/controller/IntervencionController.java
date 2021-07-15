package com.max.psicologia.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.max.psicologia.dto.IntervencionDetalleDto;
import com.max.psicologia.entity.Intervencion;
import com.max.psicologia.entity.Profesional;
import com.max.psicologia.entity.Usuario;
import com.max.psicologia.service.IntervencionService;
import com.max.psicologia.util.Parser;

@Controller
public class IntervencionController extends BaseController {
	
	@PostMapping("/crearIntervencion")
	public ResponseEntity crearIntervencion(@Valid @ModelAttribute("intervencion")Intervencion intervencion, BindingResult resultado, Model model, Errors errors) {
		try {
			Usuario usuario = usuarioService.getUsuarioByRut(intervencion.getRut());
			Profesional profesional = profesionalRepository.findByNombre(getusuarioActual()).orElse(null);
			intervencion.setUsuario(usuario);
			intervencion.setProfesional(profesional);
			intervencion.setFecha(new Date());
			if(resultado.hasErrors()) {
				model.addAttribute("formErrorMensaje",resultado.getFieldErrors().get(0).getDefaultMessage());
				model.addAttribute("intervencion", intervencion);
				model.addAttribute("formTab","active");
				return ResponseEntity.badRequest().body(resultado.getFieldErrors().get(0).getDefaultMessage());
			} else {
				intervencionRepository.save(intervencion);
				model.addAttribute("intervencionesTab","active");
			}
		} catch(Exception e) {
			model.addAttribute("intervencion", intervencion);
			model.addAttribute("formTab","active");
			model.addAttribute("formErrorMensaje",e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		agregarAttributosBase(model);
		model.addAttribute("usuarioList", getUsuariosByTipo(getSessionIntAttribute(ID_TIPO_USUARIO)));
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/intervenciones")
	public String getListaAtenciones(Model model) throws Exception {
		agregarAttributosBase(model);
		model.addAttribute("intervencionLista", intervencionRepository.findAll());
		model.addAttribute("intervencionesTab","active");
		model.addAttribute("tipousuario", getSessionIntAttribute(ID_TIPO_USUARIO));
		return "intervencion/intervenciones";
	}
	
	@PostMapping("/modalVerIntervencionDetalle/{idIntervencion}")
	@ResponseBody
	public IntervencionDetalleDto modalVerIntervencionDetalle(@PathVariable(name = "idIntervencion") int idIntervencion, Model model) {
		Intervencion intervencion= intervencionRepository.findById(idIntervencion).get();
		model.addAttribute("fases", faseRepository.findAll());
		model.addAttribute("faseSelected", intervencion.getFase().getIdFase());
		model.addAttribute("tiposIntervenciones", tipoIntervencionRepository.findAll());
		model.addAttribute("tiposIntervenciones", intervencion.getTipoIntervencion().getIdTipoIntervencion());
		return Parser.toIntervencionDto(intervencion);
	}
}
