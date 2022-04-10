package bg.softuni.validation.model.dto;

import bg.softuni.validation.model.SexEnum;
import bg.softuni.validation.model.validation.Adult;
import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class StudentDTO {

  @NotEmpty
  @Size(min=5, max = 50)
  private String name;

  @Adult
  @NotNull
  @DateTimeFormat(iso = ISO.DATE)
  private LocalDate birthday;
  @NotNull
  private SexEnum sex;
  @NotEmpty
  @Email
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
