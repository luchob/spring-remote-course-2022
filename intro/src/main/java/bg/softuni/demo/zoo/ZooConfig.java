package bg.softuni.demo.zoo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {

  @Bean
  public Animal dog() {
    return new Dog();
  }

  @Bean("superCat")
  public Animal cat() {
    return new Cat();
  }

}
