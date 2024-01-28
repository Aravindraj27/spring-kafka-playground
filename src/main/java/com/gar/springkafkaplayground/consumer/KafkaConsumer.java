package com.gar.springkafkaplayground.consumer;


import com.gar.springkafkaplayground.requests.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {
    @Value("${kafka.topic}")
    private String topic;

//    @KafkaListener(topics = "my-test-topic", groupId = "test-consumer-group")
    public void consumerMessage(String message) {
        log.info(format("Consuming message :: %s from topic :: %s", message, topic));

    }

    @KafkaListener(topics = "my-test-topic", groupId = "test-consumer-group")
    public void consumerJsonMessage(Student message) {
        log.info(format("Consuming message :: %s from topic :: %s", message.toString(), topic));

    }
}
