package cl.aiep.fondosconcursables.validacion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RutValidator 
 	implements ConstraintValidator<Rut, String>
{

	@Override
	public boolean isValid(String rutStr, ConstraintValidatorContext context) {
		String[] rutArr = rutStr.split("-");
		if(rutArr.length != 2) {
			return false;
		}
		
		int rut = Integer.parseInt( rutArr[0] );
		char dv = rutArr[1].charAt(0);
		return validarRut(rut, dv);
	}

	public boolean validarRut(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }
}
