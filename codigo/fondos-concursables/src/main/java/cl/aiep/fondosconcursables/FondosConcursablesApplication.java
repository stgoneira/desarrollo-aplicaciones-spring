package cl.aiep.fondosconcursables;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cl.aiep.fondosconcursables.modelo.Concurso;
import cl.aiep.fondosconcursables.repositorio.ConcursoRepository;

@SpringBootApplication
public class FondosConcursablesApplication {

	@Autowired
	ConcursoRepository concursoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FondosConcursablesApplication.class, args);
	}
	
	public CommandLineRunner datosIniciales() {
		return (args) -> {
			Concurso concurso = Concurso.builder() 
									.cupos(50)
									.descripcion("Lorem ipsum")
									.monto(5_000_000L)
									.postulacionesPermitidas(200)
									.postulacionesDisponibles(100)
									.postulacionesFechaInicio( LocalDate.of(2022, 2, 10) )
									.postulacionesFechaTermino( LocalDate.of(2022, 3, 10) )
									.build()
			;
		};
	}

}
