package com.tp.domain.validation;

import com.tp.domain.enrichment.ConsumptionEnrichment;
import com.tp.domain.ingestion.ConsumptionDataDto;
import com.tp.domain.validation.model.ConsumptionData;
import com.tp.domain.validation.model.ConsumptionMetadata;
import com.tp.platform.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidationService {

    private final List<ConsumptionEnrichment> enrichmentService;
    private final KafkaProducerService producerService;

    public void processConsumptionData(ConsumptionDataDto consumptionDataDto){
        if(!validate(consumptionDataDto)){
            return;
        }

        final var consumptionData = this.mapConsumption(consumptionDataDto);
        enrichmentService.forEach(enrichment->enrichment.enrich(consumptionData));

        producerService.sendMessage(consumptionData);
    }

    private boolean validate(ConsumptionDataDto consumptionDataDto) {
        return !(Double.parseDouble(consumptionDataDto.value()) < 0);
    }


    private ConsumptionData mapConsumption(ConsumptionDataDto consumptionDataDto) {
        return new ConsumptionData(consumptionDataDto.dateTime(), consumptionDataDto.device(), Double.parseDouble(consumptionDataDto.value()), new ConsumptionMetadata());
    }
}
