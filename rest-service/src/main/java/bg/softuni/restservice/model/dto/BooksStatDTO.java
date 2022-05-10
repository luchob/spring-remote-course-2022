package bg.softuni.restservice.model.dto;

public class BooksStatDTO {

  private long booksCnt;

  public long getBooksCnt() {
    return booksCnt;
  }

  public BooksStatDTO setBooksCnt(long booksCnt) {
    this.booksCnt = booksCnt;
    return this;
  }
}
