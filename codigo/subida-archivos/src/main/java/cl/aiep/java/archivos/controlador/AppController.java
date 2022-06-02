package cl.aiep.java.archivos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cl.aiep.java.archivos.modelo.Archivo;
import cl.aiep.java.archivos.modelo.Producto;
import cl.aiep.java.archivos.repositorio.ArchivoRepository;
import cl.aiep.java.archivos.repositorio.ProductoRepository;

@Controller
public class AppController {

	@Autowired
	ArchivoRepository repository;
	
	@Autowired 
	ProductoRepository productoRepository;
	
	@GetMapping("/")
	public String formulario() {
		return "formulario";
	}
	
	@GetMapping("/producto")
	public String formProducto(Producto producto, Model modelo) {
		List<Producto> productos = productoRepository.findAll();
		modelo.addAttribute("productos", productos);
		modelo.addAttribute("producto", producto);
		return "producto";
	}
	
	@PostMapping("/producto")
	public String procesarProducto(Producto producto,@RequestParam("archivo") MultipartFile archivo) {
		try {
			String nombreArchivo 	= archivo.getOriginalFilename();
			String tipoArchivo 		= archivo.getContentType(); 
			byte[] contenidoArchivo = archivo.getBytes();
			Producto p = Producto.builder()
									.datos(contenidoArchivo)
									.tipo(tipoArchivo)
									.nombre(producto.getNombre())
									.precio(producto.getPrecio())
									.build()
			; 
			productoRepository.save(p);
			return "redirect:/cualquier-pagina";
		} catch (Exception e) {
			return "formulario";
		}		
	}
	
	@PostMapping("/")
	public String procesarFormulario(@RequestParam("archivo") MultipartFile archivo) {
		try {
			String nombreArchivo 	= archivo.getOriginalFilename();
			String tipoArchivo 		= archivo.getContentType(); 
			byte[] contenidoArchivo = archivo.getBytes();
			Archivo archivoBD 		= Archivo.builder()
											.datos(contenidoArchivo)
											.filename(nombreArchivo)
											.tipo(tipoArchivo)
											.build()
			;
			repository.saveAndFlush( archivoBD );
			return "redirect:/cualquier-pagina";
		} catch (Exception e) {
			return "formulario";
		}		
	}
	
	@GetMapping("/producto/img/{id}")
	public ResponseEntity<byte[]> mostrarImagenProducto(@PathVariable("id") Producto producto) {
		return ResponseEntity.ok() 
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline")
				.contentType( MediaType.valueOf(producto.getTipo()) ) 
				.body( producto.getDatos() )
		;
	}
	
	// http://localhost:8080/archivo/a/1 
	// http://localhost:8080/archivo/i/1 
	@GetMapping("/archivo/{disposicion}/{id}")
	public ResponseEntity<byte[]> mostrarDescargarArchivo(
			@PathVariable("disposicion") 	String disposicion,
			@PathVariable("id") 			Archivo archivo
	) {
		String disposition = null;
		if( "a".equalsIgnoreCase(disposicion) ) {
			disposition = "attachment";
		} else {
			disposition = "inline";
		}
		return ResponseEntity.ok() 
					.header(HttpHeaders.CONTENT_DISPOSITION, disposition)
					.contentType( MediaType.valueOf(archivo.getTipo()) ) 
					.body( archivo.getDatos() )
		;
	}
}
