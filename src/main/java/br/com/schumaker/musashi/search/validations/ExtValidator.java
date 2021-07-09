package br.com.schumaker.musashi.search.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Hudson Schumaker
 */
public class ExtValidator implements ConstraintValidator<Ext, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
