package com.rama.artemis.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {
    @JmsListener(destination = "${jms.queue.destination2}")
    public void receive(String msg){
        System.out.println("Got Message: " + msg);
    }
}

