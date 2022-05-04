package bg.softuni.aop.basic;

import bg.softuni.aop.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
    value = "examples.basic.enabled",
    havingValue = "true"
)
public class BasicExample implements CommandLineRunner {

  private final Student student;

  public BasicExample(Student student) {
    this.student = student;
  }

  @Override
  public void run(String... args) throws Exception {
    student.saySomething();
    student.echo("Arg to echo");
    student.concat("Arg1", "Arg2");
    try {
      student.boom();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
