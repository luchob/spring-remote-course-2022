package bg.softuni.errors.web;

public class StudentNotFoundException extends RuntimeException {

  private final String studentId;

  public StudentNotFoundException(String studentId) {
    this.studentId = studentId;
  }

  public String getStudentId() {
    return studentId;
  }


}
