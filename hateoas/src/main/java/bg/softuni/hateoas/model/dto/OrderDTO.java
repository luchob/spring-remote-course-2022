package bg.softuni.hateoas.model.dto;

public class OrderDTO {

  private Long id;
  private long studentId;
  private long courseId;

  public Long getId() {
    return id;
  }

  public OrderDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public long getStudentId() {
    return studentId;
  }

  public OrderDTO setStudentId(long studentId) {
    this.studentId = studentId;
    return this;
  }

  public long getCourseId() {
    return courseId;
  }

  public OrderDTO setCourseId(long courseId) {
    this.courseId = courseId;
    return this;
  }

  @Override
  public String toString() {
    return "OrderDTO{" +
        "id=" + id +
        ", studentId=" + studentId +
        ", courseId=" + courseId +
        '}';
  }
}
