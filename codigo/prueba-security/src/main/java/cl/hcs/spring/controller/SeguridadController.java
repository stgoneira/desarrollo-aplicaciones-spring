package cl.hcs.spring.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeguridadController {

	@GetMapping("/ingreso")
	public String login() {
		return "login";
	}
	
}
