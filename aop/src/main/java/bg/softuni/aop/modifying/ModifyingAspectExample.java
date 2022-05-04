package bg.softuni.aop.modifying;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnProperty(
    value = "examples.modifying.enabled",
    havingValue = "true"
)
public class ModifyingAspectExample {

  @Pointcut("execution(* bg.softuni.aop.Student.concat(..))")
  void concatPoint() {}

  @Around(value = "concatPoint() && args(a, b)")
  String onConcatCalled(ProceedingJoinPoint pjp,
      String a,
      String b) throws Throwable {

    var modifiedArgA = "(" + a + ")";
    var modifiedArgB = "(" + b + ")";

    var result = pjp.proceed(new Object[]{modifiedArgA, modifiedArgB});

    return "[" + result + "]";
  }
}
