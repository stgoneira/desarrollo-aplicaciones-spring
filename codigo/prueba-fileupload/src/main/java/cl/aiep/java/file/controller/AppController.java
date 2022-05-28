package cl.aiep.java.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cl.aiep.java.file.entity.Archivo;
import cl.aiep.java.file.repository.ArchivoRepository;

@Controller
public class AppController {

	@Autowired
	private ArchivoRepository repository;
	
	@GetMapping("/formulario")
	public String formulario() { 
		return "formulario";
	}
	
	@GetMapping("/archivo/{disposicion}/{id}")
	public ResponseEntity<byte[]> archivo(@PathVariable("id") Archivo archivo, @PathVariable("") String disposicion) {
		String filename = archivo.getFilename();
		String disposition = null;
		if( disposicion.equalsIgnoreCase("a") ) {
			disposition = String.format("attachment; filename=\"%s\"", filename);
		} else {
			disposition = "inline";
		}
		return ResponseEntity.ok() 
					.header(HttpHeaders.CONTENT_DISPOSITION, disposition) 
					.contentType( MediaType.valueOf(archivo.getTipo()) )
					.body( archivo.getDatos() )
		;
	}
	
	@PostMapping("/formulario")
	public String procesarFormulario(@RequestParam("file") MultipartFile file, @RequestParam("nombre") String nombre ) { 
		try {
			System.out.printf("Nombre: %s %n%n", nombre);
			String filename = file.getOriginalFilename();
			filename = StringUtils.cleanPath( filename );
			Archivo archivo = Archivo.builder()
								.filename(filename) 
								.datos(file.getBytes())
								.tipo(file.getContentType())
								.build()
			;
			repository.saveAndFlush(archivo);
			return "redirect:/";
		} catch (Exception e) {
			return "formulario";
		}
	}
	
}
