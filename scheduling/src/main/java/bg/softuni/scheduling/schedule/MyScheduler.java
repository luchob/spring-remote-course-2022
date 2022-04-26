package bg.softuni.scheduling.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(MyScheduler.class);

  // uncomment for cron demo (expression in application.yaml)
  // @Scheduled(cron = "${my.scheduler.cron}")
  public void cronSchedule() {
    LOGGER.info("Cron schedule");
  }

  // uncomment for fixed rate demo
  // @Scheduled(fixedRate = 5000)
  public void fixRateSchedule() throws InterruptedException {
    LOGGER.info("Fixed rate schedule");

    Thread.sleep(2000);
  }

  // uncomment for fixed delay demo
  //@Scheduled(fixedDelay = 5000)
  public void fixDelaySchedule() throws InterruptedException {
    LOGGER.info("Fixed delay schedule");
//
    Thread.sleep(6000);
  }


}
