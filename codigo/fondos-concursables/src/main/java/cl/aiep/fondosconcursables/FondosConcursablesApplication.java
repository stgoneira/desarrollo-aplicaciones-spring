package cl.aiep.fondosconcursables;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.aiep.fondosconcursables.modelo.Concurso;
import cl.aiep.fondosconcursables.modelo.Empresa;
import cl.aiep.fondosconcursables.repositorio.ConcursoRepository;
import cl.aiep.fondosconcursables.repositorio.EmpresaRepository;
import cl.aiep.fondosconcursables.servicio.EmpresaService;

@SpringBootApplication
public class FondosConcursablesApplication {

	@Autowired
	ConcursoRepository concursoRepository;
	
	@Autowired 
	EmpresaService empresaService;
	
	public static void main(String[] args) {
		SpringApplication.run(FondosConcursablesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner datosIniciales() {
		return (args) -> {
			if( concursoRepository.count() == 0) {
				Concurso concurso = Concurso.builder() 
										.cupos(50)
										.titulo("Capital Semilla")
										.descripcion("Lorem ipsum")
										.monto(3_000_000L)
										.postulacionesPermitidas(200)
										.postulacionesDisponibles(100)
										.postulacionesFechaInicio( LocalDate.of(2022, 6, 10) )
										.postulacionesFechaTermino( LocalDate.of(2022, 7, 10) )
										.build()
				;
				concursoRepository.save(concurso);
				
				concurso = Concurso.builder() 
						.cupos(20)
						.titulo("Fondo CRECE")
						.descripcion("Lorem ipsum dolor")
						.monto(5_000_000L)
						.postulacionesPermitidas(100)
						.postulacionesDisponibles(90)
						.postulacionesFechaInicio( LocalDate.of(2022, 6, 1) )
						.postulacionesFechaTermino( LocalDate.of(2022, 6, 30) )
						.build()
				;
				concursoRepository.save(concurso);
				
				Empresa empresa = Empresa.builder()
										.rut("99888777-k")
										.razonSocial("Prueba SA") 
										.email("contacto@prueba.cl")
										.contrasena("4321")
										.build()
				;
				empresaService.crearEmpresa(empresa);
				
				empresa = Empresa.builder()
						.rut("77888999-k")
						.razonSocial("Vendeya SpA.") 
						.email("contacto@vendeya.cl")
						.contrasena("1234")
						.build()
				;
				
				empresaService.crearEmpresa(empresa);
			}
		};
	}

}
