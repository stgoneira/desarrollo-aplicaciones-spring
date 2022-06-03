package cl.aiep.java.bolsalaboral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeguridadController {

	@GetMapping("/ingreso")
	public String login() {
		return "login";
	}
	
}
