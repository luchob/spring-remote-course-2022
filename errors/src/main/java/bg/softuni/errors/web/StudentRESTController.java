package bg.softuni.errors.web;

import bg.softuni.errors.student.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentRESTController {

  @GetMapping("/{id}")
  public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") String studentId) {
    throw new StudentNotFoundException(studentId);
  }

  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  @ExceptionHandler({StudentNotFoundException.class})
  public RestErrorInfo handleNotFoundException(StudentNotFoundException sne) {
    return new RestErrorInfo(
        sne.getStudentId(),
        "Student not found!"
    );
  }

}
