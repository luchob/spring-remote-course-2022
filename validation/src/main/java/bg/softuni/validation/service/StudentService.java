package bg.softuni.validation.service;

import bg.softuni.validation.model.dto.StudentDTO;
import java.util.Optional;

public interface StudentService {

  Long createStudent(StudentDTO studentDTO);

  Optional<StudentDTO> findStudentById(Long studentId);

}
