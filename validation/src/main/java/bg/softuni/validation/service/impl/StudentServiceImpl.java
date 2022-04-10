package bg.softuni.validation.service.impl;

import bg.softuni.validation.model.dto.StudentDTO;
import bg.softuni.validation.model.entity.StudentEntity;
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
    StudentEntity newStudent = modelMapper.map(studentDTO, StudentEntity.class);
    newStudent = studentRepository.save(newStudent);
    return newStudent.getId();
  }

  @Override
  public Optional<StudentDTO> findStudentById(Long studentId) {
    return studentRepository.
        findById(studentId).
        map(se -> modelMapper.map(se, StudentDTO.class));
  }
}
