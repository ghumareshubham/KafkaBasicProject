package com.example.sgkafka.kafka;


import com.example.sgkafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(User userData){

        LOGGER.info(String.format( "JSONMessage send by producer >>>>%s",userData.toString()));


        Message<User> message= MessageBuilder
                .withPayload(userData)
                .setHeader(KafkaHeaders.TOPIC,"myJsonTopic")
                .build();

        kafkaTemplate.send(message);
    }






}
