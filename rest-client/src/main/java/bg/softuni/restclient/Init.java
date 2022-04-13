package bg.softuni.restclient;

import bg.softuni.restclient.model.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class Init implements CommandLineRunner {

  private final Logger LOGGER = LoggerFactory.getLogger(Init.class);
  private final String BOOKS_API_URL = "http://localhost:8080/api/books";
  private final RestOperations restTemplate;

  public Init(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
    ResponseEntity<BookDTO[]> allBooksResponse =
        restTemplate.getForEntity(BOOKS_API_URL, BookDTO[].class);

    if (allBooksResponse.hasBody()) {
      BookDTO[] allBooks = allBooksResponse.getBody();

      for (BookDTO aBook: allBooks) {
        LOGGER.info("A book: {}", aBook);
      }
    }
  }
}
