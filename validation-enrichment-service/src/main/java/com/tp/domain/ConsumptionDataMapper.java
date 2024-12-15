package com.tp.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumptionDataMapper {

    private final ObjectMapper objectMapper;

    public ConsumptionData mapToConsumptionData(String message) {
        try {
            return objectMapper.readValue(message, ConsumptionData.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse message: " + message, e);
        }
    }
}
