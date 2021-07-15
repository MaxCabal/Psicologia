package com.max.psicologia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.max.psicologia.dto.ComunaDto;
import com.max.psicologia.entity.Usuario;
import com.max.psicologia.util.Parser;
import com.max.psicologia.util.Utils;

@Controller
public class UsuarioController extends BaseController {
	
	@GetMapping("/updateComuna/{idRegion}")
	@ResponseBody
	public List<ComunaDto> updateComuna(@PathVariable(name = "idRegion") int idRegion) {
		return Parser.toListComunaDto(comunaRepository.findByIdRegion(idRegion));
	}
	
	@GetMapping("/usuarios/{idTipoUsuario}")
	public String listaPacientes(Model model, @PathVariable(name = "idTipoUsuario") int idTipoUsuario) {
		agregarAttributosBase(model);
		model.addAttribute("listTab","active");
		model.addAttribute("usuarioList", getUsuariosByTipo(idTipoUsuario));
		getSession().setAttribute(ID_TIPO_USUARIO, idTipoUsuario);
		return "usuario/usuarios";
	}
	
	@PostMapping("/usuarios")
	public String crearUsuario(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult resultado, Model model, Errors errors) {
		try {
			usuario.setEstado(getEstadoDefault());
			usuario.setTipoUsuario(getTipoUsuarioSession());
//			Utils.validarRut(usuario.getRut());
			Utils.formatRutPaciente(usuario);
			if(resultado.hasErrors()) {
				model.addAttribute("formErrorMensaje",resultado.getFieldErrors().get(0).getDefaultMessage());
				model.addAttribute("usuario", usuario);
				model.addAttribute("formTab","active");
			} else {
				usuarioService.crear(usuario);
				model.addAttribute("listTab","active");
			}
		} catch(Exception e) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("formTab","active");
			model.addAttribute("formErrorMensaje",e.getMessage());
		}
		agregarAttributosBase(model);
		model.addAttribute("usuarioList", getUsuariosByTipo(getSessionIntAttribute(ID_TIPO_USUARIO)));
		return "usuario/usuarios";
	}
	
	@GetMapping("/editarUsuario/{rut}")
	public String editarPaciente(Model model, @PathVariable(name = "rut") String rut) throws Exception{
		Usuario usuario = usuarioService.getUsuarioByRut(rut);
		model.addAttribute("formTab","active");
		agregarAttributosBase(model);
		model.addAttribute("usuario", usuario);
		model.addAttribute("regiones", regionRepository.findAll());
		model.addAttribute("regionSelected", usuario.getComuna().getRegion().getIdRegion());
		model.addAttribute("comunas", comunaRepository.findByIdRegion(usuario.getComuna().getRegion().getIdRegion()));
		model.addAttribute("comunaSelected", usuario.getComuna().getIdComuna());
		model.addAttribute("usuarioList", getUsuariosByTipo(getSessionIntAttribute(ID_TIPO_USUARIO)));
		return "usuario/usuarios";
	}
}
