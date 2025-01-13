package com.tp.platform.kafka;

import com.tp.domain.consumption.ConsumptionDataMapper;
import com.tp.domain.consumption.ConsumptionDataService;
import com.tp.domain.consumption.aggregates.DataAggregateService;
import com.tp.domain.consumption.raw.RawConsumptionDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ConsumptionDataMapper mapper;
    private final ConsumptionDataService consumptionDataService;
    private final RawConsumptionDataService rawConsumptionDataService;

    private final List<DataAggregateService> aggregateServices;

    @KafkaListener(topics = "consumption_data", groupId = "data-lake-service")
    public void consumeMessage(String message) {
        try {
            final var consumptionData = mapper.mapToConsumptionData(message);
            consumptionDataService.save(consumptionData);

            aggregateServices.forEach((aggregateService) -> aggregateService.addToAggregate(consumptionData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "raw_data", groupId = "data-lake-service")
    public void consumeRawMessage(String message) {
        rawConsumptionDataService.save(message);
    }
}
