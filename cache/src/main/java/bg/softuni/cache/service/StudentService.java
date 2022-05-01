package bg.softuni.cache.service;

import bg.softuni.cache.model.StudentDTO;
import bg.softuni.cache.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);


  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Cacheable("students")
  public List<StudentDTO> findAllStudents() {
    LOGGER.info("Find All students in service called");
    return studentRepository.findAllStudents();
  }

  @Cacheable("students")
  public Optional<StudentDTO> findStudentByName(String name) {
    LOGGER.info("Find Student by name {} in service called", name);
    return studentRepository.findByName(name);
  }

  @CachePut("students")
  public List<StudentDTO> refresh() {
    LOGGER.info("Refresh in service called");
    studentRepository.refresh();

    return studentRepository.findAllStudents();
  }

  @CacheEvict(
      cacheNames = "students",
      allEntries = true
  )
  public void clearCache() {}

}
