package bg.softuni.cache.model;

public class StudentDTO {

  private final String name;
  private final int age;

  public StudentDTO(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "StudentDTO{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
