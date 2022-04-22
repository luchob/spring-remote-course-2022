package bg.softuni.errors.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    // lets make a stupid bug
    String name = null;
    int size = name.length();

    return "hello";
  }

}
