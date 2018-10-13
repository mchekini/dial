package com.workshop.back.authentication.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.workshop.back.authentication.validations.Error.E01;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = CheckLoginValidator.class)
public @interface CheckLogin {

    /**
     * @return the associated error code.
     */
    Error error() default E01;

    /**
     * @return the error message template.
     */
    String message() default "{com.france.rte.eod.fopo.document.offer.constraints.IsDivisible.message}";

    /**
     * @return the groups the constraint belongs to
     */
    Class<?>[] groups() default {};

    /**
     * @return the payload associated to the constraint
     */
    Class<? extends Payload>[] payload() default {};


}
