package bg.softuni.demo.data.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cats")
public class CatEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToOne
  private OwnerEntity owner;

  public Long getId() {
    return id;
  }

  public CatEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public CatEntity setName(String name) {
    this.name = name;
    return this;
  }

  public OwnerEntity getOwner() {
    return owner;
  }

  public CatEntity setOwner(OwnerEntity owner) {
    this.owner = owner;
    return this;
  }

  @Override
  public String toString() {
    return "CatEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", owner=" + (owner != null ? owner.getFirstName() + " " + owner.getLastName() : null)  +
        '}';
  }
}
