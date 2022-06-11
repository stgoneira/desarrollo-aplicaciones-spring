package cl.aiep.fondosconcursables.validacion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RutValidator.class)
public @interface Rut {

	String message() default "{RUT incorrecto!!!}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
