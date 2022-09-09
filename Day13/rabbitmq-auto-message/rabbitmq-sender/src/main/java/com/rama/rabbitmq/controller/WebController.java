package com.rama.rabbitmq.controller;

import com.rama.rabbitmq.model.Message;
import com.rama.rabbitmq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@RequestMapping(value = "/rabbitmq/")
public class WebController {
  @Autowired
  RabbitMQSender rabbitMQSender;

  @GetMapping(value = "/sender")
  public String producer(@RequestParam("to") String to, @RequestParam("from") String from,  @RequestParam("content") String content) {

    Message msg=new Message();
    String messageId = UUID.randomUUID().toString();
    msg.setFrom(from);
    msg.setTo(to);
    msg.setContent(content);
    msg.setMessageId(messageId);
    rabbitMQSender.send(msg);

    return "Message sent to the RabbitMQ  Successfully";
  }
}