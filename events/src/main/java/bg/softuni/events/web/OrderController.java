package bg.softuni.events.web;

import bg.softuni.events.event.OrderCreatedEvent;
import java.util.UUID;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  private final ApplicationEventPublisher eventPublisher;

  public OrderController(ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  @GetMapping("/create")
  public String createOrder() {
    //create order here, bla bla

    OrderCreatedEvent evt = new OrderCreatedEvent(this, UUID.randomUUID().toString());


    eventPublisher.publishEvent(evt);

    return "done";
  }

}
