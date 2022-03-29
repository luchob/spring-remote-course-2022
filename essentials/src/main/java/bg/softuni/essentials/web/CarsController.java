package bg.softuni.essentials.web;

import bg.softuni.essentials.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarsController {

  private final CarService carService;

  public CarsController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping("/all")
  public String all(Model model) {

    model.addAttribute("cars", carService.getAllCars());

    return "all";
  }

  @GetMapping("/details")
  public String details() {
    return "details";
  }
}
