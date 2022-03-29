package bg.softuni.essentials.service.impl;

import bg.softuni.essentials.model.CarDTO;
import bg.softuni.essentials.model.EngineEnum;
import bg.softuni.essentials.service.CarService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

  private List<CarDTO> allCars = List.of(
      new CarDTO(1, "Ford", "Fiesta", EngineEnum.GASOLINE, true),
      new CarDTO(2, "Toyota", "Yaris", EngineEnum.DIESEL, false)
  );

  @Override
  public List<CarDTO> getAllCars() {
    return allCars;
  }

  @Override
  public Optional<CarDTO> findById(long id) {
    return allCars.
        stream().
        filter(c -> c.getId() == id).
        findAny();
  }
}
