package bg.softuni.demo.data.model.dto;

import java.util.List;

public class CreateOwnerDTO {

  private String ownerFirstName;
  private String ownerLastName;
  private List<String> cats;

  public String getOwnerFirstName() {
    return ownerFirstName;
  }

  public CreateOwnerDTO setOwnerFirstName(String ownerFirstName) {
    this.ownerFirstName = ownerFirstName;
    return this;
  }

  public String getOwnerLastName() {
    return ownerLastName;
  }

  public CreateOwnerDTO setOwnerLastName(String ownerLastName) {
    this.ownerLastName = ownerLastName;
    return this;
  }

  public List<String> getCats() {
    return cats;
  }

  public CreateOwnerDTO setCats(List<String> cats) {
    this.cats = cats;
    return this;
  }

  @Override
  public String toString() {
    return "CreateOwnerDTO{" +
        "ownerFirstName='" + ownerFirstName + '\'' +
        ", ownerLastName='" + ownerLastName + '\'' +
        ", cats=" + cats +
        '}';
  }
}
