package bg.softuni.errors.config;

import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ExceptionConfig {

  // uncomment to handle NPE-s with own resolver
//  @Bean
//  public HandlerExceptionResolver customHandlerExceptionResolver() {
//    return (request, response, handler, ex) -> {
//      if (ex.getClass() == NullPointerException.class) {
//        return new ModelAndView("npe-resolved");
//      }
//      return null;
//    };
//  }

  // uncomment to handle NPE-s with SimpleMappingExceptionResolver
//  @Bean
//  public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
//    SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//
//    Properties properties = new Properties();
//    properties.setProperty(NullPointerException.class.getSimpleName(), "npe-resolved");
//
//    resolver.setExceptionMappings(properties);
//
//    return resolver;
//  }
}
