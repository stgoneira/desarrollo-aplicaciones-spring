package cl.aiep.fondosconcursables;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.aiep.fondosconcursables.modelo.Administrador;
import cl.aiep.fondosconcursables.modelo.Concurso;
import cl.aiep.fondosconcursables.modelo.Empresa;
import cl.aiep.fondosconcursables.repositorio.ConcursoRepository;
import cl.aiep.fondosconcursables.servicio.AdministradorService;
import cl.aiep.fondosconcursables.servicio.EmpresaService;

@SpringBootApplication
public class FondosConcursablesApplication {

	@Autowired
	ConcursoRepository concursoRepository;
	
	@Autowired 
	EmpresaService empresaService;
	
	@Autowired
	AdministradorService administradorService;
	
	public static void main(String[] args) {
		SpringApplication.run(FondosConcursablesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner datosIniciales() {
		return (args) -> {
			if( concursoRepository.count() == 0) {
				Administrador admin = Administrador.builder()
											.usuario("admin")
											.contrasena("1234")
											.build()
				;
				administradorService.crearAdministrador(admin);
				// ------------------------------------
				
				Empresa empresa = Empresa.builder()
						.rut("12345678-5")
						.razonSocial("Prueba SA") 
						.email("contacto@prueba.cl")
						.contrasena("1234")
						.build()
				;
				empresaService.crearEmpresa(empresa);
				
				empresa = Empresa.builder()
						.rut("78827280-4")
						.razonSocial("Vendeya SpA.") 
						.email("contacto@vendeya.cl")
						.contrasena("4321")
						.build()
				;
				
				empresaService.crearEmpresa(empresa);
				// --------------------------------------
				Concurso concurso = Concurso.builder() 
										.cupos(50)
										.titulo("Capital Semilla")
										.descripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer malesuada, lorem eget vehicula ultrices, massa tellus rhoncus lacus, id condimentum neque ex in nisi. Integer quis lobortis risus. Vivamus lacinia eleifend eros, suscipit laoreet mi ullamcorper vel. Nullam vulputate mauris eros, quis volutpat velit venenatis in. Mauris id orci ac augue dapibus venenatis eget ac dui. Fusce luctus mi mattis sapien fermentum placerat. In at iaculis nibh, eu tempus urna. Praesent ac risus mauris. Etiam in mauris nisl. Duis metus urna, varius vitae neque in, tincidunt ultricies metus. Nunc ligula metus, pulvinar non laoreet a, rutrum quis tellus. ")
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
						.descripcion("In ultrices elit ut est auctor, in interdum nulla auctor. Nullam ac ipsum ut eros fringilla interdum. Pellentesque non euismod est. Integer mi purus, venenatis non mi at, varius aliquam purus. Sed viverra dictum ex congue ultrices. Integer ullamcorper elementum risus, ac rutrum sapien commodo nec. Nulla facilisi. Praesent orci ante, pretium a dolor id, rhoncus euismod augue. Morbi sit amet velit efficitur, convallis felis ut, ullamcorper diam. ")
						.monto(5_000_000L)
						.postulacionesPermitidas(100)
						.postulacionesDisponibles(90)
						.postulacionesFechaInicio( LocalDate.of(2022, 6, 1) )
						.postulacionesFechaTermino( LocalDate.of(2022, 6, 30) )
						.build()
				;
				concursoRepository.save(concurso);
				
				concurso = Concurso.builder() 
						.cupos(20)
						.titulo("FONDEVE")
						.descripcion("Pellentesque vitae urna nisl. Mauris rutrum arcu et nulla sodales, non imperdiet ex porta. Fusce purus libero, tincidunt et justo ut, rhoncus tristique tortor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce lorem odio, lobortis quis malesuada eget, finibus ac orci. Proin ut bibendum enim. ")
						.monto(10_000_000L)
						.postulacionesPermitidas(30)
						.postulacionesDisponibles(30)
						.postulacionesFechaInicio( LocalDate.of(2022, 8, 1) )
						.postulacionesFechaTermino( LocalDate.of(2022, 10, 30) )
						.build()
				;
				concursoRepository.save(concurso);				
			}
		};
	}

}
