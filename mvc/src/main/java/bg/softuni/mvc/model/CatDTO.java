package bg.softuni.mvc.model;

public class CatDTO {

  private Long id;
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public CatDTO setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public CatDTO setAge(int age) {
    this.age = age;
    return this;
  }

  public Long getId() {
    return id;
  }

  public CatDTO setId(Long id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "CatDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
