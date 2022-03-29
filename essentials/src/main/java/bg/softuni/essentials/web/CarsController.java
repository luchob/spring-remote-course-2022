package bg.softuni.essentials.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarsController {

  @GetMapping("/all")
  public String all() {
    return "all";
  }

  @GetMapping("/details")
  public String details() {
    return "details";
  }
}
