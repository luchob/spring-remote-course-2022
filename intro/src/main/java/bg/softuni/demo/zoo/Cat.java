package bg.softuni.demo.zoo;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;

public class Cat implements Animal, BeanNameAware {

  private final int catNo;

  public Cat() {
    catNo = (new Random()).nextInt(10000);
    System.out.println("Instantiation phase of super cat no: " + catNo);
  }

  @Override
  public void greet() {
    System.out.println("Meow! I'm cat no. " + catNo);
  }

  @PostConstruct
  public void init() {
    System.out.println("Initializing cat no.: " + catNo);
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Kill cat no.: " + catNo);
  }

  @Override
  public void setBeanName(String name) {
    System.out.println("I'm cat named : " + name + " in the Spring IoC");
  }
}
