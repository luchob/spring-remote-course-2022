package bg.softuni.validation.model.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AdultValidator.class)
public @interface Adult {

  String message() default "The candidate is not adult";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}

