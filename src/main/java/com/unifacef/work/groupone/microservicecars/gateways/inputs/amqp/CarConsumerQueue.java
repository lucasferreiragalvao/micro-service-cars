package com.unifacef.work.groupone.microservicecars.gateways.inputs.amqp;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.amqp.message.MessageUtil;
import com.unifacef.work.groupone.microservicecars.usecases.PatchCar;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarConsumerQueue {

    private final PatchCar patchCar;

    @RabbitListener(queues = "${application.rabbitmq.queue.name}")
    void execute(Message message){
        patchCar.execute(MessageUtil.convertMessage(message,Car.class));
    }
}
