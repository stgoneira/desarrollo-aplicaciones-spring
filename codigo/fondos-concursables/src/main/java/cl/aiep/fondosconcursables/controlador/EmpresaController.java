package cl.aiep.fondosconcursables.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.fondosconcursables.modelo.Empresa;
import cl.aiep.fondosconcursables.modelo.Postulacion;
import cl.aiep.fondosconcursables.repositorio.PostulacionRepository;
import cl.aiep.fondosconcursables.seguridad.Usuario;
import cl.aiep.fondosconcursables.servicio.EmpresaService;

@RequestMapping("/empresa")
@Controller
public class EmpresaController {

	@Autowired
	EmpresaService service;
	
	@Autowired
	PostulacionRepository postulacionRepository;
	
	@Secured("ROLE_EMPRESA")
	@GetMapping("/dashboard")
	public String inicio(Model modelo, Authentication usuarioAutenticado) {
		Usuario usuario = (Usuario) usuarioAutenticado.getPrincipal();
		List<Postulacion> postulaciones = postulacionRepository.findByEmpresa_Id( usuario.getEmpresa().getId() );
		modelo.addAttribute("postulaciones", postulaciones);
		return "empresa/dashboard";
	}
	
	@GetMapping("/registro")
	public String registro(Empresa empresa) {
		return "empresa/registro";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid Empresa empresa, BindingResult informeValidacion) {
		if( informeValidacion.hasErrors() ) {
			return "empresa/registro";	
		}
		service.crearEmpresa(empresa);
		return "redirect:/";
	}
	
}
