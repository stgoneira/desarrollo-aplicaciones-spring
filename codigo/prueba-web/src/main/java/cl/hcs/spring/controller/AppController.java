package cl.hcs.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cl.hcs.spring.modelo.Persona;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AppController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/persona")
	public String personaForm(Persona persona) {
		return "persona-form";
	}
	
	@PostMapping("/persona")
	public String personaFicha(@Valid Persona persona, BindingResult bindingResult) {
		// BindingResult como param debe venir inmediatamente después de param @Valid 
		if( bindingResult.hasErrors() ) {
			return "persona-form";
		}
		log.info(persona.toString());		
		return "persona-ficha";
	}
	
}
