package com.max.psicologia.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.max.psicologia.entity.Fase;
import com.max.psicologia.entity.TipoIntervencion;

@Controller
public class MantenedorController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(MantenedorController.class);

	@GetMapping("/mantenedor")
	public String mantenedor(Model model) {
		try {
			model.addAttribute("fase", new Fase());
			model.addAttribute("tipoIntervencion", new TipoIntervencion());
			agregarTiposFaseIntervenciones(model);
			model.addAttribute("idTipoUsuario", getTipoUsuarioSession().getIdTipoUsuario());
			model.addAttribute("faseTab","active");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "principal";
		}
		
		return "mantenedor/mantenedor";
	}
	
	@PostMapping("/crearFase")
	public String crearFase(Model model, @Valid @ModelAttribute("fase")Fase fase) throws Exception{
		faseService.guardar(fase);
		agregarTiposFaseIntervenciones(model);
		model.addAttribute("idTipoUsuario", getTipoUsuarioSession().getIdTipoUsuario());
		model.addAttribute("faseTab","active");
		return "mantenedor/mantenedor";
	}
	
	@PostMapping("/crearTipoIntervencion")
	public String crearTipoIntervencion(Model model, @Valid @ModelAttribute("tipoIntervencion")TipoIntervencion tipoIntervencion) throws Exception{
		tipoIntervencionService.save(tipoIntervencion);
		agregarTiposFaseIntervenciones(model);
		model.addAttribute("idTipoUsuario", getTipoUsuarioSession().getIdTipoUsuario());
		model.addAttribute("tipoIntervencionTab","active");
		return "mantenedor/mantenedor";
	}
	
	@GetMapping("/borrarFase/{id}")
	public String borrarFase(Model model, @PathVariable(name="id") Integer id) throws Exception  {
		try {
			faseService.borrar(id);
		} catch (Exception e) {
			model.addAttribute("deleteError","The fase could not be deleted.");
		}
		agregarTiposFaseIntervenciones(model);
		model.addAttribute("idTipoUsuario", getTipoUsuarioSession().getIdTipoUsuario());
		model.addAttribute("faseTab","active");
		return "mantenedor/mantenedor";
	}
	
	@GetMapping("/borrartipoIntervencion/{id}")
	public ResponseEntity<String> borrarTipoIntervencion(Model model, @PathVariable(name="id") Integer id) throws Exception  {
		try {
			tipoIntervencionService.delete(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		agregarTiposFaseIntervenciones(model);
		model.addAttribute("idTipoUsuario", getTipoUsuarioSession().getIdTipoUsuario());
		model.addAttribute("tipoIntervencionTab","active");
		return ResponseEntity.ok("Success");
	}
}
