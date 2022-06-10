package cl.aiep.fondosconcursables.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	@Column(nullable = false, unique = true)
	private String rut;
	@Column(nullable = false)
	private String razonSocial;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String contrasena;
}
