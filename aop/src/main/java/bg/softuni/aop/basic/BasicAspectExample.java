package bg.softuni.aop.basic;

import bg.softuni.aop.Student;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BasicAspectExample {

  private Logger LOGGER = LoggerFactory.getLogger(BasicAspectExample.class);

  @Pointcut("execution(* bg.softuni.aop.Student.*(..))")
  void onAllStudentMethods(){

  }

  @Pointcut("execution(* bg.softuni.aop.Student.echo(..))")
  void onEchoCalled(){

  }

  @After("onEchoCalled()")
  void afterEcho() {
    LOGGER.info("After echo had been called.");
  }

  @Before("onAllStudentMethods()")
  void beforeEachMethod(JoinPoint jp) {
    LOGGER.info("Before method {} is triggered with arg {}",
        jp.getSignature(),
        Arrays.asList(jp.getArgs()));
  }

  @AfterReturning(value = "onAllStudentMethods()",
    returning = "returnedValue")
  void afterReturning(
      JoinPoint jp,
      Object returnedValue) {
    LOGGER.info("Method {} returned {}",
        jp.getSignature(), returnedValue);
  }

  @AfterThrowing(value = "onAllStudentMethods()",
      throwing = "error")
  void afterThrowing(
      JoinPoint jp,
      Exception error
  ) {
    LOGGER.info("Method {} throwed exception with message {}",
        jp.getSignature(), error.getMessage());
  }
}
