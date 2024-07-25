package com.example.sgkafka.controller;


import com.example.sgkafka.kafka.JsonKafkaProducer;
import com.example.sgkafka.kafka.KafkaProducer;
import com.example.sgkafka.model.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }


    @PostMapping("/createUser")
    public ResponseEntity<String> publish(@RequestBody User user)
    {
        jsonKafkaProducer.sendMessage(user);

        return ResponseEntity.ok("JSONMessage send to the Topic Successfully....");
    }





}
