package cl.hcs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSiteController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() {
		return "nosotros";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
}
