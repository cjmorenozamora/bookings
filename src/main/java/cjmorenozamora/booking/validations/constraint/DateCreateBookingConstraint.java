package cjmorenozamora.booking.validations.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;

import cjmorenozamora.booking.validations.implementations.DateCreateBookingImpl;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
		ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { DateCreateBookingImpl.class })
public @interface DateCreateBookingConstraint {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
