package com.unifacef.work.groupone.microservicecars.configurations.rabbitmq;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMQConfig {
    @Value("${application.rabbitmq.queue.name}")
    private String queueName;

    @Value("${application.rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${application.rabbitmq.routing.key}")
    private String routingKey;

    @Bean
    public Exchange declareExchange(){
        return ExchangeBuilder.topicExchange(this.exchangeName)
                .durable(true)
                .build();
    }

    @Primary
    @Bean
    public Queue declareQueue() {
        return QueueBuilder.durable(this.queueName)
                .withArgument("x-dead-letter-exchange", this.exchangeName)
                .withArgument("x-dead-letter.routing-key",this.routingKey+"_wait")
                .build();
    }

    @Primary
    @Bean
    public Binding declareBindingQueue(){
        return  BindingBuilder.bind(this.declareQueue())
                .to(this.declareExchange())
                .with(this.routingKey)
                .noargs();
    }
}
