package bg.softuni.errors.web;

public class RestErrorInfo {

  private final String id;
  private final String message;

  public RestErrorInfo(String id, String message) {
    this.id = id;

    this.message = message;
  }

  public String getId() {
    return id;
  }

  public String getMessage() {
    return message;
  }
}
