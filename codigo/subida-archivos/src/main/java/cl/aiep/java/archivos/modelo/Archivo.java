package cl.aiep.java.archivos.modelo;

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
public class Archivo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String filename; 
	private String tipo; 
	@Lob
	private byte[] datos;
	
}
