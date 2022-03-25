package bg.softuni.state.web;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageSessionController {

  @GetMapping("/page1session")
  public String page1(HttpSession session) {
    // demonstrates how to set something in the user's session
    session.setAttribute("page1session", "Something in the session!");

    return "page1";
  }

  @GetMapping("/page1session/session")
  public String page1session(Model model,
      HttpSession session){
    // demonstrates how to get something in the user's session
    var sessionVal = session.getAttribute("page1session");
    model.addAttribute("page1session", sessionVal);

    return "page1session";
  }

}
