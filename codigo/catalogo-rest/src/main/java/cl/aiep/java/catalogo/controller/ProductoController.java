package cl.aiep.java.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.java.catalogo.exceptions.ProductoNoEncontradoException;
import cl.aiep.java.catalogo.model.Producto;
import cl.aiep.java.catalogo.repository.ProductoRepository;

@RestController
@CrossOrigin("*")
public class ProductoController {

	@Autowired
	private ProductoRepository repository;
	
	@GetMapping("/productos")
	public List<Producto> todosLosProductos() {
		return repository.findAll(); 
	} 
	
	@PostMapping("/productos") 
	public Producto nuevoProducto(@RequestBody Producto productoNuevo) {
		return repository.save(productoNuevo); 
	} 
	
	@GetMapping("/productos/{id}") 
	public Producto productoPorId(@PathVariable Long id) {
		return repository.findById(id) 
					.orElseThrow( () -> new ProductoNoEncontradoException(id) ) 
		;
	}
	
	@PutMapping("/productos/{id}") 
	public Producto reemplazarProducto(@RequestBody Producto productoAReemplazar, @PathVariable Long id) {
		return repository.findById(id) 
					.map( producto -> {
						producto.setNombre( productoAReemplazar.getNombre() );
						producto.setPrecio( productoAReemplazar.getPrecio() );
						return repository.save(producto);
					}) 
					.orElseGet( () -> { 
						productoAReemplazar.setId(id);
						return repository.save(productoAReemplazar);
					}) 
		;
	} 
	
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
