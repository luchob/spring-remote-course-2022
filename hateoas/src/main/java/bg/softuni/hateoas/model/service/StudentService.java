package bg.softuni.hateoas.model.service;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.dto.StudentDTO;
import java.util.List;
import java.util.Optional;

public interface StudentService {
  Optional<StudentDTO> findStudentById(Long studentId);

  List<StudentDTO> findAllStudents();
}
