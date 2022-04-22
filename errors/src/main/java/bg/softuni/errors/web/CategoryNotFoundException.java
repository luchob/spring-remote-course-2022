package bg.softuni.errors.web;

public class CategoryNotFoundException extends RuntimeException{

  private final String categoryId;

  public CategoryNotFoundException(String categoryId) {
    super("category with id " + categoryId + " not found!");
    this.categoryId = categoryId;
  }

  public String getCategoryId() {
    return categoryId;
  }
}
