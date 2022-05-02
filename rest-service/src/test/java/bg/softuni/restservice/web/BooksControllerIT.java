package bg.softuni.restservice.web;

import bg.softuni.restservice.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BooksControllerIT {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  BookRepository bookRepository;

  @BeforeEach
  void setUp() {

  }

  @AfterEach
  void tearDown() {

  }

}
