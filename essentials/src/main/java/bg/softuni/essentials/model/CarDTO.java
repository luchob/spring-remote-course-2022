package bg.softuni.essentials.model;

public class CarDTO {

  private final long id;
  private final String make, model;
  private final EngineEnum engine;
  private final boolean insured;

  public CarDTO(long id, String make, String model, EngineEnum engine, boolean insured) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.engine = engine;
    this.insured = insured;
  }

  public long getId() {
    return id;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public EngineEnum getEngine() {
    return engine;
  }

  public boolean isInsured() {
    return insured;
  }

  @Override
  public String toString() {
    return "CarDTO{" +
        "id=" + id +
        ", make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", engine=" + engine +
        ", insured=" + insured +
        '}';
  }
}
