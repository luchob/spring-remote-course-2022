package bg.softuni.events.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BonusPointsOrderCreatedListener {

  private final Logger LOGGER = LoggerFactory.getLogger(BonusPointsOrderCreatedListener.class);

  @EventListener(OrderCreatedEvent.class)
  public void onOrderCreated(OrderCreatedEvent evt) {
    LOGGER.info("Adding bonus points to the user. {}", evt.getOrderId());
  }

}
