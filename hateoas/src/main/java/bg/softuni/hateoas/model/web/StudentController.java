package bg.softuni.hateoas.model.web;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.model.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/students")
@RestController
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping ("/{id}")
  public ResponseEntity<EntityModel<StudentDTO>> getStudentById(@PathVariable("id") Long id) {

    Optional<StudentDTO> studentDTOOpt = studentService.findStudentById(id);
    if (studentDTOOpt.isEmpty()){
      return ResponseEntity.
          notFound().
          build();
    }

    var studentDto = studentDTOOpt.get();

    return ResponseEntity.ok(
        EntityModel.of(studentDto, createStudentLinks(studentDto))
    );
  }

  @GetMapping
  public ResponseEntity<CollectionModel<EntityModel<StudentDTO>>>
      getAllStudents() {
    throw new UnsupportedOperationException("Not yet");
  }

  @PostMapping("/{id}")
  public EntityModel<StudentDTO> updateStudent(@PathVariable("id") Long id,
      StudentDTO studentDTO) {
    throw new UnsupportedOperationException("Not yet");
  }

  @GetMapping("/{id}/orders")
  public CollectionModel<EntityModel<OrderDTO>> getStudentOrders(@PathVariable("id") Long studentId) {
    throw new UnsupportedOperationException("Not yet");
  }

  private Link[] createStudentLinks(StudentDTO studentDTO) {
    //self
    //update
    //orders
    List<Link> result = new ArrayList<>();

    Link self = linkTo(methodOn(StudentController.class).
        getStudentById(studentDTO.getId())).withSelfRel();

    Link update = linkTo(methodOn(StudentController.class).
        updateStudent(studentDTO.getId(), studentDTO)).withRel("update");

    Link orders = linkTo(methodOn(StudentController.class).
        getStudentOrders(studentDTO.getId())).withRel("orders");

    result.addAll(List.of(self, update, orders));

    return result.toArray(new Link[0]);
  }


}
