package bg.softuni.essentials.web;

import bg.softuni.essentials.model.CarDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModelAttribDemoController {

  @ModelAttribute
  public void addAttribute(Model model) {
    model.addAttribute("message", "Hello, world!");

    CarDTO car = new CarDTO().setModel("Yaris");
    model.addAttribute("car", car);
  }

  @GetMapping("/modelattrib")
  public String modelAttrib() {
    return "modelattrib";
  }

  @GetMapping("/modelattrib1")
  public String modelAttrib1() {
    return "modelattrib";
  }

  @PostMapping("/modelattrib1/car")
  public String modelAttribCar(/*@ModelAttribute("car")*/ CarDTO car) {

    System.out.println("Car: " + car);

    return "modelattrib";
  }

}
