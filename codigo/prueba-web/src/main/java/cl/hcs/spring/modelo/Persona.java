package cl.hcs.spring.modelo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Persona {

	@Min(0)
	private int id;
	@Size(min = 3, max = 20)
	private String nombre;
		
}
