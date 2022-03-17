package bg.softuni.demo.data.service.impl;

import bg.softuni.demo.data.model.dto.CreateOwnerDTO;
import bg.softuni.demo.data.model.entity.CatEntity;
import bg.softuni.demo.data.model.entity.OwnerEntity;
import bg.softuni.demo.data.repository.OwnerRepository;
import bg.softuni.demo.data.service.OwnerService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

  private final OwnerRepository ownerRepository;

  public OwnerServiceImpl(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public void createOwner(CreateOwnerDTO createOwnerDTO) {
    // my "business logic"
    OwnerEntity ownerEntity = new OwnerEntity().
        setFirstName(createOwnerDTO.getOwnerFirstName()).
        setLastName(createOwnerDTO.getOwnerLastName()).
        setCats(
            createOwnerDTO.
                getCats().
                stream().
                map(catName ->
                    new CatEntity().setName(catName)
                ).collect(Collectors.toList())
        );

    ownerEntity.getCats().forEach(c -> c.setOwner(ownerEntity));

    ownerRepository.save(ownerEntity);
  }
}
