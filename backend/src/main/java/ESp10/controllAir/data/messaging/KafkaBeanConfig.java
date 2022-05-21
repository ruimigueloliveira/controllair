package ESp10.controllAir.data.messaging;

import ESp10.controllAir.services.models.Flight;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class KafkaBeanConfig {
  @Bean
  public ConsumerFactory<String, Flight> consumerFactory(KafkaProperties kafkaProperties) {
    return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Flight> kafkaListenerContainerFactory(
      ConsumerFactory<String, Flight> consumerFactory) {

    ConcurrentKafkaListenerContainerFactory<String, Flight> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory);
    return factory;
  }
}
