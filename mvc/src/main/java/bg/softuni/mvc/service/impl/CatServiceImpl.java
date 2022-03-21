package bg.softuni.mvc.service.impl;

import bg.softuni.mvc.model.CatDTO;
import bg.softuni.mvc.service.CatService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {

  private long id = 0;
  private Map<Long, CatDTO> allCats = new HashMap<>();

  @Override
  public List<CatDTO> getAllCats() {
    return new ArrayList<>(allCats.values());
  }

  @Override
  public Optional<CatDTO> getCatById(Long id) {
    return Optional.ofNullable(allCats.get(id));
  }

  @Override
  public long createCat(CatDTO cat) {
    id++;
    allCats.put(id, cat.setId(id));
    return id;
  }

  @Override
  public void deleteCat(Long id) {
    allCats.remove(id);
  }
}
