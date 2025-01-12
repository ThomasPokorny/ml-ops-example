package com.tp.platform.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "consumption_data";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() {
        try {
            //final var message =  objectMapper.writeValueAsString(consumptionData);
            kafkaTemplate.send(TOPIC, "");
            System.out.println("Message sent to Kafka: " + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
