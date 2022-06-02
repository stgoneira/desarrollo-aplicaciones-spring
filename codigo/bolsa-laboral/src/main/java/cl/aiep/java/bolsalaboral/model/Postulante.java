package cl.aiep.java.bolsalaboral.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor 
@Builder 
@Entity
public class Postulante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false, length = 10)
	private String rut;
	@Column(nullable = false)
	private String nombre;
	@Column(unique = true, nullable = false)
	private String email;	
	@Column(nullable = false)
	private String contrasena;
	@Lob  
	private byte[] curriculum;
	
}
