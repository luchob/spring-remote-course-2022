package bg.softuni.demo.web;

import bg.softuni.demo.zoo.ZooService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  private final ZooService zooService;

  public HelloController(ZooService zooService) {
    this.zooService = zooService;
  }

  @GetMapping("/home")
  public String home() {

    zooService.greet();
    return "home";
  }
}
