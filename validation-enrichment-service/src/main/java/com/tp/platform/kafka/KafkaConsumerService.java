package com.tp.platform.kafka;

import com.tp.domain.ConsumptionDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ConsumptionDataMapper mapper;

    @KafkaListener(topics = "raw_data", groupId = "validation-enrichment-service")
    public void consumeMessage(String message) {
        try {
            final var consumptionData = mapper.mapToConsumptionData(message);
            System.out.println("Parsed Consumption Data: " + consumptionData);
            // Process the DeviceData (e.g., save to database or further processing)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
