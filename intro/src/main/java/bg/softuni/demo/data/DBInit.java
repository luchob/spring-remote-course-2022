package bg.softuni.demo.data;

import bg.softuni.demo.data.model.dto.CreateOwnerDTO;
import bg.softuni.demo.data.service.OwnerService;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

  private final OwnerService ownerService;

  public DBInit(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @Override
  public void run(String... args) throws Exception {
    CreateOwnerDTO owner1 = new
        CreateOwnerDTO().
        setOwnerFirstName("Lucho").
        setOwnerLastName("Balev").
        setCats(List.of("Filthy", "Cat2"));

    CreateOwnerDTO owner2 = new
        CreateOwnerDTO().
        setOwnerFirstName("Nina").
        setOwnerLastName("Bojinova").
        setCats(List.of("Chinchila"));

    ownerService.createOwner(owner1);
    ownerService.createOwner(owner2);
  }
}
