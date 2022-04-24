package bg.softuni.errors.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Uncomment if global exception handling (ObjectNotFoundAdvise) is disabled
//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product was not found!")
public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String message) {
    super(message);
  }
}
