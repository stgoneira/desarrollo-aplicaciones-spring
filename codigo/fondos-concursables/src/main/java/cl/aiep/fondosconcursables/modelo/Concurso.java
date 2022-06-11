package cl.aiep.fondosconcursables.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cl.aiep.fondosconcursables.validacion.FechaInicioTermino;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FechaInicioTermino
@Entity
public class Concurso {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	/**
	 * Cuántas empresas pueden ganar los fondos estatales 
	 */
	@Min(1)
	private int cupos;
	@NotBlank
	@Column(nullable = false)
	private String titulo;
	@NotBlank
	@Column(nullable = false)
	private String descripcion;
	/**
	 * Monto que se adjudican las empresas 
	 * que reciben el beneficio 
	 */
	@NotNull
	@Min(1)
	@Column(nullable = false)
	private Long monto;
	
	/**
	 * Cuántas empresas pueden postular al fondo
	 */
	@Min(1)
	@Column(nullable = false)
	private int postulacionesPermitidas;
	/**
	 * Cantidad de empresas que pueden postular antes que se acabe el plazo 
	 */
	@Min(0)
	@Column(nullable = false)
	private int postulacionesDisponibles;
	@NotNull
	@Column(nullable = false)
	private LocalDate postulacionesFechaInicio;
	@NotNull
	@Column(nullable = false)
	private LocalDate postulacionesFechaTermino;
	
}
