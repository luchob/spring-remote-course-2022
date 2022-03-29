package bg.softuni.essentials.service.impl;

import bg.softuni.essentials.model.CarDTO;
import bg.softuni.essentials.model.EngineEnum;
import bg.softuni.essentials.service.CarService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

  private List<CarDTO> allCars = List.of(
      new CarDTO("Ford", "Fiesta", EngineEnum.PETROL, true),
      new CarDTO("Toyota", "Yaris", EngineEnum.DIESEL, false)
  );

  @Override
  public List<CarDTO> getAllCars() {
    return allCars;
  }
}
