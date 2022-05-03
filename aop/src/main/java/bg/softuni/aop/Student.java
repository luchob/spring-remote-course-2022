package bg.softuni.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Student {

  private Logger LOGGER = LoggerFactory.getLogger(Student.class);

  public void saySomething() {
    LOGGER.info("Within saySomething!");
  }

  public String returnSomething() {
    String res = "Hello, world!";
    LOGGER.info("Within returnSomething! Return: {}", res);
    return res;
  }

  public void echo(String whatToEcho) {
    LOGGER.info("Within echo! To echo: {}", whatToEcho);
  }

  public String concat(String a, String b) {
    LOGGER.info("Within concat! To concat: {}, {}", a, b);
    return a + b;
  }
}
