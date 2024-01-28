package com.gar.springkafkaplayground.producer;


import com.gar.springkafkaplayground.requests.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaJsonProducer {

    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student student) {

        log.info(String.format("Sending message :: %s to topic :: %s", student.toString(), topic));
        Message<Student> message= MessageBuilder.withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }
}
