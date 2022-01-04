package com.unifacef.work.groupone.microservicecars.gateways.inputs.amqp.message;

import com.google.gson.Gson;
import org.springframework.amqp.core.Message;

import java.nio.charset.StandardCharsets;

public class MessageUtil {
    public static <T> T convertMessage(Message message, Class<T> classes){
        String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
        return new Gson().fromJson(messageBody,classes);
    }
}
