package com.example.sgkafka.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {




    //this Kafka-Topic is for sending a message of type String
@Bean
public NewTopic shubhamTopic(){
return TopicBuilder.name("myTopic").build();
}



    //this Kafka-Topic is for sending a message of type JSON data
    @Bean
    public NewTopic shubhamJSONTopic(){
        return TopicBuilder.name("myJsonTopic").
        build();
    }








}
