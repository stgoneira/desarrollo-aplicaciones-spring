package cl.aiep.java.bolsalaboral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import cl.aiep.java.bolsalaboral.model.Empresa;
import cl.aiep.java.bolsalaboral.service.EmpresaService;

@Controller
public class EmpresaController {

	@Autowired
	private EmpresaService servicio; 
	
	@GetMapping("/empresa/registro")
	public String registro(Empresa empresa, Model modelo) {
		modelo.addAttribute("empresa", empresa);
		return "empresa/registro";
	}
	
	@PostMapping("/empresa/registro")
	public String registroProcesar(Empresa empresa) {
		servicio.crearEmpresa(empresa);
		return "redirect:/empresa/registro-exitoso";
	}
	
}
