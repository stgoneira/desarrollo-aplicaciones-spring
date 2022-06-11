package cl.aiep.fondosconcursables.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.aiep.fondosconcursables.modelo.Concurso;
import cl.aiep.fondosconcursables.modelo.Empresa;
import cl.aiep.fondosconcursables.modelo.Postulacion;
import cl.aiep.fondosconcursables.repositorio.ConcursoRepository;
import cl.aiep.fondosconcursables.repositorio.PostulacionRepository;
import cl.aiep.fondosconcursables.seguridad.Usuario;

@Controller
public class PostulacionController {

	@Autowired 
	ConcursoRepository concursoRepository;
	
	@Autowired
	PostulacionRepository postulacionRepository;
	
	@Secured({"ROLE_EMPRESA"})
	@PostMapping("/postulacion/{id}")
	public String postulacion(
			@PathVariable("id") Concurso concurso
			, Authentication usuarioAutenticado
			, Model modelo
	) {
		/*
		// Con esto puedo saber quién está postulando 
		(MyUserDetails) autenticacion.getPrincipal();
		
		// 1. Validar que pueda postular 
			// 1.1 Dentro de las fechas 
			// 1.2 Que queden cupos 
			// 1.3 Que no tenga más postulaciones 
			postulacionRepository.findByEmpresa(empresa);
			
			if( noPuedePostular ) {
				modelo.addAttribute("error", "Venció plazo....");
				return "detalle-concurso";
			}
		
		// 2. Registrar postulación 
		
		// 3. Decrementar los cupos disponibles para postulación
		int disponibles = concurso.getPostulacionesDisponibles() - 1;
		concurso.setPostulacionesDisponibles( disponibles );
		concursoRepository.save( concurso );
		*/
		
		// TODO: FALTAN VALIDACIONES 
		Usuario usuario = (Usuario) usuarioAutenticado.getPrincipal();
		Empresa empresa = usuario.getEmpresa();
		Postulacion postulacion = Postulacion.builder()
									.empresa(empresa)
									.concurso(concurso)
									.build()
		;
		postulacionRepository.save(postulacion);
		return "redirect:/empresa/dashboard";
		
	}
	
}
