package cl.aiep.java.laboral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/postulante")
public class PostulanteController {

	@GetMapping("/registro")
	public String registro() {
		return "postulante/registro";
	}
	
	@GetMapping("/ingreso")
	public String ingreso() {
		return "postulante/ingreso";
	}
	
	
}
