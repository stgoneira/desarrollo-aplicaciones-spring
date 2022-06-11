package cl.aiep.fondosconcursables.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cl.aiep.fondosconcursables.validacion.Rut;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Empresa {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Rut	
	@Column(nullable = false, unique = true)
	private String rut;
	@Size(min = 3, max = 100)
	@Column(nullable = false)
	private String razonSocial;
	@Email
	@NotBlank
	@Column(nullable = false)
	private String email;
	@Size(min = 3, max = 100)
	@Column(nullable = false)
	private String contrasena;
}
