package cl.aiep.java.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cl.aiep.java.model.Aviso;
import cl.aiep.java.model.Empresa;
import cl.aiep.java.repository.AvisoRepository;
import cl.aiep.java.repository.EmpresaRepository;
import cl.aiep.java.seguridad.Usuario;

@Controller
public class AppController {

	@Autowired 
	private EmpresaRepository empresaRepository;
	@Autowired
	private AvisoRepository avisoRepository;
	
	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping("/ingreso")
	public String login() {
		return "login";
	}
	
	@GetMapping("/aviso/crear")
	public String avisoCrear(Aviso aviso) {
		return "aviso/form";
	}
	
	@PostMapping("/aviso/crear")
	public String avisoCrear(
			@Valid Aviso aviso
			, BindingResult informeValidacion
			, Authentication usuarioAutenticado) {
		
		if( informeValidacion.hasErrors() ) {
			return "aviso/form";
		}
		
		Usuario usuario = (Usuario) usuarioAutenticado.getPrincipal(); 
		Empresa empresa = empresaRepository.findById( usuario.getEmpresa().getId() ).get();
		aviso.setEmpresa(empresa);
		avisoRepository.save(aviso);
		return "redirect:/";
	}
	
	@GetMapping("/empresa/registro")
	public String empresaRegistro() {
		return "empresa/registro";
	}
	
	@GetMapping("/postulante/registro")
	public String postulanteRegistro() {
		return "postulante/registro";
	}
	
	@GetMapping("/empresa/panel")
	public String empresaPanel() {
		return "empresa/panel";
	}
	
	@GetMapping("/postulante/panel")
	public String postulantePanel() {
		return "postulante/panel";
	}
	
}
