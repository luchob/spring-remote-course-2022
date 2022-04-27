package bg.softuni.events.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryOrderCreatedListener {

  private final Logger LOGGER = LoggerFactory.getLogger(InventoryOrderCreatedListener.class);

  @EventListener(OrderCreatedEvent.class)
  public void onOrderCreated(OrderCreatedEvent evt) {
    LOGGER.info("Inventory corrected after order placed. {}", evt.getOrderId());
  }

}
