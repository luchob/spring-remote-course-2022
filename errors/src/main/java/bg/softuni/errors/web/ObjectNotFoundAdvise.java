package bg.softuni.errors.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ObjectNotFoundAdvise {

  @ExceptionHandler({
      CategoryNotFoundException.class,
      ProductNotFoundException.class
  })
  public ModelAndView objectNotFoundException() {
    ModelAndView result = new ModelAndView();

    result.setViewName("object-not-found");
    result.setStatus(HttpStatus.NOT_FOUND);
    return result;
  }

}
