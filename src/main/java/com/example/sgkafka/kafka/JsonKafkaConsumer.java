package com.example.sgkafka.kafka;

import com.example.sgkafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {


    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);




    //this consumer consume the JSON and convert it into object
    @KafkaListener(topics="myJsonTopic", groupId = "myGroup")
    public void consume(User user){

        LOGGER.info(String.format( "JSONMessage received by consumer>>> %s...",user.toString()));

    }



}
