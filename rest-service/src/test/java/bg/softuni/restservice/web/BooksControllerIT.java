package bg.softuni.restservice.web;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bg.softuni.restservice.model.entity.AuthorEntity;
import bg.softuni.restservice.model.entity.BookEntity;
import bg.softuni.restservice.repository.AuthorRepository;
import bg.softuni.restservice.repository.BookRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class BooksControllerIT {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  BookRepository bookRepository;

  @Autowired
  AuthorRepository authorRepository;

  private AuthorEntity testAuthor;
  private BookEntity testBook1;
  private BookEntity testBook2;

  @BeforeEach
  void setUp() {
    bookRepository.deleteAll();

    testAuthor = new AuthorEntity().setName("Joshua Bloch");

    testAuthor = authorRepository.save(testAuthor);

    testBook1 = new BookEntity().
        setTitle("Effective Java").
        setIsbn("978-0134685991").
        setAuthor(testAuthor);

    testBook2 = new BookEntity().
        setTitle("Java™ Puzzlers: Traps, Pitfalls, and Corner Cases").
        setIsbn("978-0321336781").
        setAuthor(testAuthor);

    testAuthor.setBooks(List.of(testBook1, testBook2));

    bookRepository.saveAll(List.of(testBook1, testBook2));
  }

  @AfterEach
  void tearDown() {
    bookRepository.deleteAll();
  }

  @Test
  void testGetAllBooks() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/books")).
        andExpect(status().isOk()).
        andExpect(jsonPath("$", hasSize(2))).
        andExpect(jsonPath("$.[0].title", is(testBook1.getTitle()))).
        andExpect(jsonPath("$.[0].author.name", is(testAuthor.getName()))).
        andExpect(jsonPath("$.[1].title", is(testBook2.getTitle()))).
        andExpect(jsonPath("$.[1].author.name", is(testAuthor.getName())));
  }

}
