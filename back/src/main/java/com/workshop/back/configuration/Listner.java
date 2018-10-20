package com.workshop.back.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

@Slf4j
public class Listner implements MessageListener {
    @Override
    public void onMessage(Message message) {
        log.info("le contenu du message = " + message.toString());
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (message.toString().contains("73"))
            throw new RuntimeException("erreur");

    }
}
