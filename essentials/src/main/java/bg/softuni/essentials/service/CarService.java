package bg.softuni.essentials.service;

import bg.softuni.essentials.model.CarDTO;
import java.util.List;
import java.util.Optional;

public interface CarService {

  List<CarDTO> getAllCars();

  Optional<CarDTO> findById(long id);

}
