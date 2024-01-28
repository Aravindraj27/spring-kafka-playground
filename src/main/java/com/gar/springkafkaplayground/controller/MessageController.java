package com.gar.springkafkaplayground.controller;


import com.gar.springkafkaplayground.producer.KafkaJsonProducer;
import com.gar.springkafkaplayground.producer.KafkaProducer;
import com.gar.springkafkaplayground.requests.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer/v1")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping("/string/messages")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message sent to queue");
    }

    @PostMapping("/json/messages")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student) {
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Message sent to queue");
    }
}
