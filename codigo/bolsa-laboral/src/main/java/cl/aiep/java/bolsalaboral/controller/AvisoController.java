package cl.aiep.java.bolsalaboral.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.aiep.java.bolsalaboral.model.Aviso;
import cl.aiep.java.bolsalaboral.model.Empresa;
import cl.aiep.java.bolsalaboral.repository.AvisoRepository;
import cl.aiep.java.bolsalaboral.repository.EmpresaRepository;
import cl.aiep.java.bolsalaboral.seguridad.Usuario;

@Controller
public class AvisoController {

	@Autowired
	private AvisoRepository repositorio;	
	@Autowired 
	private EmpresaRepository empresaRepository;
	
	@GetMapping({"/", "/avisos"})
	public String avisos(Model modelo) {
		List<Aviso> avisos = repositorio.findAll();
		modelo.addAttribute("avisos", avisos);
		return "aviso/listado";
	}
	
	@GetMapping("/aviso/crear")
	public String formularioPublicacionAviso(Aviso aviso, Model modelo) {
		modelo.addAttribute("aviso", aviso);
		return "aviso/form";
	}
	
	@GetMapping("/aviso/{id}")
	public String verAviso(@PathVariable("id") Aviso aviso, Model modelo) {
		modelo.addAttribute("aviso", aviso);
		return "aviso/ficha";
	}
		
	@PostMapping("/aviso/crear")
	public String procesarAviso(Aviso aviso, Model modelo, Authentication usuarioAuth) {
		Usuario usuario = (Usuario) usuarioAuth.getPrincipal();
		if(usuario.getEmpresa() != null) {
			Long empresaId = usuario.getEmpresa().getId(); 
			
			Empresa empresa = empresaRepository.findById( empresaId ).get();
			aviso.setEmpresa(empresa);
			
			aviso.setFechaPublicacion( LocalDateTime.now() );
			repositorio.save(aviso);
			return "redirect:/aviso/publicacion-exitosa";	
		} else {
			return "redirect:/error/usuario-no-autorizado"; 
		}
	}
	
}
