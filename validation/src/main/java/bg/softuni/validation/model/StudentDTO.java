package bg.softuni.validation.model;

import java.time.LocalDate;

public class StudentDTO {

  private String name;
  private LocalDate birthday;
  private SexEnum sex;

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

  @Override
  public String toString() {
    return "StudentDTO{" +
        "name='" + name + '\'' +
        ", birthday=" + birthday +
        ", sex=" + sex +
        '}';
  }
}
