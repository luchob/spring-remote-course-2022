package bg.softuni.mvc.web;

import bg.softuni.mvc.model.CatDTO;
import bg.softuni.mvc.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cats")
public class CatController {

  private final CatService catService;

  public CatController(CatService catService) {
    this.catService = catService;
  }

  @GetMapping("/new")
  public String newCat() {
    return "new-cat";
  }

  @PostMapping
  public String createCat(CatDTO newCat) {

    long catId = catService.createCat(newCat);

    return "redirect:/cats/" + catId;
  }

  @GetMapping("/{id}")
  public String getCat(Model model, @PathVariable("id") Long id) {
    var cat = catService.getCatById(id).orElseThrow();
    model.addAttribute("cat", cat);

    return "cat";
  }


  @GetMapping
  public String getAllCats(Model model) {
    var allCats = catService.getAllCats();

    model.addAttribute("cats", allCats);

    return "all-cats";
  }

//
//  @DeleteMapping
//  public String deleteCat() {
//
//  }

}
