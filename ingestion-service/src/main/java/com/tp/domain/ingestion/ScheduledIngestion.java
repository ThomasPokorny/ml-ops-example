package com.tp.domain.ingestion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.platform.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class ScheduledIngestion {

    private final DataGeneratorService dataGeneratorService;
    private final KafkaProducerService kafkaProducerService;
    private final ObjectMapper objectMapper;

    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime() {
        final var consumptions = this.dataGeneratorService.generateConsumption();
        if (!consumptions.isEmpty()) {
            for (Map<String, String> consumption : consumptions) {
                try {
                    String jsonMessage = objectMapper.writeValueAsString(consumption); // Convert to JSON
                    kafkaProducerService.sendMessage(jsonMessage); // Send to Kafka
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
