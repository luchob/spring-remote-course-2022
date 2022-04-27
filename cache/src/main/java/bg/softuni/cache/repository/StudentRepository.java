package bg.softuni.cache.repository;

import bg.softuni.cache.model.StudentDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(StudentRepository.class);

  private final List<StudentDTO> allStudents = new ArrayList<>();

  public StudentRepository() {
    allStudents.add(new StudentDTO("Pesho", 21));
    allStudents.add(new StudentDTO("Anna", 32));
  }

  public List<StudentDTO> findAllStudents() {

    LOGGER.info("Fetching all students in repo...");

    return new ArrayList<>(allStudents);
  }

  public Optional<StudentDTO> findByName(String name) {
    LOGGER.info("Fetching a student by name {} in repo...", name);

    return allStudents.stream().filter(s -> s.getName().equals(name)).findAny();
  }

}
