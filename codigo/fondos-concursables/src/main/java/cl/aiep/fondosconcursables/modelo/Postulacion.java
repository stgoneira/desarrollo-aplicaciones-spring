package cl.aiep.fondosconcursables.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"empresa_id", "concurso_id"})})
public class Postulacion {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Concurso concurso;	
	@Column(nullable = false)
	@Builder.Default
	private LocalDateTime fecha = LocalDateTime.now();
	
}
