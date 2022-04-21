package bg.softuni.hateoas.model.service.impl;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.model.entity.OrderEntity;
import bg.softuni.hateoas.model.entity.StudentEntity;
import bg.softuni.hateoas.model.repository.StudentRepository;
import bg.softuni.hateoas.model.service.StudentService;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Optional<StudentDTO> findStudentById(Long studentId) {
    return studentRepository.
        findById(studentId).
        map(this::mapStudent);
  }

  private StudentDTO mapStudent(StudentEntity studentEntity) {
    StudentDTO result = new StudentDTO();

    var studentOrders =
        studentEntity.
            getOrders().
            stream().
            map(this::mapOrder).
            collect(Collectors.toList());

    result.
        setId(studentEntity.getId()).
        setName(studentEntity.getName()).
        setAge(studentEntity.getAge()).
        setDeleted(studentEntity.isDeleted()).
        setOrders(studentOrders);

    return result;
  }

  private OrderDTO mapOrder(OrderEntity orderEntity) {

    return new OrderDTO().
        setStudentId(orderEntity.getStudent().getId()).
        setCourseId(orderEntity.getCourse().getId()).
        setId(orderEntity.getId());
  }
}
