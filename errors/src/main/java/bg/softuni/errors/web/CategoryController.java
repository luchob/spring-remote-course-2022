package bg.softuni.errors.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/categories")
@Controller
public class CategoryController {

  @GetMapping("/{id}")
  public String getProductById(@PathVariable("id") String id) {
    // we could not find the product
    throw new CategoryNotFoundException(id);
  }

  // Uncomment if global exception handling (ObjectNotFoundAdvise) is disabled
  //@ExceptionHandler(CategoryNotFoundException.class)
  public ModelAndView onCategoryNotFound(CategoryNotFoundException ex) {
    ModelAndView modelAndView = new ModelAndView("category-not-found");
    modelAndView.setStatus(HttpStatus.NOT_FOUND);
    modelAndView.addObject("categoryId", ex.getCategoryId());
    return modelAndView;
  }
}
