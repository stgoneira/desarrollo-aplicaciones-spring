package cl.aiep.fondosconcursables.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.fondosconcursables.modelo.Empresa;
import cl.aiep.fondosconcursables.servicio.EmpresaService;

@RequestMapping("/empresa")
@Controller
public class EmpresaController {

	@Autowired
	EmpresaService service;
	
	@GetMapping("/registro")
	public String registro(Empresa empresa) {
		return "empresa/registro";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid Empresa empresa, BindingResult informeValidacion) {
		if( informeValidacion.hasErrors() ) {
			return "empresa/registro";	
		}
		service.crearEmpresa(empresa);
		return "redirect:/";
	}
	
}
