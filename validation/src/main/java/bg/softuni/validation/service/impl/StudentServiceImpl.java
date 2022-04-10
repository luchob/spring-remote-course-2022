package bg.softuni.validation.service.impl;

import bg.softuni.validation.model.dto.StudentDTO;
import bg.softuni.validation.repository.StudentRepository;
import bg.softuni.validation.service.StudentService;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final ModelMapper modelMapper;

  public StudentServiceImpl(StudentRepository studentRepository,
      ModelMapper modelMapper) {
    this.studentRepository = studentRepository;
    this.modelMapper = modelMapper;
  }

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
