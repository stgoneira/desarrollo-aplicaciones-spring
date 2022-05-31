package cl.aiep.java.catalogo.exceptions;

public class ProductoNoEncontradoException 
	extends RuntimeException {

	public ProductoNoEncontradoException(Long id) {
		super( String.format("Producto con id %s no encontrado", id) );
	}
	
}
