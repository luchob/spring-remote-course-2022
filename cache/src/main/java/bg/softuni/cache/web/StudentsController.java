package bg.softuni.cache.web;

import bg.softuni.cache.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(StudentsController.class);

  private final StudentService studentService;

  public StudentsController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/findAll")
  public String findAll() {
    LOGGER.info("findAll endpoint called. All students: {}", studentService.findAllStudents());
    return "done";
  }

  @GetMapping("/findByName")
  public String findByName(@RequestParam("name") String name) {
    LOGGER.info("findByName endpoint called. Student: {}", studentService.findStudentByName(name));
    return "done";
  }

  @GetMapping("/refresh")
  public String refresh() {
    LOGGER.info("refresh endpoint called.");
    studentService.clearCache();
    studentService.refresh();
    return "done";
  }

}
