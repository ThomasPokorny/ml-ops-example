package com.tp.platform.kafka;

import com.tp.domain.ingestion.ConsumptionDataMapper;
import com.tp.domain.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ValidationService validationService;
    private final ConsumptionDataMapper mapper;

    @KafkaListener(topics = "raw_data", groupId = "validation-enrichment-service")
    public void consumeMessage(String message) {
        try {
            final var consumptionData = mapper.mapToConsumptionData(message);
            System.out.println("Parsed Consumption Data: " + consumptionData);
            validationService.processConsumptionData(consumptionData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
