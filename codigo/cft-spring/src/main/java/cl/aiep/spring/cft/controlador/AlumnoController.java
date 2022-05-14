package cl.aiep.spring.cft.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.spring.cft.modelo.Alumno;
import cl.aiep.spring.cft.modelo.Carrera;
import cl.aiep.spring.cft.repository.AlumnoRepository;
import cl.aiep.spring.cft.repository.CarreraRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	CarreraRepository carreraRepository;
	
	@GetMapping("/nuevo")
	public String alumnoNuevo(Alumno alumno, Model modelo) {
		List<Carrera> carreras = carreraRepository.findAll();
		modelo.addAttribute("carreras", carreras);
		return "alumno/form";
	}
	
	@GetMapping("/editar/{alumnoId}")
	public String alumnoEditar(@PathVariable int alumnoId, Model modelo) {
		Alumno alumno = alumnoRepository.findById(alumnoId);
		modelo.addAttribute("alumno", alumno);
		List<Carrera> carreras = carreraRepository.findAll();
		modelo.addAttribute("carreras", carreras);
		return "alumno/form";
	}
	
	@GetMapping("/eliminar/{alumnoId}")
	public String alumnoEliminar(@PathVariable int alumnoId) {
		alumnoRepository.delete(alumnoId);
		return "redirect:/alumno/listado";
	}
	
	@GetMapping("/listado")
	public String alumnoListado(Model modelo) {
		List<Alumno> alumnos = alumnoRepository.findAll();
		modelo.addAttribute("alumnos", alumnos);
		return "alumno/listado";
	}
	
	@PostMapping("/procesar")
	public String alumnoProcesar(@Valid Alumno alumno, BindingResult informeValidacion) {
		
		if( informeValidacion.hasErrors() ) {
			return "alumno/form";
		}
		
		if( alumno.getId() > 0) {
			alumnoRepository.edit(alumno);
		} else {
			alumnoRepository.create(alumno);	
		}
		return "redirect:/alumno/listado";
	}
	
}
