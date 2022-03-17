package bg.softuni.demo.zoo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ZooService {

  private final Animal animal1;
  private final Animal animal2;
  private final Animal animal3;

  public ZooService(
      @Qualifier("dog") Animal animal1,
      @Qualifier("superCat") Animal animal2,
      @Qualifier("superCat") Animal animal3) {
    this.animal1 = animal1;
    this.animal2 = animal2;
    this.animal3 = animal3;
  }

  public void greet() {
    animal1.greet();
    animal2.greet();
    animal3.greet();
  }
}
