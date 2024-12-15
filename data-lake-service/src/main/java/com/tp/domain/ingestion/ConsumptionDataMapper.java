package com.tp.domain.ingestion;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumptionDataMapper {

    private final ObjectMapper objectMapper;

    public ConsumptionDataDto mapToConsumptionData(String message) {
        try {
            return objectMapper.readValue(message, ConsumptionDataDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse message: " + message, e);
        }
    }
}
