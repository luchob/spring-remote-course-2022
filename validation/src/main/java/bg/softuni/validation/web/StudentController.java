package bg.softuni.validation.web;

import bg.softuni.validation.model.StudentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

  @ModelAttribute("studentModel")
  public void initModel(Model model) {
    model.addAttribute("studentModel", model);
  }

  @GetMapping("/add")
  public String add() {
    return "student-add";
  }

  @PostMapping("/add")
  public String add(@ModelAttribute("studentModel")
      StudentDTO studentModel) {
    return "student-add";
  }

}
