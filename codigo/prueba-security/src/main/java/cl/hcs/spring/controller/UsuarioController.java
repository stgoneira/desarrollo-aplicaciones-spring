package cl.hcs.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.hcs.spring.model.Usuario;
import cl.hcs.spring.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/crear")
	public String crearUsuario(Usuario usuario) {
		return "usuario/form";
	}
	
	@PostMapping("/crear")
	public String crearUsuario(@Valid Usuario usuario, BindingResult informeValidacion) {
		if( informeValidacion.hasErrors() ) return "usuario/form";
		
		usuarioService.crearUsuario(usuario);
		return "redirect:usuario/form";
	}
	
}
