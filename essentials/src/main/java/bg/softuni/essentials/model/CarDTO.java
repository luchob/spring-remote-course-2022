package bg.softuni.essentials.model;

public class CarDTO {

  private long id;
  private String make, model;
  private EngineEnum engine;
  private boolean insured;

  public CarDTO() {
  }

  public CarDTO(long id, String make, String model, EngineEnum engine, boolean insured) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.engine = engine;
    this.insured = insured;
  }

  public CarDTO setId(long id) {
    this.id = id;
    return this;
  }

  public CarDTO setMake(String make) {
    this.make = make;
    return this;
  }

  public CarDTO setModel(String model) {
    this.model = model;
    return this;
  }

  public CarDTO setEngine(EngineEnum engine) {
    this.engine = engine;
    return this;
  }

  public CarDTO setInsured(boolean insured) {
    this.insured = insured;
    return this;
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
