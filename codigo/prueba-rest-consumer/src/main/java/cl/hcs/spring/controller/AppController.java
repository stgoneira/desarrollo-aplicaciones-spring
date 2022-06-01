package cl.hcs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import cl.hcs.spring.model.Usuario;

@Controller
public class AppController {

	@GetMapping("/")
	public String usuarios(RestTemplate restTemplate, Model modelo) {
		Usuario[] usuarios = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", Usuario[].class);
		modelo.addAttribute("usuarios", usuarios);
		return "usuarios";
	}
	
}
