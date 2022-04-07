package bg.softuni.validation.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDTO {

  @NotNull
  @Size(min=5, max = 50)
  private String name;
  private LocalDate birthday;
  private SexEnum sex;
  private String email;

  public String getName() {
    return name;
  }

  public StudentDTO setName(String name) {
    this.name = name;
    return this;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public StudentDTO setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  public SexEnum getSex() {
    return sex;
  }

  public StudentDTO setSex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public StudentDTO setEmail(String email) {
    this.email = email;
    return this;
  }

  @Override
  public String toString() {
    return "StudentDTO{" +
        "name='" + name + '\'' +
        ", birthday=" + birthday +
        ", sex=" + sex +
        ", email='" + email + '\'' +
        '}';
  }
}
