package cl.aiep.java.laboral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cl.aiep.java.laboral.model.Empresa;

@Controller
public class EmpresaController {

	
	@GetMapping("/empresa/registro")
	private String registro(Empresa empresa) {
		return "empresa/registro";
	}
	
	
	
}
