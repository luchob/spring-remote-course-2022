package bg.softuni.validation.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import bg.softuni.validation.model.SexEnum;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private LocalDate birthday;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private SexEnum sex;
  @Column(nullable = false)
  private String email;

  public Long getId() {
    return id;
  }

  public StudentEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public StudentEntity setName(String name) {
    this.name = name;
    return this;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public StudentEntity setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  public SexEnum getSex() {
    return sex;
  }

  public StudentEntity setSex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public StudentEntity setEmail(String email) {
    this.email = email;
    return this;
  }

  @Override
  public String toString() {
    return "StudentEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", birthday=" + birthday +
        ", sex=" + sex +
        ", email='" + email + '\'' +
        '}';
  }
}
