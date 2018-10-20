package com.workshop.back.configuration;


import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {



    @Bean
    Queue sms(){
        Queue queue = new Queue("sms", true);
        return queue;
    }

    @Bean
    Queue mms(){
        Queue queue = new Queue("mms", true);
        return queue;
    }



    @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory factory = new CachingConnectionFactory("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        return factory;
    }


    @Bean
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setQueues(sms(), mms());
        container.setConnectionFactory(connectionFactory());
        container.setMessageListener(new Listner());
        return container;
    }


}
