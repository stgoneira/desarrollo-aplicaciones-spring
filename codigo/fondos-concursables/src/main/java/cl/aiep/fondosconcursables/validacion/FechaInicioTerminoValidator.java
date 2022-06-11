package cl.aiep.fondosconcursables.validacion;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cl.aiep.fondosconcursables.modelo.Concurso;

public class FechaInicioTerminoValidator 
	implements ConstraintValidator<FechaInicioTermino, Concurso>
{

	@Override
	public boolean isValid(Concurso concurso, ConstraintValidatorContext context) {
		LocalDate fechaInicio 	= concurso.getPostulacionesFechaInicio();
		LocalDate fechaTermino 	= concurso.getPostulacionesFechaTermino();
		
		if( fechaInicio == null || fechaTermino == null) {
			context.buildConstraintViolationWithTemplate("Las fechas no pueden ser nulas");
			return false;
		}
		
		if( fechaInicio.isBefore(fechaTermino) ) {
			return true; // es válido 
		} else {
			return false;
		}
	}

}
