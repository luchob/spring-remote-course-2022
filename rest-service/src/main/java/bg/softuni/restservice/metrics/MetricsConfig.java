package bg.softuni.restservice.metrics;

import bg.softuni.restservice.repository.BookRepository;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

  public MetricsConfig(MeterRegistry meterRegistry,
      BookRepository bookRepository) {
    Gauge.
        builder("books.count", bookRepository::count).
        register(meterRegistry);
  }
}
