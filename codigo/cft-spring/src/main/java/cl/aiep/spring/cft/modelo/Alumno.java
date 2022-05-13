package cl.aiep.spring.cft.modelo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

	@Min(0)
	private int id;
	@Size(min = 3, max = 40)
	private String nombre;
	
}
