package org.ministere.annuaire.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.*;

import javax.validation.*;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueDirectionValidator.class)
@Documented

public @interface UniqueDirection {
	String message() default "";
	  Class<?>[] groups() default {};
	  Class<? extends Payload>[] payload() default {};
}
