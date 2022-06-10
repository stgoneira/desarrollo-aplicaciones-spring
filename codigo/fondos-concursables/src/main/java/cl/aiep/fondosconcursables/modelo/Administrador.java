package cl.aiep.fondosconcursables.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Administrador {

	@Id
	private String usuario;
	@Column(nullable = false)
	private String contrasena;
}
