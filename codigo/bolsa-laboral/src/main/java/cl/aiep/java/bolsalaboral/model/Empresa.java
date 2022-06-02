package cl.aiep.java.bolsalaboral.model;

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
@AllArgsConstructor
@NoArgsConstructor 
@Builder 
@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false, length = 10)
	private String rut;
	@Column(nullable = false)
	private String razonSocial;
	@Column(unique = true, nullable = false)
	private String email;	
	@Column(nullable = false)
	private String contrasena;
	
}
