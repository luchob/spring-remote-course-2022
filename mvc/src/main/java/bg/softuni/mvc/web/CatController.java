package bg.softuni.mvc.web;

import bg.softuni.mvc.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cats")
public class CatController {

  private final CatService catService;

  public CatController(CatService catService) {
    this.catService = catService;
  }

//  @GetMapping
//  public String getAllCats() {
//
//  }

//  @GetMapping("/{id}")
//  public String getCat() {
//
//  }
//
//  @PostMapping
//  public String createCat() {
//
//  }
//
//  @DeleteMapping
//  public String deleteCat() {
//
//  }

}
