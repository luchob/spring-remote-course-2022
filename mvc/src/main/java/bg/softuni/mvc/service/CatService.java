package bg.softuni.mvc.service;

import bg.softuni.mvc.model.CatDTO;
import java.util.List;
import java.util.Optional;

public interface CatService {

  List<CatDTO> getAllCats();

  Optional<CatDTO> getCatById(Long id);

  long createCat(CatDTO cat);

  void deleteCat(Long id);
}
