package cl.hcs.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//https://jsonplaceholder.typicode.com/users 
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {

	private Long id;
	@JsonProperty("name")
	private String nombre;
	private String email;
	@JsonProperty("address")
	private Direccion direccion;
}
