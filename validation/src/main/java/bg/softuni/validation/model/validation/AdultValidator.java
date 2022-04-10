package bg.softuni.validation.model.validation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AdultValidator
    implements ConstraintValidator<Adult, LocalDate> {

  @Override
  public void initialize(Adult constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    LocalDate now = LocalDate.now();
    long years = value.until(now, ChronoUnit.YEARS);

    return years >= 18;
  }
}
