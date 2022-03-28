package bg.softuni;


import java.io.StringWriter;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class Main {

  public static void main(String[] args) {
    ITemplateEngine iTemplateEngine = initEngine();

    Context context = new Context();
    context.setVariable("name", "John Doe");

    StringWriter sw = new StringWriter();

    iTemplateEngine.process("test.html", context, sw);

    System.out.println(sw);
  }

  private static ITemplateEngine initEngine() {
    TemplateEngine templateEngine = new TemplateEngine();

    templateEngine.setTemplateResolver(new ClassLoaderTemplateResolver());

    return templateEngine;
  }

}
