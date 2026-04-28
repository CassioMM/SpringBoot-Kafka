package net.cassiom.springboot_kafka.controller;


import net.cassiom.springboot_kafka.kafka.JsonKafkaProducer;
import net.cassiom.springboot_kafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {

        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMenssage(user);
        return ResponseEntity.ok("Json Message sent to kafka topic");


    }


}
