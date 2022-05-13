package cl.hcs.spring.modelo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	@Min(0)
	private int id;
	@Size(min = 3, max = 20)
	private String nombre;
		
}
