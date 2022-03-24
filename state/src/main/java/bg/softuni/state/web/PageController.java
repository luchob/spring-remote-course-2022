package bg.softuni.state.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

  @GetMapping("/page1")
  public String page1(HttpServletResponse resp) {
    // demonstrates how to set a cookie
    Cookie cookie = new Cookie("page1cookie", "page1");
    cookie.setPath("/page1");
    cookie.setMaxAge(2*60*60);

    resp.addCookie(cookie);

    return "page1";
  }

  @GetMapping("/page2")
  public String page2() {
    return "page2";
  }
}
