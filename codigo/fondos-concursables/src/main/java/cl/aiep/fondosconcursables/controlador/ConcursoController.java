package cl.aiep.fondosconcursables.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.aiep.fondosconcursables.modelo.Concurso;
import cl.aiep.fondosconcursables.repositorio.ConcursoRepository;

@Controller
public class ConcursoController {

	@Autowired
	ConcursoRepository concursoRepository;
	
	@GetMapping("/")
	public String index(Model modelo) {
		List<Concurso> concursos = concursoRepository.findAll();
		modelo.addAttribute("concursos", concursos);
		return "inicio";
	}
	
}
