package bg.softuni.validation.service.impl;

import bg.softuni.validation.model.StudentDTO;
import bg.softuni.validation.service.StudentService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Override
  public Long createStudent(StudentDTO studentDTO) {
    // TODO
    throw new UnsupportedOperationException("Not yet");
  }

  @Override
  public Optional<StudentDTO> findStudentById(Long studentId) {
    // TODO
    throw new UnsupportedOperationException("Not yet");
  }
}
