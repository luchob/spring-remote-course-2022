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

  public void boom() {
    throw new NullPointerException("Something wrong happend!");
  }

  public void echo(String whatToEcho) {
    LOGGER.info("Within echo! To echo: {}", whatToEcho);
  }

  public String concat(String a, String b) {
    LOGGER.info("Within concat! To concat: {}, {}", a, b);
    return a + b;
  }
}
