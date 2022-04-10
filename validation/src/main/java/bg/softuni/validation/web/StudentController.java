package bg.softuni.validation.web;

import bg.softuni.validation.model.StudentDTO;
import bg.softuni.validation.service.StudentService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

  private static final Logger LOGGER = LoggerFactory.
      getLogger(StudentController.class);
  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @ModelAttribute("studentModel")
  public void initModel(Model model) {
    model.addAttribute("studentModel", new StudentDTO());
  }

  @GetMapping("/detials")
  public String details(@RequestParam("studentId") String studentId) {
    //TODO
    return "student-details";
  }

  @GetMapping("/add")
  public String add() {
    return "student-add";
  }

  @PostMapping("/add")
  public String add(@Valid @ModelAttribute("studentModel") StudentDTO studentModel,
      BindingResult bindingResult,
      RedirectAttributes rAtt) {

    if(bindingResult.hasErrors()){

      LOGGER.info("Student received: {}", studentModel);

      rAtt.addFlashAttribute("studentModel", studentModel);
      rAtt.addFlashAttribute("org.springframework.validation.BindingResult.studentModel",
          bindingResult);
      return "redirect:/students/add";
    }

    rAtt.addAttribute("studentId",
        studentService.createStudent(studentModel));
    return "redirect:/students/details";
  }

}
