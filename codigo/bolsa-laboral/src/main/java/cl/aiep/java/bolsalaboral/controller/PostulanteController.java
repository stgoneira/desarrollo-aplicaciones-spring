package cl.aiep.java.bolsalaboral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cl.aiep.java.bolsalaboral.model.Postulante;
import cl.aiep.java.bolsalaboral.service.PostulanteService;

@Controller
public class PostulanteController {

	@Autowired 
	private PostulanteService servicio;
	
	@GetMapping("/postulante/registro")
	public String registro(Postulante postulante, Model modelo) {
		modelo.addAttribute("postulante", postulante);
		return "postulante/registro";
	}
	
	@PostMapping("/postulante/registro") 
	public String registroProcesar(Postulante postulante) {
		servicio.crearPostulante(postulante); 
		return "redirect:/postulante/registro-exitoso";
	}
	
}
