package com.max.psicologia.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.max.psicologia.entity.Estado;
import com.max.psicologia.entity.Intervencion;
import com.max.psicologia.entity.TipoUsuario;
import com.max.psicologia.entity.Usuario;
import com.max.psicologia.repository.ComunaRepository;
import com.max.psicologia.repository.EstadoRepository;
import com.max.psicologia.repository.FaseRepository;
import com.max.psicologia.repository.IntervencionRepository;
import com.max.psicologia.repository.ProfesionalRepository;
import com.max.psicologia.repository.RegionRepository;
import com.max.psicologia.repository.TipoIntervencionRepository;
import com.max.psicologia.repository.TipoUsuarioRepository;
import com.max.psicologia.service.UsuarioService;

@Controller
public class BaseController {
	
	public final static String ID_TIPO_USUARIO = "idTipoUsuario";
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProfesionalRepository profesionalRepository;
	
	@Autowired
	IntervencionRepository intervencionRepository;
	
	@Autowired
	RegionRepository regionRepository;
	
	@Autowired
	ComunaRepository comunaRepository;
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	FaseRepository faseRepository;
	
	@Autowired
	TipoIntervencionRepository tipoIntervencionRepository;
	
	@Value("${default.region}")
	private String defaultRegion;
	
	@Value("${default.estado}")
	private String defaultEstado;
	
	@Autowired
	ObjectFactory<HttpSession> httpSessionFactory;
	
	public String getusuarioActual() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    return authentication.getName();
		} else {
			return null;
		}
	}
	
	protected void agregarAttributosBase(Model model) {
		agregarNuevaRegionComuna(model);
		agregarNuevaIntervencion(model);
		model.addAttribute("fases", faseRepository.findAll());
		model.addAttribute("tiposIntervenciones", tipoIntervencionRepository.findAll());
		model.addAttribute("usuario", new Usuario());
	}
	
	protected void agregarNuevaRegionComuna(Model model) {
		model.addAttribute("regiones", regionRepository.findAll());
		model.addAttribute("regionSelected", Integer.parseInt(defaultRegion));
		model.addAttribute("comunas", comunaRepository.findByIdRegion(Integer.parseInt(defaultRegion)));
	}
	
	protected void agregarNuevaIntervencion(Model model) {
		Intervencion intervencionNueva = new Intervencion();
		model.addAttribute("intervencion", intervencionNueva);
	}
	
	protected TipoUsuario getTipoBySession(int tipo) {
		return tipoUsuarioRepository.findByIdTipoUsuario(tipo).orElse(null);
	}
	
	protected Estado getEstadoDefault() throws Exception {
		return estadoRepository.findById(Integer.parseInt(defaultEstado)).orElseThrow(() -> new Exception("El estado default no existe."));
	}
	
	protected TipoUsuario getTipoUsuarioSession() throws Exception {
		return tipoUsuarioRepository.findById(Integer.parseInt(getSession().getAttribute("idTipoUsuario").toString())).orElseThrow(() -> new Exception("El tipo de usuario no existe."));
	}
	
	public HttpSession getSession() {
		return httpSessionFactory.getObject();
	}
	
	public Integer getSessionIntAttribute(String attribute) {
		return Integer.parseInt(httpSessionFactory.getObject().getAttribute(attribute).toString());
	}
	
	protected List<Usuario> getUsuariosByTipo(int idTipo) {
		return (List<Usuario>) usuarioService.getAllByTipo(idTipo);
	}
}
