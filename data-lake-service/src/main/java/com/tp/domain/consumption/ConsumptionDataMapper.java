package com.tp.domain.consumption;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public ConsumptionData toEntity(ConsumptionDataDto dto) {
        final var entity = new ConsumptionData();
        entity.setDateTime(LocalDateTime.parse(dto.dateTime()));
        entity.setDevice(dto.device());
        entity.setValue(dto.value());
        entity.setMetadata(dto.metadata());
        return entity;
    }
}
