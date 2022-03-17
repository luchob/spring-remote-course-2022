package bg.softuni.demo.data.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class OwnerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "first_n")
  private String firstName;

  private String lastName;

  @OneToMany(
      mappedBy = "owner",
      cascade = CascadeType.ALL
  )
  private List<CatEntity> cats = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public OwnerEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public OwnerEntity setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public OwnerEntity setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public List<CatEntity> getCats() {
    return cats;
  }

  public OwnerEntity setCats(List<CatEntity> cats) {
    this.cats = cats;
    return this;
  }

  public OwnerEntity addCat(CatEntity cat) {
    this.cats.add(cat);
    return this;
  }

  @Override
  public String toString() {
    return "OwnerEntity{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", cats=" + cats +
        '}';
  }
}
