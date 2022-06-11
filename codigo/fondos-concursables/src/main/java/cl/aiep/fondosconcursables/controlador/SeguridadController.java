package cl.aiep.fondosconcursables.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeguridadController {

	@GetMapping("/ingreso")
	public String login() {
		return "loginform";
	}
	
}
