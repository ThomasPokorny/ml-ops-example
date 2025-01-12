package com.tp.platform.kafka;

import com.tp.domain.consumption.ConsumptionDataMapper;
import com.tp.domain.consumption.raw.RawConsumptionDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ConsumptionDataMapper mapper;
    private final RawConsumptionDataService rawConsumptionDataService;

    @KafkaListener(topics = "consumption_data", groupId = "data-lake-service")
    public void consumeMessage(String message) {
        try {
            final var consumptionData = mapper.mapToConsumptionData(message);
            System.out.println("Parsed Consumption Data: " + consumptionData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "raw_data", groupId = "data-lake-service")
    public void consumeRawMessage(String message) {
        rawConsumptionDataService.save(message);
    }
}
