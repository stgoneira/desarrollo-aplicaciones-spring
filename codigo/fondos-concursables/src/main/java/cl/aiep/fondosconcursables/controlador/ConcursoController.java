package cl.aiep.fondosconcursables.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.aiep.fondosconcursables.modelo.Concurso;
import cl.aiep.fondosconcursables.repositorio.ConcursoRepository;

@Controller
public class ConcursoController {

	@Autowired
	ConcursoRepository concursoRepository;
	
	@GetMapping("/")
	public String index(
			@RequestParam(name = "q", defaultValue = "") String filtro
			, Model modelo
	) {
		List<Concurso> concursos;
		if( filtro.isBlank() ) {
			concursos = concursoRepository.findAll();	
		} else {
			concursos = concursoRepository.findByTituloContaining(filtro);
		}
		
		modelo.addAttribute("concursos", concursos);
		return "inicio";
	}
	
	@GetMapping("/concurso/{id}")
	public String index(@PathVariable("id") Concurso concurso, Model modelo) {
		modelo.addAttribute("concurso", concurso);
		return "concurso/ficha";
	}
	
	@GetMapping("/admin/concurso")
	public String concurso(Concurso concurso) {
		return "concurso/form";
	}
	
	@PostMapping("/admin/concurso")
	public String concurso(@Valid Concurso concurso, BindingResult informeValidacion) {
		if( informeValidacion.hasErrors() ) {
			return "concurso/form";	
		}
		concursoRepository.save(concurso);
		return "redirect:/admin/concurso/listado";
	}
	
}
