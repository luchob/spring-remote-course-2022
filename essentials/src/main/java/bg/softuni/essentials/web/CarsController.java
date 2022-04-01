package bg.softuni.essentials.web;

import bg.softuni.essentials.model.CarDTO;
import bg.softuni.essentials.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
  public String details(@RequestParam("id") long id,
      Model model) {

    model.addAttribute("car", carService.findById(id).orElseThrow());

    return "details";
  }

  @CrossOrigin("https://www.google.com/")
  @ResponseBody
  @GetMapping("/{id}")
  public CarDTO findCarById(@PathVariable("id") Long id) {
    return carService.findById(id).orElseThrow();
  }
}
