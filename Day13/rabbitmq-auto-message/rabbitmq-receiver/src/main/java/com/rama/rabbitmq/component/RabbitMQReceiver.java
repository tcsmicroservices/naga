package com.rama.rabbitmq.component;

import com.rama.rabbitmq.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {

  /*
  If you are using boot, you can simply add a Jackson2JsonMessageConverter
  @Bean to the configuration and it will be automatically wired into the listener (
   */
 /* @Value("${rabbitmq.queue.name}")
  String queueName;

  @Value("${rabbitmq.exchange.name}")
  String exchange;

  @Value("${rabbitmq.routingkey.name}")
  private String routingkey;*/
  @Bean
  public Jackson2JsonMessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

  /*public void send(Employee company) {
    rabbitTemplate.convertAndSend(exchange, routingkey, company);
    System.out.println("Send msg = " + company);

  }*/
  @RabbitListener(queues = "${rabbitmq.queue.name}")
  public void receivedMessage(Message employee) {
    System.out.println("Received Message From RabbitMQ: " + employee);
  }
}
