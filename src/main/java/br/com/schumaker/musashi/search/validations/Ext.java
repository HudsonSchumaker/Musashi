package br.com.schumaker.musashi.search.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * @author Hudson Schumaker
 */

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ExtValidator.class)
@Documented
public @interface Ext {
    String message() default "Ext is not allowed.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
